package br.edu.unifei.ecot13.eleicao;

import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Debenture extends RendaFixa {
	private static final long serialVersionUID = -2827058845889085017L;
	private double risco;
}