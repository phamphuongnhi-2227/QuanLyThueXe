import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class HopDong {
    private Xe xeThue;
    private KhachHang khachHangThue;
    private String maHD;
    private double tienDatCoc;
    private LocalDate ngayThue;
    private LocalDate ngayTra;
    
    public HopDong() {}
    
    public HopDong(Xe xeThue, KhachHang khachHangThue, String maHD, 
                   double tienDatCoc, LocalDate ngayThue, LocalDate ngayTra) {
        this.xeThue = xeThue;
        this.khachHangThue = khachHangThue;
        this.maHD = maHD;
        this.tienDatCoc = tienDatCoc;
        this.ngayThue = ngayThue;
        this.ngayTra = ngayTra;
    }
    
    public int tinhSoNgayThue() {
        return (int) ChronoUnit.DAYS.between(ngayThue, ngayTra);
    }
    
    public double tinhTongTien() {
        int soNgayThue = tinhSoNgayThue();
        double donGia = xeThue.getDonGiaTheoNgay();
        return (soNgayThue * donGia) + tienDatCoc;
    }
    
    public double tinhTienThueXe() {
        int soNgayThue = tinhSoNgayThue();
        return soNgayThue * xeThue.getDonGiaTheoNgay();
    }
    
    public void hienThiThongTin() {
        int soNgayThue = tinhSoNgayThue();
        double tienThueXe = tinhTienThueXe();
        double tongTien = tinhTongTien();
        
        System.out.println("=== THONG TIN HOP DONG ===");
        System.out.println("Ma HD: " + maHD);
        System.out.println("Khach hang: " + khachHangThue.getTenKH() + " (" + khachHangThue.getMaKH() + ")");
        System.out.println("Xe thue: " + xeThue.getTenXe() + " (" + xeThue.getBienSoXe() + ")");
        System.out.println("Tien dat coc: " + tienDatCoc + " VND");
        System.out.println("Ngay thue: " + ngayThue);
        System.out.println("Ngay tra: " + ngayTra);
        System.out.println("So ngay thue: " + soNgayThue);
        System.out.println("Don gia/ngay: " + xeThue.getDonGiaTheoNgay() + " VND");
        System.out.println("Tien thue xe: " + tienThueXe + " VND");
        System.out.println("Tong tien (thue xe + dat coc): " + tongTien + " VND");
    }
    
    public Xe getXeThue() { return xeThue; }
    public void setXeThue(Xe xeThue) { this.xeThue = xeThue; }
    public KhachHang getKhachHangThue() { return khachHangThue; }
    public void setKhachHangThue(KhachHang khachHangThue) { this.khachHangThue = khachHangThue; }
    public String getMaHD() { return maHD; }
    public void setMaHD(String maHD) { this.maHD = maHD; }
    public double getTienDatCoc() { return tienDatCoc; }
    public void setTienDatCoc(double tienDatCoc) { this.tienDatCoc = tienDatCoc; }
    public LocalDate getNgayThue() { return ngayThue; }
    public void setNgayThue(LocalDate ngayThue) { this.ngayThue = ngayThue; }
    public LocalDate getNgayTra() { return ngayTra; }
    public void setNgayTra(LocalDate ngayTra) { this.ngayTra = ngayTra; }
}