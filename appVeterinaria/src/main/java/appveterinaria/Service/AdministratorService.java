package appveterinaria.Service;

import appveterinaria.Dto.PersonDto;

public interface AdministratorService {

    public void createVeterinarian(PersonDto personDto) throws Exception;

    public void createSeller(PersonDto personDto) throws Exception;

}
