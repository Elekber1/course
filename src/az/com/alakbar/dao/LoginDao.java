package az.com.alakbar.dao;

import az.com.alakbar.model.Login;

public interface LoginDao {

    Login login(String username, String password) throws Exception;
}
