package atest;

import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GenerateSQL {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Whimsibook-MSSQL-Production");
		EntityManager em = emf.createEntityManager();
	}
}
