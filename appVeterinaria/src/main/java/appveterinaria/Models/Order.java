package appveterinaria.Models;

import java.sql.Date;

public class Order {
    private long orderId;
    private long petId;
    private Person ownerID;
    private Person veterinarianID;
    private String medicationName;
    private String dosage;
    private Date generationDate;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getPetId() {
        return petId;
    }

    public void setPetId(long petId) {
        this.petId = petId;
    }

    public Person getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(Person ownerID) {
        this.ownerID = ownerID;
    }

    public Person getVeterinarianID() {
        return veterinarianID;
    }

    public void setVeterinarianID(Person veterinarianID) {
        this.veterinarianID = veterinarianID;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public Date getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(Date generationDate) {
        this.generationDate = generationDate;
    }

    
    
}
