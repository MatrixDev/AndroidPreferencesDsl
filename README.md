# AndroidPreferencesDsl

[![Release](https://jitpack.io/v/MatrixDev/AndroidPreferencesDsl.svg)](https://jitpack.io/#MatrixDev/AndroidPreferencesDsl)

# Overview

Tired of writing Android preferences xml files?

Than you're in luck. With this very small library you can create preference screens purely in code with help of Kotlin DSL.

# Example

Creating a preference screen is pretty easy.

First you'll need to initialize DSL in your `PreferenceFragmentCompat`:

```kotlin
override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
  preferenceScreen = buildPreferenceScreen(rootKey) {
    ...
  }
}
```

Now you can start adding actual preferences:

```kotlin
buildPreferenceScreen(rootKey) {
  category {
    title = "Category #1"

    preference {
      title = "Regular preference title"
      summary = "Regular preference summary"
      setIcon(android.R.drawable.ic_dialog_info)
    }
  }
}
```

This library contains mappings for all AndroidX preferences. So to add `CheckBoxPreference` just add few lines of code:

```kotlin
category {
  ...

  checkBox {
    title = "CheckBox title"
    summary = "CheckBox summary"
    setIcon(android.R.drawable.ic_menu_compass)
    onChange { summary = "CheckBox changed to $it" }
  }
}
```

This will be the result:

![Example](https://github.com/MatrixDev/AndroidPreferencesDsl/blob/master/AndroidPreferencesDsl.png)

You can add support for your custom `AwesomePreference` class by writing just one extension function:

```kotlin
inline fun <T : PreferenceGroup> Dsl<T>.awesome(
	key: String = "",
	block: @PreferenceDslMarker AwesomePreference.() -> Unit
) = chainFinal(AwesomePreference(it.context), key, block)
```

And than `AwesomePreference` can be used within DSL block:

```kotlin
category {
  ...

  awesome {
    title = "Awesome!!!"
  }
}
```

# How to add dependencies?

To use this library in your project just add following lines:

### Step 1

Add JitPack repository in your root `build.gradle` file:

```gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

### Step 2

Add actual library and compiler dependencies:

```gradle
dependencies {
    implementation 'com.github.MatrixDev:AndroidPreferencesDsl:1.0.0'
}
```

More info can be found at https://jitpack.io/#MatrixDev/AndroidPreferencesDsl

# License

```
MIT License

Copyright (c) 2018 Rostyslav Lesovyi

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
