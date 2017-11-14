package blog.user;

import blog.core.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;

@Entity
public class User extends BaseEntity {

    public static  final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder(10);

    @Email
    @NotEmpty(message = "Please enter your email address.")
    private String email;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private String[] roles;

    protected User(){
        super();
    }

    public User(String email, String password, String[] roles) {
        this();
        this.email = email;
        setPassword(password);
        this.roles = roles;
    }

    public void setPassword(String password){
        this.password = PASSWORD_ENCODER.encode(password);
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }
}