package br.edu.unifei.ecot13.eleicao;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import lombok.Data;

@Data
@Entity
public class Investidor implements Serializable {
	private static final long serialVersionUID = -5831203951885479884L;
	@Id
	private String cpf;
    private String nome;
    private String perfil;
    @ManyToOne
    private Corretora conta;
}
