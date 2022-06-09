package br.com.lab.customers.repositories.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="tb_customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "sq_customers")	
	@TableGenerator(name = "sq_customers", table = "tb_sequences", pkColumnName = "name", valueColumnName = "value", pkColumnValue="sq_customers")
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="document_type")
	private String documentType;
	
	@Column(name="document")
	private String document;
	
	@Column(name="birth_date")
	private LocalDate birthDate;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	
	
}
