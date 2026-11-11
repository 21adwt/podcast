package com.example.podcast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

import com.example.podcast.ui.theme.PodcastTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PodcastTheme {
                PlayerScreen();
            }
        }
    }
}

@Composable
fun PlayerScreen(){
    Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding ->
        PodcastPlayerScreen(modifier = Modifier.padding(innerPadding));

    }
}
@Composable
fun PodcastPlayerScreen(
    vm : PlayerViewModel = hiltViewModel(),
    modifier: Modifier
){

    val picker = rememberLauncherForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
        uri?.let { vm.playUrl(it) }      // 把 content:// 交给播放器
    }

    Column(
        modifier = modifier.padding(24.dp)
    ) {
        Button(onClick = { picker.launch(arrayOf("audio/*")) }) {
            Text("选择系统文件里的音频")
        }
        Button(onClick = {vm.releaseSong()}){
            Text("取消音频播放")
        }
    }



}
