package com.example.mvp.data.model.authers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthorsList {
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("IDBook")
    @Expose
    private Integer iDBook;
    @SerializedName("FirstName")
    @Expose
    private String firstName;
    @SerializedName("LastName")
    @Expose
    private String lastName;
    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Integer getIDBook() {
        return iDBook;
    }

    public void setIDBook(Integer iDBook) {
        this.iDBook = iDBook;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
