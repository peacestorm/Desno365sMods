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

package com.desno365.mods.Tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import com.desno365.mods.Activities.MainActivity;
import com.desno365.mods.R;
import com.desno365.mods.SharedConstants.SharedConstants;


public class FragmentTab6 extends Fragment {

	private Boolean displayingAllChangelog = false;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragmenttab6, container, false);

		TextView textGuns = (TextView) rootView.findViewById(R.id.latest_version_guns_is);
		textGuns.setText(MainActivity.gunsModVersion);

		final TextView textChangelogGuns = (TextView) rootView.findViewById(R.id.guns_changelog);
		textChangelogGuns.setText(android.text.Html.fromHtml(MainActivity.gunsModChangelog));
		textChangelogGuns.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
		textChangelogGuns.setMaxLines(SharedConstants.CHANGELOG_TEXT_MAX_LINES);

		final TextView textShowHide = (TextView) rootView.findViewById(R.id.changelog_show_hide_tab6);
		textShowHide.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!displayingAllChangelog) {
					textChangelogGuns.setMaxLines(99999);
					displayingAllChangelog = true;
					textShowHide.setText(getResources().getString(R.string.hide_changelog));
				} else {
					textChangelogGuns.setMaxLines(SharedConstants.CHANGELOG_TEXT_MAX_LINES);
					displayingAllChangelog = false;
					textShowHide.setText(getResources().getString(R.string.show_changelog));
				}
			}
		});
		textShowHide.setText(getResources().getString(R.string.show_changelog));
		ViewTreeObserver vto = textShowHide.getViewTreeObserver();
		vto.addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {
			@Override
			public void onGlobalLayout() {
				if (textChangelogGuns.getLineCount() < SharedConstants.CHANGELOG_TEXT_MAX_LINES) {
					textShowHide.setVisibility(View.GONE);
				} else {
					textShowHide.setVisibility(View.VISIBLE);
				}
			}
		});

		return rootView;
	}

}
