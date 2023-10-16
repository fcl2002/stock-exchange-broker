package br.edu.unifei.ecot13.eleicao;

import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Cambio extends Operacao {
	private static final long serialVersionUID = -3077433942423096956L;
	private String moedaOrigem;
	private String moedaTroca;
	private double cotacao;
	
	//retorna o câmbio entre as moedas
	//public double Cambio() { return (getValor() / cotacao); }
}
