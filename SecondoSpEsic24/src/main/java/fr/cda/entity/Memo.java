package fr.cda.entity;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class Memo {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    private String titre;
    private String contenuMemo;
    
    @CreationTimestamp
    private Date dateMemo;
    
    @ManyToOne
    private User user;
}
