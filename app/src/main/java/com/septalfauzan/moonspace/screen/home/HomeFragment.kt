package com.septalfauzan.moonspace.screen.home

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.septalfauzan.moonspace.R
import com.septalfauzan.moonspace.core.presentation.ui.ScheduleAdapter
import com.septalfauzan.moonspace.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.fragment.findNavController
import com.septalfauzan.moonspace.core.data.Resource
import com.septalfauzan.moonspace.core.domain.model.RocketLaunchSchedule

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity == null) return
        val homeViewModel: HomeViewModel by viewModels()
        val rvAdapter = ScheduleAdapter()
        with(binding.rvContainer) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = rvAdapter
        }

        homeViewModel.getUpcomingLaunches()
        homeViewModel.upcomingRocketLaunch.observe(viewLifecycleOwner) {
            handleShowData(rvAdapter, it)
        }
        rvAdapter.onClick = { id -> navigateToDetail(id, findNavController()) }
        rvAdapter.bookmarkClicked = { id -> homeViewModel.updateBookmark(id) }

        binding.searchLaunched.addTextChangedListener(onInputSearchChange {
            homeViewModel.filterUpcomingLaunches(
                it
            )
        })
    }

    private fun handleShowData(
        rvAdapter: ScheduleAdapter,
        resource: Resource<List<RocketLaunchSchedule>>?
    ) {
        if (resource != null) {
            when (resource) {
                is Resource.Loading ->{
                    binding.progressBar.visibility = View.VISIBLE
                    binding.messageText.visibility = View.INVISIBLE
                    binding.emptyData.root.visibility = View.INVISIBLE
                }
                is Resource.Error ->{
                    binding.progressBar.visibility = View.INVISIBLE
                    binding.messageText.visibility = View.VISIBLE
                    binding.emptyData.root.visibility = View.VISIBLE
                    binding.messageText.text = resource.message
                }
                is Resource.Success -> {
                    binding.progressBar.visibility = View.INVISIBLE
                    binding.messageText.visibility = View.INVISIBLE
                    if(resource.data?.size == 0){
                        binding.messageText.visibility = View.VISIBLE
                        binding.messageText.text = getString(R.string.no_data)
                        binding.emptyData.root.visibility = View.VISIBLE
                    }else{
                        binding.emptyData.root.visibility = View.INVISIBLE
                    }
                    rvAdapter.setData(resource.data ?: listOf())
                }
            }
        }
    }

    private fun onInputSearchChange(onFilter: (String) -> Unit): TextWatcher =
        object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) =
                onFilter(s.toString())
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

private fun navigateToDetail(id: String, navController: NavController) {
    val bundle = Bundle()
    bundle.putString("id", id)
    navController.navigate(R.id.action_home2_to_detailFragment, bundle)
}