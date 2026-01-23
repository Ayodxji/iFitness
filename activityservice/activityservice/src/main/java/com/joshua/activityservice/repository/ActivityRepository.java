package com.joshua.activityservice.repository;

import com.joshua.activityservice.model.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ActivityRepository extends MongoRepository<Activity, String> {
    List<Activity> findByUserId(UUID userId);
}
