package com.convenient.store.gl.springbootsecurityvaadin.entities;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author p.ly
 *
 */
@Entity
@Table(name = "tblrole")
public class Role implements GrantedAuthority{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="role_id")

	private Long id;

    @NotNull
    private String name;

    @NotNull
    private boolean status;
    public Role(){
        id=1L;
        name="Hello";
        status=true;
    }
    public Role(String name, boolean status) {
        this.name = name;
        this.status = status;
    }

    public Role(Long id, String name, boolean status) {
        this.id=id;
        this.name = name;
        this.status = status;
    }

    @Override
    public String getAuthority() {
        return getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
