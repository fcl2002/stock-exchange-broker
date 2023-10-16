package br.edu.unifei.ecot13.eleicao;

import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class CDB extends RendaFixa{
	private static final long serialVersionUID = 7735815963205571539L;
	private String emissor;
}
