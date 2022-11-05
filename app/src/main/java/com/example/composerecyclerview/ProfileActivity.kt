package com.example.composerecyclerview


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddevchallenge.data.model.Puppy
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.composerecyclerview.data.model.Puppy

class ProfileActivity : AppCompatActivity() {

    private val puppy: Puppy by lazy {
        intent?.getSerializableExtra(PUPPY_ID) as Puppy
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                ProfileScreen(puppy)
            }
        }
    }

    companion object {
        private const val PUPPY_ID = "puppy_id"
        fun newIntent(context: Context, puppy: Puppy) =
            Intent(context, ProfileActivity::class.java).apply {
                putExtra(PUPPY_ID, puppy)
            }
    }
}