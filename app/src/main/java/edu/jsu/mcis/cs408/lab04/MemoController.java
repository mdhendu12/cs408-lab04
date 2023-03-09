package edu.jsu.mcis.cs408.lab04;

public class MemoController extends AbstractController
{

    public static final String OUTPUT_PROPERTY = "Output";

    public void changeOutput(String newText) {
        setModelProperty(OUTPUT_PROPERTY, newText);
    }

    public void addMemo (String newMemo) {
    }

}
