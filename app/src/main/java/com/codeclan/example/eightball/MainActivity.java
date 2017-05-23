package com.codeclan.example.eightball;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText questionEditText;
    private Button shakeButton;

    AnswerProvider answerToButtonClick = new AnswerProvider();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionEditText = (EditText)findViewById(R.id.question_text);//        answerText = (TextView)findViewById(R.id.answer_text);
        shakeButton = (Button)findViewById(R.id.shake_button);
    }

    public void onShakeButtonClicked(View button) {
//        this adds a message to the log along with the class current class,
//        so you can then easily find all logs associated with the class
        Log.d(getClass().toString(),"shake button was clicked");
        String question = questionEditText.getText().toString();
        String answerReturned = answerToButtonClick.getAnswer();


//        the answer will be passed to another activity (ie. another page) so delete this returned answer now
//        answerText.setText(answerReturned);

        Intent intent = new Intent(this,AnswerActivity.class);
        intent.putExtra("answer", answerReturned);
        startActivity(intent);



    }


}
