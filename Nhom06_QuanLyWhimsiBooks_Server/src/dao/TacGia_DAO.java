/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import java.util.ArrayList;
import entities.DanhMuc;
import entities.TacGia;
import entities.ThuongHieu;
import interfaces.ITacGia;
import interfaces.IThuongHieu;
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
public class TacGia_DAO extends UnicastRemoteObject implements  ITacGia{

    private EntityManager em;
   
    public TacGia_DAO() throws RemoteException{
        em = ConnectDB.getEntityManager();
    }

    @Override
    public List<TacGia> getAllTacGia() throws RemoteException{
       List<TacGia> list = new ArrayList<TacGia>();
		try {
			
			list = em.createNamedQuery("TacGia.findAll").getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		}
		
		return list;
    }

    @Override
    public List<TacGia> getTacGiaTheoID(int x) throws RemoteException{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addTacGia(TacGia x) throws RemoteException{
        try {
        	em.getTransaction().begin();
            em.persist(x);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean editTacGia(TacGia x) throws RemoteException{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
