/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import entities.NhaXuatBan;
import interfaces.IChiTietHoaDon;
import interfaces.INhaXuatBan;
import ultilities.EnviromentConfigs;

import java.rmi.RemoteException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author ASUS
 */
public class NhaXuatBan_BUS implements INhaXuatBan{
    private INhaXuatBan nhaXuatBan_DAO;
    
    @Override
    public List<NhaXuatBan> getAllNhaXuatBan() {
        try {
			return nhaXuatBan_DAO.getAllNhaXuatBan();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}
    }

    @Override
    public List<NhaXuatBan> getNhaXuatBanTheoID(String x) {
        try {
			return nhaXuatBan_DAO.getNhaXuatBanTheoID(x);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}
    }

    @Override
    public boolean addNhaXuatBan(NhaXuatBan x) {
       try {
		return nhaXuatBan_DAO.addNhaXuatBan(x);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false; 
	}
    }

    @Override
    public boolean editNhaXuatBan(NhaXuatBan x) {
        try {
			return nhaXuatBan_DAO.editNhaXuatBan(x);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		}
    }

	public NhaXuatBan_BUS() {
		super();
		try {
			Context ctx  = new InitialContext();
			nhaXuatBan_DAO = (INhaXuatBan) ctx.lookup("rmi://" + EnviromentConfigs.URL_RMI +"/nhaXuatBan");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    
    
}
