-- 1 them dữ liệu
-- 2
use case_study_module3;
select id_nhanvien,hoten from case_study_module3.nhanvien where hoten like'H%' and length(hoten)<15;
-- 3
use case_study_module3;
select hovaten,diachi,ngay_sinh from kh where (diachi in ('da nang', 'quang tri'))  AND (YEAR(curdate()) - YEAR(ngay_sinh) BETWEEN 20 and 50);

-- 4 Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu
-- lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của
-- khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là
-- “Diamond”.
select kh.id_kh,kh.hovaten ,count(hopdong.id_hopdong) as solandat from kh inner join hopdong on kh.id_kh = hopdong.id_kh
inner join loai_kh  on loai_kh.id_loaikh = kh.id_loaikh
where loai_kh.ten_loaikh="Diamond"
group by kh.hovaten order by solandat ASC;

-- 5 Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong,
-- TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien (Với
-- TongTien được tính theo công thức như sau: ChiPhiThue +
-- SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) cho tất cả
-- các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng
-- đặt phòng cũng phải hiển thị ra).
 select kh.id_kh,kh.hovaten,loai_kh.ten_loaikh,hopdong.id_hopdong, dv.ten_dv,hopdong.ngaylamhopdong,hopdong.ngayketthuc,sum(dv.chiphithue+hopdongchitiet.soluong*dv_dikem.gia) as 'tongtien' from kh
 left join loai_kh on kh.id_loaikh=loai_kh.id_loaikh
 left join hopdong on kh.id_kh=hopdong.id_kh
 left join dv on hopdong.id_dichvu=dv.id_dichvu
 left join hopdongchitiet on hopdong.id_hopdong=hopdongchitiet.id_hopdong
 left join dv_dikem on hopdongchitiet.id_dvdikem= dv_dikem.id_dvdikem
 group by hopdong.id_hopdong;	
 -- 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue,
 -- TenLoaiDichVu của tất cả các loại Dịch vụ
 -- chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).

select dv.id_dichvu,dv.ten_dv,dv.dientich,dv.sotang ,dv.chiphithue ,loai_dv.ten_loaidv from dv
inner join loai_dv on dv.id_loaidv=loai_dv.id_loaidv
where loai_dv.id_loaidv not in
    (select id_loaidv from Hopdong  
    join dv  on dv.id_dichvu = Hopdong.id_dichvu
	where month(ngaylamhopdong) in (1,2,3) and year(ngaylamhopdong)=2019);
-- 8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên
-- c1
select distinct hovaten from Kh ;
-- c2
select hovaten from kh
    group by hovaten;
    -- c3
    select hovaten from kh 
    union
    select hovaten from kh;
  	-- 9Thực hiện thống kê doanh thu theo tháng,
    -- nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
    
    
-- 10.Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm.
--  Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem 
-- (được tính dựa trên việc count các IDHopDongChiTiet).
select hopdong.id_hopdong, ngaylamhopdong,ngayketthuc,tiencoc,soluong,count(id_hopdongchitiet)as soluongdvdikem from hopdong 
    join hopdongchitiet on hopdong.id_hopdong= hopdongchitiet.id_hopdong
    group by id_hopdong;
   -- 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng 
   -- có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
   Select dv_dikem.id_dvdikem,dv_dikem.ten_dvdikem,dv_dikem.gia ,kh.hovaten ,kh.diachi ,loai_kh.ten_loaikh from dv_dikem
   join hopdongchitiet as hdct on dv_dikem.id_dvdikem=hdct.id_dvdikem
   join hopdong as hd on hdct.id_hopdong=hd.id_hopdong
   join kh on hd.id_kh=kh.id_kh
   join loai_kh on kh.id_loaikh=loai_kh.id_loaikh
 where kh.diachi in ("da nang","hue") and loai_kh.ten_loaikh='Diamond';
 
 
 -- 12 Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang,
-- SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem (được
-- tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ
-- đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa
-- từng được khách hàng đặt vào 6 tháng đầu năm 2019.
select hopdong.id_hopdong,nhanvien.hoten,kh.hovaten,kh.so_cmnd,dv.ten_dv,hopdongchitiet.soluong,hopdong.tiencoc,
count(hopdongchitiet.id_hopdongchitiet) as solansudung from hopdong
join  nhanvien on hopdong.id_nhanvien= nhanvien.id_nhanvien
join kh on  hopdong.id_kh=kh.id_kh
join dv on hopdong.id_dichvu= dv.id_dichvu
join hopdongchitiet on hopdong.id_hopdong=hopdongchitiet.id_hopdong
where not exists (select hopdong.id_hopdong where hopdong.ngaylamhopdong between "2019-01-01"and "2019-06-31")
and  not exists (select hopdong.id_hopdong where hopdong.ngaylamhopdong between "2019-09-01"and "2019-12-31");
-- 13 Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các
-- Khách hàng đã đặt phòng.

select hopdongchitiet.id_hopdong, dv_dikem.ten_dvdikem,count(dv_dikem.ten_dvdikem)as solandat from dv_dikem
join hopdongchitiet on hopdongchitiet.id_dvdikem=dv_dikem.id_dvdikem
group by dv_dikem.ten_dvdikem;
-- 14  Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một
-- lần duy nhất. Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu,
-- TenDichVuDiKem, SoLanSuDung.
select hopdongchitiet.id_hopdong, dv_dikem.ten_dvdikem,count(dv_dikem.ten_dvdikem)as solandat from dv_dikem
join hopdongchitiet on hopdongchitiet.id_dvdikem=dv_dikem.id_dvdikem
group by dv_dikem.ten_dvdikem
having solandat=1;
-- 15 Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen,
-- TrinhDo, TenBoPhan, SoDienThoai, DiaChi mới chỉ lập được tối đa 3
-- hợp đồng từ năm 2018 đến 2019.

select nhanvien.id_nhanvien,nhanvien.hoten,nhanvien.so_cmnd,trinhdo.trinh_do, bophan.ten_bophan,nhanvien.diachi , count(nhanvien.id_nhanvien) as laphopdong from nhanvien
join hopdong on nhanvien.id_nhanvien=hopdong.id_nhanvien
join bophan on nhanvien.id_bophan=bophan.id_bophan
join trinhdo on trinhdo.id_trinhdo= nhanvien.id_trinhdo
having laphopdong >3;

-- 16