package com.premlearns.springboot.todoapp;

import java.time.LocalDate;


//Database
//Static List of Todos

public class Todo {

    private int id;
    private String username;
    private String description;
    private LocalDate targetDate;
    private boolean done;

    public Todo(int id, String username, String description, LocalDate targerDate, boolean done) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targerDate;
        this.done = done;



    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargerDate(LocalDate targerDate) {
        this.targetDate = targerDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }


    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", targerDate=" + targetDate +
                ", done=" + done +
                '}';
    }
}
