package com.example.moe.finhacksiot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.opencsv.CSVReader;

//import java.io.FileReader;

public class AnalysisActivity extends AppCompatActivity {
    private static int EpochDays = new Dat

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);

        ArrayList<String[]> rows = new ArrayList<String[]>();

        Scanner scanIn = new Scanner(
                getResources().openRawResource(R.raw.graphready));

        while(scanIn.hasNextLine()) {
            String line = scanIn.nextLine();
            rows.add(line.split(","));
            Log.d("line: ", scanIn.nextLine());
        }

        // in this example, a LineChart is initialized from xml
        LineChart chart = (LineChart) findViewById(R.id.linechart);

        List<Entry> entries = new ArrayList<Entry>();

        for (String[] rowData: rows) {
            entries.add(new Entry(getMsFromOrdinalStr(rowData[1]), Float.parseFloat(rowData[0])));
        }

    }

    // returns the number of milliseconds since Jan 1, 1970 (Unix epoch)
    // TODO
    private float getMsFromOrdinalStr(String str) {
        int ordinalDays = Math.round(Float.parseFloat(str));
        return 0;
    }
}
