// Lớp Bảng lương
import java.util.HashMap;

public class BangLuong {
    private String maBang;
    private int bacLuong;
    private double heSoLuong;
    private double luongCoBan;
    private double heSoPhuCap;

    // Bảng hệ số lương mẫu theo bậc
    private static final HashMap<Integer, Double> BANG_HE_SO_LUONG = new HashMap<>();

    static {
        // Khởi tạo bảng hệ số lương
        BANG_HE_SO_LUONG.put(1, 1.5);
        BANG_HE_SO_LUONG.put(2, 2.0);
        BANG_HE_SO_LUONG.put(3, 2.5);
        BANG_HE_SO_LUONG.put(4, 3.0);
        BANG_HE_SO_LUONG.put(5, 3.5);
        BANG_HE_SO_LUONG.put(6, 4.0);
        BANG_HE_SO_LUONG.put(7, 4.5);
        BANG_HE_SO_LUONG.put(8, 5.0);
    }

    public BangLuong() {}

    public BangLuong(String maBang, int bacLuong, double luongCoBan, double heSoPhuCap) {
        this.maBang = maBang;
        this.bacLuong = bacLuong;
        this.heSoLuong = layHeSo(bacLuong);
        this.luongCoBan = luongCoBan;
        this.heSoPhuCap = heSoPhuCap;
    }

    public double layHeSo(int bac) {
        return BANG_HE_SO_LUONG.getOrDefault(bac, 1.0);
    }

    public double tinhLuongCoBan() {
        return luongCoBan * heSoLuong;
    }

    public double tinhPhuCap() {
        return tinhLuongCoBan() * heSoPhuCap;
    }

    public double tinhLuongTong() {
        return tinhLuongCoBan() + tinhPhuCap();
    }

    public void hienThiThongTin() {
        System.out.println("=== THÔNG TIN BẢNG LƯƠNG ===");
        System.out.println("Mã bảng: " + maBang);
        System.out.println("Bậc lương: " + bacLuong);
        System.out.println("Hệ số lương: " + heSoLuong);
        System.out.println("Lương cơ bản: " + String.format("%,.0f VND", luongCoBan));
        System.out.println("Hệ số phụ cấp: " + heSoPhuCap);
        System.out.println("Lương cơ bản (đã nhân hệ số): " + String.format("%,.0f VND", tinhLuongCoBan()));
        System.out.println("Phụ cấp: " + String.format("%,.0f VND", tinhPhuCap()));
        System.out.println("Tổng lương: " + String.format("%,.0f VND", tinhLuongTong()));
        System.out.println("---------------------------");
    }

    // Getter và Setter
    public String getMaBang() { return maBang; }
    public void setMaBang(String maBang) { this.maBang = maBang; }

    public int getBacLuong() { return bacLuong; }
    public void setBacLuong(int bacLuong) {
        this.bacLuong = bacLuong;
        this.heSoLuong = layHeSo(bacLuong);
    }

    public double getHeSoLuong() { return heSoLuong; }

    public double getLuongCoBan() { return luongCoBan; }
    public void setLuongCoBan(double luongCoBan) { this.luongCoBan = luongCoBan; }

    public double getHeSoPhuCap() { return heSoPhuCap; }
    public void setHeSoPhuCap(double heSoPhuCap) { this.heSoPhuCap = heSoPhuCap; }

    // Phương thức static để lấy thông tin hệ số
    public static void hienThiBangHeSoLuong() {
        System.out.println("\n📋 BẢNG HỆ SỐ LƯƠNG THEO BẬC:");
        System.out.println("Bậc\tHệ số");
        System.out.println("----------------");
        for (int i = 1; i <= 8; i++) {
            System.out.println(i + "\t" + BANG_HE_SO_LUONG.get(i));
        }
    }
}