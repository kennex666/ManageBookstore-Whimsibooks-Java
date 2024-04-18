/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import java.util.ArrayList;
import entities.DanhMuc;
import entities.TheLoai;
import entities.ThuongHieu;
import interfaces.ITheLoai;
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
public class TheLoai_DAO extends UnicastRemoteObject implements ITheLoai{
    private EntityManager em;
    public TheLoai_DAO() throws RemoteException{
        em = ConnectDB.getEntityManager();
    }

    @Override
    public List<TheLoai> getAllTheLoai()  throws RemoteException{
        List<TheLoai> list = new ArrayList<TheLoai>();
		try {
			list = em.createNamedQuery("TheLoai.findAll").getResultList();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		}
		
		return list;
    }

    @Override
    public List<TheLoai> getTheLoaiTheoID(int x) throws RemoteException{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addTheLoai(TheLoai x) throws RemoteException{
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
    public boolean editTheLoai(TheLoai x) throws RemoteException{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
