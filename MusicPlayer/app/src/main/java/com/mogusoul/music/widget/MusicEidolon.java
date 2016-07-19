package com.mogusoul.music.widget;

import android.media.MediaRecorder;

/**
 * Created by Administrator on 2016/6/20.
 */
public class MusicEidolon {



    private void dps(){


        MediaRecorder mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setOutputFile("FileName");
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

    }
}
