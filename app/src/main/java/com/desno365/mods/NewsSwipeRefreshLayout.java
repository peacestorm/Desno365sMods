/*
 * Copyright 2015 Dennis Motta
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.desno365.mods;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.util.Log;

import com.desno365.mods.Activities.MainActivity;


public class NewsSwipeRefreshLayout extends SwipeRefreshLayout {

	public NewsSwipeRefreshLayout(Context context) {
		super(context);
	}

	public NewsSwipeRefreshLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean canChildScrollUp() {
		try {
			return findViewById(R.id.scroll_news).canScrollVertically(-1);
		} catch (Exception e) {
			Log.e(MainActivity.TAG, "NullPointerException at canChildScrollUp() at SwipeRefreshLayout", e);
			return false;
		}
	}
}
