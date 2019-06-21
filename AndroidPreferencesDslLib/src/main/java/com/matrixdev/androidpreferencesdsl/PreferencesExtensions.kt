package com.matrixdev.androidpreferencesdsl

import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceScreen

/**
 * @author Rostyslav.Lesovyi
 */

inline fun <T : Preference> T.onClick(crossinline block: () -> Unit) {
	setOnPreferenceClickListener { true.apply { block() } }
}

inline fun <T : Preference> T.onChange(crossinline block: (value: Any?) -> Unit) {
	setOnPreferenceChangeListener { _, value -> true.apply { block(value) } }
}

inline fun PreferenceFragmentCompat.dsl(screenKey: String?, block: Dsl<PreferenceScreen>.() -> Unit): PreferenceScreen {
	val screen = preferenceManager.createPreferenceScreen(preferenceManager.context)
	screen.key = screenKey
	Dsl(screen, null, screenKey.toString()).block()
	return screen
}

inline fun PreferenceScreen.dsl(screenKey: String?, block: Dsl<PreferenceScreen>.() -> Unit) =
	apply { Dsl(this, null, this.key).block() }
