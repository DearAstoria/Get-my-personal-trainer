package com.example.getmypersonaltrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

public class CreatePublicExerciseActivity extends AppCompatActivity implements SignUpInterface {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_create_public_exercise);

   }

   public void sendExercise(View view){
      AutoCompleteTextView autoCompleteTextView = findViewById(R.id.edit_text_exercise_name_create_public_exercise);
      String exerciseName = autoCompleteTextView.getText().toString();

      EditText editText = findViewById(R.id.edit_text_emphasis_create_public_exercise);
      String emphasis = editText.getText().toString();

      editText = findViewById(R.id.edit_text_video_link_create_public_exercise);
      String videoLink = editText.getText().toString();

      String exerciseId = exerciseName + "Free";
      Exercise publicExercise = new Exercise(exerciseName, exerciseId, emphasis, videoLink, true);

      MainActivity.presenter.getModel().savePublicExercise(publicExercise, this);
   }

   @Override
   public void signUpSuccessfully() {
      Intent intent = new Intent(this, PersonalTrainerMainActivity.class);
      startActivity(intent);
   }
}