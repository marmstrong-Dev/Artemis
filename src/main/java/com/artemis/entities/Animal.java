package com.artemis.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;

@Entity
@Table(name = "Animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "animal_id")
    private Integer id;

    @Column(name = "animal_name", nullable = false)
    private String name;

    @Column(name = "animal_description", length = 1000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "speciesId")
    private Species species;

    @ManyToOne
    @JoinColumn(name = "keeperId")
    private Keeper keeper;

    public Animal() {}

    public Animal(Integer id, String name, String description, Species species, Keeper keeper) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.species = species;
        this.keeper = keeper;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Species getSpecies() { return species; }
    public void setSpecies(Species species) { this.species = species; }

    public Keeper getKeeper() { return keeper; }
    public void setKeeper(Keeper keeper) { this.keeper = keeper; }
}
