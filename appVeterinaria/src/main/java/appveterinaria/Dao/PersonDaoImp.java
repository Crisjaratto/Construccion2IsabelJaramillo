package appveterinaria.Dao;

import appveterinaria.Config.MYSQLConnection;
import appveterinaria.Dto.PersonDto;
import appveterinaria.Models.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonDaoImp implements PersonDao {

    Connection connection = MYSQLConnection.getConnection();

    @Override
    public PersonDto findUserByUserName(PersonDto personDto) throws Exception {
        String query = "SELECT CEDULA,NOMBRE,EDAD,ROLE,USERNAME,PASSWORD FROM PERSONA WHERE USERNAME = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        System.out.println(personDto.getUserName());
        preparedStatement.setString(1, personDto.getUserName());
        ResultSet resulSet = preparedStatement.executeQuery();
        Person person = new Person();
        if (resulSet.next()) {
            person.setId(resulSet.getLong("CEDULA"));
            person.setName(resulSet.getString("NOMBRE"));
            person.setAge(resulSet.getInt("EDAD"));
            person.setRole(resulSet.getString("ROLE"));
            person.setUserName(resulSet.getString("USERNAME"));
            person.setPassword(resulSet.getString("PASSWORD"));
            resulSet.close();
            preparedStatement.close();
            return new PersonDto(person);
        }
        resulSet.close();
        preparedStatement.close();
        return null;
    }

    @Override
    public void createPerson(PersonDto personDto) throws Exception {
        String query = "INSERT INTO PERSONA(CEDULA,NOMBRE,EDAD,ROLE,USERNAME,PASSWORD) VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        int i = 1;
        preparedStatement.setLong(i++, personDto.getId());
        preparedStatement.setString(i++, personDto.getName());
        preparedStatement.setInt(i++, personDto.getAge());
        preparedStatement.setString(i++, personDto.getRole());
        preparedStatement.setString(i++, personDto.getUserName());
        preparedStatement.setString(i++, personDto.getPassword());
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public boolean findUserExistById(PersonDto personDto) throws Exception {
        String query = "SELECT 1 FROM PERSONA WHERE CEDULA = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, personDto.getId());
        ResultSet resulSet = preparedStatement.executeQuery();
        boolean userExists = resulSet.next();
        resulSet.close();
        preparedStatement.close();
        return userExists;
    }

    @Override
    public boolean findExistingUserByUserName(PersonDto personDto) throws Exception {
        String query = "SELECT 1 FROM PERSONA WHERE USERNAME = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, personDto.getUserName());
        ResultSet resulSet = preparedStatement.executeQuery();
        boolean userExists = resulSet.next();
        resulSet.close();
        preparedStatement.close();
        return userExists;
    }

    @Override
    public PersonDto findUserById(PersonDto personId) throws Exception {
        String query = "SELECT CEDULA FROM PERSONA WHERE CEDULA = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, personId.getId());
        ResultSet resulSet = preparedStatement.executeQuery();
        Person person = new Person();
        if (resulSet.next()) {
            person.setId(resulSet.getLong("CEDULA"));
            resulSet.close();
            preparedStatement.close();
            return new PersonDto(person);
        }
        resulSet.close();
        preparedStatement.close();
        return null;

    }

}
