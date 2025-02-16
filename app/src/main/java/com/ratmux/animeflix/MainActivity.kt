package com.ratmux.animeflix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ratmux.animeflix.ui.theme.AnimeFlixTheme

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // NavController'ı bağla
        navController = findNavController(com.ratmux.animeflix.MainFragment)
        setupActionBarWithNavController(navController, binding.drawerLayout)

        // NavigationView'ı bağla
        binding.navView.setupWithNavController(navController)

        // RecyclerView'ı başlat
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val siteListesi = listOf(
            SiteLogosu(R.drawable.turkanime_logo, "TürkAnime"),
            SiteLogosu(R.drawable.yabancidizi_logo, "YabancıDizi"),
            SiteLogosu(R.drawable.tranimeizle_logo, "TrAnimeİzle")
        )

        val adapter = SiteAdapter(siteListesi)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2) // Grid yapısı için
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}