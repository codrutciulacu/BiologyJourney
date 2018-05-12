package com.example.xeltim.biologyjourney

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class LessonAdapter(context: Context?, resource: Int, content: Array<out Content>?) : ArrayAdapter<Content>(context, resource, content) {

    @Suppress("UNREACHABLE_CODE")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val content = getItem(position)

        var rowView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

        val text = rowView!!.findViewById<View>(R.id.list) as TextView
        text.text = content!!.title

        return rowView

    }
}