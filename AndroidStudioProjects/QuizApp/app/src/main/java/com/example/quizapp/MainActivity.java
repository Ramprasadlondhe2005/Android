package com.example.quizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewQuestion;
    private RadioGroup radioGroupOptions;
    private RadioButton radioButtonOption1, radioButtonOption2, radioButtonOption3, radioButtonOption4;
    private Button buttonSubmit;
    private TextView textViewResult;

    private String[] questions = {
            "What is the capital of France?",
            "Who wrote 'Romeo and Juliet'?",
            "What is the chemical symbol for water?",
            "Which planet is known as the Red Planet?",
            "What is the currency of Japan?"
    };

    private String[] options = {
            "Paris", "London", "Berlin", "Madrid",
            "William Shakespeare", "Charles Dickens", "Jane Austen", "Mark Twain",
            "H2O", "CO2", "NaCl", "NH3",
            "Mars", "Venus", "Jupiter", "Saturn",
            "Yen", "Euro", "Dollar", "Pound"
    };

    private String[] correctAnswers = {
            "Paris", "William Shakespeare", "H2O", "Mars", "Yen"
    };

    private int currentQuestionIndex = 0;
    private int correctCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewQuestion = findViewById(R.id.textViewQuestion);
        radioGroupOptions = findViewById(R.id.radioGroupOptions);
        radioButtonOption1 = findViewById(R.id.radioButtonOption1);
        radioButtonOption2 = findViewById(R.id.radioButtonOption2);
        radioButtonOption3 = findViewById(R.id.radioButtonOption3);
        radioButtonOption4 = findViewById(R.id.radioButtonOption4);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        textViewResult = findViewById(R.id.textViewResult);

        loadQuestion();

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers();
            }
        });
    }

    private void loadQuestion() {
        textViewQuestion.setText(questions[currentQuestionIndex]);
        radioButtonOption1.setText(options[currentQuestionIndex * 4]);
        radioButtonOption2.setText(options[currentQuestionIndex * 4 + 1]);
        radioButtonOption3.setText(options[currentQuestionIndex * 4 + 2]);
        radioButtonOption4.setText(options[currentQuestionIndex * 4 + 3]);
    }

    private void checkAnswers() {
        for (int i = 0; i < radioGroupOptions.getChildCount(); i++) {
            RadioButton radioButton = (RadioButton) radioGroupOptions.getChildAt(i);
            if (radioButton.isChecked()) {
                String selectedAnswer = radioButton.getText().toString();
                String correctAnswer = correctAnswers[currentQuestionIndex];
                if (selectedAnswer.equals(correctAnswer)) {
                    correctCount++;
                }
                break; // Move to the next question
            }
        }

        // Move to the next question if available
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.length) {
            loadQuestion();
            radioGroupOptions.clearCheck();
        } else {
            showResult();
        }
    }

    private void showResult() {
        int totalQuestions = questions.length;
        int incorrectCount = totalQuestions - correctCount;
        String resultMessage = "Quiz completed!\n\n";
        resultMessage += "Total Questions: " + totalQuestions + "\n";
        resultMessage += "Correct Answers: " + correctCount + "\n";
        resultMessage += "Incorrect Answers: " + incorrectCount;
        textViewResult.setText(resultMessage);
        buttonSubmit.setEnabled(false);
    }
}
