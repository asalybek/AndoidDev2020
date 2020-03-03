package com.example.firstprojectjob.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class KnpResponse {
    @SerializedName("")
   private List<Knp> knpList;




    public List<Knp> getKnpList() {
        return knpList;
    }

    public void setKnpList(List<Knp> knpList) {
        this.knpList = knpList;
    }
    public int getKnpListSize(){
        return knpList.size();
    }
}
