package com.keola.agq.entity;

import com.keola.agq.entity.shared.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * andre on 29/11/2023
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    @Column(name = "nombre_usuario", nullable = false, length = 20)
    private String firstName;

    @Column(name = "apellido_usuario", nullable = false, length = 20)
    private String lastName;

    @Column(name = "username", nullable = false, length = 20)
    private String username;

    @Column(name = "correo", nullable = false, unique = true, length = 50)
    private String email;

    @Column(name = "contrasena", nullable = false, length = 100)
    private String password;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    @ToString.Exclude
    private Set<Role> roles = new LinkedHashSet<>();

    public User(String firstName, String lastName, String username, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, username, email, password);
    }

    public void assignRoleToUser(Role role) {
        this.roles.add(role);
        role.getUsers().add(this);
    }

    public void removeRoleFromUser(Role role) {
        this.roles.remove(role);
        role.getUsers().remove(this);
    }
}
