package id.chirikualii.movie_catalog_android_jetpack_pro.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.chirikualii.movie_catalog_android_jetpack_pro.databinding.ActivitySplashBinding
import id.chirikualii.movie_catalog_android_jetpack_pro.ui.main.MainActivity

class SplashActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}