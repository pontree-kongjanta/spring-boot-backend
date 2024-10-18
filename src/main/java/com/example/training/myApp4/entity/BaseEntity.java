package com.example.training.myApp4.entity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @UuidGenerator
    private UUID id;
}
