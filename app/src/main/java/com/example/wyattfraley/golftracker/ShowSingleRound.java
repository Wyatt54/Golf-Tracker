package com.example.wyattfraley.golftracker;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ShowSingleRound  extends AppCompatActivity{
    TextView OverallStats;
    TextView HoleStats;
    List<Score> Scores;
    Score currentHole;
    int puttsTotal;
    int sandTotal;
    String finalScore;

    @Override
    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_show_single_round);
        Intent myIntent = getIntent();
        String strokes = myIntent.getStringExtra("Strokes");
        String putts = myIntent.getStringExtra("Putts");
        String sand = myIntent.getStringExtra("Sand");
        finalScore = myIntent.getStringExtra("Final");
        puttsTotal = 0;
        sandTotal = 0;

        OverallStats = findViewById(R.id.OverallStats);
        OverallStats.setBackgroundColor(Color.WHITE);

        HoleStats = findViewById(R.id.HoleStats);
        HoleStats.setBackgroundColor(Color.WHITE);

        Scores = InitializeScores();
        LoadScores(strokes, putts, sand);
        currentHole = Scores.get(0);

        SetOverallTextBox();
    }
    public List<Score> InitializeScores() {
        Scores = new ArrayList<>();
        final Score score1 = new Score((TextView)findViewById(R.id.tv11));
        score1.Hole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarkScore(v);
                currentHole = score1;
                currentHole.Hole.setBackground(getDrawable(R.drawable.holeselected));
                SetIndividualTextBox();
            }
        });
        Scores.add(score1);
        final Score score2 = new Score((TextView)findViewById(R.id.tv12));
        score2.Hole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarkScore(v);
                currentHole = score2;
                currentHole.Hole.setBackground(getDrawable(R.drawable.holeselected));
                SetIndividualTextBox();
            }
        });
        Scores.add(score2);
        final Score score3 = new Score((TextView)findViewById(R.id.tv13));
        score3.Hole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarkScore(v);
                currentHole = score3;
                currentHole.Hole.setBackground(getDrawable(R.drawable.holeselected));
                SetIndividualTextBox();
            }
        });
        Scores.add(score3);
        final Score score4 = new Score((TextView)findViewById(R.id.tv14));
        score4.Hole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarkScore(v);
                currentHole = score4;
                currentHole.Hole.setBackground(getDrawable(R.drawable.holeselected));
                SetIndividualTextBox();
            }
        });
        Scores.add(score4);
        final Score score5 = new Score((TextView)findViewById(R.id.tv15));
        score5.Hole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarkScore(v);
                currentHole = score5;
                currentHole.Hole.setBackground(getDrawable(R.drawable.holeselected));
                SetIndividualTextBox();
            }
        });
        Scores.add(score5);
        final Score score6 = new Score((TextView)findViewById(R.id.tv16));
        score6.Hole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarkScore(v);
                currentHole = score6;
                currentHole.Hole.setBackground(getDrawable(R.drawable.holeselected));
                SetIndividualTextBox();
            }
        });
        Scores.add(score6);
        final Score score7 = new Score((TextView)findViewById(R.id.tv17));
        score7.Hole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarkScore(v);
                currentHole = score7;
                currentHole.Hole.setBackground(getDrawable(R.drawable.holeselected));
                SetIndividualTextBox();
            }
        });
        Scores.add(score7);
        final Score score8 = new Score((TextView)findViewById(R.id.tv18));
        score8.Hole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarkScore(v);
                currentHole = score8;
                currentHole.Hole.setBackground(getDrawable(R.drawable.holeselected));
                SetIndividualTextBox();
            }
        });
        Scores.add(score8);
        final Score score9 = new Score((TextView)findViewById(R.id.tv19));
        score9.Hole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarkScore(v);
                currentHole = score9;
                currentHole.Hole.setBackground(getDrawable(R.drawable.holeselected));
                SetIndividualTextBox();
            }
        });
        Scores.add(score9);
        Scores.add(new Score((TextView)findViewById(R.id.tv20)));
        final Score score10 = new Score((TextView)findViewById(R.id.tv31));
        score10.Hole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarkScore(v);
                currentHole = score10;
                currentHole.Hole.setBackground(getDrawable(R.drawable.holeselected));
                SetIndividualTextBox();
            }
        });
        Scores.add(score10);
        final Score score11 = new Score((TextView)findViewById(R.id.tv32));
        score11.Hole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarkScore(v);
                currentHole = score11;
                currentHole.Hole.setBackground(getDrawable(R.drawable.holeselected));
                SetIndividualTextBox();
            }
        });
        Scores.add(score11);
        final Score score12 = new Score((TextView)findViewById(R.id.tv33));
        score12.Hole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarkScore(v);
                currentHole = score12;
                currentHole.Hole.setBackground(getDrawable(R.drawable.holeselected));
                SetIndividualTextBox();
            }
        });
        Scores.add(score12);
        final Score score13 = new Score((TextView)findViewById(R.id.tv34));
        score13.Hole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarkScore(v);
                currentHole = score13;
                currentHole.Hole.setBackground(getDrawable(R.drawable.holeselected));
                SetIndividualTextBox();
            }
        });
        Scores.add(score13);
        final Score score14 = new Score((TextView)findViewById(R.id.tv35));
        score14.Hole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarkScore(v);
                currentHole = score14;
                currentHole.Hole.setBackground(getDrawable(R.drawable.holeselected));
                SetIndividualTextBox();
            }
        });
        Scores.add(score14);
        final Score score15 = new Score((TextView)findViewById(R.id.tv36));
        score15.Hole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarkScore(v);
                currentHole = score15;
                currentHole.Hole.setBackground(getDrawable(R.drawable.holeselected));
                SetIndividualTextBox();
            }
        });
        Scores.add(score15);
        final Score score16 = new Score((TextView)findViewById(R.id.tv37));
        score16.Hole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarkScore(v);
                currentHole = score16;
                currentHole.Hole.setBackground(getDrawable(R.drawable.holeselected));
                SetIndividualTextBox();
            }
        });
        Scores.add(score16);
        final Score score17 = new Score((TextView)findViewById(R.id.tv38));
        score17.Hole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarkScore(v);
                currentHole = score17;
                currentHole.Hole.setBackground(getDrawable(R.drawable.holeselected));
                SetIndividualTextBox();
            }
        });
        Scores.add(score17);
        final Score score18 = new Score((TextView)findViewById(R.id.tv39));
        score18.Hole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarkScore(v);
                currentHole = score18;
                currentHole.Hole.setBackground(getDrawable(R.drawable.holeselected));
                SetIndividualTextBox();
            }
        });
        Scores.add(score18);
        Scores.add(new Score((TextView)findViewById(R.id.tv40)));

        return Scores;
    }
    public List<Integer> InitializePars() {
        List<Integer> pars = new ArrayList<>();
        pars.add(5);
        pars.add(3);
        pars.add(4);
        pars.add(4);
        pars.add(4);
        pars.add(3);
        pars.add(5);
        pars.add(4);
        pars.add(4);
        pars.add(5);
        pars.add(4);
        pars.add(4);
        pars.add(5);
        pars.add(3);
        pars.add(4);
        pars.add(4);
        pars.add(3);
        pars.add(4);

        return pars;
    }

    public void LoadScores(String strokes, String putts, String sand) {
        // First we have to parse the strings into 18 groups.
        int i = 0;
        int i2 = 0;
        int j = 0;
        int j2 = 0;
        int k = 0;
        int k2 = 0;
        int ninth = 0;
        int eighteenth = 0;

        String mStroke = new String();
        String mPutt = new String();
        String mSand = new String();
        List<Integer> pars = InitializePars();
        Score mScore;


        for (int l = 0; l < 9; l++) {
            i2 = strokes.indexOf("\n", i);
            mStroke = strokes.substring(i, i2);
            i = i2 + 1;

            j2 = putts.indexOf("\n", j);
            mPutt = putts.substring(j, j2);
            j = j2 + 1;

            k2 = sand.indexOf("\n", k);
            mSand = sand.substring(k, k2);
            k = k2 + 1;

            mScore = Scores.get(l);
            mScore.setPutts(Integer.parseInt(mPutt));
            mScore.setSand(Integer.parseInt(mSand));
            mScore.setStrokes(Integer.parseInt(mStroke));
            mScore.setPar(pars.get(l));
            mScore.Hole.setText(mStroke);
            MarkScoreSpecific(mScore);

            puttsTotal += Integer.parseInt(mPutt);
            sandTotal += Integer.parseInt(mSand);
            ninth += Integer.parseInt(mStroke);
        }

        mScore = Scores.get(9);
        mScore.Hole.setText(Integer.toString(ninth));

        for (int l = 10; l < 19; l++) {
            i2 = strokes.indexOf("\n", i);
            mStroke = strokes.substring(i, i2);
            i = i2 + 1;

            j2 = putts.indexOf("\n", j);
            mPutt = putts.substring(j, j2);
            j = j2 + 1;

            k2 = sand.indexOf("\n", k);
            mSand = sand.substring(k, k2);
            k = k2 + 1;

            mScore = Scores.get(l);
            mScore.setPutts(Integer.parseInt(mPutt));
            mScore.setSand(Integer.parseInt(mSand));
            mScore.setStrokes(Integer.parseInt(mStroke));
            mScore.setPar(pars.get(l - 1));
            mScore.Hole.setText(mStroke);
            MarkScoreSpecific(mScore);

            eighteenth += Integer.parseInt(mStroke);
        }

        mScore = Scores.get(19);
        mScore.Hole.setText(Integer.toString(eighteenth));
    }

    public void MarkScore(View v){
        // This function is responsible for altering the look of the score
        // in the hole textbox. Double circle for eagle or better, single
        // circle for birdie, nothing for par, single square for bogey,
        // and double square for double bogey or worse.

        if (currentHole.Strokes == 0 || currentHole.Strokes == currentHole.Par)
            currentHole.Hole.setBackground(getDrawable(R.drawable.holeback));
        else if (currentHole.Strokes <= currentHole.Par - 2)
            currentHole.Hole.setBackground(getDrawable(R.drawable.eagle));
        else if (currentHole.Strokes == currentHole.Par - 1)
            currentHole.Hole.setBackground(getDrawable(R.drawable.birdie));
        else if (currentHole.Strokes == currentHole.Par + 1)
            currentHole.Hole.setBackground(getDrawable(R.drawable.bogey));
        else if (currentHole.Strokes >= currentHole.Par + 2)
            currentHole.Hole.setBackground(getDrawable(R.drawable.doublebogey));

    }
    public void MarkScoreSpecific(Score specificHole) {
        // This function is responsible for altering the look of the score
        // in the hole textbox. Double circle for eagle or better, single
        // circle for birdie, nothing for par, single square for bogey,
        // and double square for double bogey or worse.

        if (specificHole.Strokes == 0 || specificHole.Strokes == specificHole.Par)
            specificHole.Hole.setBackground(getDrawable(R.drawable.holeback));
        else if (specificHole.Strokes <= specificHole.Par - 2)
            specificHole.Hole.setBackground(getDrawable(R.drawable.eagle));
        else if (specificHole.Strokes == specificHole.Par - 1)
            specificHole.Hole.setBackground(getDrawable(R.drawable.birdie));
        else if (specificHole.Strokes == specificHole.Par + 1)
            specificHole.Hole.setBackground(getDrawable(R.drawable.bogey));
        else if (specificHole.Strokes >= specificHole.Par + 2)
            specificHole.Hole.setBackground(getDrawable(R.drawable.doublebogey));
    }
    public void SetScoreData(Score currentHole, String mPutt, String mSand, String mStroke, List<Integer> pars, Integer l) {
        currentHole.setPutts(Integer.parseInt(mPutt));
        currentHole.setSand(Integer.parseInt(mSand));
        currentHole.setPar(pars.get(l - 1));
        currentHole.Hole.setText(mStroke);
        MarkScoreSpecific(currentHole);
    }

    public void SetOverallTextBox() {
        String overallInfo = new String();

        overallInfo += "Final Score: " + finalScore + "\n";
        overallInfo += "Net Score: " + Integer.toString(Integer.parseInt(finalScore) - 72) + "\n\n";
        overallInfo += "Total Putts: " + puttsTotal + "\n";
        overallInfo += "Putts Per Hole: " + Integer.toString(puttsTotal / 18) + "\n\n";

        OverallStats.setText(overallInfo);
    }
    public void SetIndividualTextBox() {
        String individualInfo = new String();

        individualInfo += "Par: " + currentHole.Par + "\n";
        individualInfo += "Score: " + currentHole.Strokes + "\n";
        individualInfo += "Putts: " + currentHole.Putts + "\n";

        HoleStats.setText(individualInfo);
    }

}