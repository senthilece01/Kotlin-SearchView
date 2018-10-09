package com.example.senthil.kotlin_recyclerview.Utils

import com.example.senthil.kotlin_recyclerview.Model.Course
import com.example.senthil.kotlin_recyclerview.R

class Helper{
    companion object {
        fun <ArrayList> getVersionsList(): ArrayList {
            var courseList = ArrayList<Course>()
            courseList.add(Course("Kotlin Android", "Create tutorial for people to learn kotlin Android"))
            courseList.add(Course("Java Android", "Java technology - Spring framework - approach to java by sample"))
            courseList.add(Course("Swift iOS", "Create tutorial for people to learn swift iOS"))
            courseList.add(Course("Objective C iOS", "Create tutorial for people to learn Objective C iOS"))
            courseList.add(Course("Python", "Create tutorial for people to learn python"))
            courseList.add(Course("React", "Create tutorial for people to learn react"))

            return courseList as ArrayList
        }
    }
}