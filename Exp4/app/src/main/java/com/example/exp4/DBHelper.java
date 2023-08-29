package com.example.exp4;

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
    private static String TABLE_USER = "User";
    private static String KEY_ID = "id";
    private static String KEY_NAME = "username";
    private static String KEY_PWD = "password";

    public DBHelper(Context context){
        super(context,DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE "+ TABLE_USER + " ( " + KEY_ID +" INTEGER PRIMARY KEY AUTOINCREMENT , " + KEY_NAME + " TEXT  ,"+ KEY_PWD +" TEXT)";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    public void insertQuery(String name, String pass)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAME, name);
        cv.put(KEY_PWD, pass);
        db.insert(TABLE_USER, null, cv);

    }

    public ArrayList<HashMap<String, String>> find(String username)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        //Cursor cursor = db.query(TABLE_USER, new String[]{KEY_NAME, KEY_PWD,KEY_ID}, KEY_NAME +" = ", new String[]{username}, null, null, null);
        String query = "SELECT "+KEY_NAME+" , "+KEY_PWD+"  FROM "+ TABLE_USER + " WHERE "+ KEY_NAME + " = " + "'" +username+ "'";
        Cursor cursor = db.rawQuery(query,null);

        ArrayList<HashMap<String, String>> userList = new ArrayList<>();


        while (cursor.moveToNext()){
            HashMap<String,String> user = new HashMap<>();
            user.put("username",cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            user.put("password",cursor.getString(cursor.getColumnIndex(KEY_PWD)));
            //user.put("ID",cursor.getString(cursor.getColumnIndex(KEY_ID)));
            userList.add(user);
        }
        return  userList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        DB_VERSION =i1;

    }
}

