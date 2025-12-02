public abstract class NhanVien {
    protected String maNV;
    protected String tenNV;
    protected String ngayVaoCQ;
    protected String soCCCD;
    protected String gioiTinh;
    protected String ngaySinh;
    protected String diaChi;
    protected String soDienThoai;
    protected String email;
    protected String phongBan;

    // Constructor
    public NhanVien() {}

    public NhanVien(String maNV, String tenNV, String ngayVaoCQ, String soCCCD,
                    String gioiTinh, String ngaySinh, String diaChi,
                    String soDienThoai, String email, String phongBan) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.ngayVaoCQ = ngayVaoCQ;
        this.soCCCD = soCCCD;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.phongBan = phongBan;
    }

    // Phương thức abstract
    public abstract double tinhThucLinh();
    public abstract double tinhPhuCap();
    public abstract void nhap();
    public abstract void xuat();

    // Phương thức cụ thể
    public int tinhTuoi() {
        // Logic tính tuổi từ ngày sinh
        return 2024 - Integer.parseInt(ngaySinh.split("/")[2]);
    }

    // Getter và Setter
    public String getMaNV() { return maNV; }
    public void setMaNV(String maNV) { this.maNV = maNV; }

    public String getTenNV() { return tenNV; }
    public void setTenNV(String tenNV) { this.tenNV = tenNV; }

    public String getNgayVaoCQ() { return ngayVaoCQ; }
    public void setNgayVaoCQ(String ngayVaoCQ) { this.ngayVaoCQ = ngayVaoCQ; }

    public String getSoCCCD() { return soCCCD; }
    public void setSoCCCD(String soCCCD) { this.soCCCD = soCCCD; }

    public String getGioiTinh() { return gioiTinh; }
    public void setGioiTinh(String gioiTinh) { this.gioiTinh = gioiTinh; }

    public String getNgaySinh() { return ngaySinh; }
    public void setNgaySinh(String ngaySinh) { this.ngaySinh = ngaySinh; }

    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }

    public String getSoDienThoai() { return soDienThoai; }
    public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhongBan() { return phongBan; }
    public void setPhongBan(String phongBan) { this.phongBan = phongBan; }
}
