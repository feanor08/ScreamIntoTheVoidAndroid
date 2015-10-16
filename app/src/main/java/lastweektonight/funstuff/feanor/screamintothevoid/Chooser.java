package lastweektonight.funstuff.feanor.screamintothevoid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by feanor on 10/9/2015.
 */
public class Chooser extends Activity implements View.OnClickListener {

    Button btnMountDoomActivity, btnBlackHoleActivity;
    Intent iNextActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooser);

        btnMountDoomActivity = (Button) findViewById(R.id.btnPlaceMtDoom);
        btnBlackHoleActivity = (Button) findViewById(R.id.btnPlaceBlackHole);
        btnMountDoomActivity.setOnClickListener(this);
        btnBlackHoleActivity.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPlaceMtDoom:
                iNextActivity = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(iNextActivity);

                break;
            case R.id.btnPlaceBlackHole:
                iNextActivity = new Intent(getApplicationContext(), BlackHoleActivity.class);

                startActivity(iNextActivity);
                break;

        }
    }
}
