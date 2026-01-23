package com.joshua.activityservice.controller;

import com.joshua.activityservice.dto.ActivityRequestDTO;
import com.joshua.activityservice.dto.ActivityResponseDTO;
import com.joshua.activityservice.service.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/activities")
@AllArgsConstructor
public class ActivityController {
    private ActivityService activityService;
    @PostMapping("/register")
    public ResponseEntity<ActivityResponseDTO> trackActivity(@RequestBody ActivityRequestDTO activityRequestDTO){
        return ResponseEntity.ok(activityService.trackActivity(activityRequestDTO));

    }
    @GetMapping()
    public ResponseEntity<List<ActivityResponseDTO>> getUserActivities(@RequestHeader("X-User-Id") UUID userId){
        return ResponseEntity.ok(activityService.getUserActivities(userId));

    }
    @GetMapping("/{activityId}")
    public ResponseEntity<ActivityResponseDTO> getActivity(@PathVariable String activityId){
        return ResponseEntity.ok(activityService.getActivity(activityId));

    }
}
