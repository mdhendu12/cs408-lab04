package edu.jsu.mcis.cs408.lab04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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

        DefaultClickHandler click = new DefaultClickHandler();
        ConstraintLayout layout = binding.layout;

        for (int i = 0; i < layout.getChildCount(); ++i) {
            View child = layout.getChildAt(i);
            if(child instanceof Button) {
                child.setOnClickListener(click);
            }
        }
    }

    @Override
    public void modelPropertyChange(final PropertyChangeEvent evt) {

        String propertyName = evt.getPropertyName();
        String propertyValue = evt.getNewValue().toString();

        Log.i(TAG, "New " + propertyName + " Value from Model: " + propertyValue);

        if ( propertyName.equals(MemoController.TEXT_PROPERTY) ) {

            String oldPropertyValue = binding.outputTV.getText().toString();

            if ( !oldPropertyValue.equals(propertyValue) ) {
                binding.outputTV.setText(propertyValue);
            }

        }

        else if ( propertyName.equals(MemoController.ID_PROPERTY) ) {

            String oldPropertyValue = binding.outputTV.getText().toString();

            if ( !oldPropertyValue.equals(propertyValue) ) {
                binding.outputTV.setText(propertyValue);
            }

        }


    }

    class DefaultClickHandler implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            String tag = ((Button) v).getTag().toString();

            if (tag.equals("addButton")) {
                String newText = binding.newMemoTV.getText().toString();
                controller.changeText(newText);
            }

            else if (tag.equals("delButton")) {
                String newText = binding.delMemoTV.getText().toString();
                controller.changeID(newText);
            }

        }

    }
}