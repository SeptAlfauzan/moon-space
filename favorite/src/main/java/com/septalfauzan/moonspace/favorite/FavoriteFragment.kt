package com.septalfauzan.moonspace.favorite

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.septalfauzan.moonspace.MainActivity
import com.septalfauzan.moonspace.core.presentation.ui.ScheduleAdapter
import com.septalfauzan.moonspace.di.FavoriteDependencies
import com.septalfauzan.moonspace.favorite.databinding.FragmentFavoriteBinding
import com.septalfauzan.moonspace.helper.ViewModelFactory
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory
    private var component: FavoriteComponent? = null
    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        getFragmentComponent()?.inject(this)
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity == null) return

        val rvAdapter = ScheduleAdapter()
        with(binding.rvContainer){
            layoutManager = LinearLayoutManager(context)
            adapter = rvAdapter
        }
        val favoriteViewModel: FavoriteViewModel by viewModels{
            factory
        }

        favoriteViewModel.getBookmarkedLaunches()
        favoriteViewModel.bookmarkedUpcomingRocketLaunch.observe(viewLifecycleOwner){
            if(it != null){
                when(it){
                    is com.septalfauzan.moonspace.core.data.Resource.Loading ->{
                        binding.messageText.visibility = View.INVISIBLE
                        binding.progressBar.visibility = View.VISIBLE
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
                            binding.emptyData.root.visibility = View.VISIBLE
                        }else{
                            binding.emptyData.root.visibility = View.INVISIBLE
                        }
                        rvAdapter.setData(it.data ?: listOf())
                    }
                }
            }
        }
        rvAdapter.onClick = { id -> navigateToDetail(id)  }
        rvAdapter.bookmarkClicked = { id -> favoriteViewModel.updateBookmark(id) }

        binding.searchLaunched.addTextChangedListener(onInputSearchChange { favoriteViewModel.filterBookmarkedUpcomingLaunches(it) })
    }

    private fun onInputSearchChange(onFilter: (String) -> Unit) : TextWatcher = object :
        TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun afterTextChanged(s: Editable?) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = onFilter(s.toString())
    }
    private fun getFragmentComponent(): FavoriteComponent?{
        if (component == null) {
            component = DaggerFavoriteComponent.builder()
                .context(requireContext())
                .appDependencies(
                    EntryPointAccessors.fromApplication(
                        requireContext(),
                        FavoriteDependencies::class.java
                    )
                )
                .build()
        }
        return component
    }

    private fun navigateToDetail(id: String){
        val intent = Intent(context, MainActivity::class.java)
        val bundle = Bundle()
        bundle.putString("id", id)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        component = null
    }
}


