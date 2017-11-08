package services;

import java.util.List;

import javax.ejb.Local;

import domain.Reunion;

@Local
public interface ReunionServiceLocal {
public Reunion addReunion(Reunion reunion);
public void saveReunion (Reunion reunion) ;
public List<Reunion> findAllReunions();
}
