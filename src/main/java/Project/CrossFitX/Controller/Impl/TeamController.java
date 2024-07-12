package Project.CrossFitX.Controller.Impl;


import Project.CrossFitX.Model.Team;
import Project.CrossFitX.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teams")
public class TeamController {

        @Autowired
        TeamService teamService;

        @GetMapping
        public List<Team> getAllTeams() {
            return teamService.getAllTeams();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Team> getTeamById(@PathVariable Integer id) {
            Optional<Team> team = teamService.getTeamById(id);
            return team.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @PostMapping
        public Team createTeam(@RequestBody Team team) {
            return teamService.saveTeam(team);
        }



        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteTeam(@PathVariable Integer id) {
            Optional<Team> team = teamService.getTeamById(id);
            if (team.isPresent()) {
                teamService.deleteTeam(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }
