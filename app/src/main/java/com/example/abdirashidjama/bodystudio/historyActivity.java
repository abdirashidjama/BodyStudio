package com.example.abdirashidjama.bodystudio;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by abdirashidjama on 2018-08-18.
 */


public class historyActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        SQLiteDatabase database = new WSQLiteDBHelper(this).getReadableDatabase();
        String[] projection = {
                //WSQLiteDBHelper.WORKOUT_COLUMN_DATE,
                WSQLiteDBHelper.WORKOUT_COLUMN_NAME,
                WSQLiteDBHelper.WORKOUT_COLUMN_WEIGHT,
                WSQLiteDBHelper.WORKOUT_COLUMN_SETS,
                WSQLiteDBHelper.WORKOUT_COLUMN_REPS
        };
        String selection =
                WSQLiteDBHelper.WORKOUT_COLUMN_NAME +  "like ? and " +
                        WSQLiteDBHelper.WORKOUT_COLUMN_WEIGHT + " > ? and ";
        //String[] selectionArgs = {"%" + name }
        Cursor cursor = database.query(
                WSQLiteDBHelper.WORKOUT_TABLE_NAME,
                projection,
                null,
                null,//selectionArgs,
                null,
                null,
                null
        );
        ArrayList<String> display = new ArrayList<String>();

        try{
            while(cursor.moveToNext()){
                int i;
                //i = cursor.getColumnIndexOrThrow(WSQLiteDBHelper.WORKOUT_COLUMN_DATE);
                // String date = cursor.getString(i);

                i = cursor.getColumnIndexOrThrow(WSQLiteDBHelper.WORKOUT_COLUMN_NAME);
                String name = cursor.getString(i);

                i = cursor.getColumnIndexOrThrow(WSQLiteDBHelper.WORKOUT_COLUMN_WEIGHT);
                String weight = cursor.getString(i);

                i = cursor.getColumnIndexOrThrow(WSQLiteDBHelper.WORKOUT_COLUMN_SETS);
                String sets = cursor.getString(i);

                i = cursor.getColumnIndexOrThrow(WSQLiteDBHelper.WORKOUT_COLUMN_REPS);
                String reps = cursor.getString(i);

                //display.add(date);
                display.add(name);
                display.add(weight);
                display.add(sets);
                display.add(reps);
                display.add("\n");
            }
        } finally {
            cursor.close();
        }
        TextView txt = (TextView) findViewById(R.id.dbDisplay);
        for(int i=0; i < display.size();i++){
            txt.append(display.get(i) + "\n");
        }
        Log.d("TAG", "cursor count is " + cursor.getCount());
    }


}
