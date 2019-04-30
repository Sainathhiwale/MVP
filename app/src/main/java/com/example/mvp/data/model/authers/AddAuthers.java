package com.example.mvp.data.model.authers;

import com.google.gson.annotations.SerializedName;

public class AddAuthers {
    @SerializedName("FirstName")
    private String firstName;

    @SerializedName("ID")
    private int iD;

    @SerializedName("IDBook")
    private int iDBook;

    @SerializedName("LastName")
    private String lastName;

    public AddAuthers( int iD, int iDBook, String firstName,String lastName) {
        this.iD = iD;
        this.iDBook = iDBook;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setID(int iD){
        this.iD = iD;
    }

    public int getID(){
        return iD;
    }

    public void setIDBook(int iDBook){
        this.iDBook = iDBook;
    }

    public int getIDBook(){
        return iDBook;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }

    @Override
    public String toString(){
        return
                "Response{" +
                        "firstName = '" + firstName + '\'' +
                        ",iD = '" + iD + '\'' +
                        ",iDBook = '" + iDBook + '\'' +
                        ",lastName = '" + lastName + '\'' +
                        "}";
    }
}
