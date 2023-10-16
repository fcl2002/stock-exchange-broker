package br.edu.unifei.ecot13.eleicao;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Instituicao implements Serializable {
	private static final long serialVersionUID = 3935312167386288882L;
	@Id
	private String nome;
	private String setor;
}
