package lou.kings.com.oneapp.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import lou.kings.com.oneapp.listener.MyKeyListener;

/**
 * Created by jin on 2016.01.28.
 */
public class KeyService extends Service {

    private MyKeyListener homeKeyListener;

    private MyBinder binder = new MyBinder(KeyService.this);

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
}
