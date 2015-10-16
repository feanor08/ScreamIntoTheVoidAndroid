package lastweektonight.funstuff.feanor.screamintothevoid;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener {
    Button btnSend;
    EditText etText;
    Handler handler;
    MediaPlayer mp;

    int sound;
    Bundle extras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        extras = null;
        btnSend = (Button) findViewById(R.id.btnScream);
        etText = (EditText) findViewById(R.id.etText);
        sound = R.raw.scream1;
        if (extras != null) {
            sound = extras.getInt("keySound");
        }

        mp = MediaPlayer.create(this, sound);

        btnSend.setOnClickListener(this);
    }

    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.fade_into_the_distance);
        anim.reset();

        etText.clearAnimation();
        etText.startAnimation(anim);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnScream:
                StartAnimations();
                mp.start();
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        etText.setText("");
                        Toast.makeText(getApplicationContext(), "Now didnt that feel better!!", Toast.LENGTH_LONG).show();
                    }
                }, 3000);
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        mp.reset();
                        mp.release();
                        mp = MediaPlayer.create(getApplicationContext(), sound);
                        etText.setHint("Done? Or you still feeling it? Get it out");
                    }
                }, 2000);


                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
