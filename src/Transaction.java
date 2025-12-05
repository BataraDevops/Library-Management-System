public class Transaction {

    private String transactionId;
    private Member member;
    private Book book;
    private String borrowDate;
    private String dueDate;
    private String returnDate;
    private int daysLate;
    private double lateFee;
    private static int totalTransactions = 0;
    private static final double LATE_FEE_PER_DAY = 2000.0;

    public Transaction(Member member, Book book, String borrowDate, int borrowDurationDays) {
        this.member = member;
        this.book = book;
        this.borrowDate = borrowDate;
        totalTransactions++;
    }

    public void processReturn(String returnDate) {
        this.returnDate = returnDate;
        book.returnBook();
    }

    public void calculateLateFee() {
        if (daysLate > 0) {
            double discount = member.getMembershipDiscount();
            lateFee = daysLate * LATE_FEE_PER_DAY * (1 - discount);
        } else {
            lateFee = 0;
        }
    }

    public void displayTransaction() {
        member.displayInfo();
        book.displayinfo();
        System.out.println("Tanggal Pinjam: " + borrowDate);
        System.out.println("Tanggal Tempo: " + dueDate);
        System.out.println("Tanggal Kembali: " + returnDate);
        System.out.println("Terlamabat: " + daysLate);
        System.out.println("Denda: " + lateFee);
    }

    public boolean isOverdue(String currentDate) {
        if (returnDate == null) {
            return currentDate.compareTo(dueDate) > 0;
        }
        return false;
    }

    public String getTransactionStatus() {
        if (returnDate != null) {
            return "Selesai";
        } else if (isOverdue(borrowDate)) {
            return "Terlambat";
        } else {
            return "Aktif";
        }
    }

    public static int getTotalTransactions() {
        return totalTransactions;
    }

//    Getter dan setter
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public int getDaysLate() {
        return daysLate;
    }

    public void setDaysLate(int daysLate) {
        this.daysLate = daysLate;
    }

    public double getLateFee() {
        return lateFee;
    }

    public void setLateFee(double lateFee) {
        this.lateFee = lateFee;
    }
}