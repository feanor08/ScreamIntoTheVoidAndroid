package lastweektonight.funstuff.feanor.screamintothevoid;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by feanor on 10/16/2015.
 */
public class BlackHoleActivity extends Activity implements View.OnClickListener {
    Button btnSend;
    EditText etText;
    Handler handler;
    MediaPlayer mp;

    int sound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_hole);

        btnSend = (Button) findViewById(R.id.btnScream1);
        etText = (EditText) findViewById(R.id.etText1);

        sound = R.raw.scream1;
        mp = new MediaPlayer();


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

            case R.id.btnScream1:
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
                        etText.setHint("Done? Or you still feeling it? Get it out");
                    }
                }, 2000);


                break;
        }
    }
}




