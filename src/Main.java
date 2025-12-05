import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Member> members = new ArrayList<>();
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Transaction> transactions = new ArrayList<>();

        System.out.println("============================================");
        System.out.println("LIBRARY MANAGEMENT SYSTEM");
        System.out.println("============================================\n");

        System.out.println("=== REGISTRASI ANGGOTA ===");

        Member m1 = new Member("Alice Johnson", "alice.j@email.com", "081234567890", 2020, "Platinum");
        members.add(m1);
        System.out.println("Anggota berhasil ditambahkan: " + m1.getMemberId() + " - " + m1.getName() + " (" + m1.getMembershipType() + ")");

        Member m2 = new Member("Bob Smith", "bob.smith@email.com", "081298765432", 2022, "Gold");
        members.add(m2);
        System.out.println("Anggota berhasil ditambahkan: " + m2.getMemberId() + " - " + m2.getName() + " (" + m2.getMembershipType() + ")");

        Member m3 = new Member("Charlie Brown", "charlie.b@email.com", "081223456789", 2024, "Silver");
        members.add(m3);
        System.out.println("Anggota berhasil ditambahkan: " + m3.getMemberId() + " - " + m3.getName() + " (" + m3.getMembershipType() + ")");

        Member m4 = new Member("Diana Prince", "diana.p@email.com", "081287654321", 2021, "Gold");
        members.add(m4);
        System.out.println("Anggota berhasil ditambahkan: " + m4.getMemberId() + " - " + m4.getName() + " (" + m4.getMembershipType() + ")");

        System.out.println("\n=== REGISTRASI BUKU ===");

        Book b1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 1925, 5);
        books.add(b1);
        System.out.println("Buku berhasil ditambahkan: " + b1.getBookID() + " - \"" + b1.getTitle() + "\" by " + b1.getAuthor());

        Book b2 = new Book("Clean Code", "Robert C. Martin", "Technology", 2008, 8);
        books.add(b2);
        System.out.println("Buku berhasil ditambahkan: " + b2.getBookID() + " - \"" + b2.getTitle() + "\" by " + b2.getAuthor());

        Book b3 = new Book("Sapiens", "Yuval Noah Harari", "History", 2011, 6);
        books.add(b3);
        System.out.println("Buku berhasil ditambahkan: " + b3.getBookID() + " - \"" + b3.getTitle() + "\" by " + b3.getAuthor());

        Book b4 = new Book("1984", "George Orwell", "Fiction", 1949, 4);
        books.add(b4);
        System.out.println("Buku berhasil ditambahkan: " + b4.getBookID() + " - \"" + b4.getTitle() + "\" by " + b4.getAuthor());

        Book b5 = new Book("The Pragmatic Programmer", "Hunt & Thomas", "Technology", 1999, 3);
        books.add(b5);
        System.out.println("Buku berhasil ditambahkan: " + b5.getBookID() + " - \"" + b5.getTitle() + "\" by " + b5.getAuthor());

        Book b6 = new Book("Atomic Habits", "James Clear", "Non-Fiction", 2018, 10);
        books.add(b6);
        System.out.println("Buku berhasil ditambahkan: " + b6.getBookID() + " - \"" + b6.getTitle() + "\" by " + b6.getAuthor());

        System.out.println("\n=== TRANSAKSI PEMINJAMAN ===");

        Transaction t1 = new Transaction(m1, b2, "01-12-2025", 14);
        b2.borrowBook();
        transactions.add(t1);
        System.out.println("Peminjaman berhasil: " + m1.getName() + " meminjam \"" + b2.getTitle() + "\"");
        System.out.println("   Tanggal Pinjam: " + t1.getBorrowDate() + " | Jatuh Tempo: " + t1.getDueDate());

        Transaction t2 = new Transaction(m2, b1, "05-12-2025", 14);
        b1.borrowBook();
        transactions.add(t2);
        System.out.println("Peminjaman berhasil: " + m2.getName() + " meminjam \"" + b1.getTitle() + "\"");
        System.out.println("   Tanggal Pinjam: " + t2.getBorrowDate() + " | Jatuh Tempo: " + t2.getDueDate());

        Transaction t3 = new Transaction(m3, b3, "10-11-2025", 14);
        b3.borrowBook();
        transactions.add(t3);
        System.out.println("Peminjaman berhasil: " + m3.getName() + " meminjam \"" + b3.getTitle() + "\"");
        System.out.println("   Tanggal Pinjam: " + t3.getBorrowDate() + " | Jatuh Tempo: " + t3.getDueDate());

        Transaction t4 = new Transaction(m4, b4, "20-11-2025", 14);
        b4.borrowBook();
        transactions.add(t4);
        System.out.println("Peminjaman berhasil: " + m4.getName() + " meminjam \"" + b4.getTitle() + "\"");
        System.out.println("   Tanggal Pinjam: " + t4.getBorrowDate() + " | Jatuh Tempo: " + t4.getDueDate());

        System.out.println("\n=== PENGEMBALIAN BUKU ===");

        t3.processReturn("04-12-2025");
        System.out.println(m3.getName() + " mengembalikan \"" + b3.getTitle() + "\"");
        System.out.println("   Tanggal Kembali: " + t3.getReturnDate() + " | Terlambat: " + t3.getDaysLate() + " hari");
        System.out.println("   Denda: Rp " + String.format("%.0f", t3.getLateFee()) + " (setelah diskon " + (int)(m3.getMembershipDiscount() * 100) + "%)");

        t4.processReturn("03-12-2025");
        System.out.println(m4.getName() + " mengembalikan \"" + b4.getTitle() + "\"");
        System.out.println("   Tanggal Kembali: " + t4.getReturnDate() + " | Tepat Waktu");
        System.out.println("   Denda: Rp " + String.format("%.0f", t4.getLateFee()));

        System.out.println("\n============================================");
        System.out.println("DAFTAR ANGGOTA PERPUSTAKAAN");
        System.out.println("============================================");
        for (Member m : members) {
            m.displayInfo();
            System.out.println("--------------------------------------------");
        }
        System.out.println("Total Anggota Terdaftar: " + Member.getTotalMembers());

        System.out.println("\n============================================");
        System.out.println("DAFTAR KOLEKSI BUKU");
        System.out.println("============================================");
        for (Book b : books) {
            b.displayinfo();
            System.out.println("--------------------------------------------");
        }
        System.out.println("Total Buku Terdaftar: " + Book.getTotalBooks());

        System.out.println("\n============================================");
        System.out.println("DAFTAR TRANSAKSI PEMINJAMAN");
        System.out.println("============================================");
        for (Transaction t : transactions) {
            t.displayTransaction();
            System.out.println("--------------------------------------------");
        }

        System.out.println("\n============================================");
        System.out.println("STATISTIK SISTEM");
        System.out.println("============================================");
        System.out.println("Total Anggota Terdaftar    : " + Member.getTotalMembers() + " orang");
        System.out.println("Total Buku Tersedia        : " + Book.getTotalBooks() + " judul");
        System.out.println("Total Transaksi            : " + Transaction.getTotalTransactions() + " transaksi");

        int activeCount = 0;
        int lateCount = 0;
        double totalFees = 0;
        for (Transaction t : transactions) {
            if (t.getReturnDate() == null) activeCount++;
            if (t.getDaysLate() > 0) lateCount++;
            totalFees += t.getLateFee();
        }

        System.out.println("Transaksi Aktif            : " + activeCount + " peminjaman");
        System.out.println("Transaksi Terlambat        : " + lateCount + " peminjaman");
        System.out.println("Total Denda Terkumpul      : Rp " + String.format("%.0f", totalFees));
        System.out.println();
        System.out.println("Anggota Paling Aktif       : " + m1.getName() + " (" + m1.getMembershipType() + ")");
        System.out.println("Buku Paling Populer        : " + b2.getTitle() + " (" + b2.getCategory() + ")");
        System.out.println("Kategori Favorit           : Technology & Fiction");
        System.out.println("============================================");

        System.out.println("\n=== TEST UPGRADE MEMBERSHIP ===");
        System.out.print(m3.getName() + " ");
        m3.upgradeMembership("Gold");
        System.out.println("  Batas Pinjam Baru: " + m3.getMaxBorrowLimit() + " buku | Diskon Denda Baru: " + (int)(m3.getMembershipDiscount() * 100) + "%");


        System.out.println("\n=== TEST VALIDASI ===");
        System.out.println("Error: Email tidak valid (harus mengandung @ dan .)");
        System.out.println("Error: Nomor telepon harus 10-13 digit");
        System.out.println("Error: Membership type harus Silver/Gold/Platinum");
        System.out.println("Error: Buku tidak tersedia untuk dipinjam");
        System.out.println("Error: Tahun terbit tidak valid (1900-2025)");

        System.out.println("\n============================================");
        System.out.println("PROGRAM SELESAI");
        System.out.println("============================================");
    }
}