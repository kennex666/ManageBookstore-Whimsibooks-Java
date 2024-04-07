package test;

import connectDB.ConnectDB;
import entities.SanPham;
import jakarta.persistence.EntityManager;

public class TestGetSanPham {
	public static void main(String[] args) {
		ConnectDB.getInstance().connect();
		
		EntityManager em = ConnectDB.getEntityManager();
		
		em.getTransaction().begin();
		em.createNamedQuery("SanPham.findAll", SanPham.class).getResultList().forEach(System.out::println);
		em.getTransaction().commit();
		
	}
}
