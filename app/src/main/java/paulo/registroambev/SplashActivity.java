package paulo.registroambev;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;

public class SplashActivity extends Activity {

    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        iniciaSplash();

    }

    public void iniciaSplash(){
        setContentView(R.layout.activity_splash);

        new Thread(new Runnable() {
            @Override
            public void run() {
                counter++;

                try {
                    while (counter == 1 || counter <= 5){
                        Thread.sleep(1000);
                        counter++;
                        Log.e("Counter = ", Integer.toString(counter));
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                if(counter == 6){
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);

                    counter++;
                    Log.e("Counter = ", Integer.toString(counter));
                }

            }
        }).start();
    }

}
