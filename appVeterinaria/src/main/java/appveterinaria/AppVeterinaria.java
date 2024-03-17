package appveterinaria;

import appveterinaria.Config.MYSQLConnection;
import appveterinaria.Controller.LoginController;
import java.util.Scanner;

public class AppVeterinaria {
    private static final Scanner reader = new Scanner(System.in);
    private static final LoginController loginController = new LoginController();
        
	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			try {
				run = runApplication();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.print("Deteniendo la aplicacion");
	}
        
	public static boolean runApplication() throws Exception {
		String menu = "Ingrese \n1.Para iniciar sesion \n2.Para cerrar la aplicacion";
		System.out.println(menu);
		String option = reader.nextLine();
		switch (option) {
		case "1" -> {
			loginController.login();
			return true;
		}
		case "2" -> {
			return false;
		}
		default -> {
			System.out.print("Ingrese una opcion valida");
			return true;
		}

		}

	}  
    
}

