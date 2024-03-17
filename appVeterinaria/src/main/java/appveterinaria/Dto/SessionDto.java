package appveterinaria.Dto;

public class SessionDto {

    private long id;
    private String userName;
    private String role;

    public SessionDto() {
    }

    public SessionDto(long id, String userName, String role) {
        this.id = id;
        this.userName = userName;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
