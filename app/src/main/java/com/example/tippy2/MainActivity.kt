package com.example.tippy2

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    private lateinit var vibrationNumber: EditText
    private lateinit var vibrateSubmit: Button
    private lateinit var outputText : TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vibrateSubmit = findViewById(R.id.vibrateSubmit)
        outputText = findViewById(R.id.outputText)
        var pressCount = 0

        vibrateSubmit.setOnClickListener {
            val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            if (vibrator.hasVibrator()) { // Vibrator availability checking
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    pressCount += 1
                    outputText.text = "Vibrations: " + pressCount.toString()
                    vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.EFFECT_HEAVY_CLICK)) // New vibrate method for API Level 26 or higher

                } else {
                    vibrator.vibrate(500) // Vibrate method for below API Level 26
                }
            }
        }


    }
}