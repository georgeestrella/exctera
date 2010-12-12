package com.geosoft.alexsensation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import android.content.Context;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.util.Log;
import android.widget.TextView;


public class TwitterActivity extends Activity {
	private JSONObject jObject;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.twitter);
     
          TextView tvData;
          tvData = (TextView) findViewById(R.id.txtData);

        //WebView mWebView;
        
        //mWebView = (WebView) findViewById(R.id.webview);
        //mWebView.getSettings().setJavaScriptEnabled(true);
        //mWebView.loadUrl("http://as.exctera.net/tweets/alex");

      
        
        
        //Start Connection              
        String url = "http://myapps.enelpatio.net/tweets/alex";              
        HttpClient httpclient = new DefaultHttpClient();
        
        // Prepare a request object
        HttpGet httpget = new HttpGet(url); 
    
        
        // Execute the request
        HttpResponse response;
        
 
        try { 
        /*
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
           
               
               
               String FILENAME = "tweets_file";
               FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
               fos.write(result.getBytes());
               fos.close();
           */  
        	  String FILENAME = "tweets_file";
              String result="";
               Log.i("Home",result);
               
               
                              
               FileInputStream fis = openFileInput(FILENAME);
             //  fis.read(result.getBytes());
               
               //result = fis.read();
               
               
            
               
           	
    		//InputStream is = fis.read();
    		byte [] buffer = new byte[fis.available()];
    		while (fis.read(buffer) != -1);
    		result = new String(buffer);
    		fis.close();   
               
               
               Log.i("Home",result);
               
               
     
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
               
               
               //Declaring and assigning varibles that will be use to convert time to string               
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");               
                Date d = null;
                String sdate  = post.getString("created_at");                             
                d = df.parse(sdate);
                long dateMin = 60000;
                long dateMax = (86400000 * 2);                
                long when = d.getTime();                
                int flags = 0;      
                
                String TimeInWords =    DateUtils.getRelativeDateTimeString(this, (when), dateMin, dateMax,flags).toString();

                Log.i("Home",TimeInWords);
               

                x += "------------"+ "\n";              
                x += post.getString("tweet") + "\n";
                x += TimeInWords + "\n\n";

               
               

               //Date date = df.parse(dateTime);

               
               
               //ParsePosition pos = new ParsePosition(0);
               //Date date = df.parse("2006-04-03T12:00:00Z", pos);
               
               //DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
               
               
               
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
        }catch (ParseException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        	}


 //End   Connection
        
        
        
        
        
        
        
        
        
        
        
        //setContentView(textview);
       
    }
}