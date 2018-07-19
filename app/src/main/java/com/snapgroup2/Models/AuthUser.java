package com.snapgroup2.Models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by snapgroup1 on 12/04/18.
 */

public class AuthUser {
    public String id,firstName,lastName,email,phone,gender,birthDate,profileImage;

    public int totalGroups;
    public AuthUser(){

    }


    public AuthUser(String id, String firstName, String lastName, String email, String phone, String gender, String birthDate, String profileImage, int totalGroups) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.birthDate = birthDate;
        this.profileImage = profileImage;
        this.totalGroups = totalGroups;

    }

    public static AuthUser fromJson(JSONObject json){
        try {
            JSONObject memberJson = json.getJSONObject("member");
            JSONObject profileJson = memberJson.getJSONObject("member");
            AuthUser user = new AuthUser(
                    memberJson.getString("id"),
                    profileJson.getString("first_name"),
                    profileJson.getString("last_name"),
                    memberJson.getString("email"),
                    memberJson.getString("phone"),
                    profileJson.getString("gender"),
                    profileJson.getString("birth_date"),
                    memberJson.getString("profile_image"),
                    Integer.parseInt(memberJson.getString("total_groups "))
            );
            return user;

        } catch (JSONException e) {
            e.printStackTrace();
            return new AuthUser();
        }

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public int getTotalGroups() {
        return totalGroups;
    }

    public void setTotalGroups(int totalGroups) {
        this.totalGroups = totalGroups;
    }

    @Override
    public String toString() {
        return "AuthUser{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", profileImage='" + profileImage + '\'' +
                ", totalGroups=" + totalGroups + '\'' +
                '}';
    }
}
