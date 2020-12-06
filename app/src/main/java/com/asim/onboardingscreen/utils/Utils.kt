package com.asim.onboardingscreen.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Patterns
import android.view.View
import android.view.WindowManager
import com.google.android.material.snackbar.Snackbar

class Utils {



    fun goToNextScreenWithFinish(cls: Class<*>?, ct: Context) {
        val intent = Intent(ct, cls)
        ct.startActivity(intent)
        (ct as Activity).finish()
    }

    fun isEmailValid(email: String?): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun goToNextScreenWithoutFinish(cls: Class<*>?, ct: Context) {
        val intent = Intent(ct, cls)
        ct.startActivity(intent)
    }

    companion object {
        fun changeStatusBarColor(statusBarColor: Int, myActivityReference: Activity) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val window = myActivityReference.window
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = statusBarColor
            }
        }

        fun navigateAndClearBackStack(cls: Class<*>?, ct: Context) {
            val intent = Intent(ct, cls)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            ct.startActivity(intent)
            (ct as Activity).finish()
        }

        fun showSnackBar(view: View?, msg: String?) {
            //findViewById(android.R.id.content)
            Snackbar.make(view!!, msg!!, Snackbar.LENGTH_SHORT)
                    .show()
        }

        fun setVisibility(visible: View, gone: View) {
            visible.visibility = View.VISIBLE
            gone.visibility = View.GONE
        }





    }
}