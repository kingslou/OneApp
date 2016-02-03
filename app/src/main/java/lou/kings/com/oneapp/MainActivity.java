package lou.kings.com.oneapp;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import lou.kings.com.oneapp.animation.GuillotineAnimation;
import lou.kings.com.oneapp.service.KeyService;
import lou.kings.com.oneapp.service.MyBinder;

public class MainActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.root)
    FrameLayout root;
    @Bind(R.id.content_hamburger)
    View contentHamburger;
    LinearLayout linsetting;
    private ServiceConnection serviceConnection;

    private static final long RIPPLE_DURATION = 250;

    private KeyService keyService;

    private MyBinder myBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        View guillotineMenu = LayoutInflater.from(MainActivity.this).inflate(R.layout.guillotine, null);
        linsetting = (LinearLayout)guillotineMenu.findViewById(R.id.settings_group);
        linsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startIntro();
            }
        });
        root.addView(guillotineMenu);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(null);
        }
        new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), contentHamburger)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .build();
        startService();
    }


    private void startIntro(){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, MyIntro.class);
        startService();
    }

    private void initBinder(){
        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                myBinder =  (MyBinder)service;
                myBinder.setKeyListener();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
    }

    private void startService(){
        Intent intent1 = new Intent(MainActivity.this, lou.kings.com.oneapp.service.ServiceOne.class);
        startService(intent1);

//        Intent intentkey = new Intent(MainActivity.this,KeyService.class);
//        startService(intentkey);
//        initBinder();
//        bindService(intentkey,serviceConnection,BIND_AUTO_CREATE);
//        Intent intent2 = new Intent(MainActivity.this, lou.kings.com.oneapp.service.ServiceTwo.class);
//        startActivity(intent2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
