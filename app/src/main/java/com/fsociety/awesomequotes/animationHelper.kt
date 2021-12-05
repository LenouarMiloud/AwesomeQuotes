package com.fsociety.awesomequotes

import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.RotateAnimation
import android.view.animation.TranslateAnimation

object animationHelper {
    // animation function
    fun animate(holderItemView:View){
        //defining the animation
        /*Alpha animation*/
        val alphaAnimation=AlphaAnimation(0.0f,0.1f)
        alphaAnimation.duration= 2000
        /*Translate animation*/
        val translateAlphaAnimation = TranslateAnimation(-100f,0.0f,0.0f,0.0f)
        translateAlphaAnimation.duration = 1000
        /*rotation animation*/
        val rotateAnimation = RotateAnimation(0.0f,360.0f)
        rotateAnimation.duration = 1000
        //assign the animation
//      holderItemView.startAnimation(alphaAnimation)
//      holderItemView.startAnimation(translateAlphaAnimation)
        holderItemView.startAnimation(rotateAnimation)

    }
}