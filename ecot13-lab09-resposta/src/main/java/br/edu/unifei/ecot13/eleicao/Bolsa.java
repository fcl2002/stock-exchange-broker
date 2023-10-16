package br.edu.unifei.ecot13.eleicao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Bolsa implements Serializable {
	private static final long serialVersionUID = -2383990564391063821L;
	@Id
	private String nome;
	private String pais;
	private double pontuacao;
	@OneToMany
	private List<Instituicao> instituicoes = new ArrayList<Instituicao>();
	@OneToMany
	private List<Acao> acoes =new ArrayList<Acao>();
}
