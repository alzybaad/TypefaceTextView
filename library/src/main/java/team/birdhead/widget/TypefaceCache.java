package team.birdhead.widget;

import android.graphics.Typeface;

public interface TypefaceCache {

    Typeface get(String name);

    void put(String name, Typeface typeface);
}
