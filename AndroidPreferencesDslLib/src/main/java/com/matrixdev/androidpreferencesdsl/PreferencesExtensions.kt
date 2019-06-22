package com.matrixdev.androidpreferencesdsl

import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceGroup
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

inline fun PreferenceFragmentCompat.buildPreferenceScreen(
	screenKey: String?,
	block: Dsl<PreferenceScreen>.() -> Unit
): PreferenceScreen {
	val screen = preferenceManager.createPreferenceScreen(preferenceManager.context)
	screen.key = screenKey
	screen.build(block)
	return screen
}

inline fun <T : PreferenceGroup> T.build(block: Dsl<T>.() -> Unit) = also {
	Dsl(it).block()
}

inline fun <T : Preference, K : PreferenceGroup> Dsl<K>.chainDsl(
	preference: T,
	key: String,
	block: Dsl<T>.() -> Unit
): T {
	chainFinal(preference, key) {}
	Dsl(preference).block()
	return preference
}

inline fun <T : Preference, K : PreferenceGroup> Dsl<K>.chainFinal(
	preference: T,
	key: String,
	block: T.() -> Unit
): T {
	if (key.isNotEmpty()) {
		preference.key = key
	} else {
		preference.key = it.key + "_" + it.preferenceCount
		preference.isPersistent = false
	}
	it.addPreference(preference)
	preference.block()
	return preference
}
