package lou.kings.com.oneapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 *  web页面打开app
 *  html调用方法
 *  <a id="openJD" href="appscheme://contentId">立即打开//</span></a>
 *  <a id="openJD" href="appscheme:///contentId">立即打开///</span></a>
 * Created by jin on 2016.02.03.
 */
public class SchemeCenter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Uri uri = getIntent().getData();
        Toast.makeText(this, "Uri:" + uri.toString(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Uri path:"+uri.getPath(), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
