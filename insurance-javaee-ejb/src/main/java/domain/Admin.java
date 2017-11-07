<<<<<<< HEAD
package domain;

import java.io.Serializable;
import javax.persistence.*;

import domain.User;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity
@Inheritance
public class Admin extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Admin() {
		super();
	}
   
}
=======
package domain;

import java.io.Serializable;
import javax.persistence.*;

import domain.User;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity
@Inheritance
public class Admin extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Admin() {
		super();
	}
   
}
>>>>>>> branch 'master' of https://github.com/PI-GL1Bs/insurance-javaee
