package team.birdhead.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.HashMap;

import team.birdhead.typefacetextview.R;

public class TypefaceTextView extends TextView {

    private static TypefaceCache sCache = null;

    public static synchronized void setCache(TypefaceCache cache) {
        sCache = cache;
    }

    private static synchronized TypefaceCache getCache() {
        return sCache != null ? sCache : (sCache = new WeakTypefaceCache());
    }

    public TypefaceTextView(Context context) {
        super(context);

        initialize(context, null, 0, 0);
    }

    public TypefaceTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initialize(context, attrs, 0, 0);
    }

    public TypefaceTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initialize(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TypefaceTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        initialize(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initialize(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TypefaceTextView, defStyleAttr, defStyleRes);
        try {
            setTypeface(a.getString(R.styleable.TypefaceTextView_typeface));
        } finally {
            a.recycle();
        }
    }

    public void setTypeface(String file) {
        if (file != null) {
            setTypeface(getTypeface(getContext(), file));
            setPaintFlags(getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        } else {
            setTypeface((Typeface) null);
        }
    }

    private static Typeface getTypeface(Context context, String file) {
        final TypefaceCache cache = getCache();
        Typeface typeface = cache.get(file);
        if (typeface == null) {
            typeface = Typeface.createFromAsset(context.getAssets(), file);
            cache.put(file, typeface);
        }

        return typeface;
    }

    private static class WeakTypefaceCache implements TypefaceCache {

        private final HashMap<String, WeakReference<Typeface>> mCache = new HashMap<>();

        @Override
        public Typeface get(String name) {
            final WeakReference<Typeface> reference = mCache.get(name);
            return reference != null ? reference.get() : null;
        }

        @Override
        public void put(String name, Typeface typeface) {
            mCache.put(name, new WeakReference<>(typeface));
        }
    }
}
