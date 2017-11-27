package domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Entity implementation class for Entity: Reclamation
 *
 */
@Entity
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown=true)
public class Reclamation implements Serializable {

	@Id
	@GeneratedValue
	private int idReclamation;
	private static final long serialVersionUID = 1L;

	public Insured getInsured() {
		return insured;
	}

	public void setInsured(Insured insured) {
		this.insured = insured;
	}

	@ManyToOne
	private Insured insured;
	private String subject;
	private String description;
	private String category;
	private String status;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;

	public Reclamation() {
	}

	public int getIdReclamation() {
		return this.idReclamation;
	}

	public void setIdReclamation(int idReclamation) {
		this.idReclamation = idReclamation;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
