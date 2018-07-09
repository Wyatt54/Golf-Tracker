package com.example.wyattfraley.golftracker;

import android.widget.TextView;

import java.util.Stack;

public class Score {
    Stack<String> Actions;
    TextView Hole;
    int strokes;
    int putts;

    Score(TextView newHole) {
        Hole = newHole;
        strokes = 0;
        putts = 0;
        Actions = new Stack<>();
    }

    void AddAction(String Action)
    {
        Actions.push(Action);
    }

    void UndoAction()
    {
        String Action;
        if (Actions.size() > 0)
        {
            Action = Actions.pop();

            if (Action == "Putt")
            {
                if (putts > 0)
                {
                    putts--;
                }
            }
            else if (Action == "Stroke")
            {
                if (strokes > 0)
                {
                    strokes--;
                }
            }
        }
    }
}
