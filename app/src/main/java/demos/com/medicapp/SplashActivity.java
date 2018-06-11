package demos.com.medicapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    final String TAG = SplashActivity.class.getName();
    // Splash screen timer
    private static int TIME_OUT = 3000;
    TextView appName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        appName = (TextView) findViewById(R.id.app_name);
        appName.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in));

        new Handler().postDelayed(new Runnable() {
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Log.d(TAG, "START NavigationActivity:");
                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);
                // Close this activity
                finish();
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        }, TIME_OUT);

        /*
        final Intent intent = new Intent(this, NavigationActivity.class);
        Thread thread = new Thread() {
            public void run() {
                try {
                    Log.d(TAG, "START NavigationActivity:");
                    sleep(3000);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    Log.d(TAG, "ERROR ELSE SplashActivity:" + e.getMessage());
                    e.printStackTrace();
                }
            }
        };
        thread.start();
        */
    }

}
