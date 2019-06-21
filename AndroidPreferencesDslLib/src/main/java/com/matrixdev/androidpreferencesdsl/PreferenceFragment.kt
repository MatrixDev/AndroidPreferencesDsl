package com.matrixdev.androidpreferencesdsl

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

/**
 * @author Rostyslav.Lesovyi
 */
class PreferenceFragment : PreferenceFragmentCompat() {

	override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
		preferenceScreen = dsl(rootKey) {
			category {

			}
		}
	}

}
