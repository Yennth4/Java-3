USE master;
GO

DROP DATABASE IF EXISTS su22b2_sof203;
GO

CREATE DATABASE su22b2_sof203;
GO

USE su22b2_sof203;
GO

CREATE TABLE danh_muc (
    id INT IDENTITY PRIMARY KEY,
    ten NVARCHAR (255) NOT NULL,
    mo_ta NVARCHAR(255) NOT NULL,
    trang_thai INT NOT NULL DEFAULT 1
);

GO

CREATE TABLE san_pham (
    id INT IDENTITY PRIMARY KEY,
    ten NVARCHAR (255) NOT NULL,
    so_luong INT NOT NULL DEFAULT 0,
    mau_sac NVARCHAR(255) NOT NULL,
    don_gia FLOAT NOT NULL DEFAULT 0,
    danh_muc_id INT NOT NULL
);

GO

INSERT INTO danh_muc (ten, mo_ta, trang_thai) VALUES
('Ao Nam', '', 1),
('Ao The Thao', '', 1),
('Quan Nam', '', 0);
GO

INSERT INTO san_pham(ten, mau_sac, so_luong, don_gia, danh_muc_id) VALUES
('Ao Polo', 'WHITE', 10, 100000, 1),
('Ao the thao', 'RED', 5, 99000, 2),
('Quan', 'BLACK', 15, 250000, 3);

GO
select * from danh_muc
select * from san_pham

insert into danh_muc values ('Quan Nam' , '' , 0)
insert into danh_muc values ('Quan Nu' , '' , 0)