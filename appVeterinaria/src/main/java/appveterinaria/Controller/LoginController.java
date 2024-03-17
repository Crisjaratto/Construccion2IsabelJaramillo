package appveterinaria.Controller;

import appveterinaria.Dto.PersonDto;
import appveterinaria.Service.LoginService;
import appveterinaria.Service.VeterinaryServiceImpl;
import appveterinaria.Validator.PersonValidator;
import java.util.Scanner;

public class LoginController {

    private static Scanner reader = new Scanner(System.in);
    private static PersonValidator personValidator = new PersonValidator();
    private static LoginService loginService = new VeterinaryServiceImpl();
    private static VeterinarianController veterinarianController = new VeterinarianController();
    private static AdministratorController administratorController = new AdministratorController();

    public void login() throws Exception {
        System.out.println("ingrese su usuario");
        String userName = reader.nextLine();
        personValidator.userNameValidador(userName);
        System.out.println("ingrese su contraseña");
        String password = reader.nextLine();
        personValidator.passwordValidator(password);
        PersonDto personDto = new PersonDto(userName, password);
        loginService.login(personDto);
        loginRouter(personDto);
        loginService.logout(0);
    }

    private void loginRouter(PersonDto personDto) {
        String option = personDto.getRole();
        switch (option) {
            case "Administrador": {
                administratorController.session();
                break;
            }
            
            case "Medico Veterinario": {
                veterinarianController.session();
                break;
            }
            
            

            default: {
                System.out.println("ingrese una opcion valida");
                break;
            }

        }
    }

}
