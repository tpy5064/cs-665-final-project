/**
 * Name: Tianqi Yang
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/10/2023
 * File Name: Timer.java
 * Description: A helper class to help me time the response time without cluttering Main.java
 */

package edu.bu.met.cs665.helpers;

public class Timer {
    private static long startTime;
    private static long endTime;

    public static void start() {
        startTime = System.currentTimeMillis();
    }

    public static void stop() {
        endTime = System.currentTimeMillis();
    }

    public static long getTime() {
        return endTime - startTime;
    }
}
