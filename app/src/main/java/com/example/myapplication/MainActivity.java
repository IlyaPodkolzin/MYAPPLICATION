package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    public EditText objectA, objectB, objectC;
    public TextView res, error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void solveEq(View v) {
        objectA = findViewById(R.id.objA);
        objectB = findViewById(R.id.objB);
        objectC = findViewById(R.id.objC);
        res = findViewById(R.id.resultT);
        error = findViewById(R.id.error_message);
        error.setText("");

        String a1 = objectA.getText().toString();
        String b1 = objectB.getText().toString();
        String c1 = objectC.getText().toString();

        String abc [] = {a1, b1, c1};

        boolean flag = true;
        for (String i: abc) {
            try {
                double check = Double.parseDouble(i);
            }
            catch (NumberFormatException nfe) {
                flag = false;
            }
        }

        if (!flag) {
            res.setText("ОШИБКА!");
            error.setText("Значения A, B и C должны быть численными.");
        }

        else {
            double a = Double.parseDouble(a1);
            double b = Double.parseDouble(b1);
            double c = Double.parseDouble(c1);

            double d = b * b - 4 * a * c;
            Log.d("RRRRR", Double.toString(d));
            DecimalFormat df = new DecimalFormat("###.###");

            if (d == 0) {
                double x = -b / (2 * a);
                res.setText("x = " + x);
            }
            else if (d < 0) {
                res.setText("Нет решений");
            }
            else {
                double x1 = -b + Math.sqrt(d) / (2 * a);
                double x2 = -b - Math.sqrt(d) / (2 * a);
                res.setText("x1 = " + df.format(x1) + ";\nx2 = " + df.format(x2));
            }
        }
    }
}