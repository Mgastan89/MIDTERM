package Project.CrossFitX.Controller.Impl;
import Project.CrossFitX.Model.Activity;
import Project.CrossFitX.Service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    @Autowired
    ActivityService activityService;

        @GetMapping
        public List<Activity> getAllActivities() {
            return activityService.getAllActivities();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Activity> getActivityById(@PathVariable Integer id) {
            Optional<Activity> activity = activityService.getActivityById(id);
            if (activity.isPresent()) {
                return ResponseEntity.ok(activity.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @PostMapping
        public Activity createActivity(@RequestBody Activity activity) {
            return activityService.saveActivity(activity);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Activity> updateActivity(@PathVariable Integer id, @RequestBody Activity activityDetails) {
            Optional<Activity> activity = activityService.getActivityById(id);
            if (activity.isPresent()) {
                Activity updatedActivity = activity.get();
                updatedActivity.setName(activityDetails.getName());
                return ResponseEntity.ok(activityService.saveActivity(updatedActivity));
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteActivity(@PathVariable Integer id) {
            Optional<Activity> activity = activityService.getActivityById(id);
            if (activity.isPresent()) {
                activityService.deleteActivity(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }




