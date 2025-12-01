public interface IQuanLyKhachHang {
    void themKhachHang(KhachHang kh);
    KhachHang timKiem(String maKH);
    void capNhatKhachHang(String maKH, KhachHang khachHangMoi);
    boolean xoaKhachHang(String maKH);
    void hienThiDanhSachKhachHang();
    boolean coHopDong(String maKH, QuanLyHopDong quanLyHopDong);
}