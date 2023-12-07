CREATE TABLE pembayaran
(
    id              varchar(36),
    waktu_transaksi timestamp      NOT NULL,
    keterangan      varchar(100)   NOT NULL,
    nilai           decimal(19, 2) NOT NULL,
    PRIMARY KEY (id)
);
