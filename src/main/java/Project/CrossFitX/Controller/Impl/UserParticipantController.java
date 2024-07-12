package Project.CrossFitX.Controller.Impl;


import Project.CrossFitX.Model.UserParticipant;
import Project.CrossFitX.Service.UserParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userParticipants")
public class UserParticipantController {

    @Autowired

    UserParticipantService userParticipantService;

    @GetMapping
    public List<UserParticipant> getAllUserParticipants() {
        return userParticipantService.getAllUserParticipants();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserParticipant> getUserParticipantById(@PathVariable Integer id) {
        Optional<UserParticipant> userParticipant = userParticipantService.getUserParticipantById(id);
        return userParticipant.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public UserParticipant createUserParticipant(@RequestBody UserParticipant userParticipant) {
        return userParticipantService.saveUserParticipant(userParticipant);
    }



}