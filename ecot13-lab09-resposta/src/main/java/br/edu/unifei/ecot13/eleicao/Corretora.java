package br.edu.unifei.ecot13.eleicao;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Corretora implements Serializable{
	private static final long serialVersionUID = 1970130898102565889L;
	@Id
	private String nome;
	private double saldo;
	@OneToOne
	private CarteiraInvestimento carteiraInvestidor;
	@OneToOne
	private Operacao operacao;
}
