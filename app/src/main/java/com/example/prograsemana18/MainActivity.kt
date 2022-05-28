package com.example.prograsemana18

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.itemholder.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imagemapa.setOnClickListener {
            val maps = Intent(this, MapsActivity::class.java)
            startActivity(maps)
        }
        viewpa.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (position == 0) {
                    //imagemapa.visibility = View.GONE
                    imagemapa.isVisible = false
                }
                if (position == 1) {
                    //imagemapa.visibility = View.VISIBLE
                    imagemapa.isVisible = true
                }
                super.onPageSelected(position)
            }
        })
        configuracionview()
    }
    private fun configuracionview(){
        val list: MutableList<String> = ArrayList()
        list.add("Creador:Gabriel Eduardo Henriquez Gonzalez")
        list.add("Boton para abrir Google Maps")

        val backList: MutableList<String> = ArrayList()
        backList.add("#102479")
        backList.add("#45b34d")

        // Set adapter to viewPager.
        viewpa.adapter = ViewPager(this, list, backList)
    }
}