package com.digidwarf.accountmanagerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @DecimalMin("-90.0")
    @DecimalMax("90.0")
    private BigDecimal centreLatitude;
    @DecimalMin("-180.0")
    @DecimalMax("180.0")
    private BigDecimal centreLongitude;
    @Positive
    private BigDecimal radius;
}