package com.example.portfolio

import android.app.Activity
import android.content.Context
import android.media.Image
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Custom_Adapter(private val  getContext: Context, private val CustomLayoutId : Int, private val custom_item : ArrayList<CustomLayout>)
    : ArrayAdapter<CustomLayout>(getContext, CustomLayoutId, custom_item) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var row = convertView

        val Holder : ViewHolder

        if (row == null){

        val inflater = (getContext as Activity).layoutInflater

        row = inflater!!.inflate(CustomLayoutId, parent, false)

        Holder = ViewHolder()

        Holder.img = row!!.findViewById(R.id.imageIv) as ImageView

        Holder.txt = row!!.findViewById(R.id.titleTv) as TextView

        row.setTag(Holder)

        } else {

            Holder = row.getTag() as ViewHolder
        }

        val item = custom_item[position]

        Holder.img!!.setImageResource(item.image)
        Holder.txt!!.setText(item.text)

        return row

    }
    class ViewHolder
    {
        internal var img : ImageView? = null
        internal var txt :TextView? = null
    }
}