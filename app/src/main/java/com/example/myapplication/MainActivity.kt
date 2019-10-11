package com.example.myapplication

import android.media.MediaPlayer
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.ToggleButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var mediaplayer : MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tb = findViewById(R.id.add) as ToggleButton

        mediaplayer = MediaPlayer.create(this, R.raw.bam)
        val soundpool = SoundPool.Builder().build()
        var soundid = soundpool.load(this, R.raw.bam,1)

        add.setOnClickListener{
            if(tb.isChecked){
                Toast.makeText(this@MainActivity,"on",Toast.LENGTH_SHORT).show()
                soundpool.play(soundid,1.0f, 1.0f, 0, -1, 1.0f)
            }else{
                Toast.makeText(this@MainActivity,"off",Toast.LENGTH_SHORT).show()
                soundpool.stop(soundid)
                soundid = soundpool.play(soundid, 1.0f, 1.0f, 1, 0, 1f);
            }
        }
    }

}
