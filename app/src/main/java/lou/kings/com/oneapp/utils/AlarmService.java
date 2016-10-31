package lou.kings.com.oneapp.utils;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.util.Log;
import android.widget.Toast;

import lou.kings.com.oneapp.Constans;
import lou.kings.com.oneapp.service.UploadPOIService;

/**
 * Created by YiMuTian on 2016/9/24.
 */

public class AlarmService {

    public static void invokeTimerPOIService(Context context){
        Toast.makeText(context,"定时器启动",Toast.LENGTH_LONG).show();
        PendingIntent alarmSender = null;
        Intent startIntent = new Intent(context, UploadPOIService.class);
        startIntent.setAction(Constans.POI_SERVICE_ACTION);
        try {
            alarmSender = PendingIntent.getService(context, 0, startIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        } catch (Exception e) {
        }
        AlarmManager am = (AlarmManager) context.getSystemService(Activity.ALARM_SERVICE);
        am.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), Constans.ELAPSED_TIME, alarmSender);
    }

    public static void cancleAlarmManager(Context context){
        Intent intent = new Intent(context,UploadPOIService.class);
        intent.setAction(Constans.POI_SERVICE_ACTION);
        PendingIntent pendingIntent=PendingIntent.getService(context, 0, intent,PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarm=(AlarmManager)context.getSystemService(Activity.ALARM_SERVICE);
        alarm.cancel(pendingIntent);
    }
}
