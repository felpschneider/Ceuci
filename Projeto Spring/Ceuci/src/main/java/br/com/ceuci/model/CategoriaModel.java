package br.com.ceuci.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tb_categoria")
public class CategoriaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private boolean horta;

	private boolean mercearia;
	
	private boolean misto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isHorta() {
		return horta;
	}

	public void setHorta(boolean horta) {
		this.horta = horta;
	}

	public boolean isMercearia() {
		return mercearia;
	}

	public void setMercearia(boolean mercearia) {
		this.mercearia = mercearia;
	}

	public boolean isMisto() {
		return misto;
	}

	public void setMisto(boolean misto) {
		this.misto = misto;
	}

	
}
