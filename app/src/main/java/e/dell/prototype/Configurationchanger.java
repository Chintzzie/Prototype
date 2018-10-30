package e.dell.prototype;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Configurationchanger extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    TextView showpass1,showpass2,showpass3,showpass4;
    String pass1,pass2,pass3,pass4;

    @Override
    protected void onDestroy() {
        PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(this);
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurationchanger);

        showpass1=findViewById(R.id.pass1_show);
        showpass2=findViewById(R.id.pass2_show);
        showpass3=findViewById(R.id.pass3_show);
        showpass4=findViewById(R.id.pass4_show);
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        pass1=sharedPreferences.getString("pass1_key","1234");
        pass2=sharedPreferences.getString("pass2_key","1122");
        pass3=sharedPreferences.getString("pass3_key","3344");
        pass4=sharedPreferences.getString("pass4_key","4321");
        showpass1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Configurationchanger.this,pass1,Toast.LENGTH_SHORT).show();
            }
        });
        showpass2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Configurationchanger.this,pass2,Toast.LENGTH_SHORT).show();
            }
        });
        showpass3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Configurationchanger.this,pass3,Toast.LENGTH_SHORT).show();
            }
        });
        showpass4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Configurationchanger.this,pass4,Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        switch(key)
        {
            case "pass1_key":
                pass1=sharedPreferences.getString("pass1_key","1234");
                return;
            case "pass2_key":
                pass2=sharedPreferences.getString("pass2_key","1122");
                return;
            case "pass3_key":
                pass3=sharedPreferences.getString("pass3_key","3344");
                return;
            case "pass4_key":
                pass4=sharedPreferences.getString("pass4_key","4321");
                return;
        }
    }
}
