package e.dell.prototype;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class Main4Activity extends AppCompatActivity {

    VideoView vid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        vid=findViewById(R.id.vid);
        final String passcode=getIntent().getStringExtra("key");
        vid.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video));
        vid.start();
        vid.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent intent = new Intent(Main4Activity.this, Main2Activity.class);
                intent.putExtra("key",passcode);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onRestart()
    {
        super.onRestart();
        vid.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.videoreverse));
        vid.start();
        vid.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent intent = new Intent(Main4Activity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
