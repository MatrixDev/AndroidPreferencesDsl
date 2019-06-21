package com.matrixdev.androidpreferencesdsl.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @author Rostyslav.Lesovyi
 */
class TestActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		supportFragmentManager.beginTransaction()
				.replace(android.R.id.content, TestFragment())
				.commit()
	}

}
