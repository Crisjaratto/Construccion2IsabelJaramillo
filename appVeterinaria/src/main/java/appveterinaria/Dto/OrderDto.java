package appveterinaria.Dto;

import java.sql.Date;

public class OrderDto {

    private long orderId;
    private long petId;
    private PersonDto ownerID;
    private PersonDto veterinarianID;
    private String medicationName;
    private String dosage;
    private Date generationDate;

    public OrderDto(long orderId, long petId, PersonDto ownerID, PersonDto veterinarianID, String medicationName, String dosage, Date generationDate) {
        this.orderId = orderId;
        this.petId = petId;
        this.ownerID = ownerID;
        this.veterinarianID = veterinarianID;
        this.medicationName = medicationName;
        this.dosage = dosage;
        this.generationDate = generationDate;
    }

    public OrderDto(long orderId, long petId, PersonDto ownerID, PersonDto veterinarianID) {
        this.orderId = orderId;
        this.petId = petId;
        this.ownerID = ownerID;
        this.veterinarianID = veterinarianID;
    }

    public OrderDto(long orderId) {
        this.orderId = orderId;
    }

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

    public PersonDto getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(PersonDto ownerID) {
        this.ownerID = ownerID;
    }

    public PersonDto getVeterinarianID() {
        return veterinarianID;
    }

    public void setVeterinarianID(PersonDto veterinarianID) {
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
