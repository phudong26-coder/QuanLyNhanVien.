// Lớp Chấm công
import java.util.Date;

public class ChamCong {
    private String maChamCong;
    private String maNV;
    private Date ngay;
    private int soGioLam;
    private int soGioTangCa;
    private int nghiPhep;
    private String ghiChu;

    public ChamCong() {}

    public ChamCong(String maChamCong, String maNV, Date ngay,
                    int soGioLam, int soGioTangCa, int nghiPhep, String ghiChu) {
        this.maChamCong = maChamCong;
        this.maNV = maNV;
        this.ngay = ngay;
        this.soGioLam = soGioLam;
        this.soGioTangCa = soGioTangCa;
        this.nghiPhep = nghiPhep;
        this.ghiChu = ghiChu;
    }

    public double tinhTienTangCa() {
        // Giả định 1 giờ tăng ca = 150% lương giờ bình thường
        // Mức lương giả định: 50,000 VND/giờ
        double luongGioCoBan = 50000;
        return soGioTangCa * luongGioCoBan * 1.5;
    }

    public int tinhNgayCongThuc() {
        // Mỗi ngày 8 giờ
        return soGioLam / 8;
    }

    public void hienThiThongTin() {
        System.out.println("=== THÔNG TIN CHẤM CÔNG ===");
        System.out.println("Mã chấm công: " + maChamCong);
        System.out.println("Mã NV: " + maNV);
        System.out.println("Ngày: " + ngay);
        System.out.println("Số giờ làm: " + soGioLam + "h");
        System.out.println("Tăng ca: " + soGioTangCa + "h");
        System.out.println("Nghỉ phép: " + nghiPhep + " ngày");
        System.out.println("Số ngày công thực: " + tinhNgayCongThuc());
        System.out.println("Tiền tăng ca: " + String.format("%,.0f VND", tinhTienTangCa()));
        System.out.println("Ghi chú: " + ghiChu);
        System.out.println("---------------------------");
    }

    // Getter và Setter
    public String getMaChamCong() { return maChamCong; }
    public void setMaChamCong(String maChamCong) { this.maChamCong = maChamCong; }

    public String getMaNV() { return maNV; }
    public void setMaNV(String maNV) { this.maNV = maNV; }

    public Date getNgay() { return ngay; }
    public void setNgay(Date ngay) { this.ngay = ngay; }

    public int getSoGioLam() { return soGioLam; }
    public void setSoGioLam(int soGioLam) { this.soGioLam = soGioLam; }

    public int getSoGioTangCa() { return soGioTangCa; }
    public void setSoGioTangCa(int soGioTangCa) { this.soGioTangCa = soGioTangCa; }

    public int getNghiPhep() { return nghiPhep; }
    public void setNghiPhep(int nghiPhep) { this.nghiPhep = nghiPhep; }

    public String getGhiChu() { return ghiChu; }
    public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; }
}