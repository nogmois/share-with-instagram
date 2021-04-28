package com.example.myapplication2


import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication2.databinding.ActivityMainBinding
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        shareInstagram()
    }

    private fun shareInstagram() {

        val btnShare = findViewById<Button>(R.id.btn_share_instagram)
        btnShare?.setOnClickListener {

            //com.example.sharefacebook/ -> No AndroidManifest
            val shareImage = Uri.parse("android.resource://com.example.myapplication2/" + R.drawable.image)

            createInstagramIntent(shareImage)
        }
    }

    private fun createInstagramIntent(uri: Uri?){

        val text: String = "API Testing"

        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "image/*"
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri)
        shareIntent.putExtra(Intent.EXTRA_TEXT, "API Testing")// Não funciona

        shareIntent.setPackage("com.instagram.android")
        startActivity(shareIntent) //-- Antigo
        //startActivity(Intent.createChooser(shareIntent, "Share to")) // Mais opções de compartilhamento
    }


}