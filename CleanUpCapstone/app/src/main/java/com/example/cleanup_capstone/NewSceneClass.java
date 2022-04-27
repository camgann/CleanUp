package com.example.cleanup_capstone;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class NewSceneClass extends Activity{
    Button backButton;
    String choice2 = "begin";
    ArrayList<String> choice = new ArrayList<String>();
    Button goButton;
    Spinner houseItemsSpin;
    Spinner daysSpin;
    Spinner weeksSpin;
    ArrayList<String> houseItems = new ArrayList<String>();
    Integer[] days = {1,2,3,4,5,6,7};
    Integer[] weeks = new Integer[20];

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newscene);
        addListenerOnButton(R.id.backButton2, backButton, ButtonSceneClass.class);
        addListenerOnButton(R.id.goButton, goButton, InProgressClass.class);
        houseItemsSpin = (Spinner) findViewById(R.id.itemsSpinner);
        daysSpin = (Spinner) findViewById(R.id.daysSpin);
        weeksSpin = (Spinner) findViewById(R.id.weeksSpin);

        for(int i= 0; i < weeks.length; i++){
            weeks[i] = i + 1;
        }
        houseItems.add("Kitchen Sink");
        houseItems.add("Blinds");
        houseItems.add("Bathroom Sink");
        houseItems.add("Mop Floor");
        houseItems.add("Vacuum Main Floor");
        houseItems.add("Wash bed sheets");
        houseItems.add("clean whole bathroom");
        houseItems.add("clean toilet");

        //adding items to arrayAdapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, houseItems);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        houseItemsSpin.setAdapter(arrayAdapter);

        ArrayAdapter<Integer> arrayAdapter2 = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, days);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        daysSpin.setAdapter(arrayAdapter2);

        ArrayAdapter<Integer> arrayAdapter3 = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, weeks);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weeksSpin.setAdapter(arrayAdapter3);

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
                if(b == R.id.goButton){
                    String s = "works";
                    choice.add(houseItemsSpin.getSelectedItem().toString());
                    Intent sendIntent = new Intent(getApplicationContext(), InProgressClass.class);
                    sendIntent.putExtra("messageKey", choice.get(choice.size()-1));
                    startActivity(sendIntent);
                }
            }
        });
    }

    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id){
        Toast.makeText(getApplicationContext(), houseItems.get(position), Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), days[position], Toast.LENGTH_LONG).show();
    }

    public void onNoSelection(AdapterView<?> arg0){

    }






}
