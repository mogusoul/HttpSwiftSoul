package com.mogusoul.music.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

/**
 * Created by Administrator on 2016/7/11.
 */
public class PermissionUtils {


    /**
     * checkSelfPermission.
     * @param context
     * @param permission
     * @return
     */
    public static boolean checkSelfPermission(Context context, String permission) {
        if (ActivityCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * requestPermissions.
     * @param context
     * @param permissions
     * @param requestCode
     */
    public static void requestPermissions(Activity context, String[] permissions, int requestCode){
        ActivityCompat.requestPermissions(context, permissions,requestCode);
    }

    /**
     * shouldShowRequestPermissionRationale.
     * @param context
     * @param permission
     * @return
     */
    public static boolean shouldShowRequestPermissionRationale(Activity context,String permission){
        return ActivityCompat.shouldShowRequestPermissionRationale(context,permission);
    }




    /**
     * READ_PHONE_STATE.
     * @param context
     * @return
     */
    public static boolean checkReadPhoneStatePermission(Context context) {
        return checkSelfPermission(context,Manifest.permission.READ_PHONE_STATE);
    }

}
