/*
 * Copyright 2015, The Android Open Source Project
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

package com.example.android.testing.blueprint;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.android.testing.blueprint.androidlibrarymodule.AndroidLibraryModuleClass;
import com.example.android.testing.blueprint.plainjavamodule.MyPlainJavaClass;

import javax.inject.Inject;

import toothpick.Scope;
import toothpick.Toothpick;

/**
 * A simple {@link AppCompatActivity} that shows a text when a button is pressed.
 * <p>
 * Also, it has an instance of a class from a different module.
 */
public class HelloTestingBlueprintActivity extends AppCompatActivity {

    @Inject
    SomeDependency dependency;

    private TextView mAndroidTestingRocksTextView;

    // Instance of a class in a different Java module.
    private MyPlainJavaClass mPlainJavaClassInstance;

    // Instance of a class in an android library module.
    private AndroidLibraryModuleClass mAndroidLibraryClassInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_testing_blueprint);
        mAndroidTestingRocksTextView = (TextView) findViewById(R.id.text_view_rocks);

        mPlainJavaClassInstance = new MyPlainJavaClass();
        mAndroidLibraryClassInstance = new AndroidLibraryModuleClass();

        Scope openScope = Toothpick.openScope("Root");
        Toothpick.inject(this, openScope);
        dependency.test();


        MeasureCanvas measureCanvas = new MeasureCanvas();

        Drawable drawable = getDrawable(R.drawable.ic_insert_link_black_24dp);
        drawable.setBounds(0, 0, 64, 64);
        drawable.draw(measureCanvas);

        Log.wtf("Measure", "W:" + measureCanvas.getMeasuredWidth() + " H:" + measureCanvas.getMeasuredHeight());


    }

    public void onClick(View view) {
        if (mPlainJavaClassInstance.isReady() && mAndroidLibraryClassInstance.isReady()) {
            mAndroidTestingRocksTextView.setText(getString(R.string.android_testing_rocks));
        }
    }
}
