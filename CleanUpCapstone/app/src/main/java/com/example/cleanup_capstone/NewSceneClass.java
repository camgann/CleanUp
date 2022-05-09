package com.example.cleanup_capstone;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class NewSceneClass extends Activity{
    //declare variables
    Button backButton;
    String item = "";
    String weeks = "";
    String days = "";
    Button goButton;
    Spinner houseItemsSpin;
    Spinner daysSpin;
    Spinner weeksSpin;
    ArrayList<String> houseItems = new ArrayList<String>();
    Integer[] daysList = {1,2,3,4,5,6,7};
    Integer[] weeksList = new Integer[20];
    LocalDate endDate;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newscene);
        addListenerOnButton(R.id.backButton2, backButton, ButtonSceneClass.class);
        addListenerOnButton(R.id.goButton, goButton, InProgressClass.class);
        //spinner = dropdown menu
        houseItemsSpin = (Spinner) findViewById(R.id.itemsSpinner);
        daysSpin = (Spinner) findViewById(R.id.daysSpin);
        weeksSpin = (Spinner) findViewById(R.id.weeksSpin);

        for(int i= 0; i < weeksList.length; i++){
            weeksList[i] = i + 1;
        }
        //if time add option to spinner to create your own item
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

        ArrayAdapter<Integer> arrayAdapter2 = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, daysList);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        daysSpin.setAdapter(arrayAdapter2);

        ArrayAdapter<Integer> arrayAdapter3 = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, weeksList);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weeksSpin.setAdapter(arrayAdapter3);

        //figuring out date the item will be ready to complete
        days = (daysSpin.getSelectedItem().toString());
        weeks = (weeksSpin.getSelectedItem().toString());

        LocalDate date = LocalDate.now();
        endDate = date.plus((Integer.parseInt(weeks)*7)+Integer.parseInt(days), ChronoUnit.DAYS);

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
                    item = (houseItemsSpin.getSelectedItem().toString());
                    Intent sendIntent = new Intent(getApplicationContext(), InProgressClass.class);
                    sendIntent.putExtra("messageKey", item);
                    sendIntent.putExtra("messageKey2", endDate);
                    //DataBaseHandler dataBaseHandler = new DataBaseHandler(NewSceneClass.this);
                    startActivity(sendIntent);
                }
            }
        });
    }

    //sends selected item to inProgress class
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id){
        Toast.makeText(getApplicationContext(), houseItems.get(position), Toast.LENGTH_LONG).show();
        //Toast.makeText(getApplicationContext(), daysList[position], Toast.LENGTH_LONG).show();
    }

    public void onNoSelection(AdapterView<?> arg0){

    }
}
