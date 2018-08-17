package gengyaping.phoneapp;

import android.app.Application;
import android.content.Context;

/**
 * Created by dell on 2018/8/16.
 */

public class AppApplication extends Application {
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context provideContext(){
        return context;
    }
}
