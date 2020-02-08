# langchanger

Inspired by https://github.com/loadrunner/language-reset

Change Android TV language back to english

I think it's a LG HDMI CEC problem?

.apk at release tab

After installing the app, you need to run this command: (adb needed)

`adb shell pm grant com.example.langfuck android.permission.CHANGE_CONFIGURATION`

and then on the tv with your remote in hand, turn on Settings->Apps->Special app access->Modify system settings->lang changer
