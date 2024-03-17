package appveterinaria.Validator;

public class ClinicalHistoryValidator extends InputsValidator {
    
    public long dateValidator(String number) throws Exception {
        return super.longValidator(number, "Fecha de atención: ");
    }
    
    public long petIdValidator(String number) throws Exception {
        return super.longValidator(number, "Identificacion de la mascota: ");
    }
    
    public void reasonForConsultationValidador(String reasonForConsultation) throws Exception {
        super.stringValidator(reasonForConsultation, "Motivo de consulta: ");
    }

    public void symptomsValidador(String symptoms) throws Exception {
        super.stringValidator(symptoms, "Síntomas: ");
    }

    public void diagnosisValidador(String diagnosis) throws Exception {
        super.stringValidator(diagnosis, "Diagnóstico: ");
    }

    public void procedureValidador(String procedure) throws Exception {
        super.stringValidator(procedure, "Procedimiento: ");
    }

    public void medicationValidador(String medication) throws Exception {
        super.stringValidator(medication, "Medicamentos: ");
    }

    public void medicationDoseValidador(String medicationDose) throws Exception {
        super.stringValidator(medicationDose, "Dosis del medicamentos: ");
    }

    public void vaccinationHistoryValidador(String vaccinationHistory) throws Exception {
        super.stringValidator(vaccinationHistory, "Historial de vacunación: ");
    }

    public void allergiesValidador(String allergies) throws Exception {
        super.stringValidator(allergies, "Alergias: ");
    }

    public void procedureDetailsValidador(String procedureDetails) throws Exception {
        super.stringValidator(procedureDetails, "Detalles del procedimiento: ");
    }
    
    public long orderId(String number) throws Exception {
        return super.longValidator(number, "Numero de la orden: ");
    }
    
    public double orderCancellation(String number) throws Exception {
        return super.doubleValidator(number, "la cancelación de la orden: ");
    }

}
