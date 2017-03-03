package de.msggillardon.coc.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.msggillardon.coc.pojos.MyEntity;

@Stateless // better Performance, transaction control, parallel and monitoring of all methods
public class MyEntityService {
	
	@PersistenceContext // only one persistence unit, so no further spec needed
	EntityManager em;
	
	public MyEntity save(MyEntity myEnt) {
		return this.em.merge(myEnt);
	}
	
	public List<MyEntity> all() {
		return this.em.createNamedQuery(MyEntity.findAll, MyEntity.class).getResultList();
	}
	
	public MyEntity find(long id) {
		return this.em.find(MyEntity.class, id);
	}

}
