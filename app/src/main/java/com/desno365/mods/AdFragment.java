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

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class AdFragment extends Fragment {
	private AdView mAdView;

	public AdFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_ad, container, false);
	}

	@Override
	public void onActivityCreated(Bundle bundle) {
		super.onActivityCreated(bundle);

		// Gets the ad view defined in layout/fragment_ad.xml
		mAdView = (AdView) getView().findViewById(R.id.adView);

		// Create an ad request. Check logcat output for the hashed device ID to
		// get test ads on a physical device. e.g.
		// "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
		AdRequest adRequest = new AdRequest.Builder().build();

		// Start loading the ad in the background.
		mAdView.loadAd(adRequest);
	}

	/**
	 * Called when returning to the activity
	 */
	@Override
	public void onResume() {
		super.onResume();
		if (mAdView != null) {
			mAdView.resume();
		}
	}

	/**
	 * Called when leaving the activity
	 */
	@Override
	public void onPause() {
		if (mAdView != null) {
			mAdView.pause();
		}
		super.onPause();
	}

	/**
	 * Called before the activity is destroyed
	 */
	@Override
	public void onDestroy() {
		if (mAdView != null) {
			mAdView.destroy();
		}
		super.onDestroy();
	}

}