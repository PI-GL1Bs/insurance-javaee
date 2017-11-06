package Domain;

import Domain.User;
import java.io.Serializable;
import javax.persistence.*;

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
