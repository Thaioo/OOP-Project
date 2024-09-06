package BaiTapCuoiKhoa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool.ManagedBlocker;

public class ComPaNy {
	private String tenCongTy;
	private int maSoThue;
	private double  doanhThu;
	private List <PerSon> quanLy;
	Scanner sc = new Scanner(System.in);
	public ComPaNy() {
		quanLy = new ArrayList<PerSon>();
	}
	
	public void nhapThongTin() {
		Scanner scaner= new Scanner (System.in);
		System.out.println("nhập tên công ty " );
		this.tenCongTy= scaner.nextLine();
		System.out.println("nhập mã số thuế ");
		this.maSoThue= scaner.nextInt();
		System.out.println("nhập doanh thu công ty");
		this.doanhThu= scaner.nextDouble();
	}
	
	

	public void themNguoiMoi(PerSon tmp) {
		if(this.timKiem(tmp.getMaSo()) != null) {
			System.out.println("Trùng nhân viên !!!");
			return;
		}
		this.quanLy.add(tmp);
	}
	
	public void xuatThongTin() {
		for (int i=0;i<this.quanLy.size();i++) {
			System.out.println("tên nhân viên là " + this.quanLy.get(i).getHoTen());
			System.out.println("mã số là " +this.quanLy.get(i).getMaSo());
			System.out.println("số điện thoại là " +this.quanLy.get(i).getSoDienThoai());
			System.out.println("số ngày làm việc là " + this.quanLy.get(i).getSoNgayLamViec());
			System.out.println("tiền lương là " + this.quanLy.get(i).TienLuongMotThang());
		}
	}
	
	public double xuatTongLuong() {
		double sumSaLaRy = 0;
		for (int i=0;i<this.quanLy.size();i++) {
			sumSaLaRy+=this.quanLy.get(i).TienLuongMotThang();
		}
		System.out.println("tổng lương của toàn công ty là " + sumSaLaRy);
		return sumSaLaRy;
	} 
	
	public void nhanVienCoLuongCaoNhat() {
		double max=0;
		String name=null;
		max= this.quanLy.get(0).TienLuongMotThang();
		for (int i=1;i<this.quanLy.size();i++) {
			if (this.quanLy.get(i).TienLuongMotThang()> max && this.quanLy.get(i) instanceof EmPloyees) {
				max=this.quanLy.get(i).TienLuongMotThang();
				name = this.quanLy.get(i).getHoTen();
			}
		}
		System.out.println("tên nhân viên có lương cao nhất là " + name + " lương " + max);
	}
	
	public void xepNhanVienTheoTen() {
		Collections.sort(quanLy,new Comparator<PerSon>() {
			@Override
			public int compare(PerSon o1, PerSon o2) {
				
				return o1.getHoTen().compareTo(o2.getHoTen());	
			}
		});
		for (PerSon nhanSu: quanLy) {
			System.out.println(nhanSu);
		}
	}
	
	public void xepNhanVienTheoLuong() {
		Collections.sort(quanLy,new Comparator<PerSon>() {
			@Override
			public int compare(PerSon o1, PerSon o2) {
				if (o1.TienLuongMotThang() != o2.TienLuongMotThang()) {
					if (o1.TienLuongMotThang()>o2.TienLuongMotThang()) return -1;
					else return 1;
				}
				else {
					return o1.getHoTen().compareTo(o2.getHoTen());
				}
			}
		});
		for (PerSon x: quanLy) {
			System.out.println(x);
		}
	}
	
	private PerSon timKiem(String maso) {
		for(int i=0;i<this.quanLy.size();++i) {
			if(this.quanLy.get(i).getMaSo().equals(maso)==true) {
				return this.quanLy.get(i);
			}
		}
		return null;
	}
	
	public void coPhanGiamDoc() {
		double max=0;
		String name=null;
		for (int i=0;i<this.quanLy.size();i++) {
			if (this.quanLy.get(i) instanceof DiRecTor && ((DiRecTor)this.quanLy.get(i)).getCoPhan() >max ) {
				name= this.quanLy.get(i).getHoTen();
				max= ((DiRecTor)this.quanLy.get(i)).getCoPhan();
			}
		}
		System.out.println("tên giám đốc có cổ phần cao nhất là " + name + " số cổ phần " + max);
		
	}
	
	public void dSNhanVien() {
		for (int i=0;i<this.quanLy.size();i++) {
			if (this.quanLy.get(i) instanceof EmPloyees && ((EmPloyees)this.quanLy.get(i)).getTruongPhong()==null) {
				System.out.println(" mã nhân viên " + this.quanLy.get(i).getMaSo());
				System.out.println(" tên nhân viên là " + this.quanLy.get(i).getHoTen());
			}
		}
	}
	
	public void dsTruongPhong() {
		for (PerSon truongPhong : quanLy ) {
			if (truongPhong  instanceof MaNaGer) {
				System.out.println("mã trưởng phòng là " + truongPhong.getMaSo());
				System.out.println("tên trưởng phòng là " + truongPhong.getHoTen());
			}
		}
	}
	public void dsnhanSu() {
		for (PerSon nhanSu : quanLy) {
			System.out.println("tên nhân sự là " + nhanSu.getHoTen());
			System.out.println("mã số nhân sự là " + nhanSu.getMaSo());
		}
	}
	public void phanBo() {
		dSNhanVien();
		System.out.print("Nhập mã nhân viên: ");
		String manv = sc.nextLine();
		PerSon ss = this.timKiem(manv);
		if(ss == null) {
			System.out.println("Không tìm thấy nhân viên nào");
			return;
		}
		if(ss instanceof EmPloyees == false) {
			System.out.println("Đây không phải là nhân viên");
			return;
		}
		if( ((EmPloyees) ss).getTruongPhong() != null ) {
			System.out.println("Nhân viên này đã có người quản lý");
			return;
		}
		
		dsTruongPhong();
		System.out.print("Nhập mã trưởng phòng: ");
		String manv1 = sc.nextLine();
		PerSon ss1 = this.timKiem(manv1);
		
		if(ss1 == null) {
			System.out.println("Không tìm thấy người nào");
			return;
		}
		if(ss1 instanceof MaNaGer == false) {
			System.out.println("Đây không phải là trưởng phòng");
			return;
		}
		((EmPloyees) ss).setTruongPhong(ss1.getMaSo());
		((MaNaGer) ss1).addNhanVien(((EmPloyees) ss));
		
				
	}
	
//	public void demNV() {
////		for (int i=0;i<this.quanLy.size();i++) {
////			String name=null;
////			int count=0;
////			if (this.quanLy.get(i) instanceof MaNaGer) {
////				name=this.quanLy.get(i).getHoTen();
////			}
////			for (int j=0;j< this.quanLy.size();j++) {
////				if (this.quanLy.get(j) instanceof EmPloyees && ((EmPloyees)this.quanLy.get(j)).getTruongPhong()!=null) {
////					if (((EmPloyees)this.quanLy.get(j)).getTruongPhong().equals(name)) {
////						count++;
////					}
////				}
////			}
////			if (this.quanLy.get(i)instanceof MaNaGer) {
////				((MaNaGer) this.quanLy.get(i)).setSoLuongNhanVien(count);
////			}
////		}
//	}
	
	public void truongPhongCoNhieuNV() {
		String name=null;
		int max=0;
		for (PerSon truongphong : quanLy) {
			if (truongphong instanceof MaNaGer) {
				if (((MaNaGer) truongphong).getSoLuongNhanVien()>max) {
					max= ((MaNaGer) truongphong).getSoLuongNhanVien();
					name= truongphong.getHoTen();
				}
			}
		}
		System.out.println("Trưởng phòng có số lượng nhân viên dưới quyền nhiều nhất là " + name + " số lượng nhân viên dưới quyền là " + max);
	}
	
	public void xoaNS() {
		dsnhanSu();
		System.out.println("mời nhập mã nhân sự cần xóa ");
		String manv= sc.nextLine();
		PerSon nhanSu= this.timKiem(manv);
		if (nhanSu ==null) {
			System.out.println("Không có mã nhân viên này");
			return;
		}
		if (nhanSu instanceof EmPloyees) {
			if( ((EmPloyees) nhanSu).getTruongPhong() == null){
				this.quanLy.remove(nhanSu);
			}
			else {
				for(int i=0;i<this.quanLy.size();i++) {
					if(this.quanLy.get(i).getMaSo().compareTo(((EmPloyees) nhanSu).getTruongPhong()) == 0) {
						((MaNaGer)this.quanLy.get(i)).delNhanVien((EmPloyees) nhanSu);
						break;
					}
				}
				
				this.quanLy.remove(nhanSu);

			}
		}
		else if (nhanSu instanceof MaNaGer) {
			for(int i=0;i<this.quanLy.size();i++) {
				if(this.quanLy.get(i) instanceof EmPloyees) {
					if(((EmPloyees) this.quanLy.get(i)).getTruongPhong()!=null && ((EmPloyees) this.quanLy.get(i)).getTruongPhong().compareTo(nhanSu.getHoTen()) == 0 ){
						((EmPloyees) this.quanLy.get(i)).setTruongPhong(null);
					}
				}
			}
			this.quanLy.remove(nhanSu);
		}

		
	}
	public double loiNhuanCongTy() {
		double loiNhuan= this.doanhThu - this.xuatTongLuong();
		return loiNhuan;
	}
	
	public void thuNhapGiamDoc() {
		for (PerSon giamDoc : quanLy) {
			if (giamDoc instanceof DiRecTor) {
				double thuNhap= ((DiRecTor)giamDoc).TienLuongMotThang()+((((DiRecTor)giamDoc).getCoPhan()/100)*this.loiNhuanCongTy());
				System.out.println("Tên Giám Đốc Là " + giamDoc.getHoTen() + "Thu Nhập Là " + thuNhap );
			}
		}
	}
}
