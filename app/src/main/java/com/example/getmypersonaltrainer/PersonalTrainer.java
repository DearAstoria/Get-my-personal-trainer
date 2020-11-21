package com.example.getmypersonaltrainer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PersonalTrainer implements UserInterface, PersonalTrainerInterface{
   private UserTypes userType;
   private String password;
   private String name;
   private String userId;
   private String aboutMyselfText;
   private List<Client> clientList = new ArrayList<Client>();
   private HashMap<String, Exercise> exerciseList;
   private String hashedPassword;
   private String salt;
   private List<String> exerciseNameList = new ArrayList<String>();

   public PersonalTrainer(){
   }

   public PersonalTrainer(UserTypes userType, String password, String name, String userId, String aboutMyselfText){
      this.aboutMyselfText = aboutMyselfText;
      this.name = name;
      this.userId = userId;
      this.password = password;
      this.userType = userType;
      exerciseList = new HashMap<String, Exercise>() {
         @Override
         public int size() {
            return 0;
         }

         @Override
         public boolean isEmpty() {
            return false;
         }

         @Override
         public boolean containsKey(@Nullable Object key) {
            return false;
         }

         @Override
         public boolean containsValue(@Nullable Object value) {
            return false;
         }

         @Nullable
         @Override
         public Exercise get(@Nullable Object key) {
            return null;
         }

         @Nullable
         @Override
         public Exercise put(String key, Exercise value) {
            return null;
         }

         @Nullable
         @Override
         public Exercise remove(@Nullable Object key) {
            return null;
         }

         @Override
         public void putAll(@NonNull Map<? extends String, ? extends Exercise> m) {

         }

         @Override
         public void clear() {

         }

         @NonNull
         @Override
         public Set<String> keySet() {
            return null;
         }

         @NonNull
         @Override
         public Collection<Exercise> values() {
            return null;
         }

         @NonNull
         @Override
         public Set<Entry<String, Exercise>> entrySet() {
            return null;
         }

         @Override
         public boolean equals(@Nullable Object o) {
            return false;
         }

         @Override
         public int hashCode() {
            return 0;
         }
      };
   }

   public PersonalTrainer(UserTypes userType,
                          String hashedPassword,
                          String salt,
                          String name,
                          String userId,
                          String aboutMyselfText,
                          HashMap<String,Exercise> exerciseList){
      this.aboutMyselfText = aboutMyselfText;
      this.name = name;
      this.userId = userId;
      this.salt = salt;
      this.hashedPassword = hashedPassword;
      this.userType = userType;
      this.exerciseList = exerciseList;
   }


   @Override
   public UserTypes getUserType() {
      return userType;
   }

   @Override
   public HashMap<String, Exercise> getExerciseList() {
      return exerciseList;
   }

   @Override
   public void setExerciseList(HashMap<String, Exercise> exerciseList) {
      this.exerciseList = exerciseList;
   }

   @Override
   public String getPassword() {
      return password;
   }

   @Override
   public String getUserId() {
      return userId;
   }

   @Override
   public String getName() {
      return name;
   }

   @Override
   public String getSalt() {
      return salt;
   }

   @Override
   public String getHashedPassword() {
      return hashedPassword;
   }

   @Override
   public void setSalt(String salt) {
      this.salt = salt;
   }

   @Override
   public void setHashedPassword(String hashedPassword) {
      this.hashedPassword = hashedPassword;
   }

   @Override
   public void setUserId(String userId) {
      this.userId = userId;
   }

   @Override
   public void setPassword(String password) {
      this.password = password;
   }

   @Override
   public void setName(String name) {
      this.name = name;
   }

   @Override
   public void setUserType(UserTypes type) {
      this.userType = type;
   }

   @Override
   public List<Client> getClients() {
      return clientList;
   }

   @Override
   public void addNewClient(Client newClient) {

   }

   @Override
   public void removeClient(String clientId) {

   }

   @Override
   public String getAboutMyselfText() {
      return aboutMyselfText;
   }

   @Override
   public List<String> getExerciseNameList() {
      return exerciseNameList;
   }

   public void addNewExerciseName(String exerciseName){
      exerciseNameList.add(exerciseName);
   }

   @Override
   public void setAboutMyselfText(String aboutMyselfText) {
      this.aboutMyselfText = aboutMyselfText;
   }

   @Override
   public void setClients(List<Client> clientList) {
      this.clientList = clientList;
   }

   public void setExerciseNameList(List<String> exerciseNameList){
      this.exerciseNameList = exerciseNameList;
   }
}
