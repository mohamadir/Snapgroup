package com.snapgroup2.Models;

import android.util.Log;

import com.snapgroup2.Misc.ActivityToolsClass;
import com.snapgroup2.Misc.Langough;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by snapgroup2 on 27/07/17.
 */

//if((firstName.equals("")||firstName.equals("null"))
//        &&(lastName.equals("")||(lastName.equals("null")))){
//
//        fullName = getResources().getString(R.string.user_empty_message,leaderID);
//
//        }
//        else {
//
//        fullName
//        }

public class GroupInList implements Serializable {
    private String _id;
    private String title,descritption,image,origin,destination;
    String conditions;
    String start_date;
    String end_date;
    String groleaderName;
    String group_leader_image;
    String grpuMax ;
    String targetMember;
    String groleaderId ;
    String regstirtion_date ;
    String number_days;
    String isManeGroup;
    String role ;
    String companyOrLeader;
    String companyname;
    String companyimage;
    String isOPen;
    String isLimorGroup;
    String locale;
    String dateBetween;
    ActivityToolsClass activityTools;
    String chatId;
    public ArrayList<Langough>langoughs;
    String isPublish;
    ArrayList<String> imagesArray = new ArrayList<>();


    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }



    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getIsLimorGroup() {
        return isLimorGroup;
    }

    public void setIsLimorGroup(String isLimorGroup) {
        this.isLimorGroup = isLimorGroup;
    }

    public String getTargetMember() {
        return targetMember;
    }

    public void setTargetMember(String targetMember) {
        this.targetMember = targetMember;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCompanyimage() {
        return companyimage;
    }

    public void setCompanyimage(String companyimage) {
        this.companyimage = companyimage;
    }

    public String getGroleaderName() {

        Log.i("TEST","group leader name : " + groleaderName);

        String formattedName = groleaderName;

        formattedName = "12345";

        return formattedName;


    }

    public void setGroleaderName(String groleaderName) {
        this.groleaderName = groleaderName;
    }

    public String getGroup_leader_image() {
        return group_leader_image;
    }

    public void setGroup_leader_image(String group_leader_image) {
        this.group_leader_image = group_leader_image;
    }

    public String getIsManeGroup() {
        return isManeGroup;
    }

    public void setIsManeGroup(String isManeGroup) {
        this.isManeGroup = isManeGroup;
    }

    public String getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(String isPublish) {
        this.isPublish = isPublish;
    }

    public ArrayList<String> getImagesArray() {
        return imagesArray;
    }

    public void setImagesArray(ArrayList<String> imagesArray) {
        this.imagesArray = imagesArray;
    }

    public String getGrpuMax() {
        return grpuMax;
    }

    public void setGrpuMax(String grpuMax) {
        this.grpuMax = grpuMax;
    }

    public String getGroleaderId() {
        return groleaderId;
    }

    public void setGroleaderId(String groleaderId) {
        this.groleaderId = groleaderId;
    }

    public String getRegstirtion_date() {
        return regstirtion_date;
    }

    public String getIs_company() {
        return companyOrLeader;
    }

    public void setCompanyOrLeader(String companyOrLeader) {
        this.companyOrLeader = companyOrLeader;
    }

    public void setRegstirtion_date(String regstirtion_date) {
        this.regstirtion_date = regstirtion_date;

    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getIsOPen() {
        return isOPen;
    }

    public void setIsOPen(String isOPen) {
        this.isOPen = isOPen;
    }

    public String getDateBetween() {
        return dateBetween;
    }

    public void setDateBetween(String dateBetween) {
        this.dateBetween = dateBetween;
    }
    public String getChatId(){
        return chatId;
    }
    public GroupInList(){}
    public GroupInList(String conditions, String _id, String title, String descritption, String image, String origin,
                       String destination,
                       String start_date,
                       String end_date,
                       String grpuMax, String groleaderName,
                       String group_leader_image,
                       String groleaderId,
                       String regstirtion_date,
                       String role, String companyOrLeader
            , String companyname, String companyimage
            , String isOPen, String isLimorGroup
            , String dateBetween, String targetMember,
                       String isPublish, String isManeGroup, ArrayList<Langough> langoughs, String number_days, String chatId
            , ActivityToolsClass activityTools)
    {
        Log.i("TEST","constructor activated");
        this.conditions=conditions;
        this._id = _id;
        this.chatId = chatId;
        this.number_days=number_days;
        this.activityTools=activityTools;
        this.companyOrLeader =companyOrLeader;
        this.title = title;
        this.role=role;
        this.langoughs=langoughs;
        this.isManeGroup=isManeGroup;
        this.regstirtion_date=regstirtion_date;
        this.descritption = descritption;
        this.targetMember=targetMember;
        this.dateBetween=dateBetween;
        this.isLimorGroup=isLimorGroup;
        this.image = image;
        this.isOPen = isOPen;
        this.isPublish=isPublish;
        this.companyimage=companyimage;
        this.companyname = companyname;
        this.origin = origin;
        this.destination = destination;
        this.start_date = start_date;
        this.end_date = end_date;
        this.grpuMax = grpuMax;
        this.groleaderName = groleaderName;
        this.group_leader_image= group_leader_image;
        this.groleaderId=groleaderId;
    }

    public String getNumber_days() {
        return number_days;
    }

    public void setNumber_days(String number_days) {
        this.number_days = number_days;
    }

    public GroupInList(String _id, String title, String descritption, ArrayList<String>images, String origin,
                       String destination,
                       String start_date,
                       String end_date,
                       String grpuMax,
                       String regstirtion_date
            , String isOPen, String targetMember, String isPublish, String isManeGroup)
    {
        this._id = _id;
        this.title = title;
        this.isPublish=isPublish;
        this.isManeGroup=isManeGroup;
        this.regstirtion_date=regstirtion_date;
        this.descritption = descritption;
        this.targetMember=targetMember;
        this.isOPen = isOPen;
        this.origin = origin;
        this.imagesArray=images;
        this.destination = destination;
        this.start_date = start_date;
        this.end_date = end_date;
        this.grpuMax = grpuMax;
    }

    public ActivityToolsClass getActivityTools() {
        return activityTools;
    }

    public void setActivityTools(ActivityToolsClass activityTools) {
        this.activityTools = activityTools;
    }

    public ArrayList<Langough> getLangoughs() {
        return langoughs;
    }

    public void setLangoughs(ArrayList<Langough> langoughs) {
        this.langoughs = langoughs;
    }

    public String get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescritption() {
        return descritption;
    }

    public String getImage() {
        return image;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescritption(String descritption) {
        this.descritption = descritption;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "GroupInList{" +
                "_id='" + _id + '\'' +
                ", title='" + title + '\'' +
                ", descritption='" + descritption + '\'' +
                ", image='" + image + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", conditions='" + conditions + '\'' +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", groleaderName='" + groleaderName + '\'' +
                ", group_leader_image='" + group_leader_image + '\'' +
                ", grpuMax='" + grpuMax + '\'' +
                ", targetMember='" + targetMember + '\'' +
                ", groleaderId='" + groleaderId + '\'' +
                ", regstirtion_date='" + regstirtion_date + '\'' +
                ", number_days='" + number_days + '\'' +
                ", isManeGroup='" + isManeGroup + '\'' +
                ", role='" + role + '\'' +
                ", companyOrLeader='" + companyOrLeader + '\'' +
                ", companyname='" + companyname + '\'' +
                ", companyimage='" + companyimage + '\'' +
                ", isOPen='" + isOPen + '\'' +
                ", isLimorGroup='" + isLimorGroup + '\'' +
                ", locale='" + locale + '\'' +
                ", dateBetween='" + dateBetween + '\'' +
                ", activityTools=" + activityTools +
                ", chatId='" + chatId + '\'' +
                ", langoughs=" + langoughs +
                ", isPublish='" + isPublish + '\'' +
                ", imagesArray=" + imagesArray +
                '}';
    }




}