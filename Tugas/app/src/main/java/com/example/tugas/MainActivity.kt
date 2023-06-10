package com.example.tugas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.tugas.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.tools_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.notif -> Toast.makeText(this, "Notif nih", Toast.LENGTH_SHORT).show()
            R.id.edu-> Toast.makeText(this, "Education nih", Toast.LENGTH_SHORT).show()
            R.id.phone -> Toast.makeText(this, "Ada Telepon", Toast.LENGTH_SHORT).show()
        }
    return true
    }
}