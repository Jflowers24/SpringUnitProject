package com.example.demo.Player;


import com.example.demo.Game.Game;
import com.example.demo.controller.Controller;
import jakarta.persistence.*;

import java.util.*;


@Entity
@Table
public class Player {
    @Id
    @SequenceGenerator(
            name = "player_sequence",
            sequenceName = "player_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "player_sequence"
    )
    private Long Id;
    private String Name;


    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<Game> games = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "ControllerHolders",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "controller_id")
    )
    private List<Controller> controllers = new ArrayList<>();



    public Player() {
    }

    public Player(Long id,
                  String name

    ) {
        Id = id;
        Name = name;
    }

    public Player(String name
    ) {
        Name = name;
    }



        public Long getId() {
            return Id;
        }

        public void setSerialNum(Long id) {
            Id = id;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public List<Controller> getControllers() {
        return controllers;
        }

        public void setControllers(List<Controller> controllers) {
        this.controllers = controllers;
        }

    public class PlayerDTO {
        private Long id;
        private String name;


        @Override
        public String toString() {
            return "Player{" +
                    "Id=" + Id +
                    ", Name='" + Name + '\''
                    ;
        }


    }
}
