package com.asim.onboardingscreen

import android.animation.ArgbEvaluator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.asim.onboardingscreen.databinding.ActivityOnBoardBinding
import com.asim.onboardingscreen.utils.BaseView
import com.asim.onboardingscreen.utils.Utils
import java.time.Duration

class OnBoardActivity : AppCompatActivity(),BaseView {

    private lateinit var onBoardBinding: ActivityOnBoardBinding
    private var argbEvaluator: ArgbEvaluator? = null
    private var statusBarColorArray: IntArray? = null
    private var currentOnBoardPage = 0 //  to track page position
    private var indicatorsImgArray: Array<ImageView>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        setListeners()
    }

    override fun init() {
        onBoardBinding = ActivityOnBoardBinding.inflate(layoutInflater)
        setContentView(onBoardBinding.root)

        val color1 = ContextCompat.getColor(this, R.color.white)
        val color2 = ContextCompat.getColor(this, R.color.white)
        val color3 = ContextCompat.getColor(this, R.color.white)

        statusBarColorArray = intArrayOf(color1, color2, color3)
        Utils.changeStatusBarColor(color1, this@OnBoardActivity)

        argbEvaluator = ArgbEvaluator()
        val mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        indicatorsImgArray = arrayOf(onBoardBinding.introIndicator0, onBoardBinding.introIndicator1, onBoardBinding.introIndicator2)

        // Set up the ViewPager with the sections adapter.

        // Set up the ViewPager with the sections adapter.
        onBoardBinding.onBoardingVp.adapter = mSectionsPagerAdapter

        onBoardBinding.onBoardingVp.currentItem = currentOnBoardPage
        OnBoardClickListener.instance?.updateIndicators(currentOnBoardPage, indicatorsImgArray!!)
    }

    override fun setValues() {
        TODO("Not yet implemented")
    }

    override fun setListeners() {
        OnBoardClickListener.instance?.onPageClickListener(onBoardBinding, argbEvaluator!!, statusBarColorArray!!, indicatorsImgArray!!, this)

        onBoardBinding.onBoardingBtnNext.setOnClickListener { v ->
            currentOnBoardPage += 1
            onBoardBinding.onBoardingVp.setCurrentItem(currentOnBoardPage, true)
        }

        onBoardBinding.onBoardingBtnBack.setOnClickListener { v ->
            currentOnBoardPage--
            onBoardBinding.onBoardingVp.setCurrentItem(currentOnBoardPage, true)
        }

        onBoardBinding.onBoardingBtnSkip.setOnClickListener { v ->

            Utils.showSnackBar(onBoardBinding.parentLayout,"Skip")
        }

        onBoardBinding.onBoardingBtnGetStarted.setOnClickListener { v ->
            Utils.showSnackBar(onBoardBinding.parentLayout,"Get Started")

        }
    }
}