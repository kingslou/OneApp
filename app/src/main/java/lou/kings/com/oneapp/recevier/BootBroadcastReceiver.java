package lou.kings.com.oneapp.recevier;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.provider.SyncStateContract;
import android.util.Log;

import lou.kings.com.oneapp.Constans;
import lou.kings.com.oneapp.utils.AlarmService;
import lou.kings.com.oneapp.utils.CheakProcessRunningUtils;

/**
 * Created by YiMuTian on 2016/9/24.
 */

public class BootBroadcastReceiver extends BroadcastReceiver {
    private Context mContext;
    @Override
    public void onReceive(Context context, Intent intent) {
        mContext = context;
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            Log.i("BootBroadcastReceiver", "BroadcastReceiver onReceive here.... ");
            Handler handler = new Handler(Looper.getMainLooper());
            //after reboot the device,about 2 minutes later,upload the POI info to server
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(!CheakProcessRunningUtils.isProcessRunning(mContext, Constans.POI_SERVICE)){
                        AlarmService.invokeTimerPOIService(mContext);
                    }
                }
            }, Constans.BROADCAST_ELAPSED_TIME_DELAY);
        }
    }
}
