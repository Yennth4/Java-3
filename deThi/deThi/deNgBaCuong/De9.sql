CREATE
DATABASE QLGV
GO
USE QLGV
CREATE TABLE GiangVien
(
    ma        VARCHAR(50) PRIMARY KEY,
    ten       NVARCHAR(150),
    loai      VARCHAR(150),
    tuoi      INT,
    bac       INT,
    gioi_tinh bit
) INSERT INTO GiangVien VALUES('M01', N'Giảng viên A', 'FullTime', '24', 1, 0),
							('M02', N'Giảng viên B', 'PartTime', '22', 2, 1),
							('M03', N'Giảng viên C', 'FullTime', '27', 3, 0),
							('M04', N'Giảng viên D', 'PartTime', '25', 4, 1)

SELECT *
FROM GiangVien
DROP TABLE GiangVien



