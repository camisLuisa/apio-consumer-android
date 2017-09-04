/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.vulcan.blog.postings.activity

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.liferay.vulcan.blog.postings.R
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class BlogPostingListTest {

	@Rule
	@JvmField
	val activityRule = ActivityTestRule(MainActivity::class.java)

	var server = MockWebServer()

	@Before
	fun setUp() {

		val response = MockResponse()
			.addHeader("Content-Type", "application/json; charset=utf-8")
			.addHeader("Cache-Control", "no-cache")
			.setBody("{}")
//		response.throttleBody(1024, 1, TimeUnit.SECONDS);

//		server = MockWebServer()
//
//		server.enqueue(MockResponse().setBody("hello, world!"))
//		server.start();
	}

	@Test
	fun appRendersLayoutTest() {

		val view = withId(R.id.thing_screenlet_activity)

		onView(view).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
	}

	@Test
	fun thingScreenletRenderingBlogsShowsResultsWithTextTest() {

		onView(withId(R.id.headline))
			.check(matches(isDisplayed()))
			.check(matches(withText("My Title")))
	}

	@After
	fun clean() {
		server.shutdown();
	}

}
