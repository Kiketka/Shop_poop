package com.example.myapplicationshop

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import android.content.Intent
import android.media.MediaPlayer
import android.view.MotionEvent
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplicationshop.model.CartStorage
import com.example.myapplicationshop.model.FavoriteStorage
import com.example.myapplicationshop.model.HistoryStorage
var mediaPlayer: MediaPlayer? = null
var isPlaying = false
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        CartStorage.init(this)
        HistoryStorage.init(this)
        FavoriteStorage.init(this)

        var btn_music = findViewById<ImageButton>(R.id.btnMusic)
        mediaPlayer = MediaPlayer.create(this, R.raw.pigstep)


        btn_music.setOnClickListener {
            if (isPlaying == false){
                mediaPlayer?.start()
                isPlaying = true
                btn_music.setImageResource(R.drawable.volume_mute)
            }
            else {
                mediaPlayer?.stop()
                isPlaying = false
                btn_music.setImageResource(R.drawable.baseline_volume_up_24)
            }
        }
        val btn_Start = findViewById<Button>(R.id.btnStart)

        btn_Start.setOnClickListener {
            //Toast.makeText(this, "Страница временно не работает", Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity2::class.java )
            startActivity(intent)
        }

        btn_Start.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN){
                v.startAnimation(AnimationUtils.loadAnimation(v.context, R.anim.scale_down))
            }
            if (event.action == MotionEvent.ACTION_UP){
                v.startAnimation(AnimationUtils.loadAnimation(v.context, R.anim.scale_upp))
            }

            if (event.action == MotionEvent.ACTION_CANCEL){
                v.startAnimation(AnimationUtils.loadAnimation(v.context, R.anim.scale_upp))
            }

            false
        }

       // btn_Start.setOnLongClickListener {
       //     Toast.makeText(this, "Страница временно не работает и долгое не поможет", Toast.LENGTH_LONG).show()
       //     true
       // }




    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}