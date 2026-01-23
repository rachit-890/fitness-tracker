package com.project.fitness.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false,foreignKey = @ForeignKey(name = "FK_USER_RECOMMENDATION"))
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "activity_id",nullable = false,foreignKey = @ForeignKey(name = "FK_ACTIVITY_RECOMMENDATION"))
    @JsonIgnore
    private Activity activity;

    @Column(length = 2000)
    private String recommendation;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    private List<String> improvements;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    private List<String> suggestions;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    private List<String> safety;

    private Integer caloriesBurned;
    private LocalDateTime startTime;

}
