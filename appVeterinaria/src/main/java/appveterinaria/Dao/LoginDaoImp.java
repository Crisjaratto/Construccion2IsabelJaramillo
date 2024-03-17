package appveterinaria.Dao;

import appveterinaria.Config.MYSQLConnection;
import appveterinaria.Dto.SessionDto;
import appveterinaria.Dto.PersonDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDaoImp implements LoginDao {

    Connection connection = MYSQLConnection.getConnection();

    @Override
    public SessionDto login(PersonDto personDto) throws Exception {
        String query = "INSERT INTO SESION(ROLE,USERNAME) VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        int i = 1;
        preparedStatement.setString(i++, personDto.getRole());
        preparedStatement.setString(i++, personDto.getUserName());
        preparedStatement.execute();
        query = "SELECT ID,ROLE,USERNAME FROM SESION WHERE USERNAME = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, personDto.getUserName());
        ResultSet resulSet = preparedStatement.executeQuery();
        if (resulSet.next()) {
            long id = resulSet.getLong("ID");
            System.out.println("El Id es: " +id);
            String userRol = resulSet.getString("ROLE");
            String userName = resulSet.getString("USERNAME");
            resulSet.close();
            preparedStatement.close();
            return new SessionDto(id, userName, userRol);
        }
        resulSet.close();
        preparedStatement.close();
        return null;
    }

    @Override
    public void logout(long sesionId) throws Exception {
        String query = "DELETE FROM SESION WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, sesionId);
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public SessionDto findSessionById(long sessionId) throws Exception {
        String query = "SELECT ID, ROLE, USERNAME FROM SESION WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, sessionId);
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println(sessionId);
        SessionDto sessionDto = new SessionDto();
        if (resultSet.next()) {
            long id = resultSet.getLong("ID");
            String userRole = resultSet.getString("ROLE");
            String userName = resultSet.getString("USERNAME");
            sessionDto = new SessionDto(id, userName, userRole);
        }
        resultSet.close();
        preparedStatement.close();

        return sessionDto;
    }

}
