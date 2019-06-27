package com.matrixdev.androidpreferencesdsl.test

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.matrixdev.androidpreferencesdsl.*

/**
 * @author Rostyslav.Lesovyi
 */
class TestFragment : PreferenceFragmentCompat() {

	override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
		buildPreferenceScreen(rootKey) {
			category {
				title = "Category #1"

				preference {
					title = "Regular preference title"
					summary = "Regular preference summary"
					setIcon(android.R.drawable.ic_dialog_info)
				}
			}
			category {
				title = "Category #2"

				val switch = switch {
					title = "Switch title"
					isChecked = true
					summary = "Switch summary"
					setIcon(android.R.drawable.ic_lock_lock)
					onChange { summary = "Switch changed to $it" }
				}

				checkBox {
					title = "CheckBox title"
					summary = "CheckBox summary"
					dependency = switch.key
					setIcon(android.R.drawable.ic_menu_compass)
					onChange { summary = "CheckBox changed to $it" }
				}
			}
		}
	}

}
