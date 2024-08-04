package com.springframwork.petclinicdata.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "speciality")
public class Speciality extends BaseEntity {

    @Column(name = "description")
    private String description;

}
