package com.tvz.demo.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "followedUsers")

public class FollowedUsers implements Serializable {

	private static final long serialVersionUID = 1L;

    @GenericGenerator(
      name = "followedUsers-sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "followedUsers_sequence"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "1")
        }
    )

	@Id
    @GeneratedValue(generator = "followedUsers-sequence-generator")
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private Users userid; 
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "followedUserid")
    private Users followedUserid; 

	public FollowedUsers() {
		
    }

    public FollowedUsers(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    } 
    
	@ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "id")
	public Users getUserid() {
		return userid;
	}

	public void setUserid(Users userid) {
		this.userid = userid;
	}

	@ManyToOne
    @JoinColumn(name = "followedUserid", referencedColumnName = "id")
	public Users getFollowedUserid() {
		return followedUserid;
	}

	public void setFollowedUserid(Users followedUserid) {
		this.followedUserid = followedUserid;
	}
	
}
