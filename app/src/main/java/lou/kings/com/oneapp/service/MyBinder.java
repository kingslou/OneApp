package lou.kings.com.oneapp.service;
import android.content.Context;
import android.os.Binder;
import android.util.Log;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import de.greenrobot.event.EventBus;
import lou.kings.com.oneapp.listener.MyKeyListener;

/**
 * Created by jin on 2016.02.03.
 */
public class MyBinder extends Binder {

    private MyKeyListener homeKeyListener;

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    private Context context;

    public MyBinder(Context context){
        this.context = context;
    }

    public void setKeyListener(){
        MyThread thread = new MyThread();
        executorService.execute(thread);
        executorService.shutdown();
    }

    class MyThread extends Thread{
        @Override
        public void run() {
            homeKeyListener = new MyKeyListener(context);
            homeKeyStart();
            homeKeyListener.startHomeListener(); //开启监听
        }
    }

    private void homeKeyStart(){

        homeKeyListener.setOnHomePressedListener(new MyKeyListener.OnHomePressedListener() {

            @Override
            public void onHomePressed() {
                EventBus.getDefault().postSticky("");
                Log.i("lock", "onHomePressed ========================================");
            }
            @Override
            public void onHomeLongPressed() {

                Log.i("lock", "onHomeLongPressed ========================================");

            }
            @Override
            public void onScreenPressed() {
                // TODO Auto-generated method stub

            }
            @Override
            public void offScreenPressed() {
                // TODO Auto-generated method stub
            }
        });
    }

}
