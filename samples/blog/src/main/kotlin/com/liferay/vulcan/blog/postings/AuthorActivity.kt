package com.liferay.vulcan.blog.postings

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.liferay.vulcan.consumer.screens.ThingScreenlet

class AuthorActivity : AppCompatActivity() {

    val thingScreenlet by lazy {
        findViewById(R.id.thing_screenlet) as ThingScreenlet
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_author)

        val id = intent.getStringExtra("id")
        thingScreenlet.load(id)
    }

}