package lou.kings.com.oneapp;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.ButterKnife;

/**
 * Created by jin on 2016.01.28.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
//        setContentView(getContentViewId());
//        ButterKnife.bind(this);
//        initData();
//        initView();
    }

//    public abstract int getContentViewId();

    public void initData() {

    }

    public void initView() {

    }


    public void initToolbar(Toolbar toolbar){
        if(null==toolbar){
            return;
        }
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
        setTitle("");
    }
}
