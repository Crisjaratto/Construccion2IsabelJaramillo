package appveterinaria.Dto;

import appveterinaria.Models.Person;

public class PersonDto {

    private long id;
    private String name;
    private int age;
    private String role;
    private String userName;
    private String password;

    public PersonDto(long id, String name, int age, String role, String userName, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.role = role;
        this.userName = userName;
        this.password = password;
    }

    public PersonDto(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.age = person.getAge();
        this.role = person.getRole();
        this.userName = person.getUserName();
        this.password = person.getPassword();
    }

    public PersonDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public PersonDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public PersonDto(String userName) {
        this.userName = userName;
    }
  
    
    public PersonDto() {
	
	}

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
