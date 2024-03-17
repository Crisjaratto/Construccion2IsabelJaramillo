package appveterinaria.Dao;

import appveterinaria.Config.MYSQLConnection;
import appveterinaria.Dto.PetDto;
import appveterinaria.Models.Pet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static javax.swing.text.html.HTML.Attribute.ID;

public class PetDaoImp implements PetDao {

    public Connection connection = MYSQLConnection.getConnection();

    public void createPet(PetDto petDto) throws Exception {
        String query = "INSERT INTO MASCOTA (ID_PROPIETARIO,NOMBRE,EDAD,PESO,RAZA,ESPECIE,CARACTERISTICAS)VALUES ( ?,?,?,?,?,?,? )";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        int i = 1;
        System.out.println("la cedula es " + petDto.getOwnerID());
        preparedStatement.setLong(i++, petDto.getOwnerID());
        preparedStatement.setString(i++, petDto.getName());
        preparedStatement.setInt(i++, petDto.getAge());
        preparedStatement.setDouble(i++, petDto.getWeight());//Peso
        preparedStatement.setString(i++, petDto.getBreed()); //Raza
        preparedStatement.setString(i++, petDto.getSpecies());
        preparedStatement.setString(i++, petDto.getCharacteristics());
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public boolean findPetById(PetDto petDto) throws Exception {
        String query = "SELECT 1 FROM MASCOTA WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, petDto.getId());
        ResultSet resulSet = preparedStatement.executeQuery();
        boolean userExists = resulSet.next();
        resulSet.close();
        preparedStatement.close();
        return userExists;
    }

    @Override
    public PetDto findUserById(PetDto petDto) throws Exception {
        String query = "SELECT ID FROM MASCOTA WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, petDto.getId());
        ResultSet resulSet = preparedStatement.executeQuery();
        if (resulSet.next()) {
            PetDto pet = new PetDto();
            pet.setId(resulSet.getLong("ID"));
            return pet ;
        }
        resulSet.close();
        preparedStatement.close();
        return null;
    }
}
