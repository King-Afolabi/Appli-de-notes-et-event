package fr.cda.entity;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class Event {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    
    @Column(nullable = false)
    private String title;

    
    private String description;

    private Date startDate;

    private Date endDate;

    private String lieu;

    private String organisateur;
    
    @ManyToMany
	@JsonIgnore
    private List<User> participants;
    
    private Boolean status;
    
    @CreationTimestamp
    private Date dateCreation;
    
    @ManyToOne
    private User user;

}
