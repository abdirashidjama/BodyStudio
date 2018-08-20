package com.example.abdirashidjama.bodystudio;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import android.widget.Toast;

/**
 * Created by abdirashidjama on 2018-08-19.
 */

public class journalEntries extends ListActivity {
    ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journalentries);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        Map<String, ?> dates = preferences.getAll();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listItems);
        setListAdapter(adapter);
        for(Map.Entry<String, ?> entry : dates.entrySet()){
            listItems.add(entry.getKey());
            adapter.notifyDataSetChanged();
        }
        final ListView listv = (ListView)findViewById(android.R.id.list);
        listv.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener(){
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String item = (String) listv.getItemAtPosition(position);
            Toast.makeText(getApplicationContext(), "You selected : " + item, Toast.LENGTH_LONG).show();
            Intent intent = new Intent();
            intent.putExtra("date", item);
            setResult(RESULT_OK,intent);
            finish();
        }
        });
    }
}
