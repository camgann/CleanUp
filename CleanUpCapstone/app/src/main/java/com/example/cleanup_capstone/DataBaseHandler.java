package com.example.cleanup_capstone;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHandler extends SQLiteOpenHelper {

    private static final int version = 1;
    private static final String DBname = "CleanUpDB";
    private static final String Tablename = "InProgress";
    private static final String Itemcol = "CleaningItem";
    private static final String Hourcol = "HoursLeft";
    private static final String Mincol = "MinutesLeft";

    public DataBaseHandler(Context context){
        super(context, DBname, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String Query = "Create Table" +
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
