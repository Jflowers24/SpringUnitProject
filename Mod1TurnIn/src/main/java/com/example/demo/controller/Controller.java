package com.example.demo.controller;

import com.example.demo.Player.Player;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Controller {

    @Id
    @SequenceGenerator(
            name = "controllersequence",
            sequenceName = "controllersequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "controllersequence"
    )
    private Long serialNum;

    private String name;

    @ManyToMany(mappedBy ="controllers")
    private List<Player> controllerOwners = new ArrayList<>();

    public Controller() {
    }

    public Controller(Long serialNum, String name) {
        this.serialNum = serialNum;
        this.name = name;
    }

    public Controller(String name) {
        this.name = name;
    }

    public Long getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(Long serialNum) {
        this.serialNum = serialNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getControllerOwner() {
        return controllerOwners;
    }

    public void setControllerOwner(List<Player> controllerOwner) {
        this.controllerOwners = controllerOwner;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "serialNum=" + serialNum +
                ", name='" + name + '\'' +
                '}';
    }
}