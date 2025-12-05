class Book {
    private String bookID;
    private String title;
    private String author;
    private String category;
    private int publicationYear;
    private boolean isAvaliable;
    private int totalCopies;
    private int AvaliableCopies;
    private static int totalBooks = 0;
    private static int bookCounter = 0;

    public Book() {
        bookCounter++;
        this.bookID = String.format("BK%03d", bookCounter);
        totalBooks++;
    }

    public Book(String title, String author, String category, int publicationYear, int totalCopies) {
        this();
        this.title = title;
        this.author = author;
        this.category = category;
        this.publicationYear = publicationYear;
        this.totalCopies = totalCopies;
        this.AvaliableCopies = totalCopies;
        this.isAvaliable = totalCopies > 0;
    }

    public boolean validateBookData() {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Error: Title tidak boleh kosong");
            return false;
        }
        if (author == null || author.trim().isEmpty()) {
            System.out.println("Error: Author tidak boleh kosong");
            return false;
        }
        if (!category.equals("Fiction") && !category.equals("Non-Fiction") &&
                !category.equals("Science") && !category.equals("Technology") && !category.equals("History")) {
            System.out.println("Error: Kategori harus Fiction/Non-Fiction/Science/Technology/History");
            return false;
        }
        if (publicationYear < 1900 || publicationYear > 2025) {
            System.out.println("Error: Tahun terbit tidak valid (1900-2025)");
            return false;
        }
        if (totalCopies < 0) {
            System.out.println("Error: Total copies harus >= 0");
            return false;
        }
        if (AvaliableCopies < 0 || AvaliableCopies > totalCopies) {
            System.out.println("Error: Available copies tidak boleh > total copies");
            return false;
        }
        return true;
    }

    public void displayinfo() {
        System.out.println("[" + bookID + "] " + title);
        System.out.println("Penulis       : " + author);
        System.out.println("Kategori      : " + category);
        System.out.println("Tahun Terbit  : " + publicationYear);
        System.out.println("Umur Buku     : " + getBookAge() + " tahun");
        System.out.println("Total Copy    : " + totalCopies + " eksemplar");
        System.out.print("Tersedia      : " + AvaliableCopies + " eksemplar | Status: " + getAvailabilityStatus());
        if (isNewRelease()) {
            System.out.print(" [NEW RELEASE]");
        }
        System.out.println();
    }

    public boolean borrowBook() {
        if (AvaliableCopies > 0) {
            AvaliableCopies--;
            isAvaliable = AvaliableCopies > 0;
            return true;
        } else {
            System.out.println("Error: Buku tidak tersedia untuk dipinjam");
            return false;
        }
    }

    public void returnBook() {
        if (AvaliableCopies < totalCopies) {
            AvaliableCopies++;
            isAvaliable = true;
        }
    }

    public int getBookAge() {
        return 2025 - publicationYear;
    }

    public boolean isNewRelease() {
        return (2025 - publicationYear) <= 7;
    }

    public String getAvailabilityStatus() {
        if (AvaliableCopies > 5) {
            return "Banyak Tersedia";
        } else if (AvaliableCopies >= 1 && AvaliableCopies <= 5) {
            return "Terbatas";
        } else {
            return "Tidak Tersedia";
        }
    }

    public static int getTotalBooks() {
        return totalBooks;
    }
    public String getBookID() {
        return bookID;
    }
    public void setBookID(String bookID) {
        this.bookID = bookID;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
    public boolean isAvaliable() {
        return isAvaliable;
    }
    public void setAvaliable(boolean isAvaliable) {
        this.isAvaliable = isAvaliable;
    }
    public int getTotalCopies() {
        return totalCopies;
    }
    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }
    public int getAvaliableCopies() {
        return AvaliableCopies;
    }
    public void setAvaliableCopies(int avaliableCopies) {
        AvaliableCopies = avaliableCopies;
    }
}