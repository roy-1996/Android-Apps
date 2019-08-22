package com.example.goodcalculator;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.Cursor;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper( Context context )
    {
        super(context , "database.db" , null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table OPERATIONS ( timestamp text, operation text, result text )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("drop table if exists OPERATIONS");
        onCreate(db);
    }


    /* Adds the operation, timestamp and the result to the result to the database */

    public boolean add_op( String time , String op , String res )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put( "timestamp" , time );
        values.put( "operation" , op );
        values.put( "result" , res );

        long x = db.insert( "OPERATIONS" , null , values );

        System.out.println("I am inserting" + x);
        return ( x == -1 ? false : true );

    }

    /* Returns all the operations from the database */

    public Cursor get_ops()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from OPERATIONS", null);
        //System.out.println("I am here");

        return cursor;
    }


}
