package br.edu.unifei.ecot13.eleicao;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Imposto implements Serializable {
	private static final long serialVersionUID = 3860404133628042327L;
	@Id
	private String nome;
	private double taxa;
	private double multaAtraso;
}
