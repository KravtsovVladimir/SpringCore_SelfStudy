package com.client;

/**
 * Created by Volodymyr_Kravtsov on 4/27/2017.
 */
public class Client {
    private int id;
    private String fullName;
    private String greeting;

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

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", greeting='" + greeting + '\'' +
                '}';
    }
}
