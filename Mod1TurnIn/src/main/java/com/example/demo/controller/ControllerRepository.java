package com.example.demo.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface ControllerRepository
        extends JpaRepository<Controller, Long>{
    @Query("SELECT s FROM Controller s WHERE s.name = ?1")
    Optional<Controller> findControllerByName(String name);
}

