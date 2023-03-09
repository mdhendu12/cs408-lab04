package edu.jsu.mcis.cs408.lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.beans.PropertyChangeEvent;

import edu.jsu.mcis.cs408.lab04.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements AbstractView {

    private ActivityMainBinding binding;

    private MemoController controller;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        controller = new MemoController();
        MemoModel model = new MemoModel(this);

        controller.addView(this);
        controller.addModel(model);

        model.initDefault();
    }

    @Override
    public void modelPropertyChange(final PropertyChangeEvent evt) {

        String propertyName = evt.getPropertyName();
        String propertyValue = evt.getNewValue().toString();

        Log.i(TAG, "New " + propertyName + " Value from Model: " + propertyValue);

        if ( propertyName.equals(MemoController.OUTPUT_PROPERTY) ) {

            String oldPropertyValue = binding.outputTV.getText().toString();

            if ( !oldPropertyValue.equals(propertyValue) ) {
                binding.outputTV.setText(propertyValue);
            }

        }


    }
}