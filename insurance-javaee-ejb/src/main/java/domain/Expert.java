<<<<<<< HEAD
package domain;

import java.io.Serializable;
import javax.persistence.*;

import domain.User;

/**
 * Entity implementation class for Entity: Expert
 *
 */
@Entity
@Inheritance
public class Expert extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Expert() {
		super();
	}
   
}
=======
package domain;

import java.io.Serializable;
import javax.persistence.*;

import domain.User;

/**
 * Entity implementation class for Entity: Expert
 *
 */
@Entity
@Inheritance
public class Expert extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Expert() {
		super();
	}
   
}
>>>>>>> branch 'master' of https://github.com/PI-GL1Bs/insurance-javaee
