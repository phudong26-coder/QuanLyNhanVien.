// Lớp Quản lý Nhân viên
import java.util.*;
import java.io.*;

public class QuanLyNhanVien implements IReadWrite {
    private HashMap<String, NhanVien> danhSachNV;
    private ArrayList<PhongBan> danhSachPhongBan;
    private ArrayList<ChamCong> danhSachChamCong;
    private ArrayList<BangLuong> danhSachBangLuong;

    public QuanLyNhanVien() {
        danhSachNV = new HashMap<>();
        danhSachPhongBan = new ArrayList<>();
        danhSachChamCong = new ArrayList<>();
        danhSachBangLuong = new ArrayList<>();
        khoiTaoDuLieuMau();
    }

    private void khoiTaoDuLieuMau() {
        // Khởi tạo bảng lương mẫu
        danhSachBangLuong.add(new BangLuong("BL001", 1, 4500000, 0.1));
        danhSachBangLuong.add(new BangLuong("BL002", 2, 4500000, 0.15));
        danhSachBangLuong.add(new BangLuong("BL003", 3, 4500000, 0.2));

        // Khởi tạo phòng ban mẫu
        danhSachPhongBan.add(new PhongBan("PB001", "Phòng Kế Toán", "NV001"));
        danhSachPhongBan.add(new PhongBan("PB002", "Phòng Kinh Doanh", "NV002"));
        danhSachPhongBan.add(new PhongBan("PB003", "Phòng Nhân Sự", "NV003"));
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Chọn loại NV (1-Biên chế, 2-Hợp đồng): ");
        int loai = sc.nextInt();
        sc.nextLine();

        NhanVien nv;
        if (loai == 1) {
            nv = new NhanVienBC();
        } else {
            nv = new NhanVienHD();
        }

        nv.nhap();
        themNhanVien(nv);
    }

    public void xuat() {
        if (danhSachNV.isEmpty()) {
            System.out.println(" Danh sách nhân viên trống!");
            return;
        }

        System.out.println("\n=== DANH SÁCH NHÂN VIÊN ===");
        System.out.println("Tổng số: " + danhSachNV.size() + " nhân viên");
        System.out.println("==========================");

        int stt = 1;
        for (NhanVien nv : danhSachNV.values()) {
            System.out.println("\n[" + stt++ + "]");
            nv.xuat();
        }
    }

    public void xoaNV(String maNV) {
        if (danhSachNV.containsKey(maNV)) {
            NhanVien nv = danhSachNV.remove(maNV);
            System.out.println(" Đã xóa nhân viên: " + nv.getTenNV());
        } else {
            System.out.println(" Không tìm thấy nhân viên với mã: " + maNV);
        }
    }

    public NhanVien timNV(String maNV) {
        return danhSachNV.get(maNV);
    }

    public boolean suaNhanVien(String maNV, NhanVien nvMoi) {
        if (danhSachNV.containsKey(maNV)) {
            danhSachNV.put(maNV, nvMoi);
            return true;
        }
        return false;
    }

    public void themNhanVien(NhanVien nv) {
        danhSachNV.put(nv.getMaNV(), nv);
    }

    public double tinhTongQuyLuong() {
        double tongLuong = 0;
        for (NhanVien nv : danhSachNV.values()) {
            tongLuong += nv.tinhThucLinh();
        }
        return tongLuong;
    }

    public void thongKe() {
        System.out.println("\n THỐNG KÊ TỔNG QUAN");
        System.out.println("========================");
        System.out.println("Tổng số nhân viên: " + danhSachNV.size());
        System.out.println("Tổng quỹ lương: " + String.format("%,.0f VND", tinhTongQuyLuong()));

        long soNVBC = danhSachNV.values().stream()
                .filter(nv -> nv instanceof NhanVienBC)
                .count();
        long soNVHD = danhSachNV.values().stream()
                .filter(nv -> nv instanceof NhanVienHD)
                .count();

        System.out.println("Số NV biên chế: " + soNVBC);
        System.out.println("Số NV hợp đồng: " + soNVHD);
        System.out.println("Số phòng ban: " + danhSachPhongBan.size());
        System.out.println("Số bảng lương: " + danhSachBangLuong.size());

        // Thống kê theo phòng ban
        System.out.println("\nTHỐNG KÊ THEO PHÒNG BAN:");
        for (PhongBan pb : danhSachPhongBan) {
            System.out.println("- " + pb.getTenPB() + ": " + pb.getSoNhanVien() + " NV");
        }
    }

    public void themPhongBan(PhongBan pb) {
        danhSachPhongBan.add(pb);
    }

    public void themChamCong(ChamCong cc) {
        danhSachChamCong.add(cc);
    }

    @Override
    public void readData() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                System.out.println(" File không tồn tại. Tạo file mới...");
                writeData();
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            int count = 0;

            System.out.println("\n ĐANG ĐỌC DỮ LIỆU TỪ FILE...");

            while ((line = br.readLine()) != null) {
                // Giả định mỗi dòng có định dạng: maNV;tenNV;loaiNV;...
                String[] data = line.split(";");
                if (data.length >= 3) {
                    String maNV = data[0];
                    String tenNV = data[1];
                    String loaiNV = data[2];

                    // Tạo nhân viên tương ứng
                    if (loaiNV.equals("BC")) {
                        NhanVienBC nv = new NhanVienBC();
                        nv.setMaNV(maNV);
                        nv.setTenNV(tenNV);
                        danhSachNV.put(maNV, nv);
                    } else if (loaiNV.equals("HD")) {
                        NhanVienHD nv = new NhanVienHD();
                        nv.setMaNV(maNV);
                        nv.setTenNV(tenNV);
                        danhSachNV.put(maNV, nv);
                    }
                    count++;
                }
            }
            br.close();

            System.out.println("Đã đọc " + count + " nhân viên từ file.");

        } catch (IOException e) {
            System.out.println(" Lỗi đọc file: " + e.getMessage());
        }
    }

    @Override
    public void writeData() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME));
            int count = 0;

            System.out.println("\n ĐANG GHI DỮ LIỆU VÀO FILE...");

            for (NhanVien nv : danhSachNV.values()) {
                String loaiNV = (nv instanceof NhanVienBC) ? "BC" : "HD";
                String line = nv.getMaNV() + ";" + nv.getTenNV() + ";" + loaiNV + ";" + nv.getPhongBan();
                bw.write(line);
                bw.newLine();
                count++;
            }
            bw.close();

            System.out.println(" Đã ghi " + count + " nhân viên vào file: " + FILE_NAME);

        } catch (IOException e) {
            System.out.println(" Lỗi ghi file: " + e.getMessage());
        }
    }

    // Getter cho danh sách
    public HashMap<String, NhanVien> getDanhSachNV() {
        return danhSachNV;
    }

    public ArrayList<PhongBan> getDanhSachPhongBan() {
        return danhSachPhongBan;
    }
}