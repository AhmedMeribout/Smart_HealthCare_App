package com.example.healthcare.diagnose;

public class DiagnoseModel {
    private String illness;
    private String treatment;
    private String photo;
    private String email;

    // creating constructor for our variables.
    public DiagnoseModel(String doctorname, String speciality, String phone, String email) {
        this.illness = doctorname;
        this.treatment = speciality;
        this.photo = phone;
        this.email = email;
    }

    // creating getter and setter methods.
    public String getTime() {
        return illness;
    }

    public void setTime(String time) {
        this.illness = time;
    }

    public String getDiagnose_id() {
        return treatment;
    }

    public void setDiagnose_id(String id) {
        this.treatment = id;
    }

    public String getSpeech() {
        return photo;
    }

    public void setSpeech(String speech) {
        this.photo = speech;
    }

    public String getResponse() {
        return email;
    }

    public void setResponse(String response) {
        this.email = response;
    }
}
