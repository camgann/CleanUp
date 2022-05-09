//package com.example.cleanup_capstone;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import java.util.Date;
//
//public class DataBaseHandler extends SQLiteOpenHelper {
//
//    private static final int version = 1;
//    private static final String DBname = "CleanUpDB";
//    private static final String idCol = "ID";
//    private static final String tableName = "InProgress";
//    private static final String itemCol = "CleaningItem";
//    private static final String dateCol = "DateFinished";
//
//
//    //constructor
//    public DataBaseHandler(Context context){
//
//        super(context, DBname, null, version);
//    }
//
//    //creates new table
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String Query = "CREATE TABLE " + tableName + " (" + idCol + " INTEGER PRIMARY KEY AUTOINCREMENT, "
//                + itemCol + " TEXT," + dateCol + " TEXT)";
//
//        db.execSQL(Query);
//    }
//
//    //not sure what this is for
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int versionOld, int versionNew) {
//        db.execSQL("DROP TABLE IF EXISTS " + tableName);
//        onCreate(db);
//    }
//
//    //SQLite add information to inProgress Table
//    public void addNewItem(String item, String date){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//
//        values.put(itemCol, item);
//        values.put(dateCol, date);
//
//        db.insert(tableName,null,values);
//
//        db.close();
//    }
//}
