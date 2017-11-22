package domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Estimation
 *
 */
@Entity

public class Estimation implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private float electricity;
	private float mechanical;
	private float Woodwork;
	private float tapestry;
	private float Painting;
	private float SheetMetalWorkshop;
	private float valueBefore;
	private float valueAfter;
	private float valueClam,priceWorkForce;
	private String result;
	private static final long serialVersionUID = 1L;

	public Estimation() {
		super();
	}   
	
	public float getPriceWorkForce() {
		return priceWorkForce;
	}

	public void setPriceWorkForce(float priceWorkForce) {
		this.priceWorkForce = priceWorkForce;
	}



	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public float getElectricity() {
		return this.electricity;
	}

	public void setElectricity(float electricity) {
		this.electricity = electricity;
	}   
	public float getMechanical() {
		return this.mechanical;
	}

	public void setMechanical(float mechanical) {
		this.mechanical = mechanical;
	}   
	public float getWoodwork() {
		return this.Woodwork;
	}

	public void setWoodwork(float Woodwork) {
		this.Woodwork = Woodwork;
	}   
	public float getTapestry() {
		return this.tapestry;
	}

	public void setTapestry(float tapestry) {
		this.tapestry = tapestry;
	}   
	public float getPainting() {
		return this.Painting;
	}

	public void setPainting(float Painting) {
		this.Painting = Painting;
	}   
	public float getSheetMetalWorkshop() {
		return this.SheetMetalWorkshop;
	}

	public void setSheetMetalWorkshop(float SheetMetalWorkshop) {
		this.SheetMetalWorkshop = SheetMetalWorkshop;
	}   
	public float getValueBefore() {
		return this.valueBefore;
	}

	public void setValueBefore(float valueBefore) {
		this.valueBefore = valueBefore;
	}   
	public float getValueAfter() {
		return this.valueAfter;
	}

	public void setValueAfter(float valueAfter) {
		this.valueAfter = valueAfter;
	}   
	public float getValueClam() {
		return this.valueClam;
	}

	public void setValueClam(float valueClam) {
		this.valueClam = valueClam;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
   
}
