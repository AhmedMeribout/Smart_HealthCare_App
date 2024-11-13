package com.example.healthcare.messages;

public class MesageModel {
    private String time;
    private String doctorname;
    private String message;
    private String phone;

    // creating constructor for our variables.
    public MesageModel(String t, String phone, String doctorsname, String message) {
        this.time = t;
        this.phone = phone;
        this.doctorname = doctorsname;
        this.message = message;
    }

    // creating getter and setter methods.
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDiagnose_id() {
        return phone;
    }

    public void setDiagnose_id(String phone) {
        this.phone = phone;
    }

    public String getSpeech() {
        return doctorname;
    }

    public void setSpeech(String speech) {
        this.doctorname = speech;
    }

    public String getResponse() {
        return message;
    }

    public void setResponse(String message) {
        this.message = message;
    }
}
