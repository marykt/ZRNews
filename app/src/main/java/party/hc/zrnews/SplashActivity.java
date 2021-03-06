package party.hc.zrnews;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGHT = 2000; // 两秒后进入系统

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new android.os.Handler().postDelayed(new Runnable() {
            public void run() {
                Intent mainIntent;
                SharedPreferences preferences=getSharedPreferences("userdata",MODE_PRIVATE);
                if(preferences.getBoolean("logged",false))
                {
                    mainIntent = new Intent(SplashActivity.this,
                            MainActivity.class);
                }
                else {
                    mainIntent = new Intent(SplashActivity.this,
                            LoginActivity.class);
                }

                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }

        }, SPLASH_DISPLAY_LENGHT);

    }

}
