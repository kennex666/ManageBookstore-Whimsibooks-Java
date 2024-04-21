/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import java.util.ArrayList;
import entities.DanhMuc;
import entities.NhaXuatBan;
import interfaces.INhaXuatBan;
import jakarta.persistence.EntityManager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class NhaXuatBan_DAO extends UnicastRemoteObject implements INhaXuatBan {
	private EntityManager em;

	public NhaXuatBan_DAO() throws RemoteException {
		em = ConnectDB.getEntityManager();
	}

	@Override
	public List<NhaXuatBan> getAllNhaXuatBan() throws RemoteException {
		List<NhaXuatBan> list = new ArrayList<NhaXuatBan>();

		try {
			list = em.createNamedQuery("NhaXuatBan.findAll").getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			return list;
		}

		return list;
	}

	@Override
	public List<NhaXuatBan> getNhaXuatBanTheoID(String x) throws RemoteException {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public boolean addNhaXuatBan(NhaXuatBan x) throws RemoteException {
		boolean isThisSession = em.getTransaction().isActive();
		try {
			if (isThisSession == false)
				em.getTransaction().begin();
			em.persist(x);
			if (isThisSession == false)
				em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editNhaXuatBan(NhaXuatBan x) throws RemoteException {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

}
