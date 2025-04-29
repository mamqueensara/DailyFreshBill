package com.training.model;

import java.util.List;

import org.hibernate.annotations.EmbeddableInstantiator;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	
	private long id;
	
	@Column
	@NotEmpty(message="Customer name is mandatory...Cannot be left blank")
	@Size(min=4,max=20,message="Length of Name should be between 3 to 20 ")
	private String custName;
	
	@Embedded
	private Address address;
		
	@Column
	@Email(message="Please enter valid email")
	private String custEmail;
	
	@Column
	@Pattern(regexp="^[0-9]{10}$",message="Phone number must be exactly 10 digits")
	private String custPhoneNumber;
	
	
		
	
	

}
