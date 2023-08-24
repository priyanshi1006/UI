package com.example.sqlite_example;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper{
    private static int DB_VERSION = 1;
    private static String DB_NAME = "kevin";
    private static String TABLE_USER = "student";
    private static String KEY_ID = "id";
    private static String KEY_NAME = "name";
    private static String KEY_DEPT = "deartment";

    public DBHelper(Context context){
        super(context,DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE "+ TABLE_USER + " ( " + KEY_ID +" INTEGER PRIMARY KEY AUTOINCREMENT , " + KEY_NAME + " TEXT, "+ KEY_DEPT +" TEXT)";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    public void insertQuery(String name, String dept)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAME, name);
        cv.put(KEY_DEPT, dept);
        db.insert(TABLE_USER, null, cv);

    }

    public ArrayList<HashMap<String, String>> show(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USER, new String[]{KEY_NAME, KEY_DEPT,KEY_ID}, null,null, null, null, null);
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();


        while (cursor.moveToNext()){
            HashMap<String,String> user = new HashMap<>();
            user.put("name",cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            user.put("Dept",cursor.getString(cursor.getColumnIndex(KEY_DEPT)));
            user.put("ID",cursor.getString(cursor.getColumnIndex(KEY_ID)));
            userList.add(user);
        }
        return  userList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
