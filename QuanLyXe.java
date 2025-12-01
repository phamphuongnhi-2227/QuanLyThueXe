import java.util.*;
import java.io.*;

public class QuanLyXe implements IQuanLyXe, IReadWrite {
    private List<Xe> danhSachXe;
    private String fileName = "QuanLyXe.txt";
    
    public QuanLyXe() {
        this.danhSachXe = new ArrayList<>();
        readFile();
    }
    
    @Override
    public void themXe(Xe themXe) {
        if (themXe == null || themXe.getBienSoXe() == null) {
            System.out.println("Loi: Du lieu xe khong hop le!");
            return;
        }
        String bienSoMoi = themXe.getBienSoXe().trim();
        if (bienSoMoi.isEmpty()) {
            System.out.println("Loi: Bien so xe khong duoc de trong!");
            return;
        }
        for (Xe xe : danhSachXe) {
            if (xe.getBienSoXe().trim().equalsIgnoreCase(bienSoMoi)) {
                System.out.println("Loi: Bien so xe '" + bienSoMoi + "' da ton tai!");
                return;
            }
        }
        danhSachXe.add(themXe);
        System.out.println("Da them xe: " + themXe.getTenXe() + " - Bien so: " + bienSoMoi);
        writeFile();
    }
    
    @Override
    public Xe timKiem(String bienSoXe) {
        if (bienSoXe == null || bienSoXe.trim().isEmpty()) {
            return null;
        }
        String bienSoCanTim = bienSoXe.trim();
        for (Xe xe : danhSachXe) {
            if (xe.getBienSoXe().trim().equalsIgnoreCase(bienSoCanTim)) {
                return xe;
            }
        }
        return null;
    }
    
    @Override
    public void capNhat(String bienSoXe, Xe xeMoi) {
        if (bienSoXe == null || xeMoi == null) {
            System.out.println("Du lieu cap nhat khong hop le!");
            return;
        }
        String bienSoCanCapNhat = bienSoXe.trim();
        String bienSoMoi = xeMoi.getBienSoXe().trim();
        
        if (!bienSoCanCapNhat.equalsIgnoreCase(bienSoMoi)) {
            for (Xe xe : danhSachXe) {
                if (xe.getBienSoXe().trim().equalsIgnoreCase(bienSoMoi) && 
                    !xe.getBienSoXe().trim().equalsIgnoreCase(bienSoCanCapNhat)) {
                    System.out.println("Loi: Bien so moi '" + bienSoMoi + "' da ton tai!");
                    return;
                }
            }
        }
        for (int i = 0; i < danhSachXe.size(); i++) {
            if (danhSachXe.get(i).getBienSoXe().trim().equalsIgnoreCase(bienSoCanCapNhat)) {
                danhSachXe.set(i, xeMoi);
                System.out.println("Da cap nhat xe: " + bienSoCanCapNhat);
                writeFile();
                return;
            }
        }
        System.out.println("Khong tim thay xe: " + bienSoCanCapNhat);
    }
    
    @Override
    public void xoaXe(String bienSoXe) {
        if (bienSoXe == null || bienSoXe.trim().isEmpty()) {
            System.out.println("Bien so xe khong hop le!");
            return;
        }
            
        String bienSoCanXoa = bienSoXe.trim();
        for (int i = 0; i < danhSachXe.size(); i++) {
            if (danhSachXe.get(i).getBienSoXe().trim().equalsIgnoreCase(bienSoCanXoa)) {
                Xe xe = danhSachXe.remove(i);
                System.out.println("Da xoa xe: " + xe.getTenXe() + " - Bien so: " + bienSoCanXoa);
                writeFile();
                return;
            }        
        }
        System.out.println("Khong tim thay xe: " + bienSoCanXoa);
    }
    
    
    @Override
    public void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("Dang doc du lieu xe tu file...");
            int count = 0;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 3) {
                    String loaiXe = data[0];
                    String bienSo = data[1].trim();
                    String tenXe = data[2];
                    
                    if ("XeChoHang".equals(loaiXe) && data.length >= 4) {
                        double trongTai = Double.parseDouble(data[3]);
                        XeChoHang xe = new XeChoHang(bienSo, tenXe, trongTai);
                        danhSachXe.add(xe);
                        count++;
                    } else if ("XeDuLich".equals(loaiXe) && data.length >= 4) {
                        int soCho = Integer.parseInt(data[3]);
                        XeDuLich xe = new XeDuLich(bienSo, tenXe, soCho);
                        danhSachXe.add(xe);
                        count++;
                    }
                }
            }
            System.out.println("Da doc " + count + " xe tu file: " + fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " chua ton tai. Se tao moi khi ghi du lieu.");
        } catch (IOException e) {
            System.out.println("Loi doc file xe: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Loi dinh dang so trong file xe: " + e.getMessage());
        }
    }
    
    @Override
    public void writeFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            for (Xe xe : danhSachXe) {
                if (xe instanceof XeChoHang) {
                    XeChoHang xeChoHang = (XeChoHang) xe;
                    pw.println("XeChoHang," + xeChoHang.getBienSoXe().trim() + "," + 
                              xeChoHang.getTenXe() + "," + xeChoHang.getTrongTai());
                } else if (xe instanceof XeDuLich) {
                    XeDuLich xeDL = (XeDuLich) xe;
                    pw.println("XeDuLich," + xeDL.getBienSoXe().trim() + "," + 
                              xeDL.getTenXe() + "," + xeDL.getSoChoNgoi());
                }
            }
            System.out.println("Da ghi " + danhSachXe.size() + " xe vao file: " + fileName);
        } catch (IOException e) {
            System.out.println("Loi ghi file xe: " + e.getMessage());
        }
    }
    
    public void hienThiDanhSachXe() {
        if (danhSachXe.isEmpty()) {
            System.out.println("Khong co xe nao de hien thi");
            return;
        }
        
        System.out.println("\nDANH SACH XE (" + danhSachXe.size() + " xe)");
        System.out.println("==========================================");
        for (int i = 0; i < danhSachXe.size(); i++) {
            System.out.println("\nXe thu " + (i + 1) + ":");
            danhSachXe.get(i).hienThiThongTin();
        }
    }
    
    public List<Xe> getDanhSachXe() {
        return danhSachXe;
    }
}