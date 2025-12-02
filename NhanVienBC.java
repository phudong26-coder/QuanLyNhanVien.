// Lớp Nhân viên Biên chế
import java.util.Scanner;

public class NhanVienBC extends NhanVien {
    private double heSoLuong;
    private double luongCoBan;
    private int soNgayLam;
    private double heSoPhuCap;
    private double bhxh;
    private double bhyt;
    private String ngayNangLuongGanNhat;

    public NhanVienBC() {}

    public NhanVienBC(String maNV, String tenNV, String ngayVaoCQ, String soCCCD,
                      String gioiTinh, String ngaySinh, String diaChi,
                      String soDienThoai, String email, String phongBan,
                      double heSoLuong, double luongCoBan, int soNgayLam,
                      double heSoPhuCap, double bhxh, double bhyt, String ngayNangLuongGanNhat) {
        super(maNV, tenNV, ngayVaoCQ, soCCCD, gioiTinh, ngaySinh, diaChi, soDienThoai, email, phongBan);
        this.heSoLuong = heSoLuong;
        this.luongCoBan = luongCoBan;
        this.soNgayLam = soNgayLam;
        this.heSoPhuCap = heSoPhuCap;
        this.bhxh = bhxh;
        this.bhyt = bhyt;
        this.ngayNangLuongGanNhat = ngayNangLuongGanNhat;
    }

    @Override
    public double tinhThucLinh() {
        double luong = (luongCoBan * heSoLuong) + tinhPhuCap();
        double baoHiem = bhxh + bhyt;
        return luong - baoHiem;
    }

    @Override
    public double tinhPhuCap() {
        return (luongCoBan * heSoPhuCap * soNgayLam) / 26;
    }

    @Override
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã NV: ");
        this.maNV = sc.nextLine();
        System.out.print("Nhập tên NV: ");
        this.tenNV = sc.nextLine();
        System.out.print("Nhập hệ số lương: ");
        this.heSoLuong = sc.nextDouble();
        System.out.print("Nhập lương cơ bản: ");
        this.luongCoBan = sc.nextDouble();
        System.out.print("Nhập số ngày làm: ");
        this.soNgayLam = sc.nextInt();
        sc.nextLine(); // Clear buffer
    }

    @Override
    public void xuat() {
        System.out.println("=== THÔNG TIN NHÂN VIÊN BIÊN CHẾ ===");
        System.out.println("Mã NV: " + maNV);
        System.out.println("Tên NV: " + tenNV);
        System.out.println("Phòng ban: " + phongBan);
        System.out.println("Hệ số lương: " + heSoLuong);
        System.out.println("Lương cơ bản: " + String.format("%,.0f VND", luongCoBan));
        System.out.println("Lương thực lĩnh: " + String.format("%,.0f VND", tinhThucLinh()));
        System.out.println("Phụ cấp: " + String.format("%,.0f VND", tinhPhuCap()));
        System.out.println("-----------------------------------");
    }

    // Getter và Setter
    public double getHeSoLuong() { return heSoLuong; }
    public void setHeSoLuong(double heSoLuong) { this.heSoLuong = heSoLuong; }

    public double getLuongCoBan() { return luongCoBan; }
    public void setLuongCoBan(double luongCoBan) { this.luongCoBan = luongCoBan; }

    public int getSoNgayLam() { return soNgayLam; }
    public void setSoNgayLam(int soNgayLam) { this.soNgayLam = soNgayLam; }

    public double getHeSoPhuCap() { return heSoPhuCap; }
    public void setHeSoPhuCap(double heSoPhuCap) { this.heSoPhuCap = heSoPhuCap; }

    public double getBhxh() { return bhxh; }
    public void setBhxh(double bhxh) { this.bhxh = bhxh; }

    public double getBhyt() { return bhyt; }
    public void setBhyt(double bhyt) { this.bhyt = bhyt; }

    public String getNgayNangLuongGanNhat() { return ngayNangLuongGanNhat; }
    public void setNgayNangLuongGanNhat(String ngayNangLuongGanNhat) {
        this.ngayNangLuongGanNhat = ngayNangLuongGanNhat;
    }
}
