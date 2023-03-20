package edu.jsu.mcis.cs408.lab04;

public class MemoController extends AbstractController
{

    public static final String TEXT_PROPERTY = "Text";
    public static final String ID_PROPERTY = "ID";

    public void changeText(String newText) {
        setModelProperty(TEXT_PROPERTY, newText);
    }

    public void changeID(String newText) { setModelProperty(ID_PROPERTY, newText); }

}
