/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import entities.TheLoai;
import interfaces.IChiTietHoaDon;
import interfaces.ITheLoai;
import ultilities.EnviromentConfigs;

import java.rmi.RemoteException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author ASUS
 */
public class TheLoai_BUS implements ITheLoai {
	private ITheLoai theLoai_DAO;

	public TheLoai_BUS() {
		try {
			Context ctx  = new InitialContext();
			theLoai_DAO = (ITheLoai) ctx.lookup("rmi://" + EnviromentConfigs.URL_RMI +"/theLoai");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<TheLoai> getAllTheLoai() {
		try {
			return theLoai_DAO.getAllTheLoai();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<TheLoai> getTheLoaiTheoID(int x) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public boolean addTheLoai(TheLoai x) {
		try {
			return theLoai_DAO.addTheLoai(x);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean editTheLoai(TheLoai x) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

}
