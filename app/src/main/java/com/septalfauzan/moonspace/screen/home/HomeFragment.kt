package com.septalfauzan.moonspace.screen.home

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.septalfauzan.moonspace.R
import com.septalfauzan.moonspace.core.presentation.ui.ScheduleAdapter
import com.septalfauzan.moonspace.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.fragment.findNavController

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var homeViewModel: HomeViewModel

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
        val homeViewModel: HomeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        val rvAdapter = ScheduleAdapter()
        with(binding.rvContainer) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = rvAdapter
        }

        homeViewModel.getUpcomingLaunches()
        homeViewModel.upcomingRocketLaunch.observe(viewLifecycleOwner) {
            if (it != null) {
                when (it) {
                    is com.septalfauzan.moonspace.core.data.Resource.Loading ->{
                        binding.progressBar.visibility = View.VISIBLE
                        binding.messageText.visibility = View.INVISIBLE
                    }
                    is com.septalfauzan.moonspace.core.data.Resource.Error ->{
                        binding.progressBar.visibility = View.INVISIBLE
                        binding.messageText.visibility = View.VISIBLE
                        binding.messageText.text = it.message
                    }
                    is com.septalfauzan.moonspace.core.data.Resource.Success -> {
                        binding.progressBar.visibility = View.INVISIBLE
                        binding.messageText.visibility = View.INVISIBLE
                        if(it.data?.size == 0){
                            binding.messageText.visibility = View.VISIBLE
                            binding.messageText.text = getString(R.string.no_data)
                        }
                        rvAdapter.setData(it.data ?: listOf())
                    }
                }
            }
        }
        rvAdapter.onClick = { id -> navigateToDetail(id, findNavController()) }
        rvAdapter.bookmarkClicked = { id -> homeViewModel.updateBookmark(id) }

        binding.searchLaunched.addTextChangedListener(onInputSearchChange {
            homeViewModel.filterUpcomingLaunches(
                it
            )
        })
    }

    private fun onInputSearchChange(onFilter: (String) -> Unit): TextWatcher =
        object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) =
                onFilter(s.toString())
        }

    override fun onDestroy() {
        super.onDestroy()
//        homeViewModel = null
    }
}

private fun navigateToDetail(id: String, navController: NavController) {
    val bundle = Bundle()
    bundle.putString("id", id)
    navController.navigate(R.id.action_home2_to_detailFragment, bundle)
}