package br.com.lf.sprint.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
public class Login extends AbstractModel{
    @NotEmpty
    @Column(unique = true)
    private String username;

    @NotEmpty
    //@JsonIgnore
    private String password;

    @NotEmpty
    private boolean admin;

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

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Login(@NotEmpty String username, @NotEmpty String password, @NotEmpty boolean admin) {
        this.username = username;
        this.password = password;
        this.admin = admin;
    }

    public Login() {
    }
}
