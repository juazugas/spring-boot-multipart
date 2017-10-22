package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@JsonView
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModelEntity {

    private String name;
    @JsonIgnore
    private Instant createDt;

}
