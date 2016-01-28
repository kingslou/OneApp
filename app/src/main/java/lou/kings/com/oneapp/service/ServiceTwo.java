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
    private final String keyServiceName = "lou.kings.com.oneapp.service.KeyService";

    IMyAidlInterface iMyAidlInterface = new IMyAidlInterface.Stub() {
        @Override
        public void startService() throws RemoteException {
            if(!CheakProcessRunningUtils.isProcessRunning(ServiceTwo.this,serviceName)){
                Intent intent = new Intent(ServiceTwo.this,ServiceOne.class);
                ServiceTwo.this.startService(intent);
            }
            if(!CheakProcessRunningUtils.isProcessRunning(ServiceTwo.this,keyServiceName)){
                Intent intent2 = new Intent(ServiceTwo.this,KeyService.class);
                ServiceTwo.this.startService(intent2);
            }
        }

        @Override
        public void stopService() throws RemoteException {
            Intent intent1 = new Intent(ServiceTwo.this,ServiceOne.class);
            Intent intent2 = new Intent(ServiceTwo.this,KeyService.class);
            ServiceTwo.this.stopService(intent1);
            ServiceTwo.this.stopService(intent2);
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
                    if(!CheakProcessRunningUtils.isProcessRunning(ServiceTwo.this,keyServiceName)){
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
