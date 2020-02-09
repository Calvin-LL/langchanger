package sh.calvin.langchanger;

import java.util.Locale;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;

public class LocaleChangedReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Resources res = context.getResources();
        if (!res.getConfiguration().locale.getLanguage().equals("en")) {
            Locale locale = new Locale("en", "US");
            try {
                MainActivity.changeLanguage(locale);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}