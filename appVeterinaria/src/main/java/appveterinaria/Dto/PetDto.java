package appveterinaria.Dto;

import appveterinaria.Models.Pet;

public class PetDto {

    private String name;
    private long ownerID;
    private int age;
    private long id;
    private String species;
    private String breed;
    private String characteristics;
    private double weight;

    public PetDto(long id, long ownerID, String name, int age, double weight, String breed, String species, String characteristics) {
        this.id = id;
        this.ownerID = ownerID;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.breed = breed;
        this.species = species;
        this.characteristics = characteristics;
    }

    public PetDto(long id) {
        this.id = id;
    }

    public PetDto() {
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(long ownerID) {
        this.ownerID = ownerID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}
