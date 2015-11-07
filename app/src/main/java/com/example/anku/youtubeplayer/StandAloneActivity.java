package com.example.anku.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandAloneActivity extends AppCompatActivity implements View.OnClickListener {
    private String GOOGLE_API_KEY = "get it from //console.developers.google.com";
    private String YTUBE_VIDEO_ID = "any video id that u want to play eg. 2Rxoz13Bthc";
    private String YTUBE_PLAYLIST="any playlist id that u want to play eg. PL55713C70BA91BD6E";

    private Button btnPlayVideo;
    private Button btnPlayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stand_alone);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnPlayVideo= (Button) findViewById(R.id.btnPlayVideo);
        btnPlayList= (Button) findViewById(R.id.btnPlayList);
        btnPlayVideo.setOnClickListener(this);
        btnPlayList.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent =null;
        switch (v.getId()){
            case R.id.btnPlayVideo:
                intent= YouTubeStandalonePlayer.createVideoIntent(this,GOOGLE_API_KEY,YTUBE_VIDEO_ID);
                break;
            case R.id.btnPlayList:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this,GOOGLE_API_KEY,YTUBE_PLAYLIST);
                break;
            default:
                break;
        }
        if(intent!=null)
            startActivity(intent);
    }
}
