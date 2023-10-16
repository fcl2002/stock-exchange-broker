package br.edu.unifei.ecot13.eleicao;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CarteiraInvestimento implements Serializable {
	private static final long serialVersionUID = 1716305057671302065L;
	@Id
	private String numConta;
}
