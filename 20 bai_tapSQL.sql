-- 1 them dữ liệu
-- 2
select id_nhanvien,hoten from case_study_module3.nhanvien where hoten like'H%' and length(hoten)<15;
-- 3
use case_study_module3;
select hovaten,diachi,ngay_sinh from kh where (diachi in ('da nang', 'quang tri'))  AND (YEAR(curdate()) - YEAR(ngay_sinh) BETWEEN 20 AND 50);

-- 4 Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu
-- lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của
-- khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là
-- “Diamond”.
select kh.id_kh,kh.hovaten ,count(hopdong.id_hopdong) as solandat from kh inner join hopdong on kh.id_kh = hopdong.id_kh
inner join loai_kh  on loai_kh.id_loaikh = kh.id_loaikh
where loai_kh.ten_loaikh="Diamond"
group by kh.hovaten order by solandat;