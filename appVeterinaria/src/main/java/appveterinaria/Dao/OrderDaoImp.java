package appveterinaria.Dao;

import appveterinaria.Config.MYSQLConnection;
import appveterinaria.Dto.OrderDto;
import appveterinaria.Dto.PersonDto;
import appveterinaria.Dto.SessionDto;
import appveterinaria.Models.Person;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDaoImp implements OrderDao {

	Connection connection = MYSQLConnection.getConnection();

	@Override
	public OrderDto createOrden(OrderDto orderDto) throws Exception {
		String query = "INSERT INTO ORDEN(MASCOTA, PROPIETARIO, MEDICO, MEDICAMENTO, FECHA) VALUES (?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		int i = 1;

		preparedStatement.setLong(i++, orderDto.getPetId());
		preparedStatement.setLong(i++, orderDto.getOwnerID().getId());
		preparedStatement.setLong(i++, orderDto.getVeterinarianID().getId());
		preparedStatement.setString(i++, orderDto.getMedicationName());
		preparedStatement.setDate(i++, orderDto.getGenerationDate());
		preparedStatement.execute();
		query = "SELECT ID FROM ORDEN WHERE FECHA = ?";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setDate(1, orderDto.getGenerationDate());
		ResultSet resulSet = preparedStatement.executeQuery();
		if (resulSet.next()) {
			orderDto.setOrderId(resulSet.getLong("ID"));
			preparedStatement.close();
			return orderDto;
		}
		preparedStatement.close();
		return null;

	}

	@Override
	public OrderDto orderById(long orderId) throws Exception {
		String query = "SELECT MASCOTA, PROPIETARIO, MEDICO, MEDICAMENTO, FECHA FROM ORDEN WHERE id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setLong(1, orderId);
		ResultSet resultSet = preparedStatement.executeQuery();

		OrderDto orderDto = new OrderDto(orderId);
		if (resultSet.next()) {
			orderDto.setOrderId(orderId);
			orderDto.setPetId(resultSet.getLong("MASCOTA"));
			PersonDto ownerDto = new PersonDto();
			ownerDto.setId(resultSet.getLong("PROPIETARIO"));
			orderDto.setOwnerID(ownerDto);
			PersonDto veterinarianDto = new PersonDto();
			veterinarianDto.setId(resultSet.getLong("MEDICO"));
			orderDto.setVeterinarianID(veterinarianDto);
			orderDto.setMedicationName(resultSet.getString("MEDICAMENTO"));
			orderDto.setGenerationDate(resultSet.getDate("FECHA"));
		}

		preparedStatement.close();
		return orderDto;
	}
}
