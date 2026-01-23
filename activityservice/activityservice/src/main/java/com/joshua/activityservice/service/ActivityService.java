package com.joshua.activityservice.service;

import com.joshua.activityservice.dto.ActivityRequestDTO;
import com.joshua.activityservice.dto.ActivityResponseDTO;
import com.joshua.activityservice.model.Activity;
import com.joshua.activityservice.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityService {
    private final ActivityRepository activityRepository;
    public ActivityResponseDTO trackActivity(ActivityRequestDTO activityRequestDTO){
        Activity activity = Activity.builder()
                .userId(activityRequestDTO.userId())
                .activityType(activityRequestDTO.activityType())
                .duration(activityRequestDTO.duration())
                .caloriesBurned(activityRequestDTO.caloriesBurned())
                .startTime(activityRequestDTO.startTime())
                .additionalNotes(activityRequestDTO.additionalNotes())
                .build();
        Activity savedActivity = activityRepository.save(activity);
        System.out.println(savedActivity);
        return activityResponseMapper(savedActivity);
    }

    private ActivityResponseDTO activityResponseMapper(Activity activity){
        ActivityResponseDTO activityResponseDTO = new ActivityResponseDTO(
                activity.getActivityType(),
                activity.getStartTime(),
                activity.getEndTime(),
                activity.getCaloriesBurned(),
                activity.getDuration()
        );
        return activityResponseDTO;
    }

    public List<ActivityResponseDTO> getUserActivities(UUID userId) {
        List<Activity> activities = activityRepository.findByUserId(userId);
        return activities.stream()
                .map(this::activityResponseMapper)
                .collect(Collectors.toList());
    }

    public ActivityResponseDTO getActivity(String activityId) {
        return activityRepository.findById(activityId)
                .map(this::activityResponseMapper)
                .orElseThrow(() -> new RuntimeException("Activity with Id"+ activityId+ "not Found"));
    }
}
