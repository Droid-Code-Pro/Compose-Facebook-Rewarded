package com.google.facebookrewardad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.facebookrewardad.ui.theme.FacebookRewardAdTheme
import com.google.metabanner.ui.component.DroidTopAppBar

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      FacebookRewardAdTheme {
        val rewardAd = remember { FacebookRewardAd(this) }
        Scaffold(
          topBar = {DroidTopAppBar()},
          modifier = Modifier.fillMaxSize()) { innerPadding ->
          Surface(
            modifier = Modifier.padding(innerPadding)
          ){
           Column(modifier = Modifier.fillMaxSize(),
             verticalArrangement = Arrangement.Center,
             horizontalAlignment = Alignment.CenterHorizontally) {
             Row(modifier = Modifier.fillMaxWidth(),
               horizontalArrangement = Arrangement.SpaceEvenly,) {
               Button(onClick = {rewardAd.loadRewardAd(this@MainActivity) }) {
                 Text(text = "Load Reward Ad")
               }
               
               Button(onClick = { rewardAd.showRewardAd() }) {
                 Text(text = "Show Reward Ad")
               }
             }
           }
          }
        }
      }
    }
  }
}
