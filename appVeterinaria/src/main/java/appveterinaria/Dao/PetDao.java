package appveterinaria.Dao;

import appveterinaria.Dto.PetDto;

public interface PetDao {
    
    public PetDto findUserById(PetDto petDto) throws Exception;
    
    public void createPet(PetDto petDto) throws Exception;

    public boolean findPetById(PetDto petDto) throws Exception;
    


}
