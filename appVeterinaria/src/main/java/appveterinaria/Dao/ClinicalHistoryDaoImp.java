package appveterinaria.Dao;

import appveterinaria.Config.MYSQLConnection;
import appveterinaria.Dto.ClinicalHistoryDto;
import appveterinaria.Dto.OrderDto;
import appveterinaria.Dto.PersonDto;
import appveterinaria.Dto.SessionDto;
import appveterinaria.Models.Person;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClinicalHistoryDaoImp implements ClinicalHistoryDao {

	public Connection connection = MYSQLConnection.getConnection();
	public static SessionDto sessionDto = new SessionDto();
	String session = sessionDto.getUserName();

	@Override
	public void createClinicalHistory(ClinicalHistoryDto clinicalHistoryDto) throws Exception {
		String query = "INSERT INTO HISTORIA(FECHA,MASCOTA,MEDICO,MOTIVO,SINTOMATOLOGIA,DIAGNOSIS,MEDICAMENTO,MEDICATIONDOSAGE,"
				+ "VACUNACION,ALERGIA,PROCEDIMIENTO,DETALLES_PROCEDIMIENTOS,ORDEN,ORDERCANCELATION) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		int i = 1;
		preparedStatement.setLong(i++, clinicalHistoryDto.getDate());
		preparedStatement.setLong(i++, clinicalHistoryDto.getPetId());
		preparedStatement.setLong(i++, clinicalHistoryDto.getVeterinarian().getId());
		preparedStatement.setString(i++, clinicalHistoryDto.getReasonForConsultation());
		preparedStatement.setString(i++, clinicalHistoryDto.getSymptoms());
		preparedStatement.setString(i++, clinicalHistoryDto.getDiagnosis());
		preparedStatement.setString(i++, clinicalHistoryDto.getMedication());
		preparedStatement.setString(i++, clinicalHistoryDto.getMedicationDose());
		preparedStatement.setString(i++, clinicalHistoryDto.getVaccinationHistory());
		preparedStatement.setString(i++, clinicalHistoryDto.getAllergies());
		preparedStatement.setString(i++, clinicalHistoryDto.getProcedure());
		preparedStatement.setString(i++, clinicalHistoryDto.getProcedureDetails());
		preparedStatement.setLong(i++, clinicalHistoryDto.getOrderId().getOrderId());
		preparedStatement.setBoolean(i++, clinicalHistoryDto.isOrderCancellation());
		System.out.println("");
		preparedStatement.execute();
		preparedStatement.close();

	}

	@Override
	public ClinicalHistoryDto findClinicalHistoryById(int clinicalHistoryId) throws Exception {
		   String query = "SELECT FECHA, MASCOTA, MEDICO, MOTIVO, SINTOMATOLOGIA, DIAGNOSIS, MEDICAMENTO, MEDICATIONDOSAGE, " +
                   "VACUNACION, ALERGIA, PROCEDIMIENTO, DETALLES_PROCEDIMIENTOS, ORDEN, ORDERCANCELATION " +
                   "FROM HISTORIA WHERE FECHA = ?";
    
    PreparedStatement preparedStatement = connection.prepareStatement(query);
    preparedStatement.setInt(1, clinicalHistoryId);
    
    ResultSet resultSet = preparedStatement.executeQuery();

    if (resultSet.next()) {
        ClinicalHistoryDto clinicalHistoryDto = new ClinicalHistoryDto(clinicalHistoryId);
        clinicalHistoryDto.setDate(clinicalHistoryId);
        clinicalHistoryDto.setPetId(clinicalHistoryId);
        clinicalHistoryDto.getVeterinarian();
        clinicalHistoryDto.setReasonForConsultation(query);
        clinicalHistoryDto.setSymptoms(query);
        clinicalHistoryDto.setDiagnosis(query);
        clinicalHistoryDto.setMedication(query);
        clinicalHistoryDto.setMedicationDose(query);
        clinicalHistoryDto.setVaccinationHistory(query);
        clinicalHistoryDto.setAllergies(query);
        clinicalHistoryDto.setProcedure(query);
        clinicalHistoryDto.setProcedureDetails(query);
        clinicalHistoryDto.setOrderId(null);
        clinicalHistoryDto.setOrderCancellation(false);
        
        resultSet.close();
        preparedStatement.close();
        return clinicalHistoryDto;
    } else {
        resultSet.close();
        preparedStatement.close();
        return null; 
    }
	}
}
