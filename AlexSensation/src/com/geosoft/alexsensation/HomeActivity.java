package com.geosoft.alexsensation;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;



public class HomeActivity extends Activity {
 
	TextView tvData;
	@Override
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_animation);
        tvData = (TextView) findViewById(R.id.txtData);
        Button next = (Button) findViewById(R.id.fade_animation);
        next.setOnClickListener(app_connection);
    


    }
    
    
    
    private OnClickListener app_connection = new OnClickListener() {
    	private JSONObject jObject;
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
              	// Log.i("Praeda",response.getStatusLine().toString());
              	 
                 // Get hold of the response entity
                 HttpEntity entity = response.getEntity();
              	 
              	 // A Simple JSON Response Read
              	 InputStream instream = entity.getContent();              	 

             	 BufferedReader reader = new BufferedReader(new InputStreamReader(instream));
                 StringBuilder sb = new StringBuilder(); 
              	 
                 
                 String line = null;
                
                     while ((line = reader.readLine()) != null) {
                         sb.append(line + "\n");
                     }
					
                     
                     String result= sb.toString();                  
                 
                     
           
                     String x = "";
                   
                     JSONObject json=new JSONObject(result);

                     JSONArray nameArray=json.names();
                     JSONArray valArray=json.toJSONArray(nameArray);
                     
                     jObject = new JSONObject(result);

                     JSONArray tweets = jObject.getJSONArray("tweets");
                  
                     
                     x = "JSON parsed.\nThere are [" +tweets.length() + "]\n\n";
                     int i;
                     for (i=0;i<tweets.length();i++)
                     {
                    	                      
                     JSONObject  post = tweets.getJSONObject(i).getJSONObject("tweet");
                     
                     x += "------------";
                     x += "Date:" + post.getString("created_at") + "\n";
                     x += "Post:" + post.getString("tweet") + "\n\n";
                     }
                     tvData.setText(x);
                                         
                     Log.i("Home",result);

              } 
              catch (ClientProtocolException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
              } catch (IOException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
              }catch (JSONException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
              }


       //End   Connection
        }
    };

    
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

