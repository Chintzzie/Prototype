package e.dell.prototype;

import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener{

    Button Internet;
    Button Call;
    Button Cam;
    Button Gallery;
    Button Game;
    Button Settings;
    Button Lock;
    Button Whatsapp;
    String pass1,pass2,pass3,pass4;
    boolean LockEnabled;
    String hint="Access Denied";

    @Override
    protected void onDestroy() {
        PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(this);
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Internet=findViewById(R.id.internet);
        Call=findViewById(R.id.call);
        Cam=findViewById(R.id.cam);
        Settings=findViewById(R.id.settings);
        Whatsapp=findViewById(R.id.whatsapp);
        Game=findViewById(R.id.game);
        Lock=findViewById(R.id.lock);
        Gallery=findViewById(R.id.gallery);
        SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(this);
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        LockEnabled=sharedPreferences.getBoolean("status",true);
        pass1=sharedPreferences.getString("pass1_key","1234");
        pass2=sharedPreferences.getString("pass2_key","1122");
        pass3=sharedPreferences.getString("pass3_key","3344");
        pass4=sharedPreferences.getString("pass4_key","4321");
        final String passcode=getIntent().getStringExtra("key");
        Internet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(passcode.equals(pass3)||passcode.equals(pass4)||!LockEnabled)
                {

                    Intent transfer=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com"));
                    startActivity(transfer);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),hint,Toast.LENGTH_SHORT).show();
                }
            }
        });
        Whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(passcode.equals(pass3)||passcode.equals(pass4)||!LockEnabled)
                {

                    Intent transfer=new Intent(Intent.ACTION_MAIN);
                    PackageManager managerclock = getPackageManager();
                    transfer = managerclock.getLaunchIntentForPackage("com.whatsapp");
                    transfer.addCategory(Intent.CATEGORY_LAUNCHER);
                    startActivity(transfer);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),hint,Toast.LENGTH_SHORT).show();
                }
            }
        });
        Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(passcode.equals(pass2)||passcode.equals(pass3)||passcode.equals(pass4)||!LockEnabled)
                {
                    Intent transfer=new Intent(Intent.ACTION_DIAL);
                    startActivity(transfer);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),hint,Toast.LENGTH_SHORT).show();
                }
            }
        });
        Cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(passcode.equals(pass1)||passcode.equals(pass2)||passcode.equals(pass3)||passcode.equals(pass4)||!LockEnabled)
                {
                    Intent transfer=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity(transfer);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),hint,Toast.LENGTH_SHORT).show();
                }
            }
        });
        Settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(passcode.equals(pass4)||!LockEnabled)
                {
                    Intent transfer=new Intent(android.provider.Settings.ACTION_SETTINGS);
                    startActivity(transfer);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),hint,Toast.LENGTH_SHORT).show();
                }
            }
        });
        Game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(passcode.equals(pass1)||passcode.equals(pass2)||passcode.equals(pass3)||passcode.equals(pass4)||!LockEnabled)
                {
                    Intent transfer=new Intent(Intent.ACTION_MAIN);
                    PackageManager managerclock = getPackageManager();
                    transfer = managerclock.getLaunchIntentForPackage("com.sticksports.spl2");
                    transfer.addCategory(Intent.CATEGORY_LAUNCHER);
                    startActivity(transfer);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),hint,Toast.LENGTH_SHORT).show();
                }

            }
        });
        Gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(passcode.equals(pass2)||passcode.equals(pass3)||passcode.equals(pass4)||!LockEnabled)
                {
                    Intent intent =  new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),hint,Toast.LENGTH_SHORT).show();
                }
            }
        });
        Lock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(passcode.equals(pass4)||!LockEnabled)
                {
                    Intent transfer=new Intent(Main2Activity.this,Configurationchanger.class);
                    startActivity(transfer);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),hint,Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        switch(key)
        {
            case "status":
                LockEnabled=sharedPreferences.getBoolean(key,true);
                return;
            case "pass1_key":
                pass1=sharedPreferences.getString("pass1_key","1234");
                return;
            case "pass2_key":
                pass1=sharedPreferences.getString("pass2_key","1122");
                return;
            case "pass3_key":
                pass1=sharedPreferences.getString("pass3_key","3344");
                return;
            case "pass4_key":
                pass1=sharedPreferences.getString("pass4_key","4321");
                return;
        }
    }
}
