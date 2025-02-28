package Project.CrossFitX.Service;
import Project.CrossFitX.Model.Team;
import Project.CrossFitX.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {



        @Autowired
        private TeamRepository teamRepository;

        public List<Team> getAllTeams() {
            return teamRepository.findAll();
        }

        public Optional<Team> getTeamById(Integer id) {
            return teamRepository.findById(id);
        }

        public Team saveTeam(Team team) {
            return teamRepository.save(team);
        }

        public void deleteTeam(Integer id) {
            teamRepository.deleteById(id);
        }
    }



