package com.monegoo.notification.db.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name="whatchers")
public class Watcher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "user", nullable = false)
    Integer user;

    @Column(name = "code", nullable = false, length = 5)
    String code;

    @Column(name = "min_rate", nullable = false, scale = 10, precision = 25)
    BigDecimal minRate;

    @Column(name = "max_rate", nullable = false, scale = 10, precision = 25)
    BigDecimal maxRate;

    @Column(name = "enabled", nullable = false)
    Boolean enabled;

    @Column(name = "last_verified")
    Date lastVerified;


}
