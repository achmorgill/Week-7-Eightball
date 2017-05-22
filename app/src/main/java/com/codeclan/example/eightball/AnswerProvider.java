package com.codeclan.example.eightball;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 22/05/2017.
 */

public class AnswerProvider implements AnswerProviding{
    private ArrayList<String> answers;

//    java is smart enough to know if you are passing something into the constructor or not.  it will choose which constructor applies
    public AnswerProvider(ArrayList<String> answers) {
        this.answers = answers;
    }

    public AnswerProvider () {
        this.answers = new ArrayList<>();
        setupDefaultAnswers();
    }

    private void setupDefaultAnswers() {
        String[] defaultAnswers = {
                "You bet your ass?",
                "like, no"
        };
        for (String answer : defaultAnswers) {
            this.answers.add(answer);
        }
    }
//takes a copy of the ArrayList so keeping the original unchanged as it could be changed as it is a public
    public ArrayList<String> getAnswers() {
        return new ArrayList<>(this.answers);
    }

    public int getNumberOfAnswers() {
        return this.answers.size();
    }

    public void add(String answer) {
        this.answers.add(answer);
    }

    public String getAnswerAtIndex(int i) {
        return this.answers.get(i);
    }

    public String getAnswer() {
        Random rand = new Random();
//        returns a random number out of getNumberOfAnswers rand,nextInt - it has int as 0 until no of getNumberOfAnswers
        int index = rand.nextInt(getNumberOfAnswers());
        return getAnswerAtIndex(index);

    }
}
