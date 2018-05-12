package com.example.xeltim.biologyjourney

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import com.squareup.picasso.Picasso

class Lesson : AppCompatActivity() {

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null
    private var mViewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)

        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)

        mViewPager = findViewById<View>(R.id.container) as ViewPager
        mViewPager!!.adapter = mSectionsPagerAdapter

    }

    class PlaceholderFragment : Fragment() {

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            val rootView = inflater!!.inflate(R.layout.fragment_lesson, container, false)
            val img = rootView.findViewById<View>(R.id.imageView) as ImageView
            val arr = arguments?.getString(ARG_PHOTO)
            Picasso.with(activity).load(arr).into(img)
            return rootView
        }


        companion object {

            private val ARG_SECTION_NUMBER = "section_number"
            private val ARG_PHOTO = "photo"

            fun newInstance(sectionNumber: Int, URL: String): PlaceholderFragment {
                val fragment = PlaceholderFragment()
                val args = Bundle()
                args.putString(ARG_PHOTO, URL)
                fragment.arguments = args
                return fragment
            }
        }
    }

    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            val intent = intent
            var arr: Array<String>? = null
            if (intent.hasExtra("url"))
                arr = intent.getStringArrayExtra("url")

            return PlaceholderFragment.newInstance(position + 1, arr!![position])
        }

        override fun getCount(): Int {
            var arr: Array<String>? = null
            if (intent.hasExtra("url"))
                arr = intent.getStringArrayExtra("url")

            return arr!!.size
        }
    }
}
