public interface IQuanLyHopDong {
    void themHopDong(HopDong hd);
    HopDong timKiemHopDong(String maHD);
    void capNhatHopDong(String maHD, HopDong hopDongMoi);
    void xoaHopDong(String maHD);
    double tinhTongTienThue(HopDong hd);
}