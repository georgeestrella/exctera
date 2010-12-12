package com.geosoft.alexsensation;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
       // button.setOnClickListener(mFadeListener);
       button.setOnClickListener(app_connection);
       
        
        
    }
    
    
    private OnClickListener app_connection = new OnClickListener() {
        public void onClick(View v) {

            //Start Connection
              
              String url = "http://myapps.enelpatio.net/tweets/alex";
              
              HttpClient httpclient = new DefaultHttpClient();
              
              // Prepare a request object
              HttpGet httpget = new HttpGet(url); 
       
              // Execute the request
              HttpResponse response;
              try { 
              	response = httpclient.execute(httpget);
              	 Log.i("Praeda",response.getStatusLine().toString());

              } 
              catch (ClientProtocolException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
              } catch (IOException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
              }

          
              String url2 = "http://myapps.enelpatio.net/tweets/alex";  
              
       //End   Connection
            
                    	
        	
        }
    };

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
           
            //Animation Example after click this button a transition animation happens
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

