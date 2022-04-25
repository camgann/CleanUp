package com.example.cleanup_capstone;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class InProgressClass extends Activity{
    Button backButton;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inprogress);
        addListenerOnButton(R.id.backButton, backButton, ButtonSceneClass.class);
    }

    public void addListenerOnButton(int b, Button button1, Class c) {
        final Context context = this;
        button1 = (Button)findViewById(b);
        //readyButton = findViewById(R.id.readyButton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, c);
                startActivity(intent);
            }
        });
    }
}