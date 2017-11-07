<<<<<<< HEAD
package domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ActualityComment
 *
 */
@Entity

public class ActualityComment implements Serializable {

	   
	@Id
	private int idActualityComment;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Insured insured ;
	@ManyToOne
	private Actuality actuality ;
	public Insured getInsured() {
		return insured;
	}
	public void setInsured(Insured insured) {
		this.insured = insured;
	}
	public ActualityComment() {
		super();
	}   
	public int getIdActualityComment() {
		return this.idActualityComment;
	}

	public void setIdActualityComment(int idActualityComment) {
		this.idActualityComment = idActualityComment;
	}
	public Actuality getActuality() {
		return actuality;
	}
	public void setActuality(Actuality actuality) {
		this.actuality = actuality;
	}
   
}
=======
package domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ActualityComment
 *
 */
@Entity

public class ActualityComment implements Serializable {

	   
	@Id
	private int idActualityComment;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Insured insured ;
	@ManyToOne
	private Actuality actuality ;
	public Insured getInsured() {
		return insured;
	}
	public void setInsured(Insured insured) {
		this.insured = insured;
	}
	public ActualityComment() {
		super();
	}   
	public int getIdActualityComment() {
		return this.idActualityComment;
	}

	public void setIdActualityComment(int idActualityComment) {
		this.idActualityComment = idActualityComment;
	}
	public Actuality getActuality() {
		return actuality;
	}
	public void setActuality(Actuality actuality) {
		this.actuality = actuality;
	}
   
}
>>>>>>> branch 'master' of https://github.com/PI-GL1Bs/insurance-javaee
