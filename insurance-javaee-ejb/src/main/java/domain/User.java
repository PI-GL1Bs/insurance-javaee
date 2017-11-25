package domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="USER_TYPE")
@DiscriminatorValue("user")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User implements Serializable {

	   
	@Id
	private int id;
	private String role ;
	private String lastName ;
	private String FirstName;
	private String photo;
	private String mail ;
	private String Adresse ;
	private String login;
	private String password ;
	private String confrimPassword;
	private String sex ;
	private String phoneNumber;
	private int nbConnect;
	
	public User(int id, String role, String lastName, String firstName, String photo, String mail, String adresse,
			String login, String password, String confrimPassword, String sex, String phoneNumber, Date birthDate) {
		super();
		this.id = id;
		this.role = role;
		this.lastName = lastName;
		FirstName = firstName;
		this.photo = photo;
		this.mail = mail;
		Adresse = adresse;
		this.login = login;
		this.password = password;
		this.confrimPassword = confrimPassword;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.birthDate = birthDate;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	private Date birthDate;
	
	
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfrimPassword() {
		return confrimPassword;
	}
	public void setConfrimPassword(String confrimPassword) {
		this.confrimPassword = confrimPassword;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	

	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}
	public int getNbConnect() {
		return nbConnect;
	}
	public void setNbConnect(int nbConnect) {
		this.nbConnect = nbConnect;
	}   
	
   
}
