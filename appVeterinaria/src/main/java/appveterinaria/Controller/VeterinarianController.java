package appveterinaria.Controller;

import appveterinaria.Dao.ClinicalHistoryDaoImp;
import appveterinaria.Dao.ClinicalHistoryDao;
import appveterinaria.Dao.LoginDao;
import appveterinaria.Dao.LoginDaoImp;
import appveterinaria.Dao.OrderDao;
import appveterinaria.Dao.OrderDaoImp;
import appveterinaria.Dto.ClinicalHistoryDto;
import appveterinaria.Dto.OrderDto;
import appveterinaria.Dto.PersonDto;
import appveterinaria.Dto.PetDto;
import appveterinaria.Dto.SessionDto;
import appveterinaria.Service.VeterinarianService;
import appveterinaria.Service.VeterinaryServiceImpl;
import appveterinaria.Validator.ClinicalHistoryValidator;
import appveterinaria.Validator.OrderValidator;
import appveterinaria.Validator.PersonValidator;
import appveterinaria.Validator.PetValidator;

import java.sql.Date;
import java.util.Scanner;

public class VeterinarianController {

	private static PetValidator petValidator = new PetValidator();
	private static ClinicalHistoryValidator clinicalHistoryValidator = new ClinicalHistoryValidator();
	private static VeterinaryServiceImpl veterinarianSVeterinaryServiceImplervice = new VeterinaryServiceImpl();
	private static PersonValidator personValidator = new PersonValidator();
	private static Scanner reader = new Scanner(System.in);
	private static VeterinarianService veterinarianService = new VeterinaryServiceImpl();
	private static final String Menú = "Ingrese: " + "\n1.Crear dueño" + "\n2.Crear mascota"
			+ "\n3.Crear historia Clinica" + "\n4.Consultar historia Clinica" + "\n5.Buscar Orden"
			+ "\n6.Para cerrar Sesion";
	private static final int clinicalHistoryDto = 0;
	private static final int clinicalHistoryId = 0;

	private void createOwner() throws Exception {
		System.out.println("Ingrese la cedula del dueño: ");
		Long idOwner = personValidator.idValidator(reader.nextLine());
		System.out.println("Ingrese el nombre del dueño: ");
		String fullNameOwner = reader.nextLine();
		personValidator.nameValidador(fullNameOwner);
		PersonDto personDto = new PersonDto(idOwner, fullNameOwner);
		veterinarianService.createOwner(personDto);
	}

	private void createPet() throws Exception {
		System.out.println("Ingrese la identificación de la mascota: ");
		Long idPet = petValidator.idValidator(reader.nextLine());
		System.out.println("Ingrese la cedula del dueño: ");
		Long id = personValidator.idValidator(reader.nextLine());
		System.out.println("Ingrese el nombre de la mascota: ");
		String fullName = reader.nextLine();
		petValidator.nameValidador(fullName);
		System.out.println("Ingrese la edad de la mascota: ");
		int age = petValidator.ageValidator(reader.nextLine());
		System.out.println("Ingrese el peso de la mascota: ");
		double Weight = petValidator.weightValidator(reader.nextLine());
		System.out.println("Ingrese la raza de la mascota: ");
		String breed = reader.nextLine();
		petValidator.breedValidador(breed);
		System.out.println("Ingrese la especie de la mascota: ");
		String species = reader.nextLine();
		petValidator.speciesValidador(species);
		System.out.println("Ingrese las caracteristicas de la mascota: ");
		String characteristics = reader.nextLine();
		petValidator.characteristicsValidador(characteristics);
		PetDto petDto = new PetDto(idPet, id, fullName, age, Weight, breed, species.toLowerCase(), characteristics);
		veterinarianService.createPet(petDto);
	}

	private void createClinicalHistory() throws Exception {
//        System.out.println("Ingrese la fecha de atención: ");
//        Long date = clinicalHistoryValidator.dateValidator(reader.nextLine());
		System.out.println("Ingrese la identificación de la mascota: ");
		Long pet = clinicalHistoryValidator.petIdValidator(reader.nextLine());
		System.out.println("Ingrese el motivo de consulta: ");
		String reasonForConsultation = reader.nextLine();
		clinicalHistoryValidator.reasonForConsultationValidador(reasonForConsultation);
		System.out.println("Ingrese los sintomas de la mascota: ");
		String symptoms = reader.nextLine();
		clinicalHistoryValidator.symptomsValidador(symptoms);
		System.out.println("Ingrese el diagnostico de la mascota: ");
		String diagnosis = reader.nextLine();
		clinicalHistoryValidator.diagnosisValidador(diagnosis);
		System.out.println("Ingrese los medicamentos: ");
		String medication = reader.nextLine();
		clinicalHistoryValidator.medicationValidador(medication);
		System.out.println("Ingrese la dosis correspondiente a cada medicamento: ");
		String medicationDose = reader.nextLine();
		clinicalHistoryValidator.medicationDoseValidador(medicationDose);
		System.out.println("Ingrese el historial de vacunación de la mascota: ");
		String vaccinationHistory = reader.nextLine();
		clinicalHistoryValidator.vaccinationHistoryValidador(vaccinationHistory);
		System.out.println("Ingrese las alergias de la mascota: ");
		String allergies = reader.nextLine();
		clinicalHistoryValidator.allergiesValidador(allergies);
		System.out.println("Ingrese el procedimiento realizado a la mascota: ");
		String procedure = reader.nextLine();
		clinicalHistoryValidator.procedureValidador(procedure);
		System.out.println("Ingrese ingrese los detalles del procedimiento realizado a la mascota: ");
		String procedureDetails = reader.nextLine();
		clinicalHistoryValidator.procedureDetailsValidador(procedureDetails);
		ClinicalHistoryDto clinicalHistoryDto = new ClinicalHistoryDto(System.currentTimeMillis(), pet, null,
				reasonForConsultation, symptoms, diagnosis, procedure, medication, medicationDose, null,
				vaccinationHistory, allergies, procedureDetails, true);
		veterinarianService.createClinicalHistory(clinicalHistoryDto);

	}
	
	public ClinicalHistoryDto findClinicalHistoryById(int clinicalHistoryId) throws Exception {
	    System.out.println("Ingrese el ID de la historia clínica: ");
	    int date = (int) clinicalHistoryValidator.dateValidator(reader.nextLine());
	    ClinicalHistoryDao clinicalHistoryDao = new ClinicalHistoryDaoImp();
	    ClinicalHistoryDto clinicalHistoryDto = clinicalHistoryDao.findClinicalHistoryById(clinicalHistoryId);
	    
	    if (clinicalHistoryDto != null && clinicalHistoryDto.getDate() == clinicalHistoryId) {
	        System.out.println("Se encontró la historia clínica con el ID " + clinicalHistoryId);
	        System.out.println("Fecha: " + clinicalHistoryDto.getDate());
	        System.out.println("Mascota: " + clinicalHistoryDto.getPetId());
	        System.out.println("Médico: " + clinicalHistoryDto.getVeterinarian());
	        System.out.println("Motivo: " + clinicalHistoryDto.getReasonForConsultation());
	        System.out.println("Sintomatología: " + clinicalHistoryDto.getSymptoms());
	        System.out.println("Diagnóstico: " + clinicalHistoryDto.getDiagnosis());
	        System.out.println("Medicamento: " + clinicalHistoryDto.getMedication());
	        System.out.println("Dosificación del medicamento: " + clinicalHistoryDto.getMedicationDose());
	        System.out.println("Vacunación: " + clinicalHistoryDto.getVaccinationHistory());
	        System.out.println("Alergia: " + clinicalHistoryDto.getAllergies());
	        System.out.println("Procedimiento: " + clinicalHistoryDto.getProcedure());
	        System.out.println("Detalles del procedimiento: " + clinicalHistoryDto.getProcedureDetails());
	        System.out.println("Orden: " + clinicalHistoryDto.getOrderId());
	        
	        
	    } else {
	        System.out.println("No se encontró una historia clínica válida con el ID " + clinicalHistoryId);
	        
	    }
	    return clinicalHistoryDto;
	}

	private OrderDto orderById() throws Exception {
		System.out.println("Ingrese el id de la orden:  ");
		long orderId = clinicalHistoryValidator.orderId(reader.nextLine());
		OrderDao orderDao = new OrderDaoImp();
		OrderDto orderDto = orderDao.orderById(orderId);
		if (orderDto == null) {
			throw new Exception("No hay una orden válida.");
		}
		System.out.println("ID: " + orderDto.getOrderId());
		System.out.println("Mascota: " + orderDto.getPetId());
		System.out.println("Medicamento: " + orderDto.getMedicationName());
		System.out.println("Fecha: " + orderDto.getGenerationDate());
		return orderDto;

	}

	public void session() {
		boolean runApp = true;
		while (runApp) {
			try {
				System.out.println(Menú);
				String option = reader.nextLine();
				runApp = Menú(option);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}

	private boolean Menú(String option) throws Exception {
		switch (option) {
		case "1": {
			createOwner();
			return true;
		}
		case "2": {
			createPet();
			return true;
		}
		case "3": {
			createClinicalHistory();
			return true;
		}
		case "4": {
			findClinicalHistoryById(clinicalHistoryId);
			return false;
		}
		case "5": {
			orderById();
			return false;
		}
		default: {
			System.out.println("Ingrese una opcion valida");
			return true;
		}
		}
	}

}
