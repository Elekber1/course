package az.com.alakbar.model;


public class Role extends CourseModel{
    
    private Long id;
    private String roleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" + "id=" + id + ", roleName=" + roleName + '}';
    }

   
    
}
