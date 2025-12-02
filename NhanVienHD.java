// Lớp Nhân viên Hợp đồng
import java.util.Scanner;

public class NhanVienHD extends NhanVien {
    private double mucLuong;
    private String loaiHopDong;
    private int soGioLam;
    private double luongTheoGio;
    private double phuCapHopDong;
    private double baoHiemXaHoi;
    private String ngayKyHopDong;
    private String ngayHetHan;
    private String mucDongBH;

    public NhanVienHD() {}

    public NhanVienHD(String maNV, String tenNV, String ngayVaoCQ, String soCCCD,
                      String gioiTinh, String ngaySinh, String diaChi,
                      String soDienThoai, String email, String phongBan,
                      double mucLuong, String loaiHopDong, int soGioLam,
                      double luongTheoGio, double phuCapHopDong,
                      double baoHiemXaHoi, String ngayKyHopDong,
                      String ngayHetHan, String mucDongBH) {
        super(maNV, tenNV, ngayVaoCQ, soCCCD, gioiTinh, ngaySinh, diaChi, soDienThoai, email, phongBan);
        this.mucLuong = mucLuong;
        this.loaiHopDong = loaiHopDong;
        this.soGioLam = soGioLam;
        this.luongTheoGio = luongTheoGio;
        this.phuCapHopDong = phuCapHopDong;
        this.baoHiemXaHoi = baoHiemXaHoi;
        this.ngayKyHopDong = ngayKyHopDong;
        this.ngayHetHan = ngayHetHan;
        this.mucDongBH = mucDongBH;
    }

    @Override
    public double tinhThucLinh() {
        return (soGioLam * luongTheoGio) + phuCapHopDong - baoHiemXaHoi;
    }

    @Override
    public double tinhPhuCap() {
        return phuCapHopDong;
    }

    @Override
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã NV: ");
        this.maNV = sc.nextLine();
        System.out.print("Nhập tên NV: ");
        this.tenNV = sc.nextLine();
        System.out.print("Nhập loại hợp đồng: ");
        this.loaiHopDong = sc.nextLine();
        System.out.print("Nhập lương theo giờ: ");
        this.luongTheoGio = sc.nextDouble();
        System.out.print("Nhập số giờ làm: ");
        this.soGioLam = sc.nextInt();
        System.out.print("Nhập phụ cấp hợp đồng: ");
        this.phuCapHopDong = sc.nextDouble();
        sc.nextLine(); // Clear buffer
    }

    @Override
    public void xuat() {
        System.out.println("=== THÔNG TIN NHÂN VIÊN HỢP ĐỒNG ===");
        System.out.println("Mã NV: " + maNV);
        System.out.println("Tên NV: " + tenNV);
        System.out.println("Phòng ban: " + phongBan);
        System.out.println("Loại hợp đồng: " + loaiHopDong);
        System.out.println("Số giờ làm: " + soGioLam + "h");
        System.out.println("Lương theo giờ: " + String.format("%,.0f VND/h", luongTheoGio));
        System.out.println("Lương thực lĩnh: " + String.format("%,.0f VND", tinhThucLinh()));
        System.out.println("Phụ cấp: " + String.format("%,.0f VND", tinhPhuCap()));
        System.out.println("-----------------------------------");
    }

    // Getter và Setter
    public double getMucLuong() { return mucLuong; }
    public void setMucLuong(double mucLuong) { this.mucLuong = mucLuong; }

    public String getLoaiHopDong() { return loaiHopDong; }
    public void setLoaiHopDong(String loaiHopDong) { this.loaiHopDong = loaiHopDong; }

    public int getSoGioLam() { return soGioLam; }
    public void setSoGioLam(int soGioLam) { this.soGioLam = soGioLam; }

    public double getLuongTheoGio() { return luongTheoGio; }
    public void setLuongTheoGio(double luongTheoGio) { this.luongTheoGio = luongTheoGio; }

    public double getPhuCapHopDong() { return phuCapHopDong; }
    public void setPhuCapHopDong(double phuCapHopDong) { this.phuCapHopDong = phuCapHopDong; }

    public double getBaoHiemXaHoi() { return baoHiemXaHoi; }
    public void setBaoHiemXaHoi(double baoHiemXaHoi) { this.baoHiemXaHoi = baoHiemXaHoi; }

    public String getNgayKyHopDong() { return ngayKyHopDong; }
    public void setNgayKyHopDong(String ngayKyHopDong) { this.ngayKyHopDong = ngayKyHopDong; }

    public String getNgayHetHan() { return ngayHetHan; }
    public void setNgayHetHan(String ngayHetHan) { this.ngayHetHan = ngayHetHan; }

    public String getMucDongBH() { return mucDongBH; }
    public void setMucDongBH(String mucDongBH) { this.mucDongBH = mucDongBH; }
}
