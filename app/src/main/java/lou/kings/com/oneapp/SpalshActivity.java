package lou.kings.com.oneapp;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by jin on 2016.01.26.
 */
public class SpalshActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //// TODO: 2016.01.28 判断是否已经登录 
            }
        },1000);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

}
