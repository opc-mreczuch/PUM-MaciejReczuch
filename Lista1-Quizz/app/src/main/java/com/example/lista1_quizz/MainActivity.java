package com.example.lista1_quizz;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ProgressBar;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView totalQuestionsTextView;
    TextView questionTextView;
    RadioButton ansA,ansB,ansC,ansD;
    Button submitBtn;

    int score = 0;
    int totalQuestions = QuestionAnswers.question.length;
    int currentQuestions = 0;
    String selectedAnswer = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });

        totalQuestionsTextView = findViewById(R.id.Pytanie);
        questionTextView = findViewById(R.id.ZawartoscPytania);
        ansA = findViewById(R.id.odp_A);
        ansB = findViewById(R.id.odp_B);
        ansC = findViewById(R.id.odp_C);
        ansD = findViewById(R.id.odp_D);
        submitBtn = findViewById(R.id.submitbutton);


        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Pytanie: ");

        loadNewQuestion();
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.submitbutton) {

            RadioGroup radioGroupOpcje = findViewById(R.id.radioGroupOpcje);
            int selectedRadioButtonId = radioGroupOpcje.getCheckedRadioButtonId();


            if (selectedRadioButtonId != -1) {
                RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                selectedAnswer = selectedRadioButton.getText().toString();

                if (selectedAnswer.equals(QuestionAnswers.correctAnswers[currentQuestions])) {
                    score++;
                }

                currentQuestions++;
                loadNewQuestion();
            } else {
                Toast.makeText(this, "Wybierz odpowiedź przed zatwierdzeniem.", Toast.LENGTH_SHORT).show();
            }
        }
    }


    void loadNewQuestion() {
        if (currentQuestions == totalQuestions) {
            finishQuiz();
            return;
        }

        totalQuestionsTextView.setText("Pytanie " + (currentQuestions + 1) + " z " + totalQuestions);
        int progress = (int) (((double) (currentQuestions+1) / totalQuestions) * 100);
        ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(progress);

        questionTextView.setText(QuestionAnswers.question[currentQuestions]);
        ansA.setText(QuestionAnswers.choices[currentQuestions][0]);
        ansB.setText(QuestionAnswers.choices[currentQuestions][1]);
        ansC.setText(QuestionAnswers.choices[currentQuestions][2]);
        ansD.setText(QuestionAnswers.choices[currentQuestions][3]);
    }




    void finishQuiz(){
        new AlertDialog.Builder(this)
                .setTitle("Wynik")
                .setMessage("Twój wynik to " + score + " z " + totalQuestions)
                .setPositiveButton("Restert",((dialog, which) -> restartQuiz()))
                .setCancelable(false)
                .show();
    }

    void restartQuiz(){
        score = 0;
        currentQuestions=0;
        loadNewQuestion();
    }
}