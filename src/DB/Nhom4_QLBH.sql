use master
go

if exists (select name from master..sysdatabases where name = 'Nhom4_QLBH')
	drop database Nhom4_QLBH
go

create database Nhom4_QLBH
go

use Nhom4_QLBH
go



create table NhanVien
(
	MaNV varchar(10) not null,
	TenNV nvarchar(40),
	Sdt varchar(13),
	DiaChi nvarchar(150),
	email nvarchar(150),
	Hinh nvarchar(150),
	primary key(MaNV)	
)
go

create table TaiKhoan(
	TenTaiKhoan varchar(20) not null primary key,
	MatKhau nvarchar(30),
	VaiTro bit,
	MaNV varchar(10),
	foreign key (MaNV) references NhanVien (MaNV)
)
go

create table KhachHang
(
	MaKH varchar(10) not null,
	TenKH nvarchar(40),
	Sdt varchar(13),
	DiaChi nvarchar(150),
	primary key(MaKH)	
)
	

create table LoaiSanPham
(
	ID_LoaiSP varchar(10),
	TenLoaiSanPham nvarchar (50),
	primary key (ID_LoaiSP)
)
go

create table SanPham
(
	MaSanPham varchar(10) not null,
	TenSanPham varchar(150),
	GiaSanPham float,
	Hinh nvarchar (150),
	ID_LoaiSP varchar(10),
	primary key (MaSanPham),
	foreign key (ID_LoaiSP) references LoaiSanPham(ID_LoaiSP)
)
go

create table HoaDon
(
	STT int not null identity(1,1),
	MaHD varchar(10) not null,
	MaSanPham varchar(10),
	SoLuong int,  
	MaKH varchar(10),
	ThoiGianLap datetime,
	MaNV varchar(10),
	TongTien float,
	primary key (STT),
	foreign key (MaKH)  references KhachHang(MaKH),
	foreign key (MaNV)  references NhanVien(MaNV),
)
go








insert into NhanVien values('NV01',N'Nguyễn Huy Hiếu',N'0432434342',N'Hà Nội','hieuha12@gamil.com',null)
insert into NhanVien values('NV02',N'Nguyễn Huy Nam',N'0998745442',N'Hải Phòng','hieuha12@gamil.com',null)
insert into NhanVien values('NV03',N'Nguyễn Thị Hương',N'0353534442',N'Hà Nam','hieuha12@gamil.com',null)
insert into NhanVien values('NV04',N'Vũ Thị Huyền',N'0756434368',N'Hải Dương','hieuha12@gamil.com',null)
insert into NhanVien values('NV05',N'Nguyễn Huy Hoàng',N'0454927343',N'Hà Nội','hieuha12@gamil.com',null)

insert into TaiKhoan values('hieund1','123456',0,'NV01')
insert into TaiKhoan values('hieund2','123456',0,'NV02')
insert into TaiKhoan values('hieund3','123456',0,'NV03')
insert into TaiKhoan values('hieund4','123456',0,'NV04')
insert into TaiKhoan values('hieund5','123456',1,'NV05')

insert into KhachHang values('KH01',N'Nguyễn Văn Nam',N'035476555',N'Hà Nội')
insert into KhachHang values('KH02',N'Kiều Văn Hoàng',N'093453434',N'Hà Nội')
insert into KhachHang values('KH03',N'Nguyễn Thị Hoa',N'095453543',N'Hà Nội')
insert into KhachHang values('KH04',N'Vũ Văn Nam',N'0954555453',N'Hà Nội')

insert into LoaiSanPham values('TC1',N'Trà Chanh')
insert into LoaiSanPham values('TS2',N'Trà Sữa')
insert into LoaiSanPham values('TS3',N'Cà Phê')
insert into LoaiSanPham values('TS4',N'Nước Ngọt')

insert into SanPham values('SP1',N'Trà Chanh Nha Đam',10000,null,'TC1')
insert into SanPham values('SP2',N'Trà Chanh Thường',10000,null,'TC1')
insert into SanPham values('SP3',N'Trà Chanh Nho',20000,null,'TS1')
insert into SanPham values('SP4',N'Trà sữa chân châu',50000,null,'TS2')
insert into SanPham values('SP5',N'Trà sữa nha dam',50000,null,'TS2')
insert into SanPham values('SP6',N'Cà phê den',20000,null,'TS3')
insert into SanPham values('SP7',N'Cà Phê đá',20000,null,'TS3')
insert into SanPham values('SP8',N'Coca',10000,null,'TS4')
insert into SanPham values('SP9',N'Pepsi',10000,null,'TS4')


insert into HoaDon values('HD01','SP1',5,'KH01','10-10-2021','NV01',50000.0)
insert into HoaDon values('HD02','SP2',4,'KH02','11-10-2021','NV02',40000.0)
insert into HoaDon values('HD03','SP3',3,'KH03','12-10-2021','NV03',60000.0)




select * from NhanVien
select  * from TaiKhoan
select * from SanPham
select * from KhachHang
select * from LoaiSanPham
select * from HoaDon

