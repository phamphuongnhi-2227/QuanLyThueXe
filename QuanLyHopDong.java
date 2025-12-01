import java.util.*;
import java.io.*;
import java.time.LocalDate;

public class QuanLyHopDong implements IQuanLyHopDong, IReadWrite {
    private List<HopDong> danhSachHopDong;
    private String fileName = "QuanLyHopDong.txt";
    private QuanLyXe quanLyXe;
    private QuanLyKhachHang quanLyKhachHang;
    
    public QuanLyHopDong(QuanLyXe quanLyXe, QuanLyKhachHang quanLyKhachHang) {
        this.danhSachHopDong = new ArrayList<>();
        this.quanLyXe = quanLyXe;
        this.quanLyKhachHang = quanLyKhachHang;
        readFile();
    }

    @Override
    public void themHopDong(HopDong hd) {
        for (HopDong hopDong : danhSachHopDong) {
            if (hopDong.getMaHD().equals(hd.getMaHD())) {
                System.out.println("Loi: Ma hop dong da ton tai!");
                return;
            }
        }
        danhSachHopDong.add(hd);
        hd.getKhachHangThue().themHopDongThue(hd);
        System.out.println("Da them hop dong: " + hd.getMaHD());
        writeFile();
    }
    
    @Override
    public HopDong timKiemHopDong(String maHD) {
        for (HopDong hd : danhSachHopDong) {
            if (hd.getMaHD().equalsIgnoreCase(maHD)) {
                return hd;
            }
        }
        return null;
    }
    
    @Override
    public void capNhatHopDong(String maHD, HopDong hopDongMoi) {
        for (int i = 0; i < danhSachHopDong.size(); i++) {
            if (danhSachHopDong.get(i).getMaHD().equals(maHD)) {
                HopDong hopDongCu = danhSachHopDong.get(i);
                KhachHang khachHangCu = hopDongCu.getKhachHangThue();
                khachHangCu.getHopDongThue().remove(hopDongCu);
                
                KhachHang khachHangMoi = hopDongMoi.getKhachHangThue();
                khachHangMoi.getHopDongThue().add(hopDongMoi);
                
                danhSachHopDong.set(i, hopDongMoi);
                System.out.println("Da cap nhat hop dong: " + maHD);
                writeFile();
                return;
            }
        }
        System.out.println("Khong tim thay hop dong: " + maHD);
    }
    
   @Override
    public void xoaHopDong(String maHD) {
        HopDong hd = timKiemHopDong(maHD);
        if (hd != null) {
            // Xóa hợp đồng khỏi danh sách của khách hàng
            KhachHang kh = hd.getKhachHangThue();
            kh.getHopDongThue().remove(hd);
            
            // Xóa hợp đồng khỏi danh sách chính
            danhSachHopDong.remove(hd);
            System.out.println("Da xoa hop dong: " + maHD);
            writeFile();
        } else {
            System.out.println("Khong tim thay hop dong: " + maHD);
        }
    }
    
    @Override
    public double tinhTongTienThue(HopDong hd) {
        return hd.tinhTongTien();
    }
    
    @Override
    public void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("Dang doc du lieu hop dong tu file...");
            int count = 0;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 10) {
                    String maHD = data[0];
                    String maKH = data[1];
                    String tenKH = data[2];
                    String soCCCD = data[3];
                    String diaChi = data[4];
                    String sdt = data[5];
                    String bienSoXe = data[6];
                    double tienDatCoc = Double.parseDouble(data[7]);
                    LocalDate ngayThue = LocalDate.parse(data[8]);
                    LocalDate ngayTra = LocalDate.parse(data[9]);
                    
                    Xe xe = quanLyXe.timKiem(bienSoXe);
                    if (xe != null) {
                        KhachHang khachHang = quanLyKhachHang.timKiem(maKH);
                        if (khachHang == null) {
                            khachHang = new KhachHang(maKH, tenKH, soCCCD, diaChi, sdt);
                            quanLyKhachHang.themKhachHang(khachHang);
                        }
                        boolean khachHangConTonTai = false;
                        for (KhachHang kh : quanLyKhachHang.getDanhSachKhachHang()) {
                            if (kh.getMaKH().equals(maKH)) {
                                khachHangConTonTai = true;
                                break;
                            }
                        }
                        if (!khachHangConTonTai) {
                            System.out.println("Khach hang " + maKH + " da bi xoa, tao moi...");
                            khachHang = new KhachHang(maKH, tenKH, soCCCD, diaChi, sdt);
                            quanLyKhachHang.themKhachHang(khachHang);
                        }
                        HopDong hopDong = new HopDong(xe, khachHang, maHD, tienDatCoc, ngayThue, ngayTra);
                        danhSachHopDong.add(hopDong);
                        khachHang.getHopDongThue().add(hopDong);
                        count++;
                    }
                }
            }
            System.out.println("Da doc " + count + " hop dong tu file: " + fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " chua ton tai. Se tao moi khi ghi du lieu.");
        } catch (IOException e) {
            System.out.println("Loi doc file hop dong: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Loi khong xac dinh khi doc file hop dong: " + e.getMessage());
        }
    }
    
    @Override
    public void writeFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            for (HopDong hd : danhSachHopDong) {
                KhachHang kh = hd.getKhachHangThue();
                pw.println(hd.getMaHD() + "," + kh.getMaKH() + "," + 
                          kh.getTenKH() + "," + kh.getSoCCCD() + "," + 
                          kh.getDiaChi() + "," + kh.getSDT() + "," + 
                          hd.getXeThue().getBienSoXe() + "," + 
                          hd.getTienDatCoc() + "," + 
                          hd.getNgayThue() + "," + hd.getNgayTra());
            }
            System.out.println("Da ghi " + danhSachHopDong.size() + " hop dong vao file: " + fileName);
        } catch (IOException e) {
            System.out.println("Loi ghi file hop dong: " + e.getMessage());
        }
    }
    
    public void hienThiDanhSachHopDong() {
        if (danhSachHopDong.isEmpty()) {
            System.out.println("Khong co hop dong nao de hien thi");
            return;
        }
        
        System.out.println("\nDANH SACH HOP DONG (" + danhSachHopDong.size() + " hop dong)");
        System.out.println("==========================================");
        for (int i = 0; i < danhSachHopDong.size(); i++) {
            System.out.println("\nHop dong thu " + (i + 1) + ":");
            danhSachHopDong.get(i).hienThiThongTin();
        }
    }
    
    public boolean kiemTraXeDaThue(Xe xe, LocalDate ngayThue, LocalDate ngayTra) {
        for (HopDong hd : danhSachHopDong) {
            if (hd.getXeThue().getBienSoXe().equals(xe.getBienSoXe())) {
                // Kiểm tra xung đột thời gian
                if (!(ngayTra.isBefore(hd.getNgayThue()) || ngayThue.isAfter(hd.getNgayTra()))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean coHopDongCuaXe(String bienSoXe) {
    for (HopDong hd : danhSachHopDong) {
        if (hd.getXeThue().getBienSoXe().equalsIgnoreCase(bienSoXe)) {
            return true;
        }
    }
    return false;
    }

    public List<HopDong> getDanhSachHopDong() {
        return danhSachHopDong;
    }

    public void hienThiHopDongTheoXe(String bienSoXe) {
    boolean found = false;
    for (HopDong hd : danhSachHopDong) {
        if (hd.getXeThue().getBienSoXe().equalsIgnoreCase(bienSoXe)) {
            if (!found) {
                System.out.println("CAC HOP DONG LIEN QUAN:");
                found = true;
            }
            hd.hienThiThongTin();
            System.out.println("---");
        }
    }
}
}