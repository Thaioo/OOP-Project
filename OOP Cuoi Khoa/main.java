package BaiTapCuoiKhoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import BaiTapBuoi11.QuanLy;

public class Driver {
public static void main(String[] args) {
	Scanner scaner=new Scanner (System.in);
	ComPaNy quanly= new ComPaNy();
	int option=-1;
	while (true) {
		System.out.println("----------- MENU QUẢN LÝ NHÂN SỰ -----------");
		System.out.println("1.Nhập Thông Tin Công Ty");
		System.out.println("2.Phân Bổ Nhân Viên Vào Trưởng Phòng ");
		System.out.println("3.Thêm Thông Tin Nhân Sự ");
		System.out.println("4.Xóa Thông Tin Nhân Sự");
		System.out.println("5.Xuất Thông Tin Toàn Bộ Người Trong Công Ty ");
		System.out.println("6.Xuất Tổng Lương Cho Toàn Công Ty ");
		System.out.println("7.Nhân Viên Thường Có Lương Cao Nhất ");
		System.out.println("8.Trưởng Phòng Có Số Lượng Nhân Viên Dưới Quyền Nhiều Nhất");
		System.out.println("9.Sắp Xếp Nhân Sự Theo Tên");
		System.out.println("10.Sắp Xếp Nhân Sự Theo Lương Giảm Dần ");
		System.out.println("11.Giám Đốc Có Số Lượng Cổ Phần Nhiều Nhất ");
		System.out.println("12.Xuất Tổng Thu Nhập Của Giám Đốc ");
		System.out.println("Mời Nhập Lựa Chọn ");
		option= scaner.nextInt();
		if (option==1) {
			quanly.nhapThongTin();
		}
		else if (option==2) {
			quanly.phanBo();
		}
		else if (option==3) {
			scaner.nextLine();
			System.out.println("nhập tên nhân sự ");
			String hoTen= scaner.nextLine();
			scaner.nextLine();
			System.out.println("nhập mã số nhân của sự ");
			String maso= scaner.nextLine();
			System.out.println("nhập lương 1 ngày ");
			double luong=scaner.nextDouble();
			System.out.println("nhập số ngày làm việc ");
			int ngay= scaner.nextInt();
			System.out.println("nhập số điện thoại của nhân sự ");
			long phone=scaner.nextLong();
			System.out.println("mời bạn nhập vị trí của nhân sự");
			System.out.println("1.Nhân Viên");
			System.out.println("2.Trưởng Phòng");
			System.out.println("3.Giám Đốc");
			int chon= scaner.nextInt();
			switch (chon) {
			case 1:
				EmPloyees nhanvien= new EmPloyees(hoTen, maso, luong, ngay, phone);
				quanly.themNguoiMoi(nhanvien);
				break;
			case 2:
				MaNaGer truongphong= new MaNaGer(hoTen, maso, luong, ngay, phone);
				quanly.themNguoiMoi(truongphong);
				break;
			case 3:
				double cophan=100;
				while(cophan>=100||cophan<0){
					System.out.println("mời bạn nhập số cổ phần của giám đốc ");
					cophan=scaner.nextDouble();
					if (cophan>=100 || cophan<0) {
						System.out.println("bạn nhập sai mời nhập lại");
					}
				};
				DiRecTor giamdoc= new DiRecTor(hoTen, maso, luong, ngay, phone, cophan);
				quanly.themNguoiMoi(giamdoc);
				break;
			default:
				break;
			}
		}
		else if (option==4) {
			quanly.xoaNS();
		}
		else if (option==5) {
			quanly.xuatThongTin();
		}
		else if (option==6) {
			quanly.xuatTongLuong();
		}
		else if (option==7) {
			quanly.nhanVienCoLuongCaoNhat();
		}
		else if (option==8) {
			quanly.truongPhongCoNhieuNV();
		}
		else if (option==9) {
			quanly.xepNhanVienTheoTen();
		}
		else if (option==10) {
			quanly.xepNhanVienTheoLuong();
		}
		else if (option==11) {
			quanly.coPhanGiamDoc();
		}
		else if (option==12) {
			quanly.thuNhapGiamDoc();
		}
	}
}
}