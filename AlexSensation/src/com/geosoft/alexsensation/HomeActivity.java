package com.geosoft.alexsensation;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;



public class HomeActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_animation);
        Button next = (Button) findViewById(R.id.fade_animation);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Info.class);
                startActivityForResult(myIntent, 0);
                 overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
                 overridePendingTransition(R.anim.fade, R.anim.hold);
            }

        });


       
        //TextView textview = new TextView(this);
        //textview.setText("This is super the Home tab");
        //setContentView(textview);
        
        // Watch for button clicks.
       // Button button = (Button)findViewById(R.id.fade_animation);
        //button.setOnClickListener(mFadeListener);
        //setContentView(button); 
       
       // Intent intent;  // Reusable Intent for each tab

        //Create an Intent to launch an Activity for the tab (to be reused)
        //intent = new Intent().setClass(this, Info.class);
    }
    
    
    
    private OnClickListener mFadeListener = new OnClickListener() {
        public void onClick(View v) {
            // Request the next activity transition (here starting a new one).
            startActivity(new Intent(HomeActivity.this, Info.class));            		
            		
            // Supply a custom animation.  This one will just fade the new
            // activity on top.  Note that we need to also supply an animation
            // (here just doing nothing for the same amount of time) for the
            // old activity to prevent it from going away too soon.
            //overridePendingTransition(R.anim.fade, R.anim.hold);
            
            overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
            
        }
    };
    

    
}

