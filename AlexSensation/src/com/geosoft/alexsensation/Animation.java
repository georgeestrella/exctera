package com.geosoft.alexsensation;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


/**
 * <p>Example of explicitly starting and stopping the {@link LocalService}.
 * This demonstrates the implementation of a service that runs in the same
 * process as the rest of the application, which is explicitly started and stopped
 * as desired.</p>
 */
public class Animation extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_animation);

        // Watch for button clicks.
        Button button = (Button)findViewById(R.id.fade_animation);
        button.setOnClickListener(mFadeListener);
       
        
        
    }

    private OnClickListener mFadeListener = new OnClickListener() {
        public void onClick(View v) {
            // Request the next activity transition (here starting a new one).
            startActivity(new Intent(Animation.this, Info.class));            		
            		
            // Supply a custom animation.  This one will just fade the new
            // activity on top.  Note that we need to also supply an animation
            // (here just doing nothing for the same amount of time) for the
            // old activity to prevent it from going away too soon.
            overridePendingTransition(R.anim.fade, R.anim.hold);
        }
    };

    private OnClickListener mZoomListener = new OnClickListener() {
        public void onClick(View v) {
            // Request the next activity transition (here starting a new one).
            startActivity(new Intent(Animation.this, Info.class));
            // This is a more complicated animation, involving transformations
            // on both this (exit) and the new (enter) activity.  Note how for
            // the duration of the animation we force the exiting activity
            // to be Z-ordered on top (even though it really isn't) to achieve
            // the effect we want.
            overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
        }
    };
}

