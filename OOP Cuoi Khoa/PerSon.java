package BaiTapCuoiKhoa;

public abstract class PerSon implements  ChucNangQuanLy {
	private String maSo;
	private String hoTen;
	private double luongCoBan;
	private int soNgayLamViec;
	private long SoDienThoai;
	public PerSon(String hoten,String maso,double luong,int songaylamviec,long sodienthoai) {
		this.hoTen=hoten;
		this.maSo=maso;
		this.luongCoBan=luong;
		this.soNgayLamViec=songaylamviec;
		this.SoDienThoai=sodienthoai;
	}
	public String getMaSo() {
		return maSo;
	}
	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public double getLuong() {
		return luongCoBan;
	}
	public void setLuong(double luong) {
		this.luongCoBan = luong;
	}
	public int getSoNgayLamViec() {
		return soNgayLamViec;
	}
	public void setSoNgayLamViec(int soNgayLamViec) {
		this.soNgayLamViec = soNgayLamViec;
	}
	public long getSoDienThoai() {
		return SoDienThoai;
	}
	public void setSoDienThoai(long soDienThoai) {
		SoDienThoai = soDienThoai;
	}
	@Override
	public String toString() {
		return "mã số " + maSo + ",họ tên " + hoTen + ",lương cơ bản " + luongCoBan + ", số ngày làm việc "
				+ soNgayLamViec + ", số điện thoại " + SoDienThoai + ", lương " + String.format("%.02f", this.TienLuongMotThang()) + "]";
	}
	
	
}

