package com.example.abdirashidjama.bodystudio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logWorkOut(View view){
        Intent intent = new Intent(this, workoutActivity.class);
        startActivity(intent);
    }

    public void history(View view){
        Intent gethistoryActivity = new Intent(MainActivity.this, historyActivity.class);
        startActivity(gethistoryActivity);
    }

    public void journal(View view){
        Intent getjournalActivity = new Intent(MainActivity.this, journalActivity.class);
        startActivity(getjournalActivity);
    }
}
