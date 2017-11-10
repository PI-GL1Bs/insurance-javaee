package services;

import java.util.List;

import javax.ejb.Local;

import domain.Reunion;

@Local
public interface ReunionServiceLocal {
public Reunion addReunion(Reunion reunion);
public Reunion saveReunion (Reunion reunion) ;
public List<Reunion> findAllReunions();
public Reunion findReunionById(int id) ;
public Boolean removeMeeting (Reunion reunion);
}
