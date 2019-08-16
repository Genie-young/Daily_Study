package com.example.youtubeapi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity {

    YouTubePlayerView youtubeView;
    //Button button;
    YouTubePlayer.OnInitializedListener listener;

    @Override
    protected void onStart() {
        super.onStart();
        youtubeView.initialize("",listener); //구글 개발자 센터 API 키 넣기
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        //button = (Button)findViewById(R.id.youtube_button);
        youtubeView = (YouTubePlayerView) findViewById(R.id.youtubeview);
        listener = new YouTubePlayer.OnInitializedListener(){
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("");  //동영상 쿼리중 ?v=의 뒷부분만 삽입.
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
//        button.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                youtubeView.initialize("AIzaSyCbPeA-xHq7ncrnD6kiNncV_7tet4Cr4fY",listener);
//
//            }
//        });

    }
}
