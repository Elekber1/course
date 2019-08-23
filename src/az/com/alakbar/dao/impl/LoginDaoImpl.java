package az.com.alakbar.dao.impl;

import az.com.alakbar.dao.DBHelper;
import az.com.alakbar.dao.LoginDao;
import az.com.alakbar.model.Login;
import az.com.alakbar.model.Role;
import az.com.alakbar.util.JdbcUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDaoImpl implements LoginDao {


    @Override
    public Login login(String username, String password) throws Exception {
        Login login = new Login();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT L.ID, L.NAME, L.SURNAME,r.id ROLE_ID,r.role_name ROLE FROM LOGIN L\n" +
                " INNER JOIN ROLE R ON l.role_id = r.id\n" +
                " WHERE L.USERNAME = ? AND L.PASSWORD = ?";
        try {
            c = DBHelper.getConnection();
            if(c!=null){
                ps = c.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if(rs.next()){
                    login.setId(rs.getLong("ID"));
                    login.setName(rs.getString("NAME"));
                    login.setSurname(rs.getString("SURNAME"));
                    Role role = new Role();
                    role.setId(rs.getLong("ROLE_ID"));
                    role.setRoleName(rs.getString("ROLE"));
                    login.setRole(role);
                }else{
                    login = null;
                }

            }else{
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JdbcUtility.close(c, ps, rs);
        }
        return login;
    }
}
