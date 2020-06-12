package com.example.retrofit_example.Models;

import java.util.List;

import javax.xml.transform.Source;

public class Website {
    private String status;
    private List<Source> source;

    public Website(String status, List<Source> source) {
        this.status = status;
        this.source = source;
    }

    public Website(){
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Source> getSource() {
        return source;
    }

    public void setSource(List<Source> source) {
        this.source = source;
    }
}
