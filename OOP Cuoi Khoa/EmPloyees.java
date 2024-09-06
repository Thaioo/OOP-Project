package BaiTapCuoiKhoa;

public class EmPloyees extends PerSon {
	 private String TruongPhong;
	public EmPloyees(String hoten,String maso, double luong, int songaylamviec, long sodienthoai) {
		super(hoten, maso, luong, songaylamviec, sodienthoai);
	}

	public String getTruongPhong() {
		return this.TruongPhong;
	}

	public void setTruongPhong(String matruongphong) {
		this.TruongPhong = matruongphong;
	}

	@Override
	public double TienLuongMotThang() {
		return super.getLuong()*super.getSoNgayLamViec();
		
	}

	@Override
	public String toString() {
		return "EmPloyees [TruongPhong=" + TruongPhong + ", getMaSo()=" + getMaSo() + ", getHoTen()=" + getHoTen()
				+ ", getLuong()=" + getLuong() + ", getSoNgayLamViec()=" + getSoNgayLamViec() + ", getSoDienThoai()="
				+ getSoDienThoai() + "]";
	}
	
	
}
