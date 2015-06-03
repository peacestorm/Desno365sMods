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

package com.desno365.mods.Mods;

import com.desno365.mods.R;
import com.desno365.mods.SharedConstants.Keys;
import com.desno365.mods.SharedConstants.NotificationsId;
import com.desno365.mods.Tabs.FragmentTab2;


public class Portal extends Mod {

	public static final int viewPagerPosition = 2;

	public Portal() {

		super();

		this.ID = 2;
		this.nameId = R.string.mod1_title;

		this.NOTIFICATION_ID_NEW_VERSION = NotificationsId.ID_PORTAL_NEW_VERSION;
		this.DOWNLOAD_FROM_WEBSITE_LINK = Keys.KEY_PORTAL_DOWNLOAD;
		this.THREAD_LINK = Keys.KEY_PORTAL_THREAD;

	}

	public static FragmentTab2 getFragmentTab() {
		return new FragmentTab2();
	}

}