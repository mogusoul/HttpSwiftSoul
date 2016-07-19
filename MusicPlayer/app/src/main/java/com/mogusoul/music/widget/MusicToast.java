package com.mogusoul.music.widget;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/6/20.
 */
public class MusicToast {

    protected static Context context;

    public static void toast(){


        Toast toast = new Toast(context);

        toast.setView(null);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM,0,0);
        toast.show();
    }




}
