package com.septalfauzan.moonspace

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.navigation.NavigationView
import com.septalfauzan.moonspace.databinding.ActivityMainBinding
import com.septalfauzan.moonspace.screen.detail.DetailFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        binding.navView.setNavigationItemSelectedListener(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navController = findNavController(R.id.fragment_container)

        if (intent != null) {
            val bundle = intent.extras
            if (bundle?.getString("id") != null) {
                navController.navigate(R.id.action_home2_to_detailFragment, bundle)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (toggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val fragment = when (item.itemId) {
            R.id.nav_home -> R.id.homeFragment
            R.id.nav_bookmark -> {
                val uri = Uri.parse("moonspace://favorite")
                startActivity(Intent(Intent.ACTION_VIEW, uri))
                null
            }
            R.id.nav_launch_location -> {
                val uri = Uri.parse("moonspace://launchedmap")
                startActivity(Intent(Intent.ACTION_VIEW, uri))
                null
            }
            else -> null
        }
        if (fragment != null) navController.navigate(fragment)

        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}