package Project.CrossFitX.Service;

import Project.CrossFitX.Model.UserParticipant;
import Project.CrossFitX.Repository.UserParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserParticipantService {


       @Autowired

       UserParticipantRepository userParticipantRepository;

        public List<UserParticipant> getAllUserParticipants() {
            return userParticipantRepository.findAll();
        }

        public Optional<UserParticipant> getUserParticipantById(Integer id) {
            return userParticipantRepository.findById(id);
        }

        public UserParticipant saveUserParticipant(UserParticipant userParticipant) {
            return userParticipantRepository.save(userParticipant);
        }

        public void deleteUserParticipant(Integer id) {
            userParticipantRepository.deleteById(id);
        }
    }




