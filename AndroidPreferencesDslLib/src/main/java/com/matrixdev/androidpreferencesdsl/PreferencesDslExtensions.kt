package com.matrixdev.androidpreferencesdsl

import androidx.preference.*

/**
 * @author Rostyslav.Lesovyi
 */

inline fun <T : PreferenceGroup> Dsl<T>.category(
	key: String = "",
	block: @PreferenceDslMarker Dsl<PreferenceCategory>.() -> Unit
) = chainDsl(PreferenceCategory(it.context), key, block)

inline fun <T : PreferenceGroup> Dsl<T>.preference(
	key: String = "",
	block: @PreferenceDslMarker Preference.() -> Unit
) = chainFinal(Preference(it.context), key, block)

inline fun <T : PreferenceGroup> Dsl<T>.checkBox(
	key: String = "",
	block: @PreferenceDslMarker CheckBoxPreference.() -> Unit
) = chainFinal(CheckBoxPreference(it.context), key, block)

inline fun <T : PreferenceGroup> Dsl<T>.switch(
	key: String = "",
	block: @PreferenceDslMarker SwitchPreference.() -> Unit
) = chainFinal(SwitchPreference(it.context), key, block)

inline fun <T : PreferenceGroup> Dsl<T>.seekBar(
	key: String = "",
	block: @PreferenceDslMarker SeekBarPreference.() -> Unit
) = chainFinal(SeekBarPreference(it.context), key, block)

inline fun <T : PreferenceGroup> Dsl<T>.dropDown(
	key: String = "",
	block: @PreferenceDslMarker DropDownPreference.() -> Unit
) = chainFinal(DropDownPreference(it.context), key, block)

inline fun <T : PreferenceGroup> Dsl<T>.editText(
	key: String = "",
	block: @PreferenceDslMarker EditTextPreference.() -> Unit
) = chainFinal(EditTextPreference(it.context), key, block)

inline fun <T : PreferenceGroup> Dsl<T>.list(
	key: String = "",
	block: @PreferenceDslMarker ListPreference.() -> Unit
) = chainFinal(ListPreference(it.context), key, block)

inline fun <T : PreferenceGroup> Dsl<T>.multiSelectList(
	key: String = "",
	block: @PreferenceDslMarker MultiSelectListPreference.() -> Unit
) = chainFinal(MultiSelectListPreference(it.context), key, block)
