package com.example.demo.service;

import com.example.demo.model.ModelEntity;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.time.Instant;

@Service
public class MultiEntityService {

    public InputStream getEntityData(String name) {
        return this.getClass().getResourceAsStream("/data/demo.bin");
    }

    public ModelEntity getEntity(String name) {
        return ModelEntity.builder().name(name).createDt(Instant.now()).build();
    }

}
