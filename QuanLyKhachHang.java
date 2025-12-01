import java.util.*;
import java.io.*;

public class QuanLyKhachHang implements IQuanLyKhachHang, IReadWrite {
    private List<KhachHang> danhSachKhachHang;
    private String fileName = "QuanLyKhachHang.txt";
    
    public QuanLyKhachHang() {
        this.danhSachKhachHang = new ArrayList<>();
        readFile();
    }
    @Override
    public void themKhachHang(KhachHang kh) {
        for (KhachHang k : danhSachKhachHang) {
            if (k.getMaKH().equals(kh.getMaKH())) {
                System.out.println("Loi: Ma khach hang da ton tai!");
                return;
            }
        }
        danhSachKhachHang.add(kh);
        writeFile();
        System.out.println("Da them khach hang: " + kh.getTenKH());
    }
    @Override
    public KhachHang timKiem(String maKH) {
        for (KhachHang kh : danhSachKhachHang) {
            if (kh.getMaKH().equalsIgnoreCase(maKH)) {
                return kh;
            }
        }
        return null;
    }
    @Override
    public void capNhatKhachHang(String maKH, KhachHang khachHangMoi) {
        for (int i = 0; i < danhSachKhachHang.size(); i++) {
            if (danhSachKhachHang.get(i).getMaKH().equalsIgnoreCase(maKH)) {
                danhSachKhachHang.set(i, khachHangMoi);
                writeFile();
                System.out.println("Da cap nhat khach hang: " + maKH);
                return;
            }
        }
        System.out.println("Khong tim thay khach hang voi ma: " + maKH);
    }

    @Override
    public boolean xoaKhachHang(String maKH) {
        for (int i = 0; i < danhSachKhachHang.size(); i++) {
            if (danhSachKhachHang.get(i).getMaKH().equalsIgnoreCase(maKH)) {
                KhachHang kh = danhSachKhachHang.remove(i);
                writeFile();
                System.out.println("Da xoa khach hang: " + kh.getTenKH() + " (" + maKH + ")");
                return true;
            }
        }
        System.out.println("Khong tim thay khach hang voi ma: " + maKH);
        return false;
    }
    
    @Override
    public boolean coHopDong(String maKH, QuanLyHopDong quanLyHopDong) {
        for (HopDong hd : quanLyHopDong.getDanhSachHopDong()) {
            if (hd.getKhachHangThue().getMaKH().equalsIgnoreCase(maKH)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void hienThiDanhSachKhachHang() {
        if (danhSachKhachHang.isEmpty()) {
            System.out.println("Khong co khach hang nao!");
            return;
        }
        
        System.out.println("\nDANH SACH KHACH HANG (" + danhSachKhachHang.size() + " khach hang)");
        System.out.println("==========================================");
        for (int i = 0; i < danhSachKhachHang.size(); i++) {
            System.out.println("\nKhach hang thu " + (i + 1) + ":");
            danhSachKhachHang.get(i).hienThiThongTin();
        }
    }
    
    @Override 
    public void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("Dang doc du lieu khach hang tu file...");
            int count = 0;
            while ((line = br.readLine()) != null) {
                System.out.println("Debug: Doc dong: " + line); 
                String[] data = line.split(",");
                if (data.length >= 5) {
                    KhachHang kh = new KhachHang(data[0], data[1], data[2], data[3], data[4]);
                    danhSachKhachHang.add(kh);
                    count++;
                } else {
                    System.out.println("Warning: Dong khong du du lieu: " + line);
                }
            }
            System.out.println("Da doc " + count + " khach hang tu file: " + fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " chua ton tai. Se tao moi khi ghi du lieu.");
        } catch (IOException e) {
            System.out.println("Loi doc file KH: " + e.getMessage());
            e.printStackTrace(); 
        }
    }
    
    @Override
    public void writeFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            for (KhachHang kh : danhSachKhachHang) {
                pw.println(kh.getMaKH() + "," + kh.getTenKH() + "," + 
                          kh.getSoCCCD() + "," + kh.getDiaChi() + "," + kh.getSDT());
            }
            System.out.println("Da ghi " + danhSachKhachHang.size() + " khach hang vao file: " + fileName);
        } catch (IOException e) {
            System.out.println("Loi ghi file KH: " + e.getMessage());
        }
    }
    
    public List<KhachHang> getDanhSachKhachHang() {
        return danhSachKhachHang;
    }
}