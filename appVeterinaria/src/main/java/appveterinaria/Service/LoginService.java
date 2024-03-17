package appveterinaria.Service;

import appveterinaria.Dto.PersonDto;

public interface LoginService {

    public void login(PersonDto personDto) throws Exception;

    public void logout(long sessionId) throws Exception;

    public void setSessionID(long sessionId);
}
