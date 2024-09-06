package BaiTapCuoiKhoa;

public class DiRecTor extends PerSon {
	private double coPhan;
	public DiRecTor(String hoten, String maso, double luong, int songaylamviec, long sodienthoai,double cophan){
		super(hoten, maso, luong, songaylamviec, sodienthoai);
		this.coPhan=cophan;
	}
	
	public double getCoPhan() {
		return coPhan;
	}

	public void setCoPhan(double coPhan) {
			this.coPhan = coPhan;
	}
	@Override
	public double TienLuongMotThang() {
		return super.getLuong()*super.getSoNgayLamViec();
	}
	
}
