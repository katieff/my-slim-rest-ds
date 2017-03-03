package de.msggillardon.coc.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = MyEntity.findAll, query = "Select e from MyEntity e") 
public class MyEntity {
	
	public final static String findAll = "MyEntity.findAll";
	
	@Id
	@GeneratedValue
	private long id;
	private String content; // no getters and setters
	
	public MyEntity(String c) {
		this.content = c;
	}
	
	protected MyEntity() {
	}

	public long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
}
