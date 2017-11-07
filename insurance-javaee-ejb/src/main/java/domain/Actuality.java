package domain;

import java.io.Serializable;
import java.util.List;

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
	@OneToMany(mappedBy="actuality")
	private List<ActualityComment> listActualityComments ;
	
	public Actuality() {
		super();
	}   
	public int getIdActuality() {
		return this.idActuality;
	}

	public void setIdActuality(int idActuality) {
		this.idActuality = idActuality;
	}
	public List<ActualityComment> getListActualityComments() {
		return listActualityComments;
	}
	public void setListActualityComments(List<ActualityComment> listActualityComments) {
		this.listActualityComments = listActualityComments;
	}
   
}
