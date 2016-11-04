package lou.kings.com.oneapp.utils;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import java.util.List;

import lou.kings.com.oneapp.App;

/**
 * Created by YiMuTian on 2016/11/4.
 */

public class PackageUtils {
    private static PackageManager packageManager = App.getAppInstance().getPackageManager();
    /**
     * 得到所有已安装的app
     *
     * @return
     */
    public static List<ResolveInfo> getAppList() {
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        // get all apps
        List<ResolveInfo> apps = packageManager.queryIntentActivities(mainIntent, 0);
        return apps;
    }

    /**
     * 该方法可以通过 loadIcon  loadLabel 返回apk的图标以及名称
     *
     * @param packageName
     * @return
     */
    public static ResolveInfo getAppInfo(String packageName) {
        ResolveInfo resolveInfo = null;
        for (ResolveInfo info : getAppList()) {
            if (info.activityInfo.packageName.equals(packageName)) {
                resolveInfo = info;
                break;
            }
        }
        return resolveInfo;
    }
}
