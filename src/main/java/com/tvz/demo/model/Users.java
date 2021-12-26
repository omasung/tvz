package com.tvz.demo.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "users")

public class Users implements Serializable {

	private static final long serialVersionUID = 1L;

    @GenericGenerator(
      name = "users-sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "users_sequence"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "1")
        }
    )

	@Id
    @GeneratedValue(generator = "users-sequence-generator")
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Column(unique = true, name = "username")
    private String username;
    
    @Column(nullable = false, name = "name")
    private String name;
    
    @Column(unique = true, name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "pic")
    private String pic;
    
    @Column(columnDefinition = "TEXT", name = "bio")
    private String bio;
    
    @Column(name = "pvt")
    private Boolean pvt;
    
    @Column(name = "verified")
    private Boolean verified; 
    
    @Column(unique = true, name = "vfCode")//Verification code
    private String vfCode;
    
    @Column(name = "signupDate")
    private LocalDateTime signupDate; 
    
    @Column(name = "lastLoginDate")
    private LocalDateTime lastLoginDate;    
    
	public Users() {
		
    }

    public Users(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Boolean getPvt() {
		return pvt;
	}

	public void setPvt(Boolean pvt) {
		this.pvt = pvt;
	}

	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

	public String getVfCode() {
		return vfCode;
	}

	public void setVfCode(String vfCode) {
		this.vfCode = vfCode;
	}

	public LocalDateTime getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(LocalDateTime signupDate) {
		this.signupDate = signupDate;
	}

	public LocalDateTime getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(LocalDateTime lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}    

}
