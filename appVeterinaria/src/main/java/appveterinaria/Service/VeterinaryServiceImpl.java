package appveterinaria.Service;

import appveterinaria.Dao.ClinicalHistoryDao;
import appveterinaria.Dao.ClinicalHistoryDaoImp;
import static appveterinaria.Dao.ClinicalHistoryDaoImp.sessionDto;
import appveterinaria.Dao.LoginDao;
import appveterinaria.Dao.LoginDaoImp;
import appveterinaria.Dao.PersonDao;
import appveterinaria.Dao.PersonDaoImp;
import appveterinaria.Dao.PetDao;
import appveterinaria.Dto.ClinicalHistoryDto;
import appveterinaria.Dto.SessionDto;
import appveterinaria.Dto.PersonDto;
import appveterinaria.Dto.PetDto;
import appveterinaria.Dao.PetDaoImp;
import appveterinaria.Dto.OrderDto;
import appveterinaria.Dao.OrderDao;
import appveterinaria.Dao.OrderDaoImp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class VeterinaryServiceImpl implements LoginService, AdministratorService, VeterinarianService {

    List<String> role = Arrays.asList("Administrador", "Medico Veterinario", "Vendedor", "Dueño de mascota");
    List<String> species = Arrays.asList("perro", "gato", "conejo", "cobaya",
            "huron", "hámster", "ardilla", "erizo", "periquito", "canario", "loro",
            "tortuga", "lagartija", "serpiente", "salamandra", "chinchilla");
    private static long sessionID = 0;

    @Override
    public void login(PersonDto personDto) throws Exception {
        PersonDao personDao = new PersonDaoImp();
        PersonDto personDtoValidate = personDao.findUserByUserName(personDto);
        if (personDtoValidate == null) {
            throw new Exception("usuario no valido");
        }
        if (!personDto.getPassword().equals(personDtoValidate.getPassword())) {
            throw new Exception("usuario o contraseña incorrectos");
        }
        personDto.setRole(personDtoValidate.getRole());
        LoginDao loginDao = new LoginDaoImp();
        SessionDto sesionDto = loginDao.login(personDtoValidate);
        setSessionID(sesionDto.getId());
        System.out.println("se inicia la sesion " + sessionID);
    }

    @Override
    public void logout(long sesionId) throws Exception {
        LoginDao loginDao = new LoginDaoImp();
        loginDao.logout(sesionId);
        setSessionID(0);
    }

    @Override
    public void setSessionID(long sesionId) {
        sessionID = sesionId;
    }

    @Override
    public void createVeterinarian(PersonDto personDto) throws Exception {
        personDto.setRole("Medico Veterinario");

        System.out.println("cedula del usuario" + personDto.getId());
        PersonDao personDao = new PersonDaoImp();
        if (personDao.findUserExistById(personDto)) {
            throw new Exception("Ya existe un usuario con esa cedula");
        }
        if (personDao.findExistingUserByUserName(personDto)) {
            throw new Exception("Ya existe el usuario");
        }
        personDao.createPerson(personDto);
        System.out.println("Se ha creado el usuario");
    }

    @Override
    public void createSeller(PersonDto personDto) throws Exception {
        personDto.setRole("Vendedor");
        PersonDao personDao = new PersonDaoImp();
        if (personDao.findUserExistById(personDto)) {
            throw new Exception("Ya existe un usuario con esa cedula");
        }
        if (personDao.findExistingUserByUserName(personDto)) {
            throw new Exception("Ya existe el usuario");
        }
        personDao.createPerson(personDto);
        System.out.println("Se ha creado el usuario");
    }

    @Override
    public void createPet(PetDto petDto) throws Exception {
        if (!species.contains(petDto.getSpecies())) {
            throw new Exception("La especie no es valida " + petDto.getSpecies());
        }
        PetDao petDao = new PetDaoImp();
        petDao.createPet(petDto);
        System.out.println("Se ha creado la mascota ");
    }

    @Override
    public void createClinicalHistory(ClinicalHistoryDto clinicalHistoryDto) throws Exception {
        // Buscar la sesión activa
        LoginDao loginDao = new LoginDaoImp();
        SessionDto sessionDto = loginDao.findSessionById(sessionID);
        if (sessionDto == null) {
            throw new Exception("No hay una sesión válida.");
        }
        clinicalHistoryDto.setDate(System.currentTimeMillis());
        // Verificar la existencia y validez de la sesión
        PersonDao personDao = new PersonDaoImp();
        PersonDto personDto = new PersonDto(sessionDto.getUserName());
        personDto = personDao.findUserByUserName(personDto);
        if (personDto == null) {
            throw new Exception("No hay un usuario válido asociado a la sesión.");
        }
        clinicalHistoryDto.setVeterinarian(personDto);
        // Buscar la mascota en la historia clínica
        PetDao petDao = new PetDaoImp();
        PetDto petDto = new PetDto(clinicalHistoryDto.getPetId());
        petDto = petDao.findUserById(petDto);
        if (petDto == null) {
            throw new Exception("La mascota especificada no existe.");
        }
        //Crear Orden
        OrderDao orderDao = new OrderDaoImp();
        OrderDto orderDto = new OrderDto(sessionID, petDto.getId(), personDto, personDto, clinicalHistoryDto.getMedication(), clinicalHistoryDto.getMedicationDose(),new Date(clinicalHistoryDto.getDate()));
        orderDto = orderDao.createOrden(orderDto);
        if (orderDto != null) {
            Long orderId = orderDto.getOrderId();
            System.out.println("ID del pedido asociado a la historia es clínica: " + orderId);
        } else {
            System.out.println("No hay pedido asociado a la historia es clínica:");
        }
        
        // Crear la historia clínica
        ClinicalHistoryDao clinicalHistoryDao = new ClinicalHistoryDaoImp();
        clinicalHistoryDto.setOrderId(orderDto);
        clinicalHistoryDao.createClinicalHistory(clinicalHistoryDto);
        System.out.println("Se ha creado la Historia clínica.");
    }

    @Override
    public void createOwner(PersonDto personDto) throws Exception {
        personDto.setRole("Dueño");
        personDto.setUserName("Dueño");
        personDto.setPassword("Dueño");
        PersonDao personDao = new PersonDaoImp();
        //if (personDao.findUserExistById(personDto)) {
        //    throw new Exception("Ya existe un usuario con esa cedula");
        //}
        personDao.createPerson(personDto);
        System.out.println("Se ha creado el propietario correctamente.");
    }

}
