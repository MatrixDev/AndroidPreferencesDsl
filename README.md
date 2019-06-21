# AndroidPreferencesDsl

[![Release](https://jitpack.io/v/MatrixDev/flavorAlias.svg)](https://jitpack.io/#MatrixDev/flavorAlias)

# Overview

Tired of writing Android preferences xml files?

Than you're in luck. With this very small library you can create preferences screens purely in code with help of Kotlin DSL.

# Example

Creating preference screens is pretty easy.

First you'll need to initialize DSL in your `PreferenceFragmentCompat`:

```kotlin
override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
  preferenceScreen = dsl(rootKey) {
    // TODO ...
  }
}
```

Than you can start adding actual preferences:

```kotlin
dsl(rootKey) {
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

Custom `Preference` can be supported by just adding one extension functions:

```kotlin
inline fun <T : PreferenceGroup> Dsl<T>.myCustomPreference(
	key: String = "",
	block: MyCustomPreference.() -> Unit
) = MyCustomPreference(it.context).apply { Dsl.attach(this, it, key).block() }
```

And than `MyCustomPreference` can be used within DSL block:

```kotlin
category {
  ...

  myCustomPreference {
    title = "MyCustomPreference title"
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
    implementation 'com.github.MatrixDev:AndroidPreferencesDslLib:1.0.0'
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
