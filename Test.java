import java.util.*;
import java.text.SimpleDateFormat;

public class Test {
    public static void main(String[] args) {
        QuanLyNhanVien qlnv = new QuanLyNhanVien();
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║      🎯 HỆ THỐNG QUẢN LÝ NHÂN VIÊN HOÀN CHỈNH    ║");
        System.out.println("╚══════════════════════════════════════════════════╝");

        do {
            hienThiMenuChinh();
            System.out.print("👉 Nhập lựa chọn (0-4): ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Vui lòng nhập số!");
                choice = -1;
                continue;
            }

            switch (choice) {
                case 1:
                    quanLyNhanVien(qlnv, sc);
                    break;
                case 2:
                    quanLyPhongBan(qlnv, sc);
                    break;
                case 3:
                    quanLyLuong(qlnv);
                    break;
                case 4:
                    quanLyChamCong(qlnv, sc);
                    break;
                case 0:
                    System.out.println("\n👋 Kết thúc chương trình! Cảm ơn bạn đã sử dụng!");
                    break;
                default:
                    System.out.println("❌ Lựa chọn không hợp lệ! Vui lòng chọn 0-4.");
            }
        } while (choice != 0);

        sc.close();
    }

    // ==================== MENU CHÍNH ====================
    public static void hienThiMenuChinh() {
        System.out.println("\n" + "═".repeat(55));
        System.out.println("📋 MENU CHỨC NĂNG CHÍNH");
        System.out.println("═".repeat(55));
        System.out.println("1. 👥 QUẢN LÝ NHÂN VIÊN");
        System.out.println("2. 🏢 QUẢN LÝ PHÒNG BAN");
        System.out.println("3. 💰 QUẢN LÝ LƯƠNG");
        System.out.println("4. ⏰ QUẢN LÝ CHẤM CÔNG");
        System.out.println("0. 🚪 THOÁT CHƯƠNG TRÌNH");
        System.out.println("─".repeat(55));
    }

    // ==================== QUẢN LÝ NHÂN VIÊN ====================
    public static void quanLyNhanVien(QuanLyNhanVien qlnv, Scanner sc) {
        int choice;
        do {
            System.out.println("\n" + "─".repeat(50));
            System.out.println("👥 QUẢN LÝ NHÂN VIÊN");
            System.out.println("─".repeat(50));
            System.out.println("1. ➕ Thêm nhân viên mới");
            System.out.println("2. 👁️ Hiển thị danh sách");
            System.out.println("3. 🔍 Tìm kiếm nhân viên");
            System.out.println("4. ✏️ Sửa thông tin");
            System.out.println("5. 🗑️ Xóa nhân viên");
            System.out.println("6. 🔄 Chuyển phòng ban");
            System.out.println("0. ↩️ Quay lại menu chính");
            System.out.print("👉 Chọn chức năng: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Vui lòng nhập số!");
                choice = -1;
                continue;
            }

            switch (choice) {
                case 1:
                    themNhanVienMoi(qlnv, sc);
                    break;
                case 2:
                    hienThiDanhSachNV(qlnv);
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
                case 6:
                    chuyenPhongBan(qlnv, sc);
                    break;
                case 0:
                    System.out.println("↩️ Quay lại menu chính...");
                    break;
                default:
                    System.out.println("❌ Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    // ==================== THÊM NHÂN VIÊN MỚI ====================
    public static void themNhanVienMoi(QuanLyNhanVien qlnv, Scanner sc) {
        try {
            System.out.println("\n➕ THÊM NHÂN VIÊN MỚI");
            System.out.println("─".repeat(40));

            System.out.print("Chọn loại NV (1-Biên chế, 2-Hợp đồng): ");
            int loai = Integer.parseInt(sc.nextLine());

            if (loai != 1 && loai != 2) {
                System.out.println("❌ Loại nhân viên không hợp lệ!");
                return;
            }

            System.out.print("Nhập mã NV: ");
            String maNV = sc.nextLine();

            if (qlnv.timNV(maNV) != null) {
                System.out.println("❌ Mã NV đã tồn tại!");
                return;
            }

            System.out.print("Nhập tên NV: ");
            String tenNV = sc.nextLine();

            ArrayList<PhongBan> dsPhongBan = qlnv.getDanhSachPhongBan();
            if (dsPhongBan.isEmpty()) {
                System.out.println("❌ Chưa có phòng ban nào!");
                return;
            }

            System.out.println("\n📋 CHỌN PHÒNG BAN:");
            for (int i = 0; i < dsPhongBan.size(); i++) {
                System.out.println((i+1) + ". " + dsPhongBan.get(i).getTenPB());
            }

            System.out.print("👉 Chọn phòng ban (số thứ tự): ");
            int chonPhong = Integer.parseInt(sc.nextLine());

            if (chonPhong < 1 || chonPhong > dsPhongBan.size()) {
                System.out.println("❌ Lựa chọn không hợp lệ!");
                return;
            }

            PhongBan pb = dsPhongBan.get(chonPhong - 1);
            String tenPhongBan = pb.getTenPB();

            NhanVien nv;

            if (loai == 1) {
                NhanVienBC nvBC = new NhanVienBC();
                nvBC.setMaNV(maNV);
                nvBC.setTenNV(tenNV);
                nvBC.setPhongBan(tenPhongBan);

                System.out.print("Nhập hệ số lương: ");
                nvBC.setHeSoLuong(Double.parseDouble(sc.nextLine()));

                System.out.print("Nhập lương cơ bản: ");
                nvBC.setLuongCoBan(Double.parseDouble(sc.nextLine()));

                System.out.print("Nhập số ngày làm: ");
                nvBC.setSoNgayLam(Integer.parseInt(sc.nextLine()));

                nv = nvBC;

            } else {
                NhanVienHD nvHD = new NhanVienHD();
                nvHD.setMaNV(maNV);
                nvHD.setTenNV(tenNV);
                nvHD.setPhongBan(tenPhongBan);

                System.out.print("Nhập lương theo giờ: ");
                nvHD.setLuongTheoGio(Double.parseDouble(sc.nextLine()));

                System.out.print("Nhập số giờ làm: ");
                nvHD.setSoGioLam(Integer.parseInt(sc.nextLine()));

                System.out.print("Nhập phụ cấp hợp đồng: ");
                nvHD.setPhuCapHopDong(Double.parseDouble(sc.nextLine()));

                nv = nvHD;
            }

            qlnv.themNhanVien(nv);
            pb.themNhanVien(nv);

            System.out.println("\n✅ THÊM NHÂN VIÊN THÀNH CÔNG!");
            System.out.println("   📝 Mã: " + maNV);
            System.out.println("   👤 Tên: " + tenNV);
            System.out.println("   🏢 Phòng: " + tenPhongBan);

        } catch (NumberFormatException e) {
            System.out.println("❌ Lỗi: Giá trị nhập phải là số!");
        } catch (Exception e) {
            System.out.println("❌ Lỗi khi thêm nhân viên: " + e.getMessage());
        }
    }

    // ==================== HIỂN THỊ DANH SÁCH NHÂN VIÊN ====================
    public static void hienThiDanhSachNV(QuanLyNhanVien qlnv) {
        System.out.println("\n👥 DANH SÁCH NHÂN VIÊN TOÀN CÔNG TY");
        System.out.println("═".repeat(60));

        if (qlnv.getDanhSachNV().isEmpty()) {
            System.out.println("📭 Chưa có nhân viên nào!");
            return;
        }

        int stt = 1;
        for (NhanVien nv : qlnv.getDanhSachNV().values()) {
            System.out.println("\n[" + stt++ + "] " + nv.getMaNV() + " - " + nv.getTenNV());
            System.out.println("   🏢 Phòng: " + nv.getPhongBan());
            System.out.println("   📋 Loại: " + (nv instanceof NhanVienBC ? "Biên chế" : "Hợp đồng"));
            System.out.println("   💰 Lương thực lĩnh: " + String.format("%,.0f VND", nv.tinhThucLinh()));
        }

        System.out.println("\n📊 TỔNG SỐ: " + qlnv.getDanhSachNV().size() + " nhân viên");
    }

    // ==================== TÌM KIẾM NHÂN VIÊN ====================
    public static void timKiemNhanVien(QuanLyNhanVien qlnv, Scanner sc) {
        System.out.println("\n🔍 TÌM KIẾM NHÂN VIÊN");
        System.out.print("Nhập mã NV cần tìm: ");
        String maNV = sc.nextLine();

        NhanVien nv = qlnv.timNV(maNV);
        if (nv != null) {
            System.out.println("\n✅ TÌM THẤY NHÂN VIÊN:");
            System.out.println("─".repeat(40));
            nv.xuat();
        } else {
            System.out.println("❌ Không tìm thấy nhân viên với mã: " + maNV);
        }
    }

    // ==================== SỬA THÔNG TIN NHÂN VIÊN ====================
    public static void suaThongTinNV(QuanLyNhanVien qlnv, Scanner sc) {
        System.out.println("\n✏️ SỬA THÔNG TIN NHÂN VIÊN");
        System.out.print("Nhập mã NV cần sửa: ");
        String maNV = sc.nextLine();

        NhanVien nv = qlnv.timNV(maNV);
        if (nv == null) {
            System.out.println("❌ Không tìm thấy nhân viên!");
            return;
        }

        System.out.println("\n📝 THÔNG TIN HIỆN TẠI:");
        nv.xuat();

        System.out.println("\n✏️ NHẬP THÔNG TIN MỚI:");
        System.out.print("Tên mới (Enter để giữ nguyên): ");
        String tenMoi = sc.nextLine();
        if (!tenMoi.isEmpty()) {
            nv.setTenNV(tenMoi);
        }

        System.out.print("Số điện thoại mới (Enter để giữ nguyên): ");
        String sdtMoi = sc.nextLine();
        if (!sdtMoi.isEmpty()) {
            nv.setSoDienThoai(sdtMoi);
        }

        qlnv.suaNhanVien(maNV, nv);
        System.out.println("\n✅ CẬP NHẬT THÔNG TIN THÀNH CÔNG!");
    }

    // ==================== XÓA NHÂN VIÊN ====================
    public static void xoaNhanVien(QuanLyNhanVien qlnv, Scanner sc) {
        System.out.println("\n🗑️ XÓA NHÂN VIÊN");
        System.out.print("Nhập mã NV cần xóa: ");
        String maNV = sc.nextLine();

        NhanVien nv = qlnv.timNV(maNV);
        if (nv == null) {
            System.out.println("❌ Không tìm thấy nhân viên!");
            return;
        }

        System.out.println("\n⚠️ THÔNG TIN NHÂN VIÊN SẼ XÓA:");
        System.out.println("   Mã: " + nv.getMaNV());
        System.out.println("   Tên: " + nv.getTenNV());
        System.out.println("   Phòng: " + nv.getPhongBan());

        System.out.print("\n❓ Bạn có chắc chắn muốn xóa? (y/n): ");
        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("y")) {
            qlnv.xoaNV(maNV);

            String phongHienTai = nv.getPhongBan();
            for (PhongBan pb : qlnv.getDanhSachPhongBan()) {
                if (pb.getTenPB().equals(phongHienTai)) {
                    pb.xoaNhanVien(maNV);
                    break;
                }
            }

            System.out.println("✅ ĐÃ XÓA NHÂN VIÊN THÀNH CÔNG!");
        } else {
            System.out.println("↩️ Hủy thao tác xóa.");
        }
    }

    // ==================== CHUYỂN PHÒNG BAN ====================
    public static void chuyenPhongBan(QuanLyNhanVien qlnv, Scanner sc) {
        System.out.println("\n🔄 CHUYỂN PHÒNG BAN CHO NHÂN VIÊN");
        System.out.print("Nhập mã NV cần chuyển: ");
        String maNV = sc.nextLine();

        NhanVien nv = qlnv.timNV(maNV);
        if (nv == null) {
            System.out.println("❌ Không tìm thấy nhân viên!");
            return;
        }

        System.out.println("Phòng hiện tại: " + nv.getPhongBan());

        ArrayList<PhongBan> dsPhongBan = qlnv.getDanhSachPhongBan();
        System.out.println("\n📋 DANH SÁCH PHÒNG BAN:");
        for (int i = 0; i < dsPhongBan.size(); i++) {
            System.out.println((i+1) + ". " + dsPhongBan.get(i).getTenPB());
        }

        System.out.print("👉 Chọn phòng mới: ");
        int chon = Integer.parseInt(sc.nextLine());

        if (chon < 1 || chon > dsPhongBan.size()) {
            System.out.println("❌ Lựa chọn không hợp lệ!");
            return;
        }

        PhongBan phongMoi = dsPhongBan.get(chon - 1);
        String phongCu = nv.getPhongBan();
        nv.setPhongBan(phongMoi.getTenPB());

        for (PhongBan pb : dsPhongBan) {
            if (pb.getTenPB().equals(phongCu)) {
                pb.xoaNhanVien(maNV);
                break;
            }
        }

        phongMoi.themNhanVien(nv);

        System.out.println("\n✅ CHUYỂN PHÒNG THÀNH CÔNG!");
        System.out.println("   👤 " + nv.getTenNV());
        System.out.println("   🏢 Từ: " + phongCu + " → " + phongMoi.getTenPB());
    }

    // ==================== QUẢN LÝ PHÒNG BAN ====================
    public static void quanLyPhongBan(QuanLyNhanVien qlnv, Scanner sc) {
        int choice;
        do {
            System.out.println("\n" + "─".repeat(50));
            System.out.println("🏢 QUẢN LÝ PHÒNG BAN");
            System.out.println("─".repeat(50));
            System.out.println("1. 📋 Hiển thị tất cả phòng ban");
            System.out.println("2. 👥 Xem chi tiết từng phòng");
            System.out.println("3. ➕ Thêm phòng ban mới");
            System.out.println("4. 🗑️ Xóa phòng ban");
            System.out.println("0. ↩️ Quay lại menu chính");
            System.out.print("👉 Chọn chức năng: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Vui lòng nhập số!");
                choice = -1;
                continue;
            }

            switch (choice) {
                case 1:
                    hienThiTatCaPhongBan(qlnv);
                    break;
                case 2:
                    xemChiTietPhongBan(qlnv, sc);
                    break;
                case 3:
                    themPhongBanMoi(qlnv, sc);
                    break;
                case 4:
                    xoaPhongBan(qlnv, sc);
                    break;
                case 0:
                    System.out.println("↩️ Quay lại menu chính...");
                    break;
                default:
                    System.out.println("❌ Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    public static void hienThiTatCaPhongBan(QuanLyNhanVien qlnv) {
        System.out.println("\n📊 DANH SÁCH PHÒNG BAN TOÀN CÔNG TY");
        System.out.println("═".repeat(60));

        ArrayList<PhongBan> dsPhongBan = qlnv.getDanhSachPhongBan();
        if (dsPhongBan.isEmpty()) {
            System.out.println("📭 Chưa có phòng ban nào!");
            return;
        }

        int stt = 1;
        for (PhongBan pb : dsPhongBan) {
            System.out.println("\n[" + stt++ + "] " + pb.getTenPB());
            System.out.println("   📍 Mã phòng: " + pb.getMaPB());
            System.out.println("   👥 Số nhân viên: " + pb.getSoNhanVien());
        }

        System.out.println("\n📈 TỔNG KẾT:");
        System.out.println("   📁 Tổng số phòng: " + dsPhongBan.size());
    }

    public static void xemChiTietPhongBan(QuanLyNhanVien qlnv, Scanner sc) {
        ArrayList<PhongBan> dsPhongBan = qlnv.getDanhSachPhongBan();

        if (dsPhongBan.isEmpty()) {
            System.out.println("📭 Chưa có phòng ban nào!");
            return;
        }

        System.out.println("\n📋 CHỌN PHÒNG BAN ĐỂ XEM CHI TIẾT:");
        for (int i = 0; i < dsPhongBan.size(); i++) {
            System.out.println((i+1) + ". " + dsPhongBan.get(i).getTenPB() +
                    " (" + dsPhongBan.get(i).getSoNhanVien() + " NV)");
        }

        System.out.print("👉 Chọn phòng: ");
        int chon = Integer.parseInt(sc.nextLine());

        if (chon < 1 || chon > dsPhongBan.size()) {
            System.out.println("❌ Lựa chọn không hợp lệ!");
            return;
        }

        PhongBan pb = dsPhongBan.get(chon - 1);
        System.out.println("\n=== THÔNG TIN PHÒNG " + pb.getTenPB().toUpperCase() + " ===");
        System.out.println("Mã phòng: " + pb.getMaPB());
        System.out.println("Trưởng phòng: " + pb.getTruongPhong());
        System.out.println("Số nhân viên: " + pb.getSoNhanVien());

        if (pb.getSoNhanVien() > 0) {
            System.out.println("\n👥 DANH SÁCH NHÂN VIÊN:");
            for (NhanVien nv : pb.getDanhSachNV()) {
                System.out.println("  - " + nv.getMaNV() + ": " + nv.getTenNV());
            }
        }
    }

    public static void themPhongBanMoi(QuanLyNhanVien qlnv, Scanner sc) {
        System.out.println("\n➕ THÊM PHÒNG BAN MỚI");

        try {
            System.out.print("Nhập mã phòng: ");
            String maPB = sc.nextLine();

            System.out.print("Nhập tên phòng: ");
            String tenPB = sc.nextLine();

            System.out.print("Nhập mã trưởng phòng: ");
            String truongPhong = sc.nextLine();

            PhongBan pb = new PhongBan(maPB, tenPB, truongPhong);
            qlnv.themPhongBan(pb);

            System.out.println("\n✅ THÊM PHÒNG BAN THÀNH CÔNG!");

        } catch (Exception e) {
            System.out.println("❌ Lỗi khi thêm phòng ban: " + e.getMessage());
        }
    }

    public static void xoaPhongBan(QuanLyNhanVien qlnv, Scanner sc) {
        System.out.println("\n🗑️ XÓA PHÒNG BAN");

        ArrayList<PhongBan> dsPhongBan = qlnv.getDanhSachPhongBan();
        if (dsPhongBan.isEmpty()) {
            System.out.println("📭 Chưa có phòng ban nào!");
            return;
        }

        System.out.println("📋 DANH SÁCH PHÒNG BAN:");
        for (int i = 0; i < dsPhongBan.size(); i++) {
            System.out.println((i+1) + ". " + dsPhongBan.get(i).getTenPB() +
                    " (" + dsPhongBan.get(i).getSoNhanVien() + " NV)");
        }

        System.out.print("👉 Chọn phòng cần xóa: ");
        int chon = Integer.parseInt(sc.nextLine());

        if (chon < 1 || chon > dsPhongBan.size()) {
            System.out.println("❌ Lựa chọn không hợp lệ!");
            return;
        }

        PhongBan pb = dsPhongBan.get(chon - 1);

        if (pb.getSoNhanVien() > 0) {
            System.out.println("❌ Không thể xóa phòng đang có nhân viên!");
            return;
        }

        System.out.print("❓ Xác nhận xóa phòng " + pb.getTenPB() + "? (y/n): ");
        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("y")) {
            dsPhongBan.remove(chon - 1);
            System.out.println("✅ ĐÃ XÓA PHÒNG BAN THÀNH CÔNG!");
        } else {
            System.out.println("↩️ Hủy thao tác xóa.");
        }
    }

    // ==================== QUẢN LÝ LƯƠNG ====================
    public static void quanLyLuong(QuanLyNhanVien qlnv) {
        System.out.println("\n💰 BẢNG LƯƠNG NHÂN VIÊN");
        System.out.println("═".repeat(60));

        if (qlnv.getDanhSachNV().isEmpty()) {
            System.out.println("📭 Chưa có nhân viên nào!");
            return;
        }

        System.out.println(String.format("%-10s %-20s %-15s %-20s",
                "Mã NV", "Tên NV", "Phòng", "Lương thực lĩnh"));
        System.out.println("─".repeat(65));

        double tongLuong = 0;

        for (NhanVien nv : qlnv.getDanhSachNV().values()) {
            double luong = nv.tinhThucLinh();

            System.out.println(String.format("%-10s %-20s %-15s %,15.0f VND",
                    nv.getMaNV(),
                    nv.getTenNV(),
                    nv.getPhongBan(),
                    luong));

            tongLuong += luong;
        }

        System.out.println("═".repeat(65));
        System.out.println(String.format("%-45s %,15.0f VND",
                "TỔNG QUỸ LƯƠNG:", tongLuong));

        System.out.println("\n📊 THÔNG TIN THÊM:");
        System.out.println("   👥 Số nhân viên: " + qlnv.getDanhSachNV().size());
        System.out.println("   💵 Trung bình lương/NV: " +
                String.format("%,.0f VND", tongLuong / qlnv.getDanhSachNV().size()));
    }

    // ==================== QUẢN LÝ CHẤM CÔNG ====================
    public static void quanLyChamCong(QuanLyNhanVien qlnv, Scanner sc) {
        System.out.println("\n⏰ QUẢN LÝ CHẤM CÔNG");

        try {
            System.out.print("Nhập mã nhân viên cần chấm công: ");
            String maNV = sc.nextLine();

            NhanVien nv = qlnv.timNV(maNV);
            if (nv == null) {
                System.out.println("❌ Không tìm thấy nhân viên!");
                return;
            }

            ChamCong cc = new ChamCong();
            cc.setMaChamCong("CC" + System.currentTimeMillis());
            cc.setMaNV(maNV);
            cc.setNgay(new Date());

            System.out.print("Nhập số giờ làm trong ngày: ");
            cc.setSoGioLam(Integer.parseInt(sc.nextLine()));

            System.out.print("Nhập số giờ tăng ca: ");
            cc.setSoGioTangCa(Integer.parseInt(sc.nextLine()));

            System.out.print("Ghi chú (nếu có): ");
            cc.setGhiChu(sc.nextLine());

            qlnv.themChamCong(cc);

            System.out.println("\n✅ ĐÃ CHẤM CÔNG THÀNH CÔNG!");
            System.out.println("   👤 Nhân viên: " + nv.getTenNV());
            System.out.println("   ⏰ Số giờ làm: " + cc.getSoGioLam() + "h");
            System.out.println("   🔄 Tăng ca: " + cc.getSoGioTangCa() + "h");
            System.out.println("   💰 Tiền tăng ca: " +
                    String.format("%,.0f VND", cc.tinhTienTangCa()));

        } catch (NumberFormatException e) {
            System.out.println("❌ Vui lòng nhập số cho giờ làm và tăng ca!");
        } catch (Exception e) {
            System.out.println("❌ Lỗi khi chấm công: " + e.getMessage());
        }
    }
}