package com.septalfauzan.moonspace.launchedmap

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions
import com.septalfauzan.moonspace.core.data.Resource
import com.septalfauzan.moonspace.di.LaunchedMapDependencies
import com.septalfauzan.moonspace.launchedmap.helper.ViewModelFactory
import dagger.hilt.android.EntryPointAccessors
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class MapsFragment : Fragment() {
    @Inject
    lateinit var factory: ViewModelFactory
    private var component: LaunchedMapComponent? = null
    private val launchedMapViewModel: LaunchedMapViewModel by viewModels {
        factory
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private val callback = OnMapReadyCallback { googleMap ->

        val mapStyle = MapStyleOptions.loadRawResourceStyle(
            requireContext(),
            when (requireContext().resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)) {
                Configuration.UI_MODE_NIGHT_YES -> R.raw.dark_map_style
                else -> R.raw.light_map_style
            }
        )

        googleMap.setMapStyle(mapStyle)

        launchedMapViewModel.upComingLaunch.observe(viewLifecycleOwner) { resource ->
            if (resource.data != null) {
                when (resource) {
                    is Resource.Loading -> Toast.makeText(
                        context,
                        "Fetch data..",
                        Toast.LENGTH_SHORT
                    ).show()

                    is Resource.Error -> Toast.makeText(
                        context,
                        "Error: ${resource.message}",
                        Toast.LENGTH_SHORT
                    ).show()

                    is Resource.Success -> {
                        val data = resource.data ?: return@observe
                        lifecycleScope.launch(Dispatchers.Default) {

                            data.map { launch ->
                                val poi = LatLng(launch.latitude ?: 0.0, launch.longitude ?: 0.0)
                                val icon = createIconMarker()
                                withContext(Dispatchers.Main) {
                                    googleMap.addMarker(
                                        MarkerOptions().position(poi).icon(icon).title(launch.name)
                                    )
                                }
                            }
                        }
                    }
                }
            }

        }
    }

    private fun createIconMarker(): BitmapDescriptor {
        try {
            val drawable = resources.getDrawable(
                com.septalfauzan.moonspace.core.R.drawable.baseline_rocket_24,
                null
            )

            val width = 72 // Adjust as needed
            val height = 72 // Adjust as needed
            val bitmap: Bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)

            val canvas = Canvas(bitmap)
            drawable.setBounds(0, 0, canvas.width, canvas.height)
            drawable.draw(canvas)

            return BitmapDescriptorFactory.fromBitmap(bitmap)
        }catch (e: Exception){
            throw e
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getFragmentComponent()?.inject(this)
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    override fun onDestroy() {
        super.onDestroy()
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?

        mapFragment?.onDestroy()
    }

    private fun getFragmentComponent(): LaunchedMapComponent? {
        if (component == null) {
            component = DaggerLaunchedMapComponent.builder()
                .context(requireContext())
                .appDependencies(
                    EntryPointAccessors.fromApplication(
                        requireContext(),
                        LaunchedMapDependencies::class.java
                    )
                )
                .build()
        }
        return component
    }
}