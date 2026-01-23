package com.joshua.activityservice.dto;

import com.joshua.activityservice.model.ActivityType;
import lombok.Data;

import java.time.LocalDateTime;
public record ActivityResponseDTO(ActivityType activityType,
                                  LocalDateTime startTime,
                                  LocalDateTime endTime,
                                  Integer caloriesBurned,
                                  Integer duration) {
}
