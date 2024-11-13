package com.example.healthcare.doctors;

public class DoctorModel {
    private String phone;
    private String speciality;
    private String doctorname;
    private String email;

    // creating constructor for our variables.
    public DoctorModel(String doctorname, String speciality, String phone, String email) {
        this.doctorname = doctorname;
        this.speciality = speciality;
        this.phone = phone;
        this.email = email;
    }

    // creating getter and setter methods.
    public String getTime() {
        return doctorname;
    }

    public void setTime(String time) {
        this.doctorname = time;
    }

    public String getDiagnose_id() {
        return speciality;
    }

    public void setDiagnose_id(String id) {
        this.speciality = speciality;
    }

    public String getSpeech() {
        return phone;
    }

    public void setSpeech(String speech) {
        this.phone = speech;
    }

    public String getResponse() {
        return email;
    }

    public void setResponse(String response) {
        this.email = response;
    }
}
