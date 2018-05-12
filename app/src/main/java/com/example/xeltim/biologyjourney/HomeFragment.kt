package com.example.xeltim.biologyjourney

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(){

    val arr = arrayOf("https://i.imgur.com/zADUO7e.png", "https://i.imgur.com/EGtXTwE.png", "https://i.imgur.com/xOgIpFf.png", "https://i.imgur.com/clwUlk2.png")
    val arr2 = arrayOf("https://i.imgur.com/awsPTvN.png", "https://i.imgur.com/nHpBbBP.png", "https://i.imgur.com/2pkT8QY.png", "https://i.imgur.com/qb3BvJi.png",
            "https://i.imgur.com/d4F1aid.png", "https://i.imgur.com/HKsdvBp.png", "https://i.imgur.com/GSiIgT0.png", "https://i.imgur.com/GWc4QbE.png")
    val arr3 = arrayOf("https://i.imgur.com/6czvD7Y.png", "https://i.imgur.com/e1mAjUF.png", "https://i.imgur.com/xFxt4NR.png", "https://i.imgur.com/aaXGCue.png")
    val arr4 = arrayOf("https://i.imgur.com/V6LILOJ.png", "https://i.imgur.com/GcXvDer.png", "https://i.imgur.com/TofTvoZ.png", "https://i.imgur.com/s6sqzgN.png",
            "https://i.imgur.com/NjaiztC.png", "https://i.imgur.com/aAM47qr.png", "https://i.imgur.com/5pSTuVC.png", "https://i.imgur.com/Zkn0GtY.png",
            "https://i.imgur.com/eiyhzW6.png")
    val arr5 = arrayOf("https://i.imgur.com/KQzfBqT.png")


    val content: Array<Content>?  = arrayOf(Content(arr, " Lesson 1 - The Cell"), Content(arr2, " Lesson 2 - Chemistry of Cells"), Content(arr3, " Lesson 3 - Cell Type"),
            Content(arr4, " Lesson 4 - Cell Membrane"), Content(arr5, " Lesson 5 - Cell Wall"))

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {

        var root: View = inflater!!.inflate(R.layout.fragment_home, container, false)

        var adapter: LessonAdapter = LessonAdapter(activity, 0, content)

        var listview = root.findViewById<ListView?>(R.id.listview_forecast) as ListView?

        listview?.setAdapter(adapter)

        listview?.setOnItemClickListener(AdapterView.OnItemClickListener(){ parent, view, position, id ->
            Item(position)
        })

        return root
    }

    protected inline fun Item(i: Int){
        var intent: Intent = Intent(activity, Lesson::class.java)
        intent.putExtra("title", content?.get(i)?.title)
        intent.putExtra("url", content?.get(i)?.URL)
        startActivity(intent)
    }

}