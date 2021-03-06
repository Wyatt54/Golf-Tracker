package com.example.wyattfraley.golftracker;

import android.annotation.SuppressLint;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ShowAllRounds extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    List<ScoreEntryDisplayRound> allRounds;
    List<Button> buttons;
    Spinner sortSpinner;
    ScrollView scrollView;
    LinearLayout ll;


    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_show_all_rounds);
        allRounds = new ArrayList<>();
        buttons = new ArrayList<>();
        InitializeSpinner();

        scrollView = findViewById(R.id.RoundScroll);

        ll = findViewById(R.id.allRoundsLL);
        ll.setOrientation(LinearLayout.VERTICAL);

        LoadRounds();
    }

    private void InitializeSpinner() {
        sortSpinner = findViewById(R.id.sortRoundsSpinner);
        sortSpinner.setOnItemSelectedListener(this);
        //sortSpinner.getBackground().setColorFilter(getResources().getColor(gray), PorterDuff.Mode.SRC_ATOP);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sort_rounds, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sortSpinner.setAdapter(adapter);
    }
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        Object itemAtPosition = parent.getItemAtPosition(pos);

        switch (itemAtPosition.toString()) {
            case "Played Order":
                SortByPlayedOrder();
                break;
            case "Best to Worst: Score":
                SortByBestToWorstScore();
                break;
            case "Worst to Best: Score":
                SortByWorstToBestScore();
                break;
        }
    }
    private void SortByPlayedOrder() {
        Comparator<ScoreEntryDisplayRound> comparator = new Comparator<ScoreEntryDisplayRound>() {
            @Override
            public int compare(ScoreEntryDisplayRound first, ScoreEntryDisplayRound second) {
                Date firstDate = new Date(first.uid);
                Date secondDate = new Date(second.uid);

                if (firstDate.compareTo(secondDate) > 0) {
                    return -1;
                }
                else if (firstDate.compareTo(secondDate) < 0) {
                    return 1;
                }
                return 0;
            }
        };

        allRounds.sort(comparator);
        DisplayScores();
    }
    private void SortByBestToWorstScore() {
        Comparator<ScoreEntryDisplayRound> comparator = new Comparator<ScoreEntryDisplayRound>() {
            @Override
            public int compare(ScoreEntryDisplayRound first, ScoreEntryDisplayRound second) {
                Integer firstScore = (first.finalScore - first.parPlayed) * (72 / first.parPlayed);
                Integer secondScore = (second.finalScore - second.parPlayed) * (72 / first.parPlayed);

                if (firstScore < secondScore) {
                    return -1;
                }
                else if (firstScore > secondScore) {
                    return 1;
                }
                return 0;
            }
        };

        allRounds.sort(comparator);
        DisplayScores();
    }
    private void SortByWorstToBestScore() {
        Comparator<ScoreEntryDisplayRound> comparator = new Comparator<ScoreEntryDisplayRound>() {
            @Override
            public int compare(ScoreEntryDisplayRound first, ScoreEntryDisplayRound second) {
                Integer firstScore = (first.finalScore - first.parPlayed) * (72 / first.parPlayed);
                Integer secondScore = (second.finalScore - second.parPlayed) * (72 / first.parPlayed);

                if (firstScore > secondScore) {
                    return -1;
                }
                else if (firstScore < secondScore) {
                    return 1;
                }
                return 0;
            }
        };

        allRounds.sort(comparator);
        DisplayScores();
    }
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    @SuppressLint("StaticFieldLeak")
    public void LoadRounds() {
        final GolfDatabase Db = Room.databaseBuilder(getApplicationContext(), GolfDatabase.class, "score-db-V6").fallbackToDestructiveMigration().build();

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                allRounds = Db.myScoreEntryDao().getRoundsForDisplay();
                Collections.reverse(allRounds);
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                DisplayScores();
            }
        }.execute();
    }

    public void DisplayScores() {
        /*
         * Initializes each round as its own button,
         * and sets up the on click listener to open up a new activity,
         * which allows the user to look at more detailed stats for an individual round.
         */
        ll.removeAllViews();
        ll.addView(sortSpinner);

        for (int i = 0; i < allRounds.size(); i++) {
            final ScoreEntryDisplayRound myEntry = allRounds.get(i);

            Button myButton = new Button(this);
            final String uid = myEntry.uid;
            Integer finalScore = myEntry.finalScore;
            String toDisplay = uid.substring(0, 10);
            myButton.setText(String.format("%s:  Score: %d", toDisplay, finalScore));
            myButton.setBackgroundResource(R.drawable.round_button);


            myButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(ShowAllRounds.this, ShowSingleRound.class);
                    myIntent.putExtra("uid", myEntry.uid);

                    startActivityForResult(myIntent, 100);
                }
            });

            ll.addView(myButton);
            buttons.add(myButton);
        }
        scrollView.removeAllViews();
        scrollView.addView(ll);
    }
    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        /*
         * This function reloads the rounds if a round was deleted in
         * the ShowSingleRound activity.
         */
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... voids) {
                        LoadRounds();
                        return null;
                    }
                }.execute();
            }
        }
    }
}
