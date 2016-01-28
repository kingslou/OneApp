package lou.kings.com.oneapp;

import android.app.Application;
import android.graphics.Typeface;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;

/**
 * Created by jin on 2016.01.28.
 */
public class App extends Application {
    private static final String CANARO_EXTRA_BOLD_PATH = "fonts/canaro_extra_bold.otf";
    public static Typeface canaroExtraBold;

    @Override
    public void onCreate() {
        super.onCreate();
        CustomActivityOnCrash.install(this);
        initTypeface();
    }

    private void initTypeface() {
        canaroExtraBold = Typeface.createFromAsset(getAssets(), CANARO_EXTRA_BOLD_PATH);

    }

}
