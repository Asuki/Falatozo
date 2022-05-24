package hu.anyrt.falatozo.data.entity;

import androidx.annotation.Nullable;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class User {
    @Id
    long id;
    // Felhasználói azonosító a projektben. Az API adja vissza
    public String userId;
    // A cégnél használt dolgozószám
    public int employeeId;
    // A felületen használt felhasználónév
    public String username;
    // Vezetéknév
    public String lastName;
    // Jelszó
    public String firstName;
    // e-mail
    public String email;
    // Profilkép -> Az appban van meghatározva
    @Nullable
    public Integer avatar;
    // Jelszó
    @Nullable
    public String password;

    public User(long id, String userId, int employeeId, String username, String lastName,
                String firstName, String email, @Nullable Integer avatar,
                @Nullable String password) {
        this.id = id;
        this.userId = userId;
        this.employeeId = employeeId;
        this.username = username;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.avatar = avatar;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Nullable
    public Integer getAvatar() {
        return avatar;
    }

    public void setAvatar(@Nullable Integer avatar) {
        this.avatar = avatar;
    }

    @Nullable
    public String getPassword() {
        return password;
    }

    public void setPassword(@Nullable String password) {
        this.password = password;
    }
}
