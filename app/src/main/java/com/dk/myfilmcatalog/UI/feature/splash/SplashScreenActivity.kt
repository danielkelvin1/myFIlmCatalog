package com.dk.myfilmcatalog.UI.feature.splash

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.dk.myfilmcatalog.UI.MainActivity
import com.dk.myfilmcatalog.R
import com.dk.myfilmcatalog.UI.base.BaseActivity
import com.dk.myfilmcatalog.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : BaseActivity<ActivitySplashScreenBinding>() {


    override fun getViewBinding() = ActivitySplashScreenBinding.inflate(layoutInflater)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        playAnimation()
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }

    fun playAnimation(){
        val icon = ObjectAnimator.ofFloat(binding.ivIconMovie, View.TRANSLATION_Y, 800f, 0f).setDuration(500)
        val title = ObjectAnimator.ofFloat(binding.tvTitle, View.ALPHA, 1f).setDuration(500)

        AnimatorSet().apply {
            playSequentially(icon, title)
            start()
        }
    }

}