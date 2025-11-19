package com.prathish.studentapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NonNull;

@Entity
@Data
public class Students {

    @Id
    @GeneratedValue
    Long id;
    String name;
    String std_year;
    String dept;
}
