package br.edu.utfpr.util.filter.entityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManagerFactory {
    private static EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("prova");

    public static EntityManagerFactory getManagerFactory() {
        return managerFactory;
    }
}
