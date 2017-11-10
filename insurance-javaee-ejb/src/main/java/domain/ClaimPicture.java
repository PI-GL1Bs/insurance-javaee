package domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ClaimPicture
 *
 */
@Entity

public class ClaimPicture implements Serializable {

	@Id
	private String name;
	private byte[]  url;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Claim claim;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Claim getClaim() {
		return claim;
	}
	public void setClaim(Claim claim) {
		this.claim = claim;
	}
	public ClaimPicture() {
		super();
	}   
	public byte[] getUrl() {
		return this.url;
	}

	public void setUrl(byte[] url) {
		this.url = url;
	}
   
}
