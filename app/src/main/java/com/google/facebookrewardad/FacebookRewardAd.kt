package com.google.facebookrewardad

import android.app.Activity
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.facebook.ads.Ad
import com.facebook.ads.AdError
import com.facebook.ads.AdSettings
import com.facebook.ads.AudienceNetworkAds
import com.facebook.ads.RewardedVideoAd
import com.facebook.ads.RewardedVideoAdListener

class FacebookRewardAd(activity: Activity) {
  
  init {
    AudienceNetworkAds.initialize(activity)
    AdSettings.setTestMode(true)
  }
  
  private var rewardAd: RewardedVideoAd? = null
  
  fun loadRewardAd(context: Activity) {
    if (rewardAd == null) {
      
      rewardAd = RewardedVideoAd(context, context.resources.getString(R.string.facebook_reward_ad))
      
      rewardAd?.loadAd(
        rewardAd?.buildLoadAdConfig()?.withAdListener(object : RewardedVideoAdListener {
          override fun onError(p0: Ad?, p1: AdError?) {
            Toast.makeText(context, "Reward Ad Failed Load", Toast.LENGTH_SHORT).show()
            rewardAd = null
          }
          
          override fun onAdLoaded(p0: Ad?) {
            Toast.makeText(context, "Reward Ad Loaded", Toast.LENGTH_SHORT).show()
          }
          
          override fun onRewardedVideoCompleted() {
            Toast.makeText(context, "User Earned Reward", Toast.LENGTH_SHORT).show()
            rewardAd = null
          }
          
          override fun onRewardedVideoClosed() {
         rewardAd = null
          }
          override fun onAdClicked(p0: Ad?) {}
          override fun onLoggingImpression(p0: Ad?) {}
        })?.build()
      )
    }
  }
  
  fun showRewardAd() {
    if (rewardAd != null && rewardAd?.isAdLoaded == true){
      rewardAd?.show()
    }
  }
}