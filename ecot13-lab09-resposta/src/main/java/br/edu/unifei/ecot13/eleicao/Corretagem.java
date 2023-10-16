package br.edu.unifei.ecot13.eleicao;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Corretagem implements Serializable {
	private static final long serialVersionUID = 870282666684509839L;
	@Id
	private String tipo; //simples ou mista
	private double taxaFixa;
	private double taxaVariavel;
}
