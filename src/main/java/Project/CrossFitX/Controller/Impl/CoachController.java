package Project.CrossFitX.Controller.Impl;

import Project.CrossFitX.Model.Coach;
import Project.CrossFitX.Service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coaches")
public class CoachController {


        @Autowired
        CoachService coachService;

        @GetMapping
        public List<Coach> getAllCoaches() {
            return coachService.getAllCoaches();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Coach> getCoachById(@PathVariable Integer id) {
            Optional<Coach> coach = coachService.getCoachById(id);
            if (coach.isPresent()) {
                return ResponseEntity.ok(coach.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @PostMapping
        public Coach createCoach(@RequestBody Coach coach) {
            return coachService.saveCoach(coach);
        }



        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteCoach(@PathVariable Integer id) {
            Optional<Coach> coach = coachService.getCoachById(id);
            if (coach.isPresent()) {
                coachService.deleteCoach(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }
