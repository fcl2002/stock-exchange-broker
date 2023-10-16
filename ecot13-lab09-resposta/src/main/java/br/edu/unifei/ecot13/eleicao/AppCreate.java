/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.ecot13.eleicao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppCreate {

    public static void main(String args[]) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("corretora");
        EntityManager em = emf.createEntityManager();
        
        em.close();
        emf.close();
    }
}
