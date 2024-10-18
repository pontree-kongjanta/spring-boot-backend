package com.example.training.myApp4.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "tb_socialmedia")
public class SocialMedai extends BaseEntity{

    @Column(length = 120)
    private String socialName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User usergg;

}
