// Lớp Main để test toàn bộ hệ thống
import java.util.*;
import java.text.SimpleDateFormat;

public class Test {
    public static void main(String[] args) {
        QuanLyNhanVien qlnv = new QuanLyNhanVien();
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║     HỆ THỐNG QUẢN LÝ NHÂN VIÊN    ║");
        System.out.println("╚════════════════════════════════════════╝");

        do {
            hienThiMenuChinh();
            System.out.print(" Nhập lựa chọn: ");
            choice = sc.nextInt();
            sc.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    quanLyNhanVien(qlnv, sc);
                    break;
                case 2:
                    quanLyPhongBan(qlnv, sc);
                    break;
                case 3:
                    quanLyLuong(qlnv, sc);
                    break;
                case 4:
                    quanLyChamCong(qlnv, sc);
                    break;
                case 5:
                    thongKeBaoCao(qlnv);
                    break;
                case 6:
                    docGhiDuLieu(qlnv);
                    break;
                case 7:
                    testTinhNang(qlnv, sc);
                    break;
                case 0:
                    System.out.println("\n👋 Kết thúc chương trình! Cảm ơn bạn đã sử dụng!");
                    break;
                default:
                    System.out.println("❌ Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
        } while (choice != 0);

        sc.close();
    }

    public static void hienThiMenuChinh() {
        System.out.println("\n" + "═".repeat(50));
        System.out.println(" MENU CHÍNH");
        System.out.println("═".repeat(50));
        System.out.println("1.  QUẢN LÝ NHÂN VIÊN");
        System.out.println("2.  QUẢN LÝ PHÒNG BAN");
        System.out.println("3.  QUẢN LÝ LƯƠNG");
        System.out.println("4.  QUẢN LÝ CHẤM CÔNG");
        System.out.println("5.  THỐNG KÊ BÁO CÁO");
        System.out.println("6.  ĐỌC/GHI DỮ LIỆU");
        System.out.println("7.  TEST TÍNH NĂNG");
        System.out.println("0.  THOÁT");
        System.out.println("─".repeat(50));
    }

    public static void quanLyNhanVien(QuanLyNhanVien qlnv, Scanner sc) {
        int choice;
        do {
            System.out.println("\n" + "─".repeat(40));
            System.out.println(" QUẢN LÝ NHÂN VIÊN");
            System.out.println("─".repeat(40));
            System.out.println("1.  Thêm nhân viên mới");
            System.out.println("2.  Hiển thị danh sách");
            System.out.println("3.  Tìm kiếm nhân viên");
            System.out.println("4. ️ Sửa thông tin");
            System.out.println("5.  Xóa nhân viên");
            System.out.println("0.  Quay lại");
            System.out.print(" Chọn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    themNhanVienMoi(qlnv, sc);
                    break;
                case 2:
                    qlnv.xuat();
                    break;
                case 3:
                    timKiemNhanVien(qlnv, sc);
                    break;
                case 4:
                    suaThongTinNV(qlnv, sc);
                    break;
                case 5:
                    xoaNhanVien(qlnv, sc);
                    break;
            }
        } while (choice != 0);
    }

    public static void themNhanVienMoi(QuanLyNhanVien qlnv, Scanner sc) {
        try {
            System.out.print("Chọn loại NV (1-Biên chế, 2-Hợp đồng): ");
            int loai = Integer.parseInt(sc.nextLine());  // Dùng parseInt thay vì nextInt

            if (loai == 1) {
                NhanVienBC nv = new NhanVienBC();

                System.out.print("Nhập mã NV: ");
                nv.setMaNV(sc.nextLine());

                System.out.print("Nhập tên NV: ");
                nv.setTenNV(sc.nextLine());

                // Xử lý nhập số an toàn
                System.out.print("Nhập hệ số lương: ");
                while (true) {
                    try {
                        double heSo = Double.parseDouble(sc.nextLine());
                        nv.setHeSoLuong(heSo);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.print(" Hệ số lương phải là số! Nhập lại: ");
                    }
                }

                System.out.print("Nhập lương cơ bản: ");
                while (true) {
                    try {
                        double luongCB = Double.parseDouble(sc.nextLine());
                        nv.setLuongCoBan(luongCB);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.print(" Lương cơ bản phải là số! Nhập lại: ");
                    }
                }

                System.out.print("Nhập số ngày làm: ");
                while (true) {
                    try {
                        int soNgay = Integer.parseInt(sc.nextLine());
                        nv.setSoNgayLam(soNgay);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.print(" Số ngày làm phải là số nguyên! Nhập lại: ");
                    }
                }

                System.out.print("Nhập phòng ban: ");
                nv.setPhongBan(sc.nextLine());

                qlnv.themNhanVien(nv);
                System.out.println(" Thêm nhân viên biên chế thành công!");

            } else if (loai == 2) {
                NhanVienHD nv = new NhanVienHD();

                System.out.print("Nhập mã NV: ");
                nv.setMaNV(sc.nextLine());

                System.out.print("Nhập tên NV: ");
                nv.setTenNV(sc.nextLine());

                // Xử lý nhập số cho hợp đồng
                System.out.print("Nhập lương theo giờ: ");
                while (true) {
                    try {
                        double luongGio = Double.parseDouble(sc.nextLine());
                        nv.setLuongTheoGio(luongGio);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.print(" Lương theo giờ phải là số! Nhập lại: ");
                    }
                }

                System.out.print("Nhập số giờ làm: ");
                while (true) {
                    try {
                        int soGio = Integer.parseInt(sc.nextLine());
                        nv.setSoGioLam(soGio);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.print(" Số giờ làm phải là số nguyên! Nhập lại: ");
                    }
                }

                System.out.print("Nhập phụ cấp hợp đồng: ");
                while (true) {
                    try {
                        double phuCap = Double.parseDouble(sc.nextLine());
                        nv.setPhuCapHopDong(phuCap);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.print(" Phụ cấp phải là số! Nhập lại: ");
                    }
                }

                System.out.print("Nhập phòng ban: ");
                nv.setPhongBan(sc.nextLine());

                qlnv.themNhanVien(nv);
                System.out.println(" Thêm nhân viên hợp đồng thành công!");
            }

        } catch (Exception e) {
            System.out.println(" Lỗi khi thêm nhân viên: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void timKiemNhanVien(QuanLyNhanVien qlnv, Scanner sc) {
        System.out.print("Nhập mã NV cần tìm: ");
        String maNV = sc.nextLine();

        NhanVien nv = qlnv.timNV(maNV);
        if (nv != null) {
            System.out.println(" Tìm thấy nhân viên:");
            nv.xuat();
        } else {
            System.out.println(" Không tìm thấy nhân viên với mã: " + maNV);
        }
    }

    public static void suaThongTinNV(QuanLyNhanVien qlnv, Scanner sc) {
        System.out.print("Nhập mã NV cần sửa: ");
        String maNV = sc.nextLine();

        NhanVien nv = qlnv.timNV(maNV);
        if (nv != null) {
            System.out.print("Nhập tên mới: ");
            String tenMoi = sc.nextLine();
            nv.setTenNV(tenMoi);
            qlnv.suaNhanVien(maNV, nv);
            System.out.println(" Cập nhật thông tin thành công!");
        } else {
            System.out.println(" Không tìm thấy nhân viên!");
        }
    }

    public static void xoaNhanVien(QuanLyNhanVien qlnv, Scanner sc) {
        System.out.print("Nhập mã NV cần xóa: ");
        String maNV = sc.nextLine();

        NhanVien nv = qlnv.timNV(maNV);
        if (nv != null) {
            System.out.print("Bạn có chắc muốn xóa " + nv.getTenNV() + "? (y/n): ");
            String confirm = sc.nextLine();
            if (confirm.equalsIgnoreCase("y")) {
                qlnv.xoaNV(maNV);
            }
        } else {
            System.out.println(" Không tìm thấy nhân viên!");
        }
    }

    public static void quanLyPhongBan(QuanLyNhanVien qlnv, Scanner sc) {
        System.out.println("\n DANH SÁCH PHÒNG BAN:");
        for (PhongBan pb : qlnv.getDanhSachPhongBan()) {
            System.out.println("- " + pb.getTenPB() + " (" + pb.getSoNhanVien() + " NV)");
        }
    }

    public static void quanLyLuong(QuanLyNhanVien qlnv, Scanner sc) {
        System.out.println("\n BẢNG LƯƠNG NHÂN VIÊN");
        System.out.println("═".repeat(40));

        if (qlnv.getDanhSachNV().isEmpty()) {
            System.out.println(" Chưa có nhân viên nào!");
            return;
        }

        double tongLuong = 0;
        int stt = 1;
        for (NhanVien nv : qlnv.getDanhSachNV().values()) {
            System.out.println("\n[" + stt++ + "] " + nv.getMaNV() + " - " + nv.getTenNV());
            System.out.println("   Lương thực lĩnh: " + String.format("%,.0f VND", nv.tinhThucLinh()));
            System.out.println("   Phụ cấp: " + String.format("%,.0f VND", nv.tinhPhuCap()));
            tongLuong += nv.tinhThucLinh();
        }

        System.out.println("\n" + "─".repeat(40));
        System.out.println("TỔNG QUỸ LƯƠNG: " + String.format("%,.0f VND", tongLuong));
    }

    public static void quanLyChamCong(QuanLyNhanVien qlnv, Scanner sc) {
        System.out.println("\n THÊM CHẤM CÔNG");
        System.out.print("Nhập mã NV: ");
        String maNV = sc.nextLine();

        NhanVien nv = qlnv.timNV(maNV);
        if (nv == null) {
            System.out.println(" Không tìm thấy nhân viên!");
            return;
        }

        ChamCong cc = new ChamCong();
        cc.setMaChamCong("CC" + System.currentTimeMillis());
        cc.setMaNV(maNV);
        cc.setNgay(new Date());
        System.out.print("Nhập số giờ làm: ");
        cc.setSoGioLam(sc.nextInt());
        System.out.print("Nhập số giờ tăng ca: ");
        cc.setSoGioTangCa(sc.nextInt());
        sc.nextLine();

        qlnv.themChamCong(cc);
        System.out.println(" Đã thêm chấm công!");
        cc.hienThiThongTin();
    }

    public static void thongKeBaoCao(QuanLyNhanVien qlnv) {
        qlnv.thongKe();

        // Hiển thị bảng hệ số lương
        BangLuong.hienThiBangHeSoLuong();
    }

    public static void docGhiDuLieu(QuanLyNhanVien qlnv) {
        int choice;
        Scanner sc = new Scanner(System.in);

        System.out.println("\n QUẢN LÝ DỮ LIỆU");
        System.out.println("1.  Đọc dữ liệu từ file");
        System.out.println("2.  Ghi dữ liệu ra file");
        System.out.println("0.  Quay lại");
        System.out.print(" Chọn: ");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                qlnv.readData();
                break;
            case 2:
                qlnv.writeData();
                break;
        }
    }

    public static void testTinhNang(QuanLyNhanVien qlnv, Scanner sc) {
        System.out.println("\n KIỂM TRA TÍNH NĂNG HỆ THỐNG");
        System.out.println("═".repeat(40));

        // Test 1: Thêm dữ liệu mẫu
        System.out.println("\n1.  THÊM DỮ LIỆU MẪU");

        // Thêm NV biên chế mẫu
        NhanVienBC nv1 = new NhanVienBC();
        nv1.setMaNV("NVBC001");
        nv1.setTenNV("Nguyễn Văn An");
        nv1.setHeSoLuong(2.5);
        nv1.setLuongCoBan(4500000);
        nv1.setSoNgayLam(22);
        nv1.setPhongBan("Phòng Kế Toán");
        qlnv.themNhanVien(nv1);
        System.out.println("    Thêm NV biên chế: " + nv1.getTenNV());

        // Thêm NV hợp đồng mẫu
        NhanVienHD nv2 = new NhanVienHD();
        nv2.setMaNV("NVHD001");
        nv2.setTenNV("Trần Thị Bình");
        nv2.setLuongTheoGio(50000);
        nv2.setSoGioLam(160);
        nv2.setPhuCapHopDong(1000000);
        nv2.setPhongBan("Phòng Kinh Doanh");
        qlnv.themNhanVien(nv2);
        System.out.println("    Thêm NV hợp đồng: " + nv2.getTenNV());

        // Test 2: Tính lương
        System.out.println("\n2.  TÍNH LƯƠNG MẪU");
        System.out.println("   - " + nv1.getTenNV() + ": " +
                String.format("%,.0f VND", nv1.tinhThucLinh()));
        System.out.println("   - " + nv2.getTenNV() + ": " +
                String.format("%,.0f VND", nv2.tinhThucLinh()));

        // Test 3: Tổng quỹ lương
        System.out.println("\n3.  TỔNG QUỸ LƯƠNG");
        System.out.println("   Tổng: " +
                String.format("%,.0f VND", qlnv.tinhTongQuyLuong()));

        // Test 4: Bảng lương mẫu
        System.out.println("\n4.  BẢNG LƯƠNG MẪU");
        BangLuong bl = new BangLuong("BL001", 3, 4500000, 0.2);
        bl.hienThiThongTin();

        System.out.println("\n KIỂM TRA HOÀN TẤT!");

        // Hiển thị menu tiếp tục
        System.out.print("\nNhấn Enter để tiếp tục...");
        sc.nextLine();
    }
}
