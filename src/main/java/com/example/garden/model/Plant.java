package com.example.garden.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Plant")
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String scientificName;
    private String description;
//    private String family;
//    private String genus;
//    private String species;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public String getFamily() {
//        return family;
//    }
//
//    public void setFamily(String family) {
//        this.family = family;
//    }

//    public String getGenus() {
//        return genus;
//    }
//
//    public void setGenus(String genus) {
//        this.genus = genus;
//    }

//    public String getSpecies() {
//        return species;
//    }
//
//    public void setSpecies(String species) {
//        this.species = species;
//    }
}
