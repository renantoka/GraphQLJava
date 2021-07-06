package com.SEPLAG.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.leangen.graphql.annotations.GraphQLQuery;

@Entity
public class Food {
	
	@Id
	@GeneratedValue
	@GraphQLQuery(name = "id", description = "id da comida")
	private Long id;
	
	@GraphQLQuery(name = "nome", description = "nome da comida")
	private String nome;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", nome=" + nome + "]";
	}

}
