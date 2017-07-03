/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.miwok2.R.id.colors;
import static com.example.android.miwok2.R.id.family;
import static com.example.android.miwok2.R.id.numbers;
import static com.example.android.miwok2.R.id.phrases;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the View that shows each category
        TextView numbersTView = (TextView)findViewById(numbers);
        TextView familyTView = (TextView)findViewById(family);
        TextView colorsTView = (TextView)findViewById(colors);
        TextView phrasesTView = (TextView)findViewById(phrases);

// NUMBERS
        // Set an OnClickListener on the numbersTView object
        numbersTView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, com.example.android.miwok2.NumbersActivity.class);
                startActivity(numbersIntent);
                } // Close method onClick()
            } // Close @Override
        ); // Close setOnClickListener()

// FAMILY
        // Set an OnClickListener on the familyTView object
        familyTView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent familyIntent = new Intent(MainActivity.this, com.example.android.miwok2.FamilyMembersActivity.class);
                startActivity(familyIntent);
                } // Close method onClick()
            } // Close @Override
        ); // Close setOnClickListener()

// COLORS
        // Set an OnClickListener on the colorsTView object
        colorsTView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent colorsIntent = new Intent(MainActivity.this, com.example.android.miwok2.ColorsActivity.class);
                startActivity(colorsIntent);
                } // Close method onClick()
            } // Close @Override
        ); // Close setOnClickListener()

// PHRASES
        // Set an OnClickListener on the phrasesTView object
        phrasesTView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phrasesIntent = new Intent(MainActivity.this, com.example.android.miwok2.PhrasesActivity.class);
                startActivity(phrasesIntent);
                } // Close method onClick()
            } // Close @Override
        ); // Close setOnClickListener()

    } // Close method onCreate()
} // Close class MainActivity
