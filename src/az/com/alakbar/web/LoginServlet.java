package az.com.alakbar.web;

import az.com.alakbar.dao.LoginDao;
import az.com.alakbar.dao.impl.LoginDaoImpl;
import az.com.alakbar.model.Login;
import az.com.alakbar.service.LoginService;
import az.com.alakbar.service.impl.LoginServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/ls")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginDao loginDao = new LoginDaoImpl();
        LoginService loginService = new LoginServiceImpl(loginDao);
        String address = "";

        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");

       try{
           if(username != null && !username.isEmpty() && pwd != null && !pwd.isEmpty()){
          Login login =  loginService.login(username,pwd);
          if(login != null){
              HttpSession session = request.getSession(true);
              session.setAttribute("login",login);
              address = "index.jsp";
          }else{
            address = "login.jsp";
          }

           }else{
               address = "login.jsp";
           }
       }catch (Exception ex){

           ex.printStackTrace();
       }
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
       dispatcher.forward(request, response);
    }


}
