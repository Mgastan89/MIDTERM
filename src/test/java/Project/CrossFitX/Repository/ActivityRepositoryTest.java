package Project.CrossFitX.Repository;

import Project.CrossFitX.Model.Activity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;



@DataJpaTest

class ActivityRepositoryTest {

        @Autowired

        ActivityRepository activityRepository;

        @Test
        void testSaveActivity() {
            Activity activity = new Activity();
            activity.setName("Yoga");

            Activity savedActivity = activityRepository.save(activity);

            assertNotNull(savedActivity);
            assertEquals("Yoga", savedActivity.getName());
        }

        @Test
        void testFindActivityById() {
            Activity activity = new Activity();
            activity.setName("Pilates");

            Activity savedActivity = activityRepository.save(activity);

            Optional<Activity> foundActivity = activityRepository.findById(savedActivity.getId());

            assertTrue(foundActivity.isPresent());
            assertEquals("Pilates", foundActivity.get().getName());
        }

        @Test
        void testFindAllActivities() {
            Activity activity1 = new Activity();
            activity1.setName("Running");

            Activity activity2 = new Activity();
            activity2.setName("Swimming");

            activityRepository.save(activity1);
            activityRepository.save(activity2);

            List<Activity> activities = activityRepository.findAll();

            assertFalse(activities.isEmpty());
            assertEquals(2, activities.size());
        }

        @Test
        void testDeleteActivity() {
            Activity activity = new Activity();
            activity.setName("Cycling");

            Activity savedActivity = activityRepository.save(activity);
            activityRepository.deleteById(savedActivity.getId());

            Optional<Activity> foundActivity = activityRepository.findById(savedActivity.getId());

            assertFalse(foundActivity.isPresent());
        }
    }


