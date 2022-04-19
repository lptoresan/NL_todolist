package br.com.listatarefa.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="listatarefas")
public class ListaTarefa implements Serializable, Base {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="codigo")
	private Long id;
	private String nome;
	private String observacao;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return null;
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
		ListaTarefa other = (ListaTarefa) obj;
		return Objects.equals(id, other.id);
	}

}
