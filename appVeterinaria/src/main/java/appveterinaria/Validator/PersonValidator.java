package appveterinaria.Validator;

public class PersonValidator extends InputsValidator {

    public void nameValidador(String name) throws Exception {
        super.stringValidator(name, "Nombre de usuario: ");
    }

    public long idValidator(String number) throws Exception {
        return super.longValidator(number, "Id de usuario: ");
    }

    public void roleValidator(String role) throws Exception {
        super.stringValidator(role, "Roll de usuario: ");
    }

    public int ageValidator(String age) throws Exception {
        return super.integerValidator(age, "La edad: ");
    }

    public void userNameValidador(String username) throws Exception {
        super.stringValidator(username, "Usuario: ");
    }

    public void passwordValidator(String password) throws Exception {
        super.stringValidator(password, "Contraseña de usuario: ");
    }
}
