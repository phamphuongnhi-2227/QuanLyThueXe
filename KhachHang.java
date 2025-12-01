import java.util.ArrayList;
import java.util.List;

public class KhachHang {
    private String maKH;
    private String tenKH;
    private String soCCCD;
    private String diaChi;
    private String SDT;
    private List<HopDong> hopDongThue;
    
    public KhachHang() {
        this.hopDongThue = new ArrayList<>();
    }
    public KhachHang(String maKH, String tenKH, String soCCCD, String diaChi, String SDT) {
        this();
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.soCCCD = soCCCD;
        this.diaChi = diaChi;
        this.SDT = SDT;
    }
    
    public void themHopDongThue(HopDong hd) {
    this.hopDongThue.add(hd);
    
    if (!hd.getMaHD().contains("READING_FROM_FILE")) { // Hoặc một điều kiện khác
        System.out.println("Da them hop dong thue cho khach hang: " + tenKH);
    }
}
    
    public void hienThiThongTin() {
        System.out.println("=== THONG TIN KHACH HANG ===");
        System.out.println("Ma KH: " + maKH);
        System.out.println("Ten KH: " + tenKH);
        System.out.println("So CCCD: " + soCCCD);
        System.out.println("Dia chi: " + diaChi);
        System.out.println("SDT: " + SDT);
        System.out.println("So hop dong thue: " + hopDongThue.size());
    }
    
    public String getMaKH() { return maKH; }
    public void setMaKH(String maKH) { this.maKH = maKH; }
    public String getTenKH() { return tenKH; }
    public void setTenKH(String tenKH) { this.tenKH = tenKH; }
    public String getSoCCCD() { return soCCCD; }
    public void setSoCCCD(String soCCCD) { this.soCCCD = soCCCD; }
    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }
    public String getSDT() { return SDT; }
    public void setSDT(String SDT) { this.SDT = SDT; }
    public List<HopDong> getHopDongThue() { return hopDongThue; }
}