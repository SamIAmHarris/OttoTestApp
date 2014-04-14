package com.samiamharris.ottotestapp;

/**
 * Created by samharris on 4/14/14.
 */
public class ButtonEvent {

    public String message;

    //Reverse the string here
    public ButtonEvent(String message) {
        this.message = new StringBuilder(message)
                .reverse().toString();
    }
}
