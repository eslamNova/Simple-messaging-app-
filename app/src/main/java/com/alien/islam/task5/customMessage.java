package com.alien.islam.task5;

/**
 * Created by islam on 3/15/2018.
 */

public class customMessage {

    public static final int RED_MODE=0 , BLUE_MODE=1;

    String text ;
    int mode ;

    public customMessage(String text) {
        this.text = text;
        this.mode = RED_MODE;
    }

    public String getText() {
        return text;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getMode() {
        return mode;
    }
}
