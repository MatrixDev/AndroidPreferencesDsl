package com.matrixdev.androidpreferencesdsl

import androidx.preference.*

/**
 * @author Rostyslav.Lesovyi
 */

inline fun <T : PreferenceGroup> Dsl<T>.category(
	key: String = "",
	block: @PreferenceDslMarker Dsl<PreferenceCategory>.() -> Unit
) = PreferenceCategory(it.context).apply { Dsl(this, it, key).block() }

inline fun <T : PreferenceGroup> Dsl<T>.preference(
	key: String = "",
	block: @PreferenceDslMarker Preference.() -> Unit
) = Preference(it.context).apply { Dsl.attach(this, it, key).block() }

inline fun <T : PreferenceGroup> Dsl<T>.checkBox(
	key: String = "",
	block: @PreferenceDslMarker CheckBoxPreference.() -> Unit
) = CheckBoxPreference(it.context).apply { Dsl.attach(this, it, key).block() }

inline fun <T : PreferenceGroup> Dsl<T>.switch(
	key: String = "",
	block: @PreferenceDslMarker SwitchPreference.() -> Unit
) = SwitchPreference(it.context).apply { Dsl.attach(this, it, key).block() }

inline fun <T : PreferenceGroup> Dsl<T>.seekBar(
	key: String = "",
	block: @PreferenceDslMarker SeekBarPreference.() -> Unit
) = SeekBarPreference(it.context).apply { Dsl.attach(this, it, key).block() }

inline fun <T : PreferenceGroup> Dsl<T>.dropDown(
	key: String = "",
	block: DropDownPreference.() -> Unit
) = DropDownPreference(it.context).apply { Dsl.attach(this, it, key).block() }

inline fun <T : PreferenceGroup> Dsl<T>.editText(
	key: String = "",
	block: EditTextPreference.() -> Unit
) = EditTextPreference(it.context).apply { Dsl.attach(this, it, key).block() }

inline fun <T : PreferenceGroup> Dsl<T>.list(
	key: String = "",
	block: ListPreference.() -> Unit
) = ListPreference(it.context).apply { Dsl.attach(this, it, key).block() }

inline fun <T : PreferenceGroup> Dsl<T>.multiSelectList(
	key: String = "",
	block: MultiSelectListPreference.() -> Unit
) = MultiSelectListPreference(it.context).apply { Dsl.attach(this, it, key).block() }
