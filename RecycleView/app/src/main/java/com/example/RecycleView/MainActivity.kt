package com.example.RecycleView

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    private lateinit var rvChara : RecyclerView
    private val list = ArrayList<Chara>()

    private fun showSelectedHero(chara: Chara) {
        Toast.makeText(this, "Kamu memilih " + chara.name, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvChara = findViewById(R.id.rv_character)
        rvChara.setHasFixedSize(true)


        list.addAll(getListChara())
        showRecyclerList()

    }

    private fun getListChara(): ArrayList<Chara> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataDetail = resources.getStringArray(R.array.detail_description)
        val listChara = ArrayList<Chara>()
        for (i in dataName.indices) {
            val chara = Chara(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataDetail[i])
            listChara.add(chara)
        }
        return listChara
    }

    private fun showRecyclerList() {
        rvChara.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListCharaAdapter(list)
        rvChara.adapter = listHeroAdapter
        listHeroAdapter.setOnItemClickCallback(object : ListCharaAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Chara) {
                showSelectedHero(data)
                val DataIntent = Intent(this@MainActivity, DetailPage::class.java)
                DataIntent.putExtra(DetailPage.EXTRA_IMAGE, data.photo)
                DataIntent.putExtra(DetailPage.EXTRA_NAME, data.name)
                DataIntent.putExtra(DetailPage.EXTRA_DESC, data.description)
                DataIntent.putExtra(DetailPage.EXTRA_DETAIL, data.detaildecs)
                startActivity(DataIntent)

            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.aboutmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_profile -> {
                val moveIntent = Intent(this@MainActivity, AboutPage::class.java)
                startActivity(moveIntent)
            }
        }

        return super.onOptionsItemSelected(item)
    }

}