public class XeDuLich extends Xe {
    private int soChoNgoi;
    
    public XeDuLich() { super(); }
    
    public XeDuLich(String bienSoXe, String tenXe, int soChoNgoi) {
        super(bienSoXe, tenXe);
        this.soChoNgoi = soChoNgoi;
    }
    
    @Override
    public double getDonGiaTheoNgay() {
        switch (soChoNgoi) {
            case 4:
                return 400000;
            case 7:
                return 600000;
            case 12:
                return 700000;
            default:
                if (soChoNgoi >= 30) {
                    return 1000000;
                } else {
                    return 500000;
                }
        }
    }
    
    @Override
    public void hienThiThongTin() {
        System.out.println("=== THONG TIN XE DU LICH ===");
        System.out.println("Bien so: " + bienSoXe);
        System.out.println("Ten xe: " + tenXe);
        System.out.println("So cho ngoi: " + soChoNgoi);
        System.out.println("Don gia/ngay: " + getDonGiaTheoNgay() + " VND");
    }
    
    public int getSoChoNgoi() { return soChoNgoi; }
    public void setSoChoNgoi(int soChoNgoi) { this.soChoNgoi = soChoNgoi; }
}