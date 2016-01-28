package lou.kings.com.oneapp.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by jin on 2016.01.28.
 */
public class KeyService extends Service {

    MyBinder binder = new MyBinder();

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

    class MyBinder extends Binder{
        public void KeyListener(){
            Thread threadstart = new Thread(new Runnable() {
                @Override
                public void run() {

                }
            });
            threadstart.start();
        };
    }
}
