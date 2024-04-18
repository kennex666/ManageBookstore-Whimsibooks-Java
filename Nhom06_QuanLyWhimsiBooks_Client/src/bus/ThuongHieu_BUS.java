/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import entities.ThuongHieu;
import interfaces.IThuongHieu;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import ultilities.EnviromentConfigs;

import java.rmi.RemoteException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author ASUS
 */

public class ThuongHieu_BUS implements IThuongHieu {

	private IThuongHieu thuongHieu_DAO;

	@Override
	public List<ThuongHieu> getAllThuongHieu() {
		try {
			return thuongHieu_DAO.getAllThuongHieu();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<ThuongHieu> getThuongHieuTheoID(int x) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public boolean addThuongHieu(ThuongHieu x) {
		try {
			return thuongHieu_DAO.addThuongHieu(x);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean editThuongHieu(ThuongHieu x) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	public ThuongHieu_BUS() {
		super();
		// TODO Auto-generated constructor stub
		try {
			Context ctx  = new InitialContext();
			thuongHieu_DAO = (IThuongHieu) ctx.lookup("rmi://" + EnviromentConfigs.URL_RMI +"/thuongHieu");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
