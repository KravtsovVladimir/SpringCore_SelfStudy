package com;

/**
 * Created by Volodymyr_Kravtsov on 4/27/2017.
 */
public class Client {
    private int id;
    private String fullName;

    public Client(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
