package insurancejavaee.reclamation;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import domain.Claim;
import domain.Reclamation;
import domain.Reunion;
import services.ReclamationServiceLocal;

@ManagedBean
public class MapBean {

	private List<Agence> agences = new ArrayList<Agence>();

	public MapBean() {
	}

	@PostConstruct
	public void init() {
		agences.add(new Agence(36.849543439983634, 10.164928436279297, "El Manzah 6"));

		agences.add(new Agence(36.88984963563158, 10.179519653320312, "Cité El Ghazela"));

		agences.add(new Agence(36.84631527829811, 10.19582748413086, "Centre Urbain Nord"));

		agences.add(new Agence(36.82845490018628, 10.196342468261719, "Cité El Khadra"));
	}

	public List<Agence> getAgences() {
		return agences;
	}

	public void setAgences(List<Agence> agences) {
		this.agences = agences;
	}

	public class Agence {
		public double lat;
		public double lng;
		public String name;

		public Agence(double lat, double lng, String name) {
			this.lat = lat;
			this.lng = lng;
			this.name = name;
		}

		public double getLat() {
			return lat;
		}

		public void setLat(double lat) {
			this.lat = lat;
		}

		public double getLng() {
			return lng;
		}

		public void setLng(double lng) {
			this.lng = lng;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
