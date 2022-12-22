package com.artemis.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Species")
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "species_id")
    private Integer id;

    @Column(name = "species_name", nullable = false)
    private String name;

    @Column(name = "species_type")
    private String type;

    @Column(name = "species_binomial")
    private String binomial;

    @Column(name = "species_genus")
    private String genus;

    @Column(name = "species_family")
    private String family;

    public Species() {}

    public Species(
            Integer id, String name, String type,
            String binomial, String genus, String family
    ) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.binomial = binomial;
        this.genus = genus;
        this.family = family;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getBinomial() { return binomial; }
    public void setBinomial(String binomial) { this.binomial = binomial; }

    public String getGenus() { return genus; }
    public void setGenus(String genus) { this.genus = genus; }

    public String getFamily() { return family; }
    public void setFamily(String family) { this.family = family; }
}
