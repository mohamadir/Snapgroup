package com.snapgroup2.Misc;


public class ActivityToolsClass
{
    public String plan,members,map,conditions,chat,files,payments,checklist,groupleader,services,roomlist,arrivalConfirmation;


    public String getPlan() {
        return plan;
    }

    public String getMembers() {
        return members;
    }

    public String getMap() {
        return map;
    }

    public String getConditions() {
        return conditions;
    }

    public String getChat() {
        return chat;
    }

    public String getFiles() {
        return files;
    }

    public String getPayments() {
        return payments;
    }

    public String getChecklist() {
        return checklist;
    }

    public String getGroupleader() {
        return groupleader;
    }

    public String getServices() {
        return services;
    }

    public String getArrivalConfirmation() {
        return arrivalConfirmation;
    }

    public void setArrivalConfirmation(String arrivalConfirmation) {
        this.arrivalConfirmation = arrivalConfirmation;
    }

    public String getRoomlist() {
        return roomlist;
    }

    public ActivityToolsClass(String plan, String members, String map, String conditions,
                              String chat, String files, String payments,
                              String checklist, String groupleader,
                              String services, String roomlist,String arrivalConfirmation) {
        this.plan = plan;
        this.members = members;
        this.arrivalConfirmation=arrivalConfirmation;
        this.map = map;
        this.conditions = conditions;

        this.chat = chat;
        this.files = files;
        this.payments = payments;
        this.checklist = checklist;
        this.groupleader = groupleader;
        this.services = services;
        this.roomlist = roomlist;
    }
    public ActivityToolsClass()
    {

    }
}
