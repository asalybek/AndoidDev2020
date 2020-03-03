package com.example.firstprojectjob.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Knp {
    @SerializedName("transfer_types")
    private List<String> transferTypes = new ArrayList<>();
    @SerializedName("code")
    private String code;
    @SerializedName("name")
    private String name;
    @SerializedName("is_individuals")
    private boolean is_individuals;
    @SerializedName("is_corporate")
    private boolean is_corporate;
    @SerializedName("is_resident")
    private boolean is_resident;
    @SerializedName("is_non_resident")
    private boolean is_non_resident;

    public List<String> getTransferTypes() {
        return transferTypes;
    }

    public void setTransferTypes(List<String> transferTypes) {
        this.transferTypes = transferTypes;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIs_individuals() {
        return is_individuals;
    }

    public void setIs_individuals(boolean is_individuals) {
        this.is_individuals = is_individuals;
    }

    public boolean isIs_corporate() {
        return is_corporate;
    }

    public void setIs_corporate(boolean is_corporate) {
        this.is_corporate = is_corporate;
    }

    public boolean isIs_resident() {
        return is_resident;
    }

    public void setIs_resident(boolean is_resident) {
        this.is_resident = is_resident;
    }

    public boolean isIs_non_resident() {
        return is_non_resident;
    }

    public void setIs_non_resident(boolean is_non_resident) {
        this.is_non_resident = is_non_resident;
    }

    public Knp(List<String> transferTypes, String code, String name, boolean is_individuals, boolean is_corporate, boolean is_resident, boolean is_non_resident) {
        this.transferTypes = transferTypes;
        this.code = code;
        this.name = name;
        this.is_individuals = is_individuals;
        this.is_corporate = is_corporate;
        this.is_resident = is_resident;
        this.is_non_resident = is_non_resident;
    }
}
