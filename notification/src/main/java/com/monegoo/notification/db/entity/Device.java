package com.monegoo.notification.db.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name="devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "pushToken", nullable = false, length = 1024)
    String pushToken;

    @Column(name = "accessToken", nullable = false, length = 1024)
    String accessToken;

}
