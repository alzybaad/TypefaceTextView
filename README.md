TypefaceTextView
===

TextView which can set a custom font in assets by XML or Java.

Usage
---

XML:
```xml
<team.birdhead.widget.TypefaceTextView
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="\uf17b"
    app:typeface="font/fontawesome-webfont.ttf"/>
```

Java:
```java
TypefaceTextView textView;
textView.setTypeface("font/fontawesome-webfont.ttf");
```

Download
---
Gradle:
```groovy
repositories {
    maven { url 'http://team-birdhead.github.io/maven' }
}

dependencies {
    compile 'team.birdhead.typefacetextview:typefacetextview:1.0.0'
}
```

License
---
    Copyright 2016 alzybaad

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.