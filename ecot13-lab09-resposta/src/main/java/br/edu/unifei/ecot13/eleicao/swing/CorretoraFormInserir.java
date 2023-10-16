package br.edu.unifei.ecot13.eleicao.swing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.unifei.ecot13.eleicao.Acao;
import br.edu.unifei.ecot13.eleicao.Bolsa;
import br.edu.unifei.ecot13.eleicao.Operacao;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class CorretoraFormInserir extends JFrame {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("corretora");
	private EntityManager em = emf.createEntityManager();
	
	private Operacao operacao;
	private Bolsa bolsa;
	private Acao acao;

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textTicket;
	private JTextField textCodigo;
	private JTextField textValor;
	private JTextField textPais;
	private JTextField textCompra;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CorretoraFormInserir frame = new CorretoraFormInserir();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CorretoraFormInserir() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Código: ");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodigo.setBounds(42, 51, 79, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblValor.setBounds(42, 81, 79, 14);
		contentPane.add(lblValor);
		
		JLabel lblBolsa = new JLabel("Nome:");
		lblBolsa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBolsa.setBounds(42, 144, 88, 14);
		contentPane.add(lblBolsa);
		
		textNome = new JTextField();
		textNome.setBounds(149, 143, 92, 20);
		textNome.setColumns(10);
		contentPane.add(textNome);
		
		JLabel lblPais = new JLabel("País:");
		lblPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPais.setBounds(42, 174, 79, 14);
		contentPane.add(lblPais);
		
		JLabel lblTicket = new JLabel("Ticket: ");
		lblTicket.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTicket.setBounds(42, 233, 79, 14);
		contentPane.add(lblTicket);
		
		textTicket = new JTextField();
		textTicket.setBounds(149, 232, 92, 20);
		textTicket.setColumns(10);
		contentPane.add(textTicket);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(149, 50, 92, 20);
		textCodigo.setColumns(10);
		contentPane.add(textCodigo);
		
		textValor = new JTextField();
		textValor.setBounds(149, 80, 92, 20);
		textValor.setColumns(10);
		contentPane.add(textValor);
		
		textPais = new JTextField();
		textPais.setBounds(149, 173, 92, 20);
		textPais.setColumns(10);
		contentPane.add(textPais);
		
		JLabel Operacao = new JLabel("Operação");
		Operacao.setHorizontalAlignment(SwingConstants.CENTER);
		Operacao.setFont(new Font("Tahoma", Font.BOLD, 20));
		Operacao.setBounds(51, 10, 190, 31);
		contentPane.add(Operacao);
		
		JLabel Bolsa = new JLabel("Bolsa");
		Bolsa.setHorizontalAlignment(SwingConstants.CENTER);
		Bolsa.setFont(new Font("Tahoma", Font.BOLD, 15));
		Bolsa.setBounds(42, 110, 199, 31);
		contentPane.add(Bolsa);
		
		JLabel Ação = new JLabel("Ação");
		Ação.setHorizontalAlignment(SwingConstants.CENTER);
		Ação.setFont(new Font("Tahoma", Font.BOLD, 15));
		Ação.setBounds(42, 198, 199, 31);
		contentPane.add(Ação);
		
		JLabel lblPrecoCompra = new JLabel("Preço compra:");
		lblPrecoCompra.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecoCompra.setBounds(42, 263, 88, 14);
		contentPane.add(lblPrecoCompra);
		
		textCompra = new JTextField();
		textCompra.setColumns(10);
		textCompra.setBounds(149, 262, 92, 20);
		contentPane.add(textCompra);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.setForeground(new Color(0, 0, 0));
		btnInserir.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnInserir.setBounds(42, 331, 107, 31);
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acao = new Acao();
				bolsa = new Bolsa();
				operacao = new Operacao();
				
				acao.setTicket(textTicket.getText());
				acao.setPrecoCompra(Double.parseDouble(textCompra.getText()));
				bolsa.setNome(textNome.getText());
				bolsa.setPais(textPais.getText());
				operacao.setCodigo(textCodigo.getText());
				operacao.setValor(Double.parseDouble(textValor.getText()));
				operacao.setDataOperacao(new Date(new GregorianCalendar(2023, 7, 11).getTimeInMillis()));
						
				acao.setListada(bolsa);
				bolsa.getAcoes().add(acao);				
				operacao.setInvestimento(bolsa);
				
				em.getTransaction().begin();
				em.persist(acao);
				em.persist(bolsa);
				em.persist(operacao);
				em.getTransaction().commit();
			}
		});
		contentPane.add(btnInserir);
	}
}
