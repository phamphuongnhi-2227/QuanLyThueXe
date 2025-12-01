public abstract class Xe {
    protected String bienSoXe;
    protected String tenXe;
    
    public Xe() {}
    
    public Xe(String bienSoXe, String tenXe) {
        this.bienSoXe = bienSoXe;
        this.tenXe = tenXe;
    }
    
    public abstract double getDonGiaTheoNgay();
    public abstract void hienThiThongTin();
    
    public String getBienSoXe() { return bienSoXe; }
    public void setBienSoXe(String bienSoXe) { this.bienSoXe = bienSoXe; }
    public String getTenXe() { return tenXe; }
    public void setTenXe(String tenXe) { this.tenXe = tenXe; }
}