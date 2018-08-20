package com.example.abdirashidjama.bodystudio;

/**
 * Created by abdirashidjama on 2018-08-09.
 */

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.preference.PreferenceManager;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Date;
import java.util.Map;

public class journalActivity extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);
        //setting date on startup
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        EditText editText = (EditText)findViewById(R.id.dateTxt);
        editText.setText(date, TextView.BufferType.EDITABLE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode, data);
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
                Map<String, ?> mp = sp.getAll();
                EditText datetxt = (EditText) findViewById(R.id.dateTxt);
                EditText journaltxt = (EditText) findViewById(R.id.journalText);
                String dateretrieved = data.getStringExtra("date");
                datetxt.setText(dateretrieved);
                String jentry = sp.getString(dateretrieved,"");  //mp.get(data.getStringExtra("date")).toString();
                if(jentry !=""){
                    journaltxt.setText(jentry);
                }
            }
        }
    }

    public void logJournal(View view){
        EditText date = (EditText)findViewById(R.id.dateTxt);
        EditText journal = (EditText) findViewById(R.id.journalText);
        SharedPreferences prefrences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor= prefrences.edit();
        editor.putString(date.getText().toString(),journal.getText().toString());
        editor.commit();
        Toast.makeText(this,"added journal entry ", Toast.LENGTH_LONG).show();
    }
    public void pastEntries(View view){
        Intent getjournalEntries = new Intent(this, journalEntries.class);
        startActivityForResult(getjournalEntries, 1);

    }

}