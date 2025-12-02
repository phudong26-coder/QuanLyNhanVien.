// Lớp Phòng ban
import java.util.ArrayList;

public class PhongBan {
    private String maPB;
    private String tenPB;
    private String truongPhong;
    private int soNhanVien;
    private ArrayList<NhanVien> danhSachNV;

    public PhongBan() {
        danhSachNV = new ArrayList<>();
    }

    public PhongBan(String maPB, String tenPB, String truongPhong) {
        this.maPB = maPB;
        this.tenPB = tenPB;
        this.truongPhong = truongPhong;
        this.soNhanVien = 0;
        danhSachNV = new ArrayList<>();
    }

    public void themNhanVien(NhanVien nv) {
        danhSachNV.add(nv);
        soNhanVien++;
        System.out.println("✅ Đã thêm NV " + nv.getMaNV() + " vào phòng " + tenPB);
    }

    public void xoaNhanVien(String maNV) {
        for (int i = 0; i < danhSachNV.size(); i++) {
            if (danhSachNV.get(i).getMaNV().equals(maNV)) {
                danhSachNV.remove(i);
                soNhanVien--;
                System.out.println("✅ Đã xóa NV " + maNV + " khỏi phòng " + tenPB);
                return;
            }
        }
        System.out.println("❌ Không tìm thấy NV " + maNV + " trong phòng " + tenPB);
    }

    public double tinhTongLuongPhongBan() {
        double tongLuong = 0;
        for (NhanVien nv : danhSachNV) {
            tongLuong += nv.tinhThucLinh();
        }
        return tongLuong;
    }

    public void hienThiDanhSachNV() {
        System.out.println("\n=== DANH SÁCH NHÂN VIÊN PHÒNG " + tenPB.toUpperCase() + " ===");
        if (danhSachNV.isEmpty()) {
            System.out.println("📭 Phòng chưa có nhân viên nào!");
        } else {
            for (NhanVien nv : danhSachNV) {
                nv.xuat();
            }
            System.out.println("Tổng số NV: " + soNhanVien);
            System.out.println("Tổng lương phòng: " + String.format("%,.0f VND", tinhTongLuongPhongBan()));
        }
    }

    // Getter và Setter
    public String getMaPB() { return maPB; }
    public void setMaPB(String maPB) { this.maPB = maPB; }

    public String getTenPB() { return tenPB; }
    public void setTenPB(String tenPB) { this.tenPB = tenPB; }

    public String getTruongPhong() { return truongPhong; }
    public void setTruongPhong(String truongPhong) { this.truongPhong = truongPhong; }

    public int getSoNhanVien() { return soNhanVien; }
    public void setSoNhanVien(int soNhanVien) { this.soNhanVien = soNhanVien; }

    public ArrayList<NhanVien> getDanhSachNV() { return danhSachNV; }
}