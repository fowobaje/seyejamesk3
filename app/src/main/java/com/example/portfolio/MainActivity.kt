package com.example.portfolio

import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    var  colorCode:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        toolbar.title = ("Portfolio")
        setSupportActionBar(toolbar)

        appbar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener{
            appBarLayout, i ->

                colorCode = -i
            if(colorCode > 255) colorCode = 255

            toolbar.background.alpha = colorCode
            toolbar.alpha = colorCode/256f

        })




        val GV = this.findViewById(R.id.gridv) as GridView

        val adapter = Custom_Adapter(this, R.layout.grid, data)

        GV.adapter = adapter
    }

    private fun setSupportActionBar(toolbar: CollapsingToolbarLayout?) {
        print("onCreate")
    }


    val data : ArrayList<CustomLayout>
    get() {

        val item_liste : ArrayList<CustomLayout> = ArrayList<CustomLayout>()

        item_liste.add(CustomLayout(R.drawable.google_drive, "Drive"))
        item_liste.add(CustomLayout(R.drawable.facebook, "Facebook"))
        item_liste.add(CustomLayout(R.drawable.twitter, "Twitter"))
        item_liste.add(CustomLayout(R.drawable.app_store, "Store"))
        item_liste.add(CustomLayout(R.drawable.skype, "Skype"))
        item_liste.add(CustomLayout(R.drawable.settings, "Setting"))
        item_liste.add(CustomLayout(R.drawable.spotify, "Spotify"))
        item_liste.add(CustomLayout(R.drawable.pitrest, "Pinterest"))
        item_liste.add(CustomLayout(R.drawable.drop_box, "Dropbox"))
       

        return item_liste

    }


}




