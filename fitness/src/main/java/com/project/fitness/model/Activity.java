package com.project.fitness.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false,foreignKey = @ForeignKey(name = "FK_USER_ACTIVITY"))
    @JsonIgnore
    private User user;

    @Enumerated(EnumType.STRING)
    private ActivityType type;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    private Map<String,Object> additionalMetics;

    private Integer duration;
    private Integer caloriesBurned;
    private LocalDateTime startTime;


    @OneToMany(mappedBy = "activity",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    private List<Recommendation> recommendations=new ArrayList<>();

}
