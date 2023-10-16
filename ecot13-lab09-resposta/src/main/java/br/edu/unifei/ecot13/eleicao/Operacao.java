package br.edu.unifei.ecot13.eleicao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Operacao implements Serializable {
	private static final long serialVersionUID = 8025950851748691144L;
	@Id
	private String codigo;
	private double valor;
	@Temporal(TemporalType.DATE)
	private Date dataOperacao;
	@OneToOne
	private Corretagem corretagem;
	@OneToOne
	private Imposto imposto;
	@OneToOne
	private Bolsa investimento;
	@OneToOne
	private RendaFixa aplicacao;
}
