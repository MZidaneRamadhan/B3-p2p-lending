Feature: Pengajuan Pinjaman P2P Lending

    Scenario: Borrower mengajukan pinjaman valid
        Given seorang borrower dengan ID "B001" terdaftar, credit score 750, dan limit pinjaman 20000000
        When borrower mengajukan pinjaman sebesar 10000000 dengan tenor 12 bulan
        Then pinjaman berhasil dibuat dengan status "PENDING"

    Scenario: Borrower mengajukan pinjaman melebihi limit
        Given seorang borrower dengan ID "B002" terdaftar, credit score 700, dan limit pinjaman 5000000
        When borrower mengajukan pinjaman sebesar 6000000 dengan tenor 12 bulan
        Then pinjaman gagal dibuat dengan pesan "Jumlah pinjaman melebihi limit yang tersedia"

    Scenario: Borrower mengajukan pinjaman dengan jumlah negatif
        Given seorang borrower dengan ID "B002" terdaftar, credit score 700, dan limit pinjaman 5000000
        When borrower mengajukan pinjaman sebesar -5000 dengan tenor 6 bulan
        Then sistem menolak pengajuan dengan pesan "Jumlah pinjaman harus positif"

    Scenario: Borrower mengajukan pinjaman dengan tenor negatif
        Given seorang borrower dengan ID "B002" terdaftar, credit score 700, dan limit pinjaman 5000000
        When borrower mengajukan pinjaman sebesar 3000000 dengan tenor -6 bulan
        Then sistem menolak pengajuan dengan pesan "Tenor harus positif"

    Scenario: Borrower mengajukan pinjaman dengan tenor credit score rendah
        Given seorang borrower dengan ID "B003" terdaftar, credit score 550, dan limit pinjaman 3000000
        When borrower mengajukan pinjaman sebesar 2000000 dengan tenor 12 bulan
        Then sistem menolak pengajuan dengan pesan "Credit score terlalu rendah untuk mengajukan pinjaman"