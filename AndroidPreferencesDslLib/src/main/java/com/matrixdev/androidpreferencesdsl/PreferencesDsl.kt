package com.matrixdev.androidpreferencesdsl

import androidx.preference.Preference
import androidx.preference.PreferenceGroup

/**
 * @author Rostyslav.Lesovyi
 */

@DslMarker
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE)
annotation class PreferenceDslMarker

@PreferenceDslMarker
class Dsl<T : Preference>(val it: T, parent: PreferenceGroup?, key: String) {
	companion object {
		fun <T : Preference> attach(preference: T, parent: PreferenceGroup?, key: String) = preference.also {
			preference.key = if (parent == null || key.isNotEmpty()) {
				key
			} else {
				parent.key + "_" + parent.preferenceCount
			}
			parent?.addPreference(preference)
		}
	}

	init {
		if (parent != null) attach(it, parent, key)
	}

	var title
		get() = it.title
		set(value) {
			it.title = value
		}

	var summary
		get() = it.summary
		set(value) {
			it.summary = value
		}

	fun setTitle(textResId: Int) = it.setTitle(textResId)
	fun setSummary(textResId: Int) = it.setSummary(textResId)

}
