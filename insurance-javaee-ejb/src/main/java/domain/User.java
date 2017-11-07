<<<<<<< HEAD
package domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="USER_TYPE")
@DiscriminatorValue("user")
public class User implements Serializable {

	   
	@Id
	private int cin;
	private String role ;
	private String name ;
	private String FirstName;
	private String photo;
	private String mail ;
	private String Adresse ;
	private String login;
	private String password ;
	private String confrimPassword;
	private String sex ;
	private int Tel ;
	private Date birthDate;
	
	
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public User(int cin, String role, String name, String firstName, String photo, String mail, String adresse,
			String login, String password, String confrimPassword, String sex, int tel) {
		super();
		this.cin = cin;
		this.role = role;
		this.name = name;
		FirstName = firstName;
		this.photo = photo;
		this.mail = mail;
		Adresse = adresse;
		this.login = login;
		this.password = password;
		this.confrimPassword = confrimPassword;
		this.sex = sex;
		Tel = tel;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getTel() {
		return Tel;
	}
	public void setTel(int tel) {
		Tel = tel;
	}
	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
	}

	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	public int getIdUser() {
		return this.cin;
	}

	public void setIdUser(int idUser) {
		this.cin = idUser;
	}
   
}
=======
package domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="USER_TYPE")
@DiscriminatorValue("user")
public class User implements Serializable {

	   
	@Id
	private int cin;
	private String role ;
	private String name ;
	private String FirstName;
	private String photo;
	private String mail ;
	private String Adresse ;
	private String login;
	private String password ;
	private String confrimPassword;
	private String sex ;
	private int Tel ;
	private Date birthDate;
	
	
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public User(int cin, String role, String name, String firstName, String photo, String mail, String adresse,
			String login, String password, String confrimPassword, String sex, int tel) {
		super();
		this.cin = cin;
		this.role = role;
		this.name = name;
		FirstName = firstName;
		this.photo = photo;
		this.mail = mail;
		Adresse = adresse;
		this.login = login;
		this.password = password;
		this.confrimPassword = confrimPassword;
		this.sex = sex;
		Tel = tel;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getTel() {
		return Tel;
	}
	public void setTel(int tel) {
		Tel = tel;
	}
	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
	}

	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	public int getIdUser() {
		return this.cin;
	}

	public void setIdUser(int idUser) {
		this.cin = idUser;
	}
   
}
>>>>>>> branch 'master' of https://github.com/PI-GL1Bs/insurance-javaee
