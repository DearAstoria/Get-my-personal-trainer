package com.example.getmypersonaltrainer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


public class PersonalTrainerMainActivity extends AppCompatActivity {
    private static final String TAG = "TrainerMainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_trainer_main);

        Log.i(TAG, "Started Personal Trainer main Activity");
    }

    public void createPublicExercise(View view){
        Intent intent = new Intent(this, CreatePublicExerciseActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.trainer_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.item_create_public_exercise:
                Intent intent = new Intent(this, CreatePublicExerciseActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

