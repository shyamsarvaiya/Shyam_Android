package com.example.data2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.TextSliderView

class MainActivity2 : AppCompatActivity()
{
    lateinit var sliderLayout: SliderLayout
    lateinit var map :HashMap<String,Int>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        sliderLayout = findViewById(R.id.slider)
        map = HashMap<String,Int>()

        map.put("a",R.drawable.a)
        map.put("b",R.drawable.abc)
        map.put("c",R.drawable.photo)

        for(i in map.keys)
        {

            var txtslider = TextSliderView(this)

            txtslider.description(i)
            txtslider.image(map.get(i)!!)

            sliderLayout.addSlider(txtslider)
            sliderLayout.setPresetTransformer(SliderLayout.Transformer.)
        }



    }
}