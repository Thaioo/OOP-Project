package BaiTapCuoiKhoa;
import java.util.ArrayList;
import java.util.List;
public class MaNaGer extends PerSon {
	
	private List<EmPloyees> danhsachnv = new ArrayList<EmPloyees>();
	public MaNaGer(String hoten, String maso, double luong, int songaylamviec, long sodienthoai) {
		super(hoten,maso, luong, songaylamviec, sodienthoai);
	}	
	
	public int getSoLuongNhanVien() {
		return danhsachnv.size();
	}


	public void addNhanVien(EmPloyees tmp) {
		this.danhsachnv.add(tmp);
	}
	public void delNhanVien (EmPloyees tmp) {
		this.danhsachnv.remove(tmp);
	}
	@Override
	public double TienLuongMotThang() {
		return super.getLuong()*super.getSoNgayLamViec()+(100*this.getSoLuongNhanVien());
		
	}

	@Override
	public String toString() {
		return "MaNaGer [" + "getSoLuongNhanVien()=" + getSoLuongNhanVien()
				+ ", TienLuongMotThang()=" + TienLuongMotThang() + ", getMaSo()=" + getMaSo() + ", getHoTen()="
				+ getHoTen() + ", getLuong()=" + getLuong() + ", getSoNgayLamViec()=" + getSoNgayLamViec()
				+ ", getSoDienThoai()=" + getSoDienThoai() + "]";
	}
	

}
