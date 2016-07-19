package com.mogusoul.music.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * Created by Administrator on 2016/7/11.
 */
public class DeviceUtils {


    public static String getDeviceId(Context context){

        TelephonyManager tm = ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE));
        String imei = tm.getDeviceId();

        return imei;
    }
    @TargetApi(Build.VERSION_CODES.M)
    public static String getSimSerialNumber(Context context){

        TelephonyManager tm = ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE));
        String serialNumber = tm.getSimSerialNumber();

        serialNumber += " Subscriber:>"+tm.getSubscriberId();
        serialNumber += ":>"+tm.getDeviceId(1);
        serialNumber += ":>"+tm.getLine1Number();
        serialNumber += ":>"+tm.getMmsUserAgent();

        serialNumber += ":>"+tm.getNetworkCountryIso();
        serialNumber += ":>"+tm.getNetworkOperator();
        serialNumber += ":>"+tm.getNetworkOperatorName();
        serialNumber += ":>"+tm.getNetworkType();

        serialNumber += ":>"+tm.getSimCountryIso();
        serialNumber += ":>"+tm.getSimOperator();
        serialNumber += ":>"+tm.getSimOperatorName();
        serialNumber += ":>"+tm.getPhoneType();
        serialNumber += ":>"+tm.getMmsUAProfUrl();
        serialNumber += ":>"+tm.getDeviceSoftwareVersion();



        String ANDROID_ID = Settings.System.getString(context.getContentResolver(), Settings.System.ANDROID_ID);
        serialNumber += " ANDROID_ID:"+ANDROID_ID;
        serialNumber += " MAC: "+getMac();


        return serialNumber;
    }


    public static String getMac() {
        String macSerial = null;
        String str = "";
        try {
            Process pp = Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ");
            InputStreamReader ir = new InputStreamReader(pp.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            for (; null != str;) {
                str = input.readLine();
                if (str != null) {
                    macSerial = str.trim();// 去空格
                    break;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return macSerial;
    }
    public static String getCpuinfo() {
        String macSerial = null;
        String str = "";
        try {
            Process pp = Runtime.getRuntime().exec("cat /proc/cpuinfo ");
            InputStreamReader ir = new InputStreamReader(pp.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            for (; null != str;) {
                str = input.readLine();
                if (str != null) {
                    macSerial = str.trim();// 去空格
                    break;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return macSerial;
    }




}
