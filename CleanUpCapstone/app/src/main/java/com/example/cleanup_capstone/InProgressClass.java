package com.example.cleanup_capstone;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;


public class InProgressClass extends Activity{
    Button backButton;
    Button button;
    TextView receiver_msg;
    TableRow tableRow;
    TextView textView;
    TableLayout tableLayout;
    ArrayList<String> receivedChoice = new ArrayList<String>();


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inprogress);
        addListenerOnButton(R.id.backButton, backButton, ButtonSceneClass.class);
        tableLayout = (TableLayout) findViewById(R.id.inProgressTableLayout);
        Intent intent = getIntent();
        String str = intent.getStringExtra("messageKey");
        receiver_msg = (TextView)findViewById(R.id.check);
        receiver_msg.setText(str);
        receivedChoice.add((String)receiver_msg.getText());
        addToTable();
//        for (int i = 0; i < 4; i++) {
//            tableRow = new TableRow(getApplicationContext());
//            for (int j = 0; j < 3; j++) {
//                textView = new TextView(getApplicationContext());
//                textView.setText(receiver_msg.getText());
//                //receiver_msg.setText(str);
//                textView.setPadding(50, 100, 20, 20);
//                tableRow.addView(textView);
//            }
//            tableLayout.addView(tableRow);
//        }
    }

    public void addToTable(){
        tableRow = new TableRow(getApplicationContext());
        textView = new TextView(getApplicationContext());
        textView.setText(receivedChoice.get(receivedChoice.size()-1));
        textView.setTextSize(38);
        textView.setPadding(50, 100, 20, 20);
        tableRow.addView(textView);
        textView = new TextView(getApplicationContext());
        textView.setText("Hey");
        textView.setTextSize(38);
        tableRow.addView(textView);
        tableLayout.addView(tableRow);

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

/*    protected void onSavedInstanceState(@NonNull Bundle outState){
        outState.putString("key",(String)receiver_msg.getText());
        super.onSaveInstanceState(outState);
    }

    protected void onRestoreInstantState(@NonNull Bundle savedInstanceState){
        receivedChoice = savedInstanceState.getStringArrayList("key");
        Toast.makeText(getApplicationContext(),receivedChoice+"",Toast.LENGTH_SHORT).show();
        super.onRestoreInstanceState(savedInstanceState);
    }*/S

    protected void OnResume(){
        super.onResume();
        Toast.makeText(getApplicationContext(),"being called",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause(){
        super.onPause();

    }
}