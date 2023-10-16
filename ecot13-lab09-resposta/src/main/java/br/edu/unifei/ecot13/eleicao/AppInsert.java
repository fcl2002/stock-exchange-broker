/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.ecot13.eleicao;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppInsert {

    public static void main(String args[]) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("corretora");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        //Investidores
        Investidor i1 = new Investidor();
        i1.setCpf("123.456.789-01");
        i1.setNome("Fernando");
        i1.setPerfil("Moderado");
        em.persist(i1);
        
        Investidor i2 = new Investidor();
        i2.setCpf("123.456.789-02");
        i2.setNome("Carlos");
        i2.setPerfil("Agressivo");
        em.persist(i2);
        
        //Corretoras
        Corretora c1 = new Corretora();
        c1.setNome("Rico");
        em.persist(c1);
        
        Corretora c2 = new Corretora();
        c2.setNome("XP Investimentos");
        em.persist(c2);
        
        //Carteiras de Investimento
        CarteiraInvestimento ci1 = new CarteiraInvestimento();
        ci1.setNumConta("2002-31");
        em.persist(ci1);
        
        CarteiraInvestimento ci2 = new CarteiraInvestimento();
        ci2.setNumConta("1998-26");
        em.persist(ci2);
        
        //Relacionamentos Investidores - Corretoras - Carteiras de Investimento    
        i1.setConta(c1);
        i1.getConta().setCarteiraInvestidor(ci1);
        em.merge(i1);
        
        i2.setConta(c2);
        i2.getConta().setCarteiraInvestidor(ci2);
        em.merge(i2);
        
        //Instituições
        Publica pub = new Publica();
        pub.setNome("Banco do Brasil");
        pub.setSetor("Aplicacoes financeiras");
        pub.setNivel("Federal");
        em.persist(pub);
        
        Privada priv = new Privada();
        priv.setNome("Alphabet");
        priv.setSetor("Tecnologia");
        priv.setAcionistaMajoritario("Larry Page");
        priv.setTipoSociedade("Holding");
        em.persist(priv);
             
        //Ações
        Acao a1 = new Acao();
        a1.setTicket("BBAS3");
        em.persist(a1);
        
        Acao a2 = new Acao();
        a2.setTicket("GOGL");
        em.persist(a2);
                
        //Bolsas
        Bolsa b1 = new Bolsa();
        b1.setNome("B3");
        b1.setPais("Brasil");
        b1.setPontuacao(117000);
        em.persist(b1);
        
        Bolsa b2 = new Bolsa();
        b2.setNome("Nasdaq");
        b2.setPais("Estados Unidos");
        b2.setPontuacao(13816);
        em.persist(b2);
        
        //Relacionamentos: Acoes - Bolsas - Instituicoes
        a1.setListada(b1);
        em.merge(a1);
        
        a2.setListada(b2);
        em.merge(a2);
        
        //RendaFixa
        RendaFixa rf1 = new RendaFixa();
        rf1.setNome("titulo");
        
        CDB bb = new CDB();
        bb.setNome("Crédito Banco do Brasil");
        bb.setRentabilidade(11);
        bb.setDataVencimento(new Date(new GregorianCalendar(2023, 6, 30).getTimeInMillis()));
        bb.setEmissor(pub.getNome());
        em.persist(bb);
        
        Debenture alphabet = new Debenture();
        alphabet.setNome(priv.getNome());
        alphabet.setRentabilidade(13);
        alphabet.setRisco(30.0); //vai de 0 a 100, quanto mais próximo de 100 maior o risco de calote do título emitido
        em.persist(alphabet);             
        
        //Imposto
        Imposto imp1 = new Imposto();
        imp1.setNome("Imposto de Renda");
        imp1.setTaxa(0.10); //10%
        imp1.setMultaAtraso(350.75);
        em.persist(imp1);
        
        Imposto imp2 = new Imposto();
        imp2.setNome("Imposto sobre Operações Financeiras (IOF)");
        imp2.setTaxa(0.05); //5%
        imp2.setMultaAtraso(49.98);
        em.persist(imp2);
        
        //Corretagem
        Corretagem cr1 = new Corretagem();
        cr1.setTipo("Simples");
        cr1.setTaxaFixa(100);
        cr1.setTaxaVariavel(0);
        em.persist(cr1);
        
        Corretagem cr2 = new Corretagem();
        cr2.setTipo("Mista");
        cr2.setTaxaFixa(100);
        cr2.setTaxaVariavel(0.10); //10%
        em.persist(cr2);
        
        //Operações
        Operacao op1 = new Operacao();
        op1.setCodigo("0001");
        op1.setValor(10000.0);
        op1.setDataOperacao(new Date(new GregorianCalendar(2023, 7, 10).getTimeInMillis()));
        
        //Investindo em Alphabet (priv) através da corretora Rico(c1)
        op1.setInvestimento(b2);
        op1.getInvestimento().getAcoes().add(a2);
        op1.getInvestimento().getInstituicoes().add(priv);
        op1.setImposto(imp1);
        op1.setCorretagem(cr1);
        em.persist(op1);
        
        Operacao op2 = new Operacao();
        op2.setCodigo("0002");
        op2.setValor(20000.0);
        op2.setDataOperacao(new Date(new GregorianCalendar(2023, 7, 10).getTimeInMillis()));
        
        //Investindo em CDB BB (pub) através da corretora XP(c2)
        op2.setAplicacao(bb);
        op2.setImposto(imp2);
        op2.setCorretagem(cr2);
        em.persist(op2);
        
        //Câmbio        
        Cambio cambio = new Cambio();
        cambio.setCodigo("0003");
        cambio.setValor(5000.50);
        cambio.setDataOperacao(new Date(new GregorianCalendar(2023, 7, 20).getTimeInMillis()));
        
        cambio.setMoedaOrigem("Real");
        cambio.setMoedaTroca("Dólar");
        cambio.setCotacao(4.98);
        
        cambio.setImposto(imp2);
        cambio.setCorretagem(cr2);
        em.persist(cambio);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
