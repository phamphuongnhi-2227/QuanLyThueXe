public class XeChoHang extends Xe {
    private double trongTai;
    
    public XeChoHang() { super(); }
    
    public XeChoHang(String bienSoXe, String tenXe, double trongTai) {
        super(bienSoXe, tenXe);
        this.trongTai = trongTai;
    }
    
    @Override
    public double getDonGiaTheoNgay() {
        return trongTai * 100000;
    }
    
    @Override
    public void hienThiThongTin() {
        System.out.println("=== THONG TIN XE CHO HANG ===");
        System.out.println("Bien so: " + bienSoXe);
        System.out.println("Ten xe: " + tenXe);
        System.out.println("Trong tai: " + trongTai + " tan");
        System.out.println("Don gia/ngay: " + getDonGiaTheoNgay() + " VND");
    }
    
    public double getTrongTai() { return trongTai; }
    public void setTrongTai(double trongTai) { this.trongTai = trongTai; }
}