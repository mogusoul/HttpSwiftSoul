package com.mogusoul.music.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.WindowManager;

/**
 * Created by Administrator on 2016/6/20.
 */
public class AlterDailog extends Dialog{


    public AlterDailog(Context context) {
        super(context);
    }

    public AlterDailog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public AlterDailog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public void init(){


        getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_DIALOG);





    }





}
