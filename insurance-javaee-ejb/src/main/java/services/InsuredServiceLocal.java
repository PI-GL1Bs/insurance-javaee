package services;

import java.util.List;

import javax.ejb.Local;


import domain.Insured;

@Local
public interface InsuredServiceLocal {


	void saveOrUpdate(Insured insured);
	Insured findInsuredById(int id);
    void removeInsured(Insured insured);
	List<Insured> findAllInsured();
	Insured findInsuredByName(String name);
    void modifyInsured(Insured insured);
}
