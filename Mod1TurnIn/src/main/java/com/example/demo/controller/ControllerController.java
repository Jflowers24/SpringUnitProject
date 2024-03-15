package com.example.demo.controller;

import com.example.demo.Game.Game;
import com.example.demo.Player.Player;
import com.example.demo.Player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/controller")
public class ControllerController {
    private final ControllerService controllerService;
    private final ControllerRepository controllerRepository;

    @Autowired
    public ControllerController(ControllerService controllerService, ControllerRepository controllerRepository) {
        this.controllerService = controllerService;
        this.controllerRepository = controllerRepository;


    }
    @Autowired
    PlayerRepository playerRepository;

    @GetMapping
    public List<Controller> GetControllers(){
        return controllerService.GetControllers();
    }/*check*/

    @PostMapping
    public void registerNewController(@RequestBody Controller controller) {
        controllerService.addnewController(controller);
        /*check*/
    }
    @DeleteMapping(path = "{controllerserialNum}")
    public void deleteGame(@PathVariable(
            "controllerserialNum") Long controllerserialNum){
        controllerService.deleteController(controllerserialNum);
    }/*check*/

    @GetMapping(path = "{controllerserialNum}")
    public Optional<Controller> SearchController(@PathVariable("controllerserialNum") Long controllerserialNum){
        return controllerService.SearchController(controllerserialNum);/*check*/
    }

    @PutMapping("{controllerserialNum}/{addOwner}/{playerId}")
    Controller addControllertoplayer(
            @PathVariable Long controllerserialNum,
            @PathVariable Long playerId
    ){
        Controller controller = controllerService.SearchController(controllerserialNum).orElse(null);
        Optional<Player> player = playerRepository.findById(playerId);

        if (controller != null && player.isPresent()) {
            List<Player> owners = controller.getControllerOwner();
            owners.add(player.get());
            controller.setControllerOwner(owners);
            controllerService.saveController(controller);/*check*/




        }
        return controller;
    }
}
