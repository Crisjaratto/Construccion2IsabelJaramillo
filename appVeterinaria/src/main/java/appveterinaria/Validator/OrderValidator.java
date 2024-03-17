package appveterinaria.Validator;

public class OrderValidator extends InputsValidator {

    public long orderIdValidator(String number) throws Exception {
        return super.longValidator(number, "N° de la orden: ");
    }

    public long petIdValidator(String number) throws Exception {
        return super.longValidator(number, "Identificacion de la mascota: ");
    }

    public void medicationNameValidador(String medicationName) throws Exception {
        super.stringValidator(medicationName, "Nombre del medicamento: ");
    }

    public void dosageValidador(String dosage) throws Exception {
        super.stringValidator(dosage, "Dosis del medicamento: ");
    }
}
