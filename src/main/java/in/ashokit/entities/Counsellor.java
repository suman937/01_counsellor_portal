package in.ashokit.entities;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="counsellor_tbl")
@Data
public class Counsellor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="conunsellor_id")
	private Integer counsellorId;
	
	@Column(name="name")
	private String name;
	
	@Column(unique = true)
	private String email;
	
	private String pwd;
	
	private Long phno;
	@CreationTimestamp
	private LocalDate createdDate;
	@UpdateTimestamp
	private LocalDate updatedDate;

}
