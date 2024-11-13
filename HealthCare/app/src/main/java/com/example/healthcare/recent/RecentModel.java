package com.example.healthcare.recent;

public class RecentModel {
    private String time;
    private String diagnose_id;
    private String speech;
    private String response;

    // creating constructor for our variables.
    public RecentModel(String t, String d_id, String speech, String response) {
        this.time = t;
        this.diagnose_id = d_id;
        this.speech = speech;
        this.response = response;
    }

    // creating getter and setter methods.
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDiagnose_id() {
        return diagnose_id;
    }

    public void setDiagnose_id(String diagnose_id) {
        this.diagnose_id = diagnose_id;
    }

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
