package edu.jsu.mcis.cs408.lab04;

import android.content.Context;
import android.util.Log;

public class MemoModel extends AbstractModel {

    public static final String TAG = "DefaultModel";

    private String output;

    private DatabaseHandler db;

    public MemoModel(Context context) {
        super();
        db = new DatabaseHandler(context, null, null, 1);
    }
    public void initDefault() {

        setOutput("Sample Text 1");

    }


    public String getOutput() {
        return output;
    }


    public void setOutput(String newText) {

        String oldText = this.output;
        this.output = newText;

        Log.i(TAG, "Text1 Change: From " + oldText + " to " + newText);

        firePropertyChange(MemoController.OUTPUT_PROPERTY, oldText, newText);

    }


}
