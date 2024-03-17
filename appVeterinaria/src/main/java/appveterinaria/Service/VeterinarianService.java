package appveterinaria.Service;

import appveterinaria.Dto.ClinicalHistoryDto;
import appveterinaria.Dto.PersonDto;
import appveterinaria.Dto.PetDto;


public interface VeterinarianService {

    public void createPet(PetDto petDto) throws Exception;

    public void createClinicalHistory(ClinicalHistoryDto medicalHistoryDto) throws Exception;
    
    public void createOwner(PersonDto personDto) throws Exception;
   
}
