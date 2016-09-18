package lou.kings.com.oneapp;

import java.lang.reflect.Field;

/**
 * Created by YiMuTian on 2016/9/18.
 */

public class AppConfig {
    public static final String SHAREDPREFERENCE_NAME = "YunShan-POS-SP";
    public static final String APP_SERVER_FLAVOR = "staging";

    // 注意：代码混淆器的干扰
    public static String getServerFlavor() {
        String flavor = APP_SERVER_FLAVOR;
        try {
            // 注意这里类的包名是 "com.ieasy.yunshanphone"
            Class<?> c = Class.forName("com.ieasy.yunshanphone.FlavorConfig");
            Field field = c.getField("APP_SERVER_FLAVOR");
            flavor = (String) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flavor;
    }

    // 注意：代码混淆器的干扰
    private static String getAppUpgradeServerUrl(String fieldName) {
        String flavor = "";
        try {
            // 注意这里类的包名是 "com.ieasy.yunshanphone"
            Class<?> c = Class.forName("com.ieasy.yunshanphone.FlavorConfig");
            Field field = c.getField(fieldName);
            flavor = (String) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flavor;
    }

    public static String getAppUpgradeUrlForAllInPay() {
        return getAppUpgradeServerUrl("APP_UPGRADE_SERVER_URL_ALLINPAY");
    }

    public static String getAppUpgradeUrlForUnionPay() {
        return getAppUpgradeServerUrl("APP_UPGRADE_SERVER_URL_UNIONPAY");
    }

    public static String getAppUpgradeUrlForLakalaPay() {
        return getAppUpgradeServerUrl("APP_UPGRADE_SERVER_URL_LAKALAPAY");
    }
}
