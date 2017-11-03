package Domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Actuality
 *
 */
@Entity

public class Actuality implements Serializable {

	   
	@Id
	private int idActuality;
	private static final long serialVersionUID = 1L;

	public Actuality() {
		super();
	}   
	public int getIdActuality() {
		return this.idActuality;
	}

	public void setIdActuality(int idActuality) {
		this.idActuality = idActuality;
	}
   
}
