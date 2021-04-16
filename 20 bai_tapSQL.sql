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
    
-- 9.Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm.
--  Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem 
-- (được tính dựa trên việc count các IDHopDongChiTiet).
select hopdong.id_hopdong, ngaylamhopdong,ngayketthuc,tiencoc,soluong,count(id_hopdongchitiet) from hopdong 
    join hopdongchitiet on hopdong.id_hopdong= hopdongchitiet.id_hopdong
    group by id_hopdong;