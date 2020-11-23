package com.example.getmypersonaltrainer;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class Presenter {
   private Model model;
   private boolean logged;
   private UserInterface user;
   private PersonalTrainer myPersonalTrainer = null;
   private Class<?> goingTo = null;
   private Class<?> goBack = null;
   private Activity actualActivity = null;

   Presenter(){
      model = new Model();
      logged = false;
   }

   public PersonalTrainer getMyPersonalTrainer() {
      return myPersonalTrainer;
   }

   public void setMyPersonalTrainer(PersonalTrainer myPersonalTrainer) {
      this.myPersonalTrainer = myPersonalTrainer;
   }

   public Model getModel() {
      return model;
   }

   public void setModel(Model model) {
      this.model = model;
   }

   public boolean isLogged() {
      return logged;
   }

   public void setLogged(boolean logged) {
      this.logged = logged;
   }

   public UserInterface getUser() {
      return user;
   }

   public void setUser(UserInterface user) {
      this.user = user;
   }

   public Class<?> getGoingTo() {
      return goingTo;
   }

   public void setGoingTo(Class<?> goingTo) {
      this.goingTo = goingTo;
   }

   public Activity getActualActivity() {
      return actualActivity;
   }

   public void setActualActivity(Activity actualActivity) {
      this.actualActivity = actualActivity;
   }

   public Class<?> getGoBack() {
      return goBack;
   }

   public void setGoBack(Class<?> goBack) {
      this.goBack = goBack;
   }
}
