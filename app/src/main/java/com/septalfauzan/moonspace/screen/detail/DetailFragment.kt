package com.septalfauzan.moonspace.screen.detail

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.septalfauzan.moonspace.R
import com.septalfauzan.moonspace.core.data.Resource
import com.septalfauzan.moonspace.core.domain.model.RocketLaunchProgram
import com.septalfauzan.moonspace.core.domain.model.RocketLaunchSchedule
import com.septalfauzan.moonspace.core.presentation.ui.ProgramLauncherAdapter
import com.septalfauzan.moonspace.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.detailContent.visibility = INVISIBLE
        if (activity == null) return
        val id = arguments?.getString("id") ?: "-"

        val detailViewModel: DetailViewModel by viewModels()
        detailViewModel.getDetailLaunch(id).observe(viewLifecycleOwner) {
            if (it.data != null) {
                when (it) {
                    is Resource.Loading -> Toast.makeText(
                        requireContext(),
                        "Loading...",
                        Toast.LENGTH_SHORT
                    ).show()
                    is Resource.Error -> Toast.makeText(
                        requireContext(),
                        it.message,
                        Toast.LENGTH_SHORT
                    ).show()
                    is Resource.Success -> populateUi(requireContext(), it.data!!)
                }
            }
        }

        detailViewModel.getBookmarkStatus(id).observe(viewLifecycleOwner) { status ->
            binding.bookmarkButton.setImageResource(if (status) R.drawable.baseline_bookmark_24 else R.drawable.baseline_bookmark_border_24)
        }
        binding.bookmarkButton.setOnClickListener {
            detailViewModel.updateBookmark(id)
        }
    }


    private fun populateUi(context: Context, data: RocketLaunchSchedule) {
        Glide.with(context).load(data.imageUrl).into(binding.image)
        binding.detailTitle.text = data.name
        binding.detailLaunched.text = "🔴 ${data.launchedAt}"
        binding.infoName.text = data.info?.spaceShipName
        binding.maidenFlight.text = data.info?.maidenFlight
        binding.infoCost.text = data.info?.cost
        binding.infoDesc.text = data.info?.desc

        val programLauncherAdapter = ProgramLauncherAdapter()

        with(binding.rvLaunchProgram) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = programLauncherAdapter
        }

        Log.d("TAG", "populateUi: ${data.programs}")
        data.programs?.let {
            programLauncherAdapter.setData(it as List<RocketLaunchProgram>)
        }

        binding.circularLoading.visibility = INVISIBLE
        binding.detailContent.visibility = VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}