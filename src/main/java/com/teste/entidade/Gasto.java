package com.teste.entidade;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "gastos")
public class Gasto implements Serializable {

	@Serial
	private static final long serialVersionUID = -6261125648129225476L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, length = 30)
	private String nome;
	@Column(nullable = false, length = 45)
	private String descricao;


	@Column(nullable = false)
	private LocalDateTime data;
	@Column(nullable = false)
	private BigDecimal valor;
	@Column(nullable = false, length = 45)
	//@Converter(ListConverter.class)
	private String tags;


	public Gasto() {
	}

	public Gasto(Long id, String nome, String descricao, LocalDateTime data, BigDecimal valor, String tags) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.data = data;
		this.valor = valor;
		this.tags = tags;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
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
		Gasto other = (Gasto) obj;
		return Objects.equals(id, other.id);
	}
}
