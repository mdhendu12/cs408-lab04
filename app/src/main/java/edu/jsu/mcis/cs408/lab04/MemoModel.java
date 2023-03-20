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

        setOutput("Memo Area");

    }


    public String getOutput() {
        return output;
    }

    public void setOutput(String newText) {
        String oldText = this.output;
        this.output = newText;

        firePropertyChange(MemoController.TEXT_PROPERTY, oldText, newText);
    }


    public void setText(String newText) {

        String oldText = this.output;
        db.addMemo(newText);
        this.output = db.getAllMemos();
        newText = db.getAllMemos();

        Log.i(TAG, "Text1 Change: From " + oldText + " to " + newText);

        firePropertyChange(MemoController.TEXT_PROPERTY, oldText, newText);

    }

    public void setID (String id) {

        String oldText = this.output;
        String newText;

        db.deleteMemo(Integer.valueOf(id));

        this.output = newText = db.getAllMemos();

        firePropertyChange(MemoController.ID_PROPERTY, oldText, newText);

    }

}
