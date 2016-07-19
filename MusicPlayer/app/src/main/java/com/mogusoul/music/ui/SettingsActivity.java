package com.mogusoul.music.ui;


import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mogusoul.music.core.musicplayer.R;
import com.mogusoul.music.utils.CollectionsUtils;
import com.mogusoul.music.utils.DeviceUtils;
import com.mogusoul.music.utils.PermissionUtils;

import java.lang.reflect.Method;

/**
 * A {@link PreferenceActivity} that presents a set of application settings. On
 * handset devices, settings are presented as a single list. On tablets,
 * settings are split by category, with category headers shown to the left of
 * the list of settings.
 * <p/>
 * See <a href="http://developer.android.com/design/patterns/settings.html">
 * Android Design: Settings</a> for design guidelines and the <a
 * href="http://developer.android.com/guide/topics/ui/settings.html">Settings
 * API Guide</a> for more information on developing a Settings UI.
 */
public class SettingsActivity extends AppCompatActivity {


    Button button;
    TextView textView;

    @Override
    @TargetApi(Build.VERSION_CODES.M)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);

        button = (Button) findViewById(R.id.permission);
        textView = (TextView) findViewById(R.id.text);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imei = "";
                try {

                    imei = DeviceUtils.getDeviceId(getActivity());
                    imei += " number: "+DeviceUtils.getSimSerialNumber(getActivity());

                } catch (Exception e) {
                    e.printStackTrace();
                }

//
//                PackageManager var2 = getActivity().getPackageManager();
//                try {
//                    int index = var2.checkPermission(Manifest.permission.READ_PHONE_STATE,getActivity().getPackageName());
//                    Log.i("permission", "index: " + index);
//                } catch (Exception e){
//
//                }

                try {
                    Class var1 = Class.forName("android.os.SystemProperties");
                    Method var2 = var1.getMethod("get", new Class[]{String.class, String.class});
                    String var0 = (String)((String)var2.invoke(var1, new Object[]{"ro.serialno", "unknown"}));
                    Log.i("permission", "serialno: " + var0);

                } catch (Exception var3) {
                }

                boolean show = PermissionUtils.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.READ_PHONE_STATE);
                boolean check = PermissionUtils.checkSelfPermission(getActivity(), Manifest.permission.READ_PHONE_STATE);

                Log.i("permission", "imei: " + imei + " show: " + show + " check: " + check);


                if (!check) {
//                    PermissionUtils.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_PHONE_STATE}, 1);
//                    requestPermissions(new String[]{Manifest.permission.READ_PHONE_STATE},1);
                }

            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        Log.i("permission", "requestCode: " + requestCode + " permissions: " + CollectionsUtils.toString(permissions) + " grantResults: " + CollectionsUtils.toString(grantResults));
//        Collections.emptySet();

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    protected Activity getActivity() {
        return this;
    }


}
