import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {
    private static QuanLyXe quanLyXe = new QuanLyXe();
    private static QuanLyKhachHang quanLyKhachHang = new QuanLyKhachHang();
    private static QuanLyHopDong quanLyHopDong = new QuanLyHopDong(quanLyXe, quanLyKhachHang);
    private static Scanner scanner = new Scanner(System.in);
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public static void main(String[] args) {
        System.out.println("Da tai du lieu tu file!");
        
        int luaChon;
        do {
            hienThiMenu();
            System.out.print("Nhap lua chon cua ban: ");
            try {
                luaChon = scanner.nextInt();
                scanner.nextLine();
                
                switch (luaChon) {
                    case 1:
                        menuQuanLyXe();
                        break;
                    case 2:
                        menuQuanLyKhachHang();
                        break;
                    case 3:
                        menuQuanLyHopDong();
                        break;
                    case 4:
                        menuThongKe();
                        break;
                    case 0:
                        System.out.println("\nTam biet! Da tu dong luu du lieu!");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le! Vui long chon 0-4.");
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Vui long nhap so!");
                scanner.nextLine();
                luaChon = -1;
            }
            
        } while (luaChon != 0);
        
        scanner.close();
    }
    
    private static void hienThiMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("HE THONG QUAN LY THUE XE");
        System.out.println("=".repeat(50));
        System.out.println("1. Quan ly xe");
        System.out.println("2. Quan ly khach hang");
        System.out.println("3. Quan ly hop dong");
        System.out.println("4. Thong ke & Bao cao");
        System.out.println("0. Thoat (tu dong luu)");
        System.out.println("=".repeat(50));
    }
    
    // ==================== MENU QUẢN LÝ XE ====================
    private static void menuQuanLyXe() {
        int luaChon;
        do {
            System.out.println("\n=== QUAN LY XE ===");
            System.out.println("1. Them xe moi");
            System.out.println("2. Hien thi danh sach xe");
            System.out.println("3. Tim kiem xe");
            System.out.println("4. Cap nhat thong tin xe");
            System.out.println("5. Xoa xe");
            System.out.println("0. Quay lai menu chinh");
            System.out.print("Nhap lua chon: ");
            
            try {
                luaChon = scanner.nextInt();
                scanner.nextLine();
                
                switch (luaChon) {
                    case 1:
                        themXeMoi();
                        break;
                    case 2:
                        quanLyXe.hienThiDanhSachXe();
                        break;
                    case 3:
                        timKiemXe();
                        break;
                    case 4:
                        capNhatThongTinXe();
                        break;
                    case 5:
                        xoaXe();
                        break;
                    case 0:
                        System.out.println("Quay lai menu chinh.");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le! Vui long chon 0-5.");
                }
                
                if (luaChon != 0) {
                    System.out.println("\nNhan Enter de tiep tuc...");
                    scanner.nextLine();
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Vui long nhap so!");
                scanner.nextLine();
                luaChon = -1;
            }
            
        } while (luaChon != 0);
    }
    
    // ==================== MENU QUẢN LÝ KHÁCH HÀNG ====================
    private static void menuQuanLyKhachHang() {
        int luaChon;
        do {
            System.out.println("\n=== QUAN LY KHACH HANG ===");
            System.out.println("1. Them khach hang moi");
            System.out.println("2. Hien thi danh sach khach hang");
            System.out.println("3. Tim kiem khach hang");
            System.out.println("4. Cap nhat thong tin khach hang");
            System.out.println("5. Xoa khach hang");
            System.out.println("0. Quay lai menu chinh");
            System.out.print("Nhap lua chon: ");
            
            try {
                luaChon = scanner.nextInt();
                scanner.nextLine();
                
                switch (luaChon) {
                    case 1:
                        themKhachHangTrongMenu();
                        break;
                    case 2:
                        quanLyKhachHang.hienThiDanhSachKhachHang();
                        break;
                    case 3:
                        timKiemKhachHang();
                        break;
                    case 4:
                        capNhatThongTinKhachHang();
                        break;
                    case 5:
                        xoaKhachHang();
                        break;
                    case 0:
                        System.out.println("Quay lai menu chinh.");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le! Vui long chon 0-5.");
                }
                
                if (luaChon != 0) {
                    System.out.println("\nNhan Enter de tiep tuc...");
                    scanner.nextLine();
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Vui long nhap so!");
                scanner.nextLine();
                luaChon = -1;
            }
            
        } while (luaChon != 0);
    }
    
    // ==================== MENU QUẢN LÝ HỢP ĐỒNG ====================
    private static void menuQuanLyHopDong() {
        int luaChon;
        do {
            System.out.println("\n=== QUAN LY HOP DONG ===");
            System.out.println("1. Them hop dong thue moi");
            System.out.println("2. Hien thi danh sach hop dong");
            System.out.println("3. Tim kiem hop dong");
            System.out.println("4. Cap nhat thong tin hop dong");
            System.out.println("5. Xoa hop dong");
            System.out.println("0. Quay lai menu chinh");
            System.out.print("Nhap lua chon: ");
            
            try {
                luaChon = scanner.nextInt();
                scanner.nextLine();
                
                switch (luaChon) {
                    case 1:
                        themHopDongMoi();
                        break;
                    case 2:
                        quanLyHopDong.hienThiDanhSachHopDong();
                        break;
                    case 3:
                        timKiemHopDong();
                        break;
                    case 4:
                        capNhatThongTinHopDong();
                        break;
                    case 5:
                        xoaHopDong();
                        break;
                    case 0:
                        System.out.println("Quay lai menu chinh.");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le! Vui long chon 0-5.");
                }
                
                if (luaChon != 0) {
                    System.out.println("\nNhan Enter de tiep tuc...");
                    scanner.nextLine();
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Vui long nhap so!");
                scanner.nextLine();
                luaChon = -1;
            }
            
        } while (luaChon != 0);
    }
    
    // ==================== MENU THỐNG KÊ ====================
    private static void menuThongKe() {
        int luaChon;
        do {
            System.out.println("\n=== THONG KE & BAO CAO ===");
            System.out.println("1. Thong ke tong quan");
            System.out.println("2. Thong ke doanh thu");
            System.out.println("3. Top khach hang than thiet");
            System.out.println("4. Top xe duoc thue nhieu nhat");
            System.out.println("5. Bao cao theo thang");
            System.out.println("0. Quay lai menu chinh");
            System.out.print("Nhap lua chon: ");
            
            try {
                luaChon = scanner.nextInt();
                scanner.nextLine();
                
                switch (luaChon) {
                    case 1:
                        thongKeTongQuan();
                        break;
                    case 2:
                        thongKeDoanhThu();
                        break;
                    case 3:
                        thongKeKhachHangThanThiet();
                        break;
                    case 4:
                        thongKeXeDuocThueNhieuNhat();
                        break;
                    case 5:
                        baoCaoTheoThang();
                        break;
                    case 0:
                        System.out.println("Quay lai menu chinh.");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le! Vui long chon 0-5.");
                }
                
                if (luaChon != 0) {
                    System.out.println("\nNhan Enter de tiep tuc...");
                    scanner.nextLine();
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Vui long nhap so!");
                scanner.nextLine();
                luaChon = -1;
            }
            
        } while (luaChon != 0);
    }
    
    // ==================== CÁC PHƯƠNG THỨC XỬ LÝ XE ====================
    private static void themXeMoi() {
        System.out.println("\nTHEM XE MOI");
        System.out.println("1. Xe cho hang");
        System.out.println("2. Xe du lich");
        System.out.print("Chon loai xe: ");
        
        int loai = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Nhap bien so xe: ");
        String bienSo = scanner.nextLine().trim();
        
        if (bienSo.isEmpty()) {
            System.out.println("Bien so xe khong duoc de trong!");
            return;
        }
        
        Xe xeExist = quanLyXe.timKiem(bienSo);
        if (xeExist != null) {
            System.out.println("Bien so '" + bienSo + "' da ton tai!");
            return;
        }
        
        System.out.print("Nhap ten xe: ");
        String tenXe = scanner.nextLine();
        
        if (loai == 1) {
            System.out.print("Nhap trong tai (tan): ");
            double trongTai = scanner.nextDouble();
            scanner.nextLine();
            
            XeChoHang xe = new XeChoHang(bienSo, tenXe, trongTai);
            quanLyXe.themXe(xe);
            
        } else if (loai == 2) {
            System.out.print("Nhap so cho ngoi: ");
            int soCho = scanner.nextInt();
            scanner.nextLine();
            
            XeDuLich xe = new XeDuLich(bienSo, tenXe, soCho);
            quanLyXe.themXe(xe);
        } else {
            System.out.println("Loai xe khong hop le!");
        }
    }
    
    private static void timKiemXe() {
        System.out.print("\nNhap bien so xe can tim: ");
        String bienSo = scanner.nextLine();
        Xe xe = quanLyXe.timKiem(bienSo);
        if (xe != null) {
            System.out.println("\nTim thay xe:");
            xe.hienThiThongTin();
        } else {
            System.out.println("Khong tim thay xe voi bien so: " + bienSo);
        }
    }
    
    
        
    private static void xoaXe() {
        System.out.print("\nNhap bien so xe can xoa: ");
        String bienSo = scanner.nextLine();
        
        // Kiểm tra xe có tồn tại không
        Xe xe = quanLyXe.timKiem(bienSo);
        if (xe == null) {
            System.out.println("Khong tim thay xe voi bien so: " + bienSo);
            return;
        }
        
    if (quanLyHopDong.coHopDongCuaXe(bienSo)) {
        System.out.println("KHONG THE XOA! Xe nay dang co hop dong thue.");
        System.out.println("Vui long xoa cac hop dong lien quan truoc khi xoa xe.");
        
        quanLyHopDong.hienThiHopDongTheoXe(bienSo);
        
        System.out.print("\nBan co muon xoa tat ca hop dong va xe nay? (y/n): ");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("y")) {

            List<HopDong> hopDongsToRemove = new ArrayList<>();
            for (HopDong hd : quanLyHopDong.getDanhSachHopDong()) {
                if (hd.getXeThue().getBienSoXe().equalsIgnoreCase(bienSo)) {
                    hopDongsToRemove.add(hd);
                }
            }
            
            for (HopDong hd : hopDongsToRemove) {
                quanLyHopDong.xoaHopDong(hd.getMaHD());
            }

            quanLyXe.xoaXe(bienSo);
        } else {
            System.out.println("Da huy thao tac xoa.");
        }
    } else {
        quanLyXe.xoaXe(bienSo);
    }
}
private static void capNhatThongTinXe() {
    System.out.print("Nhap bien so xe can cap nhat: ");
    String bienSo = scanner.nextLine().trim();
    
    Xe xeCu = quanLyXe.timKiem(bienSo);
    if (xeCu == null) {
        System.out.println("Khong tim thay xe voi bien so: " + bienSo);
        return;
    }
    
    System.out.print("Bien so moi (de trong neu giu nguyen): ");
    String bienSoMoi = scanner.nextLine().trim();
    
    if (!bienSoMoi.isEmpty() && !bienSoMoi.equals(bienSo)) {

        if (quanLyXe.timKiem(bienSoMoi) != null) {
            System.out.println("Bien so moi '" + bienSoMoi + "' da ton tai!");
            return;
        }
        
        if (quanLyHopDong.coHopDongCuaXe(bienSo)) {
            System.out.println("KHONG THE DOI BIEN SO! Xe nay dang co hop dong thue.");
            System.out.println("Vui long xoa hoac cap nhat cac hop dong lien quan truoc.");
            quanLyHopDong.hienThiHopDongTheoXe(bienSo);
            return;
        }
    } else {
        bienSoMoi = bienSo;
    }
    }

    // ==================== CÁC PHƯƠNG THỨC XỬ LÝ KHÁCH HÀNG ====================
    private static KhachHang themKhachHangMoi() {
        System.out.println("\nTHEM KHACH HANG MOI");
        System.out.print("Ma khach hang (nhap '0' de huy): ");
        String maKH = scanner.nextLine();
        
        if (maKH.equals("0")) {
            System.out.println("Da huy thao tac them khach hang.");
            return null;
        }
        
        if (quanLyKhachHang.timKiem(maKH) != null) {
            System.out.println("Ma khach hang da ton tai!");
            return null;
        }
        
        System.out.print("Ten khach hang: ");
        String tenKH = scanner.nextLine();
        System.out.print("So CCCD: ");
        String cccd = scanner.nextLine();
        System.out.print("Dia chi: ");
        String diaChi = scanner.nextLine();
        System.out.print("So dien thoai: ");
        String sdt = scanner.nextLine();
        
        KhachHang kh = new KhachHang(maKH, tenKH, cccd, diaChi, sdt);
        quanLyKhachHang.themKhachHang(kh);
        return kh;
    }
    
    private static void themKhachHangTrongMenu() {
        KhachHang kh = themKhachHangMoi();
        if (kh != null) {
            System.out.println("Da them khach hang thanh cong: " + kh.getTenKH());
        } else {
            System.out.println("Them khach hang that bai!");
        }
    }
    
    private static void timKiemKhachHang() {
        System.out.print("\nNhap ma khach hang hoac ten can tim: ");
        String keyword = scanner.nextLine();
        
        boolean found = false;
        for (KhachHang kh : quanLyKhachHang.getDanhSachKhachHang()) {
            if (kh.getMaKH().toLowerCase().contains(keyword.toLowerCase()) || 
                kh.getTenKH().toLowerCase().contains(keyword.toLowerCase())) {
                if (!found) {
                    System.out.println("Ket qua tim kiem:");
                    found = true;
                }
                kh.hienThiThongTin();
                System.out.println("---");
            }
        }
        
        if (!found) {
            System.out.println("Khong tim thay khach hang phu hop.");
        }
    }
    
    private static void capNhatThongTinKhachHang() {
        System.out.println("\nCAP NHAT THONG TIN KHACH HANG");
        
        if (quanLyKhachHang.getDanhSachKhachHang().isEmpty()) {
            System.out.println("Khong co khach hang nao de cap nhat!");
            return;
        }
        
        quanLyKhachHang.hienThiDanhSachKhachHang();
        
        System.out.print("Nhap ma khach hang can cap nhat: ");
        String maKH = scanner.nextLine();
        
        KhachHang khCu = quanLyKhachHang.timKiem(maKH);
        if (khCu == null) {
            System.out.println("Khong tim thay khach hang voi ma: " + maKH);
            return;
        }
        
        System.out.println("\nThong tin hien tai:");
        khCu.hienThiThongTin();
        
        System.out.println("\nNhap thong tin moi (de trong neu giu nguyen):");
        System.out.print("Ten khach hang: ");
        String tenMoi = scanner.nextLine();
        if (tenMoi.trim().isEmpty()) {
            tenMoi = khCu.getTenKH();
        }
        
        System.out.print("So CCCD: ");
        String cccdMoi = scanner.nextLine();
        if (cccdMoi.trim().isEmpty()) {
            cccdMoi = khCu.getSoCCCD();
        }
        
        System.out.print("Dia chi: ");
        String diaChiMoi = scanner.nextLine();
        if (diaChiMoi.trim().isEmpty()) {
            diaChiMoi = khCu.getDiaChi();
        }
        
        System.out.print("So dien thoai: ");
        String sdtMoi = scanner.nextLine();
        if (sdtMoi.trim().isEmpty()) {
            sdtMoi = khCu.getSDT();
        }
        
        KhachHang khMoi = new KhachHang(maKH, tenMoi, cccdMoi, diaChiMoi, sdtMoi);
        
        System.out.println("\nThong tin moi se cap nhat:");
        khMoi.hienThiThongTin();
        System.out.print("\nBan co chac chan muon cap nhat? (y/n): ");
        String confirm = scanner.nextLine();
        
        if (confirm.equalsIgnoreCase("y")) {
            quanLyKhachHang.capNhatKhachHang(maKH, khMoi);
        } else {
            System.out.println("Da huy thao tac cap nhat.");
        }
    }
    
    private static void xoaKhachHang() {
        System.out.println("\nXOA KHACH HANG");
        
        if (quanLyKhachHang.getDanhSachKhachHang().isEmpty()) {
            System.out.println("Khong co khach hang nao de xoa!");
            return;
        }
        
        quanLyKhachHang.hienThiDanhSachKhachHang();
        
        System.out.print("Nhap ma khach hang can xoa: ");
        String maKH = scanner.nextLine();
        
        KhachHang kh = quanLyKhachHang.timKiem(maKH);
        if (kh == null) {
            System.out.println("Khong tim thay khach hang voi ma: " + maKH);
            return;
        }
        
        if (quanLyKhachHang.coHopDong(maKH, quanLyHopDong)) {
            System.out.println("KHONG THE XOA! Khach hang nay co hop dong thue xe.");
            System.out.println("Vui long xoa cac hop dong lien quan truoc khi xoa khach hang.");
            
            System.out.println("\nCAC HOP DONG LIEN QUAN:");
            boolean coHopDong = false;
            for (HopDong hd : quanLyHopDong.getDanhSachHopDong()) {
                if (hd.getKhachHangThue().getMaKH().equalsIgnoreCase(maKH)) {
                    hd.hienThiThongTin();
                    System.out.println("---");
                    coHopDong = true;
                }
            }
            
            if (coHopDong) {
                System.out.print("\nBan co muon xoa tat ca hop dong va khach hang nay? (y/n): ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("y")) {
                    for (int i = quanLyHopDong.getDanhSachHopDong().size() - 1; i >= 0; i--) {
                        HopDong hd = quanLyHopDong.getDanhSachHopDong().get(i);
                        if (hd.getKhachHangThue().getMaKH().equalsIgnoreCase(maKH)) {
                            quanLyHopDong.xoaHopDong(hd.getMaHD());
                        }
                    }
                    quanLyKhachHang.xoaKhachHang(maKH);
                } else {
                    System.out.println("Da huy thao tac xoa.");
                }
            }
        } else {
            System.out.println("\nThong tin khach hang se xoa:");
            kh.hienThiThongTin();
            System.out.print("\nBan co chac chan muon xoa khach hang nay? (y/n): ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("y")) {
                quanLyKhachHang.xoaKhachHang(maKH);
            } else {
                System.out.println("Da huy thao tac xoa.");
            }
        }
    }
    
    // ==================== CÁC PHƯƠNG THỨC XỬ LÝ HỢP ĐỒNG ====================
    private static void themHopDongMoi() {
        System.out.println("\nTHEM HOP DONG THUE XE");
        
        if (quanLyXe.getDanhSachXe().isEmpty()) {
            System.out.println("Khong co xe nao de thue! Vui long them xe truoc.");
            return;
        }
        
        quanLyXe.hienThiDanhSachXe();
        
        System.out.print("Nhap bien so xe muon thue: ");
        String bienSo = scanner.nextLine();
        Xe xe = quanLyXe.timKiem(bienSo);
        if (xe == null) {
            System.out.println("Khong tim thay xe!");
            return;
        }
        
        KhachHang khachHang = chonKhachHang();
        if (khachHang == null) {
            System.out.println("Da huy thao tac them hop dong.");
            return;
        }
        
        if (quanLyKhachHang.timKiem(khachHang.getMaKH()) == null) {
            System.out.println("Khach hang da bi xoa khoi he thong! Vui long chon khach hang khac.");
            return;
        }
        
        System.out.print("Nhap ma hop dong: ");
        String maHD = scanner.nextLine();
        
        if (quanLyHopDong.timKiemHopDong(maHD) != null) {
            System.out.println("Ma hop dong da ton tai!");
            return;
        }
        
        System.out.print("Nhap tien dat coc: ");
        double tienDatCoc = scanner.nextDouble();
        scanner.nextLine();
        
        LocalDate ngayThue = nhapNgay("Nhap ngay thue (dd/MM/yyyy): ");
        LocalDate ngayTra = nhapNgay("Nhap ngay tra (dd/MM/yyyy): ");
        
        if (ngayTra.isBefore(ngayThue)) {
            System.out.println("Ngay tra phai sau ngay thue!");
            return;
        }
        
        if (quanLyHopDong.kiemTraXeDaThue(xe, ngayThue, ngayTra)) {
            System.out.println("Xe da duoc thue trong khoang thoi gian nay! Vui long chon xe khac hoac thay doi ngay thue.");
            return;
        }
        
        HopDong hd = new HopDong(xe, khachHang, maHD, tienDatCoc, ngayThue, ngayTra);
        quanLyHopDong.themHopDong(hd);
    }
    
    private static KhachHang chonKhachHang() {
        int choice;
        do {
            System.out.println("\nCHON KHACH HANG");
            System.out.println("1. Khach hang moi");
            System.out.println("2. Khach hang co san");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                
                switch (choice) {
                    case 1:
                        KhachHang khMoi = themKhachHangMoi();
                        if (khMoi != null) {
                            return khMoi;
                        }
                        break;
                    case 2:
                        if (quanLyKhachHang.getDanhSachKhachHang().isEmpty()) {
                            System.out.println("Khong co khach hang nao! Vui long tao khach hang moi.");
                            break;
                        }
                        
                        quanLyKhachHang.hienThiDanhSachKhachHang();
                        System.out.print("Nhap ma khach hang: ");
                        String maKH = scanner.nextLine();
                        KhachHang kh = quanLyKhachHang.timKiem(maKH);
                        if (kh == null) {
                            System.out.println("Khong tim thay khach hang! Vui long thu lai.");
                            break;
                        }
                        
                        boolean tonTai = false;
                        for (KhachHang k : quanLyKhachHang.getDanhSachKhachHang()) {
                            if (k.getMaKH().equals(maKH)) {
                                tonTai = true;
                                break;
                            }
                        }
                        
                        if (!tonTai) {
                            System.out.println("Khach hang da bi xoa! Vui long chon khach hang khac.");
                            break;
                        }
                        
                        return kh;
                    case 0:
                        System.out.println("Quay lai.");
                        return null;
                    default:
                        System.out.println("Lua chon khong hop le! Vui long chon 0-2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Vui long nhap so!");
                scanner.nextLine();
                choice = -1;
            }
            
        } while (true);
    }
    
    private static void timKiemHopDong() {
        System.out.print("\nNhap ma hop dong can tim: ");
        String maHD = scanner.nextLine();
        HopDong hd = quanLyHopDong.timKiemHopDong(maHD);
        if (hd != null) {
            System.out.println("\nTim thay hop dong:");
            hd.hienThiThongTin();
        } else {
            System.out.println("Khong tim thay hop dong: " + maHD);
        }
    }
    
    private static void capNhatThongTinHopDong() {
        System.out.println("\nCAP NHAT THONG TIN HOP DONG");
        
        if (quanLyHopDong.getDanhSachHopDong().isEmpty()) {
            System.out.println("Khong co hop dong nao de cap nhat!");
            return;
        }
        
        quanLyHopDong.hienThiDanhSachHopDong();
        
        System.out.print("Nhap ma hop dong can cap nhat: ");
        String maHD = scanner.nextLine();
        
        HopDong hdCu = quanLyHopDong.timKiemHopDong(maHD);
        if (hdCu == null) {
            System.out.println("Khong tim thay hop dong voi ma: " + maHD);
            return;
        }
        
        System.out.println("\nThong tin hien tai:");
        hdCu.hienThiThongTin();
        
        System.out.println("\nNhap thong tin moi:");
        
        quanLyXe.hienThiDanhSachXe();
        System.out.print("Nhap bien so xe moi (de trong neu giu nguyen): ");
        String bienSoMoi = scanner.nextLine();
        Xe xeMoi = null;
        if (!bienSoMoi.trim().isEmpty()) {
            xeMoi = quanLyXe.timKiem(bienSoMoi);
            if (xeMoi == null) {
                System.out.println("Khong tim thay xe voi bien so: " + bienSoMoi);
                return;
            }
        } else {
            xeMoi = hdCu.getXeThue();
        }
        
        quanLyKhachHang.hienThiDanhSachKhachHang();
        System.out.print("Nhap ma khach hang moi (de trong neu giu nguyen): ");
        String maKHMoi = scanner.nextLine();
        KhachHang khMoi = null;
        if (!maKHMoi.trim().isEmpty()) {
            khMoi = quanLyKhachHang.timKiem(maKHMoi);
            if (khMoi == null) {
                System.out.println("Khong tim thay khach hang voi ma: " + maKHMoi);
                return;
            }
        } else {
            khMoi = hdCu.getKhachHangThue();
        }
        
        System.out.print("Nhap tien dat coc moi (" + hdCu.getTienDatCoc() + " VND, nhap 0 neu giu nguyen): ");
        double tienCocMoi = scanner.nextDouble();
        scanner.nextLine();
        if (tienCocMoi == 0) {
            tienCocMoi = hdCu.getTienDatCoc();
        }
        
        LocalDate ngayThueMoi = nhapNgay("Nhap ngay thue moi (dd/MM/yyyy): ");
        LocalDate ngayTraMoi = nhapNgay("Nhap ngay tra moi (dd/MM/yyyy): ");
        
        if (ngayTraMoi.isBefore(ngayThueMoi)) {
            System.out.println("Ngay tra phai sau ngay thue!");
            return;
        }
        
        for (HopDong hd : quanLyHopDong.getDanhSachHopDong()) {
            if (hd.getMaHD().equals(maHD)) continue;
            
            if (hd.getXeThue().getBienSoXe().equals(xeMoi.getBienSoXe())) {
                if (!(ngayTraMoi.isBefore(hd.getNgayThue()) || ngayThueMoi.isAfter(hd.getNgayTra()))) {
                    System.out.println("Xe da duoc thue trong khoang thoi gian nay! Vui long chon xe khac hoac thay doi ngay thue.");
                    return;
                }
            }
        }
        
        HopDong hdMoi = new HopDong(xeMoi, khMoi, maHD, tienCocMoi, ngayThueMoi, ngayTraMoi);
        
        System.out.println("\nThong tin moi se cap nhat:");
        hdMoi.hienThiThongTin();
        System.out.print("\nBan co chac chan muon cap nhat? (y/n): ");
        String confirm = scanner.nextLine();
        
        if (confirm.equalsIgnoreCase("y")) {
            quanLyHopDong.capNhatHopDong(maHD, hdMoi);
        } else {
            System.out.println("Da huy thao tac cap nhat.");
        }
    }
    
    private static void xoaHopDong() {
        System.out.print("\nNhap ma hop dong can xoa: ");
        String maHD = scanner.nextLine();
        quanLyHopDong.xoaHopDong(maHD);
    }
    
    // ==================== CÁC PHƯƠNG THỨC THỐNG KÊ ====================
    private static void thongKeTongQuan() {
        System.out.println("\n=== THONG KE TONG QUAN ===");
        System.out.println("Tong so hop dong: " + quanLyHopDong.getDanhSachHopDong().size());
        System.out.println("Tong so khach hang: " + quanLyKhachHang.getDanhSachKhachHang().size());
        System.out.println("Tong so xe: " + quanLyXe.getDanhSachXe().size());

        int xeChoHang = 0, xeDuLich = 0;
        for (Xe xe : quanLyXe.getDanhSachXe()) {
            if (xe instanceof XeChoHang) xeChoHang++;
            else if (xe instanceof XeDuLich) xeDuLich++;
        }
        System.out.println(" - Xe cho hang: " + xeChoHang);
        System.out.println(" - Xe du lich: " + xeDuLich);
    }
    
    private static void thongKeDoanhThu() {
        System.out.println("\n=== THONG KE DOANH THU ===");
        double tongDoanhThu = 0;
        for (HopDong hd : quanLyHopDong.getDanhSachHopDong()) {
            tongDoanhThu += hd.tinhTienThueXe();
        }
        System.out.println("Tong doanh thu: " + tongDoanhThu + " VND");
        
        double doanhThuXeChoHang = 0, doanhThuXeDuLich = 0;
        for (HopDong hd : quanLyHopDong.getDanhSachHopDong()) {
            if (hd.getXeThue() instanceof XeChoHang) {
                doanhThuXeChoHang += hd.tinhTienThueXe();
            } else if (hd.getXeThue() instanceof XeDuLich) {
                doanhThuXeDuLich += hd.tinhTienThueXe();
            }
        }
        System.out.println(" - Doanh thu xe cho hang: " + doanhThuXeChoHang + " VND");
        System.out.println(" - Doanh thu xe du lich: " + doanhThuXeDuLich + " VND");
    }
    
    private static void thongKeKhachHangThanThiet() {
        System.out.println("\n=== TOP KHACH HANG THAN THIET ===");
        
        Map<String, Integer> thongKeKH = new HashMap<>();
        Map<String, Double> doanhThuKH = new HashMap<>();
        
        for (HopDong hd : quanLyHopDong.getDanhSachHopDong()) {
            String maKH = hd.getKhachHangThue().getMaKH();
            thongKeKH.put(maKH, thongKeKH.getOrDefault(maKH, 0) + 1);
            doanhThuKH.put(maKH, doanhThuKH.getOrDefault(maKH, 0.0) + hd.tinhTienThueXe());
        }
        
        thongKeKH.entrySet().stream()
            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
            .limit(5)
            .forEach(entry -> {
                String maKH = entry.getKey();
                KhachHang kh = quanLyKhachHang.timKiem(maKH);
                if (kh != null) {
                    System.out.println(kh.getTenKH() + " (" + maKH + ")");
                    System.out.println("  - So hop dong: " + entry.getValue());
                    System.out.println("  - Tong chi tieu: " + doanhThuKH.get(maKH) + " VND");
                }
            });
    }
    
    private static void thongKeXeDuocThueNhieuNhat() {
        System.out.println("\n=== TOP XE DUOC THUE NHIEU NHAT ===");
        
        Map<String, Integer> thongKeXe = new HashMap<>();
        
        for (HopDong hd : quanLyHopDong.getDanhSachHopDong()) {
            String bienSo = hd.getXeThue().getBienSoXe();
            thongKeXe.put(bienSo, thongKeXe.getOrDefault(bienSo, 0) + 1);
        }
        
        thongKeXe.entrySet().stream()
            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
            .limit(5)
            .forEach(entry -> {
                String bienSo = entry.getKey();
                Xe xe = quanLyXe.timKiem(bienSo);
                if (xe != null) {
                    System.out.println(xe.getTenXe() + " (" + bienSo + ")");
                    System.out.println("  - So lan duoc thue: " + entry.getValue());
                }
            });
    }
    
    private static void baoCaoTheoThang() {
        System.out.println("\n=== BAO CAO THEO THANG ===");
        System.out.print("Nhap thang (1-12): ");
        int thang = scanner.nextInt();
        System.out.print("Nhap nam: ");
        int nam = scanner.nextInt();
        scanner.nextLine();
        
        double doanhThuThang = 0;
        int soHopDongThang = 0;
        
        for (HopDong hd : quanLyHopDong.getDanhSachHopDong()) {
            if (hd.getNgayThue().getMonthValue() == thang && hd.getNgayThue().getYear() == nam) {
                doanhThuThang += hd.tinhTienThueXe();
                soHopDongThang++;
            }
        }
        
        System.out.println("Bao cao thang " + thang + "/" + nam + ":");
        System.out.println(" - So hop dong: " + soHopDongThang);
        System.out.println(" - Doanh thu: " + doanhThuThang + " VND");
    }
    
    // ==================== PHƯƠNG THỨC HỖ TRỢ ====================
    private static LocalDate nhapNgay(String message) {
        while (true) {
            try {
                System.out.print(message);
                String ngayStr = scanner.nextLine();
                return LocalDate.parse(ngayStr, dateFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("Dinh dang ngay khong dung! Vui long nhap theo dinh dang dd/MM/yyyy");
            }
        }
    }
}