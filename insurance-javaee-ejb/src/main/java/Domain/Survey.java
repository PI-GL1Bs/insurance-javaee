package Domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Survey
 *
 */
@Entity

public class Survey implements Serializable {

	   
	@Id
	private int idSurvey;
	private static final long serialVersionUID = 1L;

	public Survey() {
		super();
	}   
	public int getIdSurvey() {
		return this.idSurvey;
	}

	public void setIdSurvey(int idSurvey) {
		this.idSurvey = idSurvey;
	}
   
}
