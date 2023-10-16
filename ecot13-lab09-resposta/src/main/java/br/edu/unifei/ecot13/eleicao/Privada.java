package br.edu.unifei.ecot13.eleicao;

import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Privada extends Instituicao {
	private static final long serialVersionUID = 6042013984459223927L;
	private String acionistaMajoritario;
	private String tipoSociedade; //MEI, EI, LTDA, SA, SS
}
