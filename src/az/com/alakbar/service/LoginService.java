package az.com.alakbar.service;

import az.com.alakbar.model.Login;

public interface LoginService {

    Login login(String username, String password) throws Exception;
}
