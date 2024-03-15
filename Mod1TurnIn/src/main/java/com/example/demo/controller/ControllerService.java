package com.example.demo.controller;

import com.example.demo.Game.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ControllerService {
    private final ControllerRepository controllerRepository;

    @Autowired
    public ControllerService(ControllerRepository controllerRepository) {
        this.controllerRepository = controllerRepository;
    }

    public List<Controller> GetControllers() { return controllerRepository.findAll();
    }

    public void addnewController(Controller controller) {
        Optional<Controller> controllerOptional = controllerRepository
                .findControllerByName(controller.getName());
        if (controllerOptional.isPresent()) {
            throw new IllegalStateException("Name Already Taken.");

        }
        controllerRepository.save(controller);
        System.out.println(controller);
    }

    public void deleteController(Long controllerserialNum) {
        controllerRepository.findById(controllerserialNum);
        boolean exists = controllerRepository.existsById(controllerserialNum);
        if (!exists){
            throw new IllegalStateException("Controller with id " + controllerserialNum + " Doesn't Exists");

        }
        controllerRepository.deleteById(controllerserialNum);
    }


    public Optional<Controller> SearchController(Long controllerserialNum) {
            return Optional.ofNullable(controllerRepository.findById(controllerserialNum).orElseThrow(() -> new IllegalStateException("Game doesn't exist")));
        }

    public void saveController(Controller controller) {
    }
}

