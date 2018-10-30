package e.dell.prototype;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

public class Settingsfragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.prefss);
    }
}
