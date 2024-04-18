package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name = "NhanVien.getAllEmployees", query = "select nv from NhanVien nv"),
	@NamedQuery(name = "NhanVien.chuyenChucVuNhanVienCu", query = "update NhanVien set chucVu = :chucVuMoi where chucVu = :chucVuCu")
})
public class NhanVien implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String nhanVienID;
	private String userName;
	private String password;
	private LocalDate ngayTaoTK;
	private String hoTen;
	private String gioiTinh;
	private String soDienThoai;
	private String chucVu;
	private String email;
	private LocalDate ngaySinh;
	private String diaChi;
	
	@OneToMany(mappedBy = "nhanVien")
	private List<HoaDon> hoaDons;
	
	@OneToMany(mappedBy = "nhanVien")
	private List<HoaDonTra> hoaDonTras;
	
	public List<HoaDon> getHoaDons() {
		return hoaDons;
	}

	public void setHoaDons(List<HoaDon> hoaDons) {
		this.hoaDons = hoaDons;
	}

	public List<HoaDonTra> getHoaDonTras() {
		return hoaDonTras;
	}

	public void setHoaDonTras(List<HoaDonTra> hoaDonTras) {
		this.hoaDonTras = hoaDonTras;
	}

	public NhanVien() {

	}

	public NhanVien( String nhanVienID ) {
		this.nhanVienID=nhanVienID;
	}

	public String getNhanVienID() {
		return nhanVienID;
	}

	public void setNhanVienID(String nhanVienID) {
            if(nhanVienID==null || nhanVienID.trim().isEmpty())
                nhanVienID = "NV0001";
            this.nhanVienID = nhanVienID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getNgayTaoTK() {
		return ngayTaoTK;
	}

	public void setNgayTaoTK(LocalDate ngayTaoTK) {
		this.ngayTaoTK = ngayTaoTK;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) throws Exception {
		if (hoTen.trim() == "" || hoTen.isBlank() || hoTen.isEmpty())
			throw new Exception("Tên khách hàng là trường bắt buộc!");
		this.hoTen = hoTen;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) throws Exception {
		if (soDienThoai.trim()== "" || soDienThoai.isBlank() || soDienThoai.isEmpty())
			throw new Exception("Số điện thoại là một trường bắt buộc!");
		this.soDienThoai = soDienThoai;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		
		this.email = email;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) throws Exception {
		
		if (diaChi.trim() == "" || diaChi.isBlank() || diaChi.isEmpty())
			throw new Exception("Địa chỉ là một trường bắt buộc!");
		
		this.diaChi = diaChi;
	}


	public NhanVien(String nhanVienID, String userName, String password, LocalDate ngayTaoTK, String hoTen, String gioiTinh,
			String soDienThoai, String chucVu, String email, LocalDate ngaySinh, String diaChi) throws Exception {
		setNhanVienID(nhanVienID);
		setUserName(userName);
		setPassword(password);
		setNgayTaoTK(ngayTaoTK);
		setHoTen(hoTen);
		setGioiTinh(gioiTinh);
		setSoDienThoai(soDienThoai);
		setChucVu(chucVu);
		setEmail(email);
		setNgaySinh(ngaySinh);
		setDiaChi(diaChi);
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(nhanVienID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(nhanVienID, other.nhanVienID);
	}

	@Override
	public String toString() {
		return "NhanVien [nhanVienID=" + nhanVienID + ", userName=" + userName + ", password=" + password
				+ ", ngayTaoTK=" + ngayTaoTK + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", soDienThoai="
				+ soDienThoai + ", chucVu=" + chucVu + ", email=" + email + ", ngaySinh=" + ngaySinh + ", diaChi="
				+ diaChi + ", hoaDons=" + hoaDons + ", hoaDonTras=" + hoaDonTras + "]";
	}
	
}
