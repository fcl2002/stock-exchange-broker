package br.edu.unifei.ecot13.eleicao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
public class RendaFixa implements Serializable{
	private static final long serialVersionUID = -4104217723961475558L;
	@Id
	private String nome;
	private double rentabilidade;
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;
}