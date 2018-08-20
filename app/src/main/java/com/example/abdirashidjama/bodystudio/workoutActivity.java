package com.example.abdirashidjama.bodystudio;

/**
 * Created by abdirashidjama on 2018-05-30.
 */
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.Locale;

public class workoutActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
    }

    public void increment(View view){
        TextView txt = null;
        Button b = (Button) findViewById(view.getId());
        String bname = b.getResources().getResourceEntryName(view.getId());
        switch(bname){
            case "incrementerS":
                txt = (TextView)findViewById(R.id.setsEditText);
                break;
            case "incrementerW":
                txt = (TextView)findViewById(R.id.weightEditText);
                break;
            case "incrementerR":
                txt = (TextView)findViewById(R.id.repsEditText);
        }
        if(txt.getText().toString().matches("")){
            txt.setText("0");
        }
        else {
            int num = Integer.valueOf(txt.getText().toString()) + 1;
            txt.setText(String.valueOf(num));
        }
    }
    public void decrement(View view){
        TextView txt = null;
        Button b = (Button) findViewById(view.getId());
        String bname = b.getResources().getResourceEntryName(view.getId());
        switch(bname){
            case "decrementerS":
                txt = (TextView)findViewById(R.id.setsEditText);
                break;
            case "decrementerW":
                txt = (TextView)findViewById(R.id.weightEditText);
                break;
            case "decrementerR":
                txt = (TextView)findViewById(R.id.repsEditText);
        }
        int num = Integer.valueOf(txt.getText().toString()) - 1;
        txt.setText(String.valueOf(num));
    }

    public void logWorkOut(View view){
        SQLiteDatabase database = new WSQLiteDBHelper(this).getWritableDatabase();
        ContentValues values = new ContentValues();
        TextView name = (TextView) findViewById(R.id.ExerciseTextView);
        TextView weight = (TextView) findViewById(R.id.weightEditText);
        TextView sets = (TextView) findViewById(R.id.setsEditText);
        TextView reps = (TextView) findViewById(R.id.repsEditText);
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        //values.put(WSQLiteDBHelper.WORKOUT_COLUMN_DATE, date.toString());
        values.put(WSQLiteDBHelper.WORKOUT_COLUMN_NAME, name.getText().toString());
        values.put(WSQLiteDBHelper.WORKOUT_COLUMN_WEIGHT, weight.getText().toString());
        values.put(WSQLiteDBHelper.WORKOUT_COLUMN_SETS, sets.getText().toString());
        values.put(WSQLiteDBHelper.WORKOUT_COLUMN_REPS, sets.getText().toString());
        long newRowId = database.insert(WSQLiteDBHelper.WORKOUT_TABLE_NAME, null, values);
        Toast.makeText(this, "THe new Row ID is " + newRowId, Toast.LENGTH_LONG).show();
    }

}
