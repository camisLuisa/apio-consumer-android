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

package com.liferay.apio.blog.postings.screens.events

import android.view.View
import com.liferay.apio.consumer.model.Thing
import com.liferay.apio.blog.postings.screens.views.BaseView
import com.liferay.apio.blog.postings.screens.views.Scenario

sealed class Event<T> {
	class Click(val view: View, val thing: Thing) : Event<View.OnClickListener>()

	class FetchLayout(val view: BaseView? = null, val thing: Thing, val scenario: Scenario) : Event<Int>()
}
