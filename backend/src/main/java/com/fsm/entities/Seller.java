package com.fsm.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tb_sellers")
public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	@OneToMany(mappedBy = "seller")
	private List<Sale> sales = new ArrayList<>();
	
	

	public Seller() {
		super();
	}


	public Seller(Long id, String name, List<Sale> sales) {
		super();
		this.id = id;
		this.name = name;

	}

	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Sale> getSales() {
		return sales;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seller other = (Seller) obj;
		return Objects.equals(id, other.id);
	}
	
}
