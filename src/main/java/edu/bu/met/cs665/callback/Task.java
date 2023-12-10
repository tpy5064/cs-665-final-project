/**
 * Name: Tianqi Yang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/10/2023
 * File Name: Task.java
 * Description: Takes the defined Callback class and allows the program to call it optionally, depending if a callback
 * is provided.
 */

package edu.bu.met.cs665.callback;

import java.util.Optional;

public abstract class Task {


    public final void fetchWithCallback(String apiUrl, Callback callback) {
        fetch(apiUrl);
        //If a callback function is provided, then callback.
        Optional.ofNullable(callback).ifPresent(Callback::call);
    }

    public abstract void fetch(String apiUrl);
}
