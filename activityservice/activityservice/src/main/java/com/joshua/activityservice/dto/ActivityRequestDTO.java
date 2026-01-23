package com.joshua.activityservice.dto;

import com.joshua.activityservice.model.ActivityType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public record ActivityRequestDTO(UUID userId,
                                 ActivityType activityType,
                                 Integer duration,
                                 Integer caloriesBurned,
                                 LocalDateTime startTime,
                                 Map<String, Object> additionalNotes) {
}
