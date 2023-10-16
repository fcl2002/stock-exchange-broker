package br.edu.unifei.ecot13.eleicao;

import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Publica extends Instituicao {
	private static final long serialVersionUID = 3094345793011337993L;
	private String nivel; //federal, estadual, municipal
}
