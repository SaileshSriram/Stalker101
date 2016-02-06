package com.food.pewpewpew.catchme;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;

/**
 * Created by sailesh on 2/6/16.
 */
public class ParseInitApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "SqCcFj77lMJUaNUChbq7UzEKIR0X8FpxIY7ubcQy", "8JRDeyilogAKKsucSfPM2ex4QDUj0kkWhcEScj4e");
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
