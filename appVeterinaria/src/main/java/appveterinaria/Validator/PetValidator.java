package appveterinaria.Validator;

public class PetValidator extends InputsValidator {

    public void nameValidador(String name) throws Exception {
        super.stringValidator(name, "Nombre de la mascota: ");
    }

    public long idValidator(String number) throws Exception {
        return super.longValidator(number, "la identificación de la mascota: ");
    }

    public int ageValidator(String number) throws Exception {
        return super.integerValidator(number, "la edad de la mascota: ");
    }

    public void speciesValidador(String species) throws Exception {
        super.stringValidator(species, "la especie de la mascota: ");
    }

    public void breedValidador(String breed) throws Exception {
        super.stringValidator(breed, "la raza de la mascota: ");
    }

    public void characteristicsValidador(String characteristics) throws Exception {
        super.stringValidator(characteristics, "Las carateristicas de la mascota: ");
    }

    public double weightValidator(String number) throws Exception {
        return super.doubleValidator(number, "El peso de la mascota es: ");
    }

}
