package com.example.wyattfraley.golftracker;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ShowAllHoles extends AppCompatActivity {
    FXUtility fxUtility;
    List<Button> buttons;
    List<TextView> textViews;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_holes);

        fxUtility = new FXUtility();

        TotalRoundStats stats = LoadTotalStats();
        InitializeButtons();
        InitializeText();
    }
    public void InitializeButtons() {
        buttons = new ArrayList<>();

        Button toAdd = findViewById(R.id.holeButton1);
        buttons.add(toAdd);
        toAdd = findViewById(R.id.holeButton2);
        buttons.add(toAdd);
        toAdd = findViewById(R.id.holeButton3);
        buttons.add(toAdd);
        toAdd = findViewById(R.id.holeButton4);
        buttons.add(toAdd);
        toAdd = findViewById(R.id.holeButton5);
        buttons.add(toAdd);
        toAdd = findViewById(R.id.holeButton6);
        buttons.add(toAdd);
        toAdd = findViewById(R.id.holeButton7);
        buttons.add(toAdd);
        toAdd = findViewById(R.id.holeButton8);
        buttons.add(toAdd);
        toAdd = findViewById(R.id.holeButton9);
        buttons.add(toAdd);
        toAdd = findViewById(R.id.holeButton10);
        buttons.add(toAdd);
        toAdd = findViewById(R.id.holeButton11);
        buttons.add(toAdd);
        toAdd = findViewById(R.id.holeButton12);
        buttons.add(toAdd);
        toAdd = findViewById(R.id.holeButton13);
        buttons.add(toAdd);
        toAdd = findViewById(R.id.holeButton14);
        buttons.add(toAdd);
        toAdd = findViewById(R.id.holeButton15);
        buttons.add(toAdd);
        toAdd = findViewById(R.id.holeButton16);
        buttons.add(toAdd);
        toAdd = findViewById(R.id.holeButton17);
        buttons.add(toAdd);
        toAdd = findViewById(R.id.holeButton18);
        buttons.add(toAdd);
    }
    public void InitializeText() {
        textViews = new ArrayList<>();

        TextView toAdd = findViewById(R.id.holeStats1);
        toAdd.setVisibility(View.GONE);
        textViews.add(toAdd);
        toAdd = findViewById(R.id.holeStats2);
        toAdd.setVisibility(View.GONE);
        textViews.add(toAdd);
        toAdd = findViewById(R.id.holeStats3);
        toAdd.setVisibility(View.GONE);
        textViews.add(toAdd);
        toAdd = findViewById(R.id.holeStats4);
        toAdd.setVisibility(View.GONE);
        textViews.add(toAdd);
        toAdd = findViewById(R.id.holeStats5);
        toAdd.setVisibility(View.GONE);
        textViews.add(toAdd);
        toAdd = findViewById(R.id.holeStats6);
        toAdd.setVisibility(View.GONE);
        textViews.add(toAdd);
        toAdd = findViewById(R.id.holeStats7);
        toAdd.setVisibility(View.GONE);
        textViews.add(toAdd);
        toAdd = findViewById(R.id.holeStats8);
        toAdd.setVisibility(View.GONE);
        textViews.add(toAdd);
        toAdd = findViewById(R.id.holeStats9);
        toAdd.setVisibility(View.GONE);
        textViews.add(toAdd);
        toAdd = findViewById(R.id.holeStats10);
        toAdd.setVisibility(View.GONE);
        textViews.add(toAdd);
        toAdd = findViewById(R.id.holeStats11);
        toAdd.setVisibility(View.GONE);
        textViews.add(toAdd);
        toAdd = findViewById(R.id.holeStats12);
        toAdd.setVisibility(View.GONE);
        textViews.add(toAdd);
        toAdd = findViewById(R.id.holeStats13);
        toAdd.setVisibility(View.GONE);
        textViews.add(toAdd);
        toAdd = findViewById(R.id.holeStats14);
        toAdd.setVisibility(View.GONE);
        textViews.add(toAdd);
        toAdd = findViewById(R.id.holeStats15);
        toAdd.setVisibility(View.GONE);
        textViews.add(toAdd);
        toAdd = findViewById(R.id.holeStats16);
        toAdd.setVisibility(View.GONE);
        textViews.add(toAdd);
        toAdd = findViewById(R.id.holeStats17);
        toAdd.setVisibility(View.GONE);
        textViews.add(toAdd);
        toAdd = findViewById(R.id.holeStats18);
        toAdd.setVisibility(View.GONE);
        textViews.add(toAdd);
    }

    public TotalRoundStats LoadTotalStats() {
        TotalRoundStats stats = new TotalRoundStats();

        File file = new File( Environment.getExternalStorageDirectory() + "/Download/TotalStats.txt");

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                1);

        try {
            // Reading object in a file
            FileInputStream stream = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(stream);

            // Method for deserialization of object
            stats = (TotalRoundStats)in.readObject();

            in.close();
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return stats;
    }

    public void toggle_contents(View v){
        // First have to find the appropriate text box.
        int found = 0;
        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).isPressed()) {
                found = i;
                break;
            }
        }

        TextView toAnimate = textViews.get(found);


        if(toAnimate.isShown()){
            fxUtility.slide_up(this, toAnimate);
            toAnimate.setVisibility(View.GONE);
        }
        else{
            toAnimate.setVisibility(View.VISIBLE);
            fxUtility.slide_down(this, toAnimate);
        }
    }
}
