package Domain;

import java.io.Serializable;
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
