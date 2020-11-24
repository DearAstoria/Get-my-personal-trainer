   package com.example.getmypersonaltrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

import java.io.Serializable;

import static com.example.getmypersonaltrainer.UserTypes.PERSONAL_TRAINER;

   public class MainActivity extends AppCompatActivity implements LoginInterface{
      final static String PREFERENCES = "SharedPreference";
      final static String USER_ID = "userId";
      final static String NOT_FOUND = "notFound";
      private static final String TAG = "MyActivity";

      private String logId = null;

      public final static Presenter presenter = new Presenter();
      @Override
      protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      presenter.setActualActivity(this);
      SharedPreferences sharedPreferences;
      sharedPreferences = getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);

      logId = sharedPreferences.getString(USER_ID, NOT_FOUND);
      if(logId.equals(NOT_FOUND)){
         //If not found Put the text as blank
         eraseText(R.id.edit_text_user_id_login_activity);
      } else{
         //To-do: Put the userId in the login information
         EditText editText = (EditText) findViewById(R.id.edit_text_user_id_login_activity);
         editText.setText(logId);
      }
   }

   public void login(View view){
      Log.i(TAG, "login function called");
      EditText editText = (EditText) findViewById(R.id.edit_text_user_id_login_activity);
      logId = editText.getText().toString();

      editText = (EditText) findViewById(R.id.edit_text_password_login_activity);
      String password = editText.getText().toString();

      presenter.getModel().checkLogin(logId, password, this);
      Log.i(TAG, "login function finished");
   }

      public void saveLoginId(){
         if(presenter.isLogged()) {
            SharedPreferences sharedPreferences;
            sharedPreferences = getSharedPreferences(PREFERENCES,
                  Context.MODE_PRIVATE);
            SharedPreferences.Editor preferencesEditor = sharedPreferences.edit();
            preferencesEditor.putString(USER_ID, logId);
            preferencesEditor.apply();
         }
      }

      public void singUp(View view){
         Intent intent = new Intent(this, ChooseSignUpType.class);
         startActivity(intent);
      }

      @Override
      public void loginUserType(UserTypes userType, boolean goodLoginResult) {
         if(goodLoginResult){
            switch (userType){
               case PERSONAL_TRAINER:{
                  presenter.setLogged(true);
                  saveLoginId();
                  Intent intent = new Intent(this, PersonalTrainerMainActivity.class);
                  startActivity(intent);
                  break;
               }

               case CLIENT:{
                  presenter.setLogged(true);
                  setUserAsClient();
                  saveLoginId();
                  Intent intent = new Intent(this, ClientMainActivity.class);
                  startActivity(intent);
                  break;
               }
            }
         }
      }

      @Override
      public void setPresenterUser(User user) {
         presenter.setUser(user);
      }

      public void setUserAsClient(){
         if(presenter.getUser() instanceof ClientInterface) {
            Client client = new Client(
                  presenter.getUser().getUserType(),
                  "",
                  presenter.getUser().getName(),
                  presenter.getUser().getUserId(),
                  ((ClientInterface) presenter.getUser()).getPhone(),
                  ((ClientInterface) presenter.getUser()).getBirthDate(),
                  ((ClientInterface) presenter.getUser()).getBodyMass(),
                  ((ClientInterface) presenter.getUser()).getSize(),
                  ((ClientInterface) presenter.getUser()).getPersonalTrainerId(),
                  presenter.getUser().getReceivedInvitation(),
                  presenter.getUser().getInvitationMessage(),
                  presenter.getUser().getHashedPassword(),
                  presenter.getUser().getSalt());

            presenter.setUser(client);
         }
      }


      @Override
      public void setPersonalTrainerExerciseNameList() {
         PersonalTrainer personalTrainer = null;
         if(presenter.getUser() instanceof  PersonalTrainerInterface) {
            personalTrainer = new PersonalTrainer(presenter.getUser().getUserType(),
                  presenter.getUser().getHashedPassword(),
                  presenter.getUser().getSalt(),
                  presenter.getUser().getName(),
                  presenter.getUser().getUserId(),
                  ((PersonalTrainerInterface) presenter.getUser()).getAboutMyselfText(),
                  presenter.getUser().getExerciseList());
         }
         presenter.setUser(personalTrainer);

         Log.i(TAG, "setPersonalTrainerExerciseNameList function called");
         presenter.getModel().getExerciseNameList((PersonalTrainer) presenter.getUser());
      }

      public void eraseText(int textId){
         EditText editText = (EditText) findViewById(textId);
         editText.setText(R.string.blank);
      }

      @Override
      protected void onStop() {
         super.onStop();
         eraseText(R.id.edit_text_password_login_activity);

      }

   }
