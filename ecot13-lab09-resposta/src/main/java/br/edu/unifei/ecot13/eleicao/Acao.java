package br.edu.unifei.ecot13.eleicao;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Acao implements Serializable{
	private static final long serialVersionUID = -7398476917421384345L;
	@Id
	private String ticket;
	private double precoCompra;
	private double prevoVenda;
	@ManyToOne
	private Bolsa listada;
}
