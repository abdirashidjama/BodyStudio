package com.example.abdirashidjama.bodystudio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Created by abdirashidjama on 2018-08-16.
 */

public class WSQLiteDBHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "Workout_db";
    public static final String WORKOUT_TABLE_NAME= "activity_workout";
    public static final String WORKOUT_COLUMN_ID = "_id";
    //public static final String WORKOUT_COLUMN_DATE = "date";
    public static final String WORKOUT_COLUMN_NAME = "name";
    public static final String WORKOUT_COLUMN_WEIGHT = "weight";
    public static final String WORKOUT_COLUMN_SETS = "sets";
    public static final String WORKOUT_COLUMN_REPS = "reps";


    public WSQLiteDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL("CREATE TABLE " + WORKOUT_TABLE_NAME + " (" +
                WORKOUT_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "  +
                //WORKOUT_COLUMN_DATE + " TEXT, " +
                WORKOUT_COLUMN_NAME + " TEXT, " +
                WORKOUT_COLUMN_WEIGHT + " INT UNSIGNED, " +
                WORKOUT_COLUMN_SETS + " INT UNSIGNED, " +
                WORKOUT_COLUMN_REPS + " INT UNSIGNED" + ")");
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + WORKOUT_TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

}
