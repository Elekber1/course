package az.com.alakbar.service.impl;

import az.com.alakbar.dao.LoginDao;
import az.com.alakbar.model.Login;
import az.com.alakbar.service.LoginService;

public class LoginServiceImpl implements LoginService {

    private LoginDao loginDao;

    public LoginServiceImpl(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    public Login login(String username, String password) throws Exception {
        return loginDao.login(username,password);
    }
}
