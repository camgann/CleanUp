package com.example.cleanup_capstone;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ButtonSceneClass extends Activity {
    Button readyButton;
    Button newButton;
    Button inProgressButton;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttonscene);
        addListenerOnButton(R.id.readyButton, readyButton, ReadySceneClass.class);
        addListenerOnButton(R.id.inProgressButton, inProgressButton, InProgressClass.class);
        addListenerOnButton(R.id.newButton, newButton, NewSceneClass.class);
    }

    public void addListenerOnButton(int b, Button button1, Class c) {
        final Context context = this;
        button1 = (Button) findViewById(b);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, c);
                startActivity(intent);
            }
        });
    }
}
