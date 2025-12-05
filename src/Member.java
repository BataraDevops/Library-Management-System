class Member {
    private String memberId;
    private String name;
    private String email;
    private String phoneNumber;
    private int registrationYear;
    private String membershipType;
    private static int totalMembers = 0;
    private static int memberCounter = 0;

    public Member() {
        memberCounter++;
        this.memberId = String.format("MBR%03d", memberCounter);
        totalMembers++;
    }

    public Member(String name, String email, String phoneNumber, int registrationYear, String membershipType) {
        this();
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.registrationYear = registrationYear;
        this.membershipType = membershipType;
    }

    public boolean validateMemberData() {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Error: Name tidak boleh kosong");
            return false;
        }
        if (!email.contains("@") || !email.contains(".")) {
            System.out.println("Error: Email tidak valid (harus mengandung @ dan .)");
            return false;
        }
        if (phoneNumber.length() < 10 || phoneNumber.length() > 13) {
            System.out.println("Error: Nomor telepon harus 10-13 digit");
            return false;
        }
        if (registrationYear < 2015 || registrationYear > 2025) {
            System.out.println("Error: Tahun registrasi harus antara 2015-2025");
            return false;
        }
        if (!membershipType.equals("Silver") && !membershipType.equals("Gold") && !membershipType.equals("Platinum")) {
            System.out.println("Error: Membership type harus Silver/Gold/Platinum");
            return false;
        }
        return true;
    }

    public void displayInfo() {
        System.out.println("[" + memberId + "] " + name);
        System.out.println("Email         : " + email);
        System.out.println("Phone         : " + phoneNumber);
        System.out.println("Membership    : " + membershipType);
        System.out.println("Tahun Daftar  : " + registrationYear);
        System.out.println("Durasi Member : " + getMembershipDuration() + " tahun");
        System.out.println("Batas Pinjam  : " + getMaxBorrowLimit() + " buku");
        System.out.println("Diskon Denda  : " + (int)(getMembershipDiscount() * 100) + "%");
    }

    public void upgradeMembership(String newType) {
        if (membershipType.equals("Silver") && newType.equals("Gold")) {
            membershipType = newType;
            System.out.println("berhasil di-upgrade dari Silver ke Gold!");
        } else if (membershipType.equals("Gold") && newType.equals("Platinum")) {
            membershipType = newType;
            System.out.println("berhasil di-upgrade dari Gold ke Platinum!");
        } else {
            System.out.println("Gagal di-upgrade");
        }
    }

    public int getMaxBorrowLimit() {
        switch (membershipType) {
            case "Platinum": return 10;
            case "Gold": return 7;
            case "Silver": return 5;
            default: return 0;
        }
    }

    public int getMembershipDuration() {
        return 2025 - registrationYear;
    }

    public double getMembershipDiscount() {
        switch (membershipType) {
            case "Platinum": return 0.5;
            case "Gold": return 0.3;
            case "Silver": return 0.1;
            default: return 0.0;
        }
    }


    public static int getTotalMembers() {
        return totalMembers;
    }
    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public int getRegistrationYear() {
        return registrationYear;
    }
    public void setRegistrationYear(int registrationYear) {
        this.registrationYear = registrationYear;
    }
    public String getMembershipType() {
        return membershipType;
    }
    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }
}