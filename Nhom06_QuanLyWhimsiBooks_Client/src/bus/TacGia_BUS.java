/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;
import entities.TacGia;
import interfaces.IChiTietHoaDon;
import interfaces.ITacGia;
import ultilities.EnviromentConfigs;

import java.rmi.RemoteException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author ASUS
 */
public class TacGia_BUS implements ITacGia {
	private ITacGia tacGia_DAO;

	@Override
	public String toString() {
		return super.toString(); // Generated from
									// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
	}

	@Override
	public List<TacGia> getAllTacGia() {
		try {
			return tacGia_DAO.getAllTacGia();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<TacGia> getTacGiaTheoID(int x) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public boolean addTacGia(TacGia x) {
		try {
			return tacGia_DAO.addTacGia(x);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean editTacGia(TacGia x) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	public TacGia_BUS() {
		super();
		// TODO Auto-generated constructor stub
		try {
			Context ctx  = new InitialContext();
			tacGia_DAO = (ITacGia) ctx.lookup("rmi://" + EnviromentConfigs.URL_RMI +"/tacGia");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
