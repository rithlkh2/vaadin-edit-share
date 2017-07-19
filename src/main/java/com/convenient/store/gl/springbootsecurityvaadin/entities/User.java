package com.convenient.store.gl.springbootsecurityvaadin.entities;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 
 * @author p.ly
 *
 */
@Entity
@Table(name = "tbluser")
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="sec_usr_id")
    private Long id;

    @NotNull
    @Column(name="sec_usr_login")
    private String username;

    @NotNull
    @Column(name="sec_usr_lastname")
    private String lastName;

    @NotNull
    @Column(name="sec_usr_firstname")
    private String firstName;
    
    
//    private String email;
//
//
	private String sec_usr_pwd;
//
//
//    private Date dt_cre;
//
//
//    private String usr_cre;
//
//
//    private Date dt_upd;
//
//
//    private String usr_upd;

  
    //private boolean status;

   
    //private Long dealerId;

   
    //private boolean firstLogin;

    @ManyToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "tbluser_role", joinColumns = {@JoinColumn(name = "sec_usr_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roles;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.trim();
    }

    @Override
    public String getPassword() {
    	
        return getSec_usr_pwd();
    }

    public void setPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassowrd = passwordEncoder.encode(password.trim());
        this.setSec_usr_pwd(hashedPassowrd);
    }

//    public boolean isStatus() {
//        return status;
//    }
//
//    public void setStatus(boolean status) {
//        this.status = status;
//    }
//
//    public List<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(List<Role> roles) {
//        this.roles = roles;
//    }
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Date getDt_cre() {
//        return dt_cre;
//    }
//
//    public void setDt_cre(Date dt_cre) {
//        this.dt_cre = dt_cre;
//    }
//
//    public String getUsr_cre() {
//        return usr_cre;
//    }
//
//    public void setUsr_cre(String usr_cre) {
//        this.usr_cre = usr_cre;
//    }
//
//    public Date getDt_upd() {
//        return dt_upd;
//    }
//
//    public void setDt_upd(Date dt_upd) {
//        this.dt_upd = dt_upd;
//    }
//
//    public String getUsr_upd() {
//        return usr_upd;
//    }
//
//    public void setUsr_upd(String usr_upd) {
//        this.usr_upd = usr_upd;
//    }
//
//    public Long getDealerId() {
//        return dealerId;
//    }
//
//    public void setDealerId(Long dealerId) {
//        this.dealerId = dealerId;
//    }
//
//    public boolean isFirstLogin() {
//        return firstLogin;
//    }
//
//    public void setFirstLogin(boolean firstLogin) {
//        this.firstLogin = firstLogin;
//    }
    
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

    public String getSec_usr_pwd() {
        return sec_usr_pwd;
    }

    public void setSec_usr_pwd(String sec_usr_pwd) {
        this.sec_usr_pwd = sec_usr_pwd;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
