package lou.kings.com.oneapp.service;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import lou.kings.com.oneapp.aidl.IMyAidlInterface;
import lou.kings.com.oneapp.utils.CheakProcessRunningUtils;

/**
 * Created by jin on 2016.01.27.
 */
public class ServiceTwo extends Service{

    private final String serviceName = "lou.kings.com.oneapp.service.ServiceOne";

    IMyAidlInterface iMyAidlInterface = new IMyAidlInterface.Stub() {
        @Override
        public void startService() throws RemoteException {

        }

        @Override
        public void stopService() throws RemoteException {

        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(!CheakProcessRunningUtils.isProcessRunning(ServiceTwo.this,serviceName)){
                        try {
                            iMyAidlInterface.startService();
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }
}
