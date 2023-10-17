package com.example.roadsignquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView signImageView;
    private TextView questionText;
    private Button option1, option2, option3, option4;
    private TextView resultText;

    private Random random = new Random();
    private int currentQuestionIndex;

    private Question[] questions = {
            new Question(R.drawable.stopsign, "Stop", new String[]{"Stop", "Yield", "Speed Limit", "No Entry"}),
            new Question(R.drawable.yieldsign, "Yield", new String[]{"Stop", "Yield", "Speed Limit", "No Entry"}),
            new Question(R.drawable.speedlimit, "Speed Limit", new String[]{"Stop", "Yield", "Speed Limit", "No Entry"}),
            new Question(R.drawable.noentry, "No Entry", new String[]{"Stop", "Yield", "Speed Limit", "No Entry"}),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signImageView = findViewById(R.id.signImageView);
        questionText = findViewById(R.id.questionText);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        resultText = findViewById(R.id.resultText);

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(option1.getText().toString());
                displayRandomQuestion();
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(option2.getText().toString());
                displayRandomQuestion();
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(option3.getText().toString());
                displayRandomQuestion();
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(option4.getText().toString());
                displayRandomQuestion();
            }
        });

        displayRandomQuestion();
    }

    private void displayRandomQuestion() {
        currentQuestionIndex = random.nextInt(questions.length);
        Question currentQuestion = questions[currentQuestionIndex];

        signImageView.setImageResource(currentQuestion.getImageResourceId());
        questionText.setText("What is the name of this road sign?");
        String[] options = currentQuestion.getOptions();
        option1.setText(options[0]);
        option2.setText(options[1]);
        option3.setText(options[2]);
        option4.setText(options[3]);
        resultText.setText("");
    }

    private void checkAnswer(String selectedAnswer) {
        Question currentQuestion = questions[currentQuestionIndex];
        String correctAnswer = currentQuestion.getCorrectAnswer();

        if (selectedAnswer.equals(correctAnswer)) {
            resultText.setText("Correct!");
        } else {
            resultText.setText("Incorrect. The correct answer is: " + correctAnswer);
        }
    }
}
