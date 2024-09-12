package com.ecommerce.common.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(length = 40, nullable = false, unique = true)
    private String name;

    @Column(length = 150, nullable = false)
    private String description;

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Role(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
