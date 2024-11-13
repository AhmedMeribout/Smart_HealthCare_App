package com.example.healthcare.pdf;

public class PdfModel {
    private String time;
    private String id;
    private String doctorid;
    private String filename;

    // creating constructor for our variables.
    public PdfModel(String t, String id, String did, String filename) {
        this.time = t;
        this.id = id;
        this.doctorid = did;
        this.filename = filename;
    }

    // creating getter and setter methods.
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDiagnose_id() {
        return id;
    }

    public void setDiagnose_id(String id) {
        this.id = id;
    }

    public String getSpeech() {
        return doctorid;
    }

    public void setSpeech(String speech) {
        this.doctorid = speech;
    }

    public String getResponse() {
        return filename;
    }

    public void setResponse(String response) {
        this.filename = response;
    }
}
