package az.com.alakbar.model;


public class Login extends CourseModel{
    
    private String username;
    private String password;
    private String name;
    private String surname;
    private Role role;
    private String email;

    public Login() {
    }

   
    public Login(Role role) {
        this.role = role;
    }
    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Login{" + "username=" + username + ", password=" + password + ", name=" + name + ", surname=" + surname + ", role=" + role + ", email=" + email + '}';
    }
       
}
