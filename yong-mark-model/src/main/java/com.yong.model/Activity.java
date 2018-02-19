package com.yong.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "activity")
public class Activity {
    @Id
    private String id;
    private List<ActivitySession> activitySessions;
}
