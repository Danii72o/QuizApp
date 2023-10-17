package com.example.roadsignquizapp;
public class Question {
    private int imageResourceId;
    private String correctAnswer;
    private String[] options;

    public Question(int imageResourceId, String correctAnswer, String[] options) {
        this.imageResourceId = imageResourceId;
        this.correctAnswer = correctAnswer;
        this.options = options;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String[] getOptions() {
        return options;
    }
}
