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
	GioiTinh bit,
	MatKhau	nvarchar(20),
	VaiTro	nvarchar(20),
	Hinh nvarchar(150),
	primary key(MaNV)	
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
	MaLoaiSanPham varchar(10) not null,
	TenSanPham nvarchar (50),
	MoTa nvarchar (150),
	primary key (MaLoaiSanPham)
)
go

create table SanPham
(
	MaSanPham varchar(10) not null,
	MaLoaiSanPham varchar(10),
	TenSanPham nvarchar (50),
	Hinh nvarchar (150),
	GiaSanPham float,
	primary key (MaSanPham)
)
go


	
create table HoaDon
(
	MaHD varchar(10) not null,
	ThoiGianLap datetime,
	MaNV varchar(10),
	MaKH varchar(10),
	primary key (MaHD)
)
go

create table ChiTietHD
(
	MaHD varchar(10) not null,
	MaSanPham varchar(10),
	TenSanPham nvarchar(50),
	SoLuong int,
	TongTien float,
	GiamGia float,
	primary key (MaHD)
)
go



alter table SanPham
	add constraint fk_SanPham_LoaiSanPham foreign key (MaLoaiSanPham) references LoaiSanPham (MaLoaiSanPham)

alter table HoaDon
	add constraint fk_HoaDon_NhanVien foreign key (MaNV) references NhanVien (MaNV),
	constraint fk_HoaDon_KhachHang foreign key (MaKH) references KhachHang (MaKH)

alter table ChiTietHD
	add constraint fk_ChiTietHD_HoaDon foreign key (MaHD) references  HoaDon(MaHD),
	constraint fk_ChiTietHD_SanPham foreign key (MaSanPham) references SanPham(MaSanPham)



insert into NhanVien values('NV01',N'Nguyễn Huy Hiếu',N'0432434342',N'Hà Nội',1,'123456','Nhân Viên',null)
insert into NhanVien values('NV02',N'Nguyễn Huy Nam',N'0998745442',N'Hải Phòng',1,'123456','Nhân Viên',null)
insert into NhanVien values('NV03',N'Nguyễn Thị Hương',N'0353534442',N'Hà Nam',0,'123456','Nhân Viên',null)
insert into NhanVien values('NV04',N'Vũ Thị Huyền',N'0756434368',N'Hải Dương',0,'123456','Quản Lý',null)
insert into NhanVien values('NV05',N'Nguyễn Huy Hoàng',N'0454927343',N'Hà Nội',1,'123456','Quản Lý',null)

insert into KhachHang values('KH01',N'Nguyễn Văn Nam',N'035476555',N'Hà Nội')
insert into KhachHang values('KH02',N'Kiều Văn Hoàng',N'093453434',N'Hà Nội')
insert into KhachHang values('KH03',N'Nguyễn Thị Hoa',N'095453543',N'Hà Nội')
insert into KhachHang values('KH04',N'Vũ Văn Nam',N'0954555453',N'Hà Nội')

insert into HoaDon values('HD01','10-10-2021','NV01','KH01')
insert into HoaDon values('HD02','11-10-2021','NV02','KH02')
insert into HoaDon values('HD03','12-10-2021','NV01','KH03')
insert into HoaDon values('HD04','10-10-2021','NV03','KH04')

insert into LoaiSanPham values(N'SP1','Trà sữa chân châu',N'Nhiều chân châu')
insert into LoaiSanPham values(N'SP2','Trà sữa chân châu đường đen',N'Nhiều chân châu và đường')
insert into LoaiSanPham values(N'SP3','Trà sữa nha đam',N'Nhiều nha đam')
insert into LoaiSanPham values(N'SP4','Cà phê sữa',N'Nhiều sữa ít cà phê')
insert into LoaiSanPham values(N'SP5','Cà phê đen',N'Very good')

insert into SanPham values('SP01',N'SP1',N'Trà sữa chân châu',null,50000.0)
insert into SanPham values('SP02',N'SP2 ',N'Trà sữa chân châu đường đen',null,750000.0)
insert into SanPham values('SP03',N'SP3',N'Trà sữa nha đam',null,50000.0)
insert into SanPham values('SP04',N'SP4',N'Cà phê sữa ',null,100000.0)
insert into SanPham values('SP05',N'SP5',N'Cà phê đen',null,500000.0)

insert into ChiTietHD values('HD01','SP01',N'Trà sữa chân châu',5,'250000.0','2.0')
insert into ChiTietHD values('HD02','SP02',N'Trà sữa chân châu',4,'250000.0','2.0')
insert into ChiTietHD values('HD03','SP04',N'Cà phê sữa',3,'400000.0','2.0')
insert into ChiTietHD values('HD04','SP01',N'Trà sữa chân châu',5,'250000.0','2.0')

select * from NhanVien
select * from SanPham
select * from ChiTietHD
select * from KhachHang
select * from HoaDon
select * from LoaiSanPham

