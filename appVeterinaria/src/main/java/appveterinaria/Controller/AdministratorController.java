package appveterinaria.Controller;

import appveterinaria.Dto.PersonDto;
import appveterinaria.Service.AdministratorService;
import appveterinaria.Service.VeterinaryServiceImpl;
import appveterinaria.Validator.PersonValidator;
import java.util.Scanner;

public class AdministratorController {

    private static PersonValidator personValidator = new PersonValidator();
    private static VeterinaryServiceImpl veterinarianSVeterinaryServiceImplervice = new VeterinaryServiceImpl();
    private static Scanner reader = new Scanner(System.in);
    private static AdministratorService administratorService = new VeterinaryServiceImpl();
    private static final String Menú = "Ingrese: "
            + "\n1.Crear Medico Veterinario"
            + "\n2.Crear Vendedor"
            + "\n3.Cerrar Sesion";

    private void createVeterinarian() throws Exception {
        System.out.println("Ingrese numero de cedula: ");
        Long id = personValidator.idValidator(reader.nextLine());
        System.out.println("Ingrese nombre completo: ");
        String name = reader.nextLine();
        personValidator.nameValidador(name);
        System.out.println("ingrese la edad: ");
        int age = personValidator.ageValidator(reader.nextLine());
        System.out.println("Ingrese el nombre del usuario: ");
        String userName = reader.nextLine();
        personValidator.userNameValidador(userName);
        System.out.println("Ingrese la contraseña");
        String password = reader.nextLine();
        personValidator.userNameValidador(password);
        PersonDto personDto = new PersonDto(id, name, age, null, userName, password);
        administratorService.createVeterinarian(personDto);
    }

    private void createSeller() throws Exception {
        System.out.println("Ingrese numero de cedula: ");
        Long id = personValidator.idValidator(reader.nextLine());
        System.out.println("Ingrese nombre completo: ");
        String name = reader.nextLine();
        personValidator.nameValidador(name);
        System.out.println("ingrese la edad: ");
        int age = personValidator.ageValidator(reader.nextLine());
        System.out.println("Ingrese el nombre del usuario: ");
        String userName = reader.nextLine();
        personValidator.userNameValidador(userName);
        System.out.println("Ingrese la contraseña");
        String password = reader.nextLine();
        personValidator.userNameValidador(password);
        PersonDto personDto = new PersonDto(id, name, age, null, userName, password);
        administratorService.createSeller(personDto);
    }

    public void session() {
        boolean runApp = true;
        while (runApp) {
            try {
                System.out.println(Menú);
                String option = reader.nextLine();
                runApp = menu(option);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    private boolean menu(String option) throws Exception {
        switch (option) {
            case "1": {
                createVeterinarian();
                return true;
            }
            case "2": {
                createSeller();
                return true;
            }
            case "3": {
                return false;
            }
            default: {
                System.out.println("Ingrese una opcion valida");
                return true;
            }
        }
    }

}
