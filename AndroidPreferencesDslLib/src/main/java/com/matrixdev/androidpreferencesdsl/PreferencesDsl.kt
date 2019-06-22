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
class Dsl<T : Preference>(val it: T) {

	var title: CharSequence
		get() = it.title
		set(value) {
			it.title = value
		}

	var summary: CharSequence
		get() = it.summary
		set(value) {
			it.summary = value
		}

	fun setTitle(textResId: Int) = it.setTitle(textResId)
	fun setSummary(textResId: Int) = it.setSummary(textResId)

}
