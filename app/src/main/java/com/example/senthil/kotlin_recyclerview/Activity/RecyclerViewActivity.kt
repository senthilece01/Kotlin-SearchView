package com.example.senthil.kotlin_recyclerview.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.widget.LinearLayout
import com.example.senthil.kotlin_recyclerview.Adapter.CustomRecyclerAdapter
import com.example.senthil.kotlin_recyclerview.Model.Course
import com.example.senthil.kotlin_recyclerview.R
import com.example.senthil.kotlin_recyclerview.Utils.Helper
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    lateinit var adapter: CustomRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val rvRecyclerView = findViewById<RecyclerView>(R.id.sample_recyclerView)

        rvRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        adapter = CustomRecyclerAdapter(this, Helper.Companion.getVersionsList())
        rvRecyclerView.adapter = adapter

        sample_editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                filter(p0.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
    }

    fun filter(text: String) {

        val filteredCourseAry: ArrayList<Course> = ArrayList()

        val courseAry : ArrayList<Course> = Helper.Companion.getVersionsList()

        for (eachCourse in courseAry) {
            if (eachCourse.courseName!!.toLowerCase().contains(text.toLowerCase()) || eachCourse.courseDescrip!!.toLowerCase().contains(text.toLowerCase())) {
                filteredCourseAry.add(eachCourse)
            }
        }

        //calling a method of the adapter class and passing the filtered list
        adapter.filterList(filteredCourseAry);
    }
}
