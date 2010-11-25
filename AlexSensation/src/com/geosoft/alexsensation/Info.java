package com.geosoft.alexsensation;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * A gallery of basic controls: Button, EditText, RadioButton, Checkbox,
 * Spinner. This example uses the light theme.
 */
public class Info extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
        
        Button next = (Button) findViewById(R.id.button_home);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), AlexSensation.class); 
                		
                startActivityForResult(myIntent, 0);
                  overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
            }

        });

       // Spinner s1 = (Spinner) findViewById(R.id.spinner1);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        //        android.R.layout.simple_spinner_item, mStrings);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //s1.setAdapter(adapter);
    }

 
}
