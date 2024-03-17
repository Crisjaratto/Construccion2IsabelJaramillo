package appveterinaria.Dao;

import appveterinaria.Dto.ClinicalHistoryDto;
import appveterinaria.Dto.PersonDto;

public interface ClinicalHistoryDao {

    public void createClinicalHistory(ClinicalHistoryDto clinicalHistoryDto) throws Exception;
    
    public ClinicalHistoryDto findClinicalHistoryById (int clinicalHistoryId)throws Exception;

}
