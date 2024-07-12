package Project.CrossFitX.Service;
import Project.CrossFitX.Model.Coach;
import Project.CrossFitX.Repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoachService {

        @Autowired
        CoachRepository coachRepository;

        public List<Coach> getAllCoaches() {
            return coachRepository.findAll();
        }

        public Optional<Coach> getCoachById(Integer id) {
            return coachRepository.findById(id);
        }

        public Coach saveCoach(Coach coach) {
            return coachRepository.save(coach);
        }

        public void deleteCoach(Integer id) {
            coachRepository.deleteById(id);
        }
    }

