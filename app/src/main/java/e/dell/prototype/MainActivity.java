package e.dell.prototype;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.locks.Lock;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    String pass1,pass2,pass3,pass4;
    String passcode="";
    EditText pass;
    Button submit;
    boolean LockEnabled;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit=findViewById(R.id.submit);
        pass=findViewById(R.id.pass);
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        LockEnabled=sharedPreferences.getBoolean("status",true);
        pass1=sharedPreferences.getString("pass1_key","1234");
        pass2=sharedPreferences.getString("pass2_key","1122");
        pass3=sharedPreferences.getString("pass3_key","3344");
        pass4=sharedPreferences.getString("pass4_key","4321");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passcode = pass.getText().toString();
                if (passcode.equals(pass1) || passcode.equals(pass2) || passcode.equals(pass3) || passcode.equals(pass4)||!LockEnabled)
                {
                    Intent intent = new Intent(MainActivity.this, Main4Activity.class);
                    intent.putExtra("key",passcode);
                    pass.setText(null);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Wrong password", Toast.LENGTH_SHORT).show();
                    pass.setText(null);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.launch,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId())
       {
           case R.id.forgotpass:
               Intent intent=new Intent(MainActivity.this,Main5Activity.class);
                startActivity(intent);
                return true;
       }
        return super.onOptionsItemSelected(item);
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
