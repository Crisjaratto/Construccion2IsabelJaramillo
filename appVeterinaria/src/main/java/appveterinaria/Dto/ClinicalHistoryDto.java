package appveterinaria.Dto;

public class ClinicalHistoryDto {
    private long date;
    private long petId;
    private PersonDto veterinarian;
    private String reasonForConsultation;
    private String symptoms;
    private String diagnosis;
    private String procedure;
    private String medication;
    private String medicationDose;
    private OrderDto orderId;
    private String vaccinationHistory;
    private String allergies;
    private String procedureDetails;
    private boolean orderCancellation;

    public ClinicalHistoryDto(long date, long petId, PersonDto veterinarian, String reasonForConsultation, String symptoms, String diagnosis, String procedure, String medication, String medicationDose, OrderDto orderId, String vaccinationHistory, String allergies, String procedureDetails, boolean orderCancellation) {
        this.date = date;
        this.petId = petId;
        this.veterinarian = veterinarian;
        this.reasonForConsultation = reasonForConsultation;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
        this.procedure = procedure;
        this.medication = medication;
        this.medicationDose = medicationDose;
        this.orderId = orderId;
        this.vaccinationHistory = vaccinationHistory;
        this.allergies = allergies;
        this.procedureDetails = procedureDetails;
        this.orderCancellation = orderCancellation;
    }

    public ClinicalHistoryDto(long date) {
        this.date = date;
        this.veterinarian = veterinarian;
        this.reasonForConsultation = reasonForConsultation;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
        this.procedure = procedure;
        this.medication = medication;
        this.medicationDose = medicationDose;
        this.orderId = orderId;
        this.vaccinationHistory = vaccinationHistory;
        this.allergies = allergies;
        this.procedureDetails = procedureDetails;
    }
    
    public ClinicalHistoryDto(OrderDto orderId) {
        this.orderId = orderId;
    }
    
    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
    
    public long getPetId() {
        return petId;
    }

    public void setPetId(long petId) {
        this.petId = petId;
    }

    
    public PersonDto getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(PersonDto veterinarian) {
        this.veterinarian = veterinarian;
    }

    public String getReasonForConsultation() {
        return reasonForConsultation;
    }

    public void setReasonForConsultation(String reasonForConsultation) {
        this.reasonForConsultation = reasonForConsultation;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getMedicationDose() {
        return medicationDose;
    }

    public void setMedicationDose(String medicationDose) {
        this.medicationDose = medicationDose;
    }

    public OrderDto getOrderId() {
        return orderId;
    }

    public void setOrderId(OrderDto orderId) {
        this.orderId = orderId;
    }

    public String getVaccinationHistory() {
        return vaccinationHistory;
    }

    public void setVaccinationHistory(String vaccinationHistory) {
        this.vaccinationHistory = vaccinationHistory;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getProcedureDetails() {
        return procedureDetails;
    }

    public void setProcedureDetails(String procedureDetails) {
        this.procedureDetails = procedureDetails;
    }
    
    
    public boolean isOrderCancellation() {
        return orderCancellation;
    }

    public void setOrderCancellation(boolean orderCancellation) {
        this.orderCancellation = orderCancellation;
    }
    
    
}
