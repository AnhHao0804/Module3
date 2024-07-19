create database demoDuLich;
use demoDuLich;
create table CategoryTour(
        id int primary key,
        categoryCode varchar(255),
categoryName varchar(255)
);
create table City(
        id int primary key,
        cityName varchar(255)
);
create table Destination(
        id int primary key,
        destinationName varchar(255),
describes varchar(255),
cost int,
city_id int,
foreign key (city_id) references city(id)
        );
create table Tour(
        id int primary key,
        tourCode int,
        category_id int,
        destination_id int,
        dateStart datetime,
        dateEnd datetime,
        foreign key (category_id) references CategoryTour(id),
foreign key (destination_id) references Destination(id)
        );
create table OrderTour(
        id int primary key,
        tour_id int,
        client_id int,
        statuss varchar(255),
foreign key (tour_id) references Tour(id),
foreign key (client_id) references Clients(id)
        );
create table Clients(
        id int primary key,
        nameClient varchar(255),
idNumber int,
dateBirth datetime,
city_id int,
foreign key (city_id) references City(id)
        );
insert into City(id,cityname) values (1,'Vũng Tàu'),
        (2,'Hà Nội'),
        (3,'Đà Nẵng'),
        (4,'Vịnh Hạ Long'),
        (5,'Đà Lạt');
insert into Destination(id, destinationName, describes, cost, city_id) values 
(1, 'Bãi Sau', 'Bãi biển nổi tiếng ở Vũng Tàu', 200000, 1),
        (2, 'Hồ Tây', 'Khu vực du lịch nổi tiếng ở Hà Nội', 150000, 2),
        (3, 'Bán đảo Sơn Trà', 'Khu bảo tồn thiên nhiên ở Đà Nẵng', 300000, 3),
        (4, 'Hang Sửng Sốt', 'Hang động lớn ở Vịnh Hạ Long', 250000, 4),
        (5, 'Hồ Xuân Hương', 'Hồ nổi tiếng ở Đà Lạt', 100000, 5);
insert into Clients(id, nameClient, idNumber, dateBirth, city_id) values 
(1, 'Nguyễn Văn A', 123456789, '1990-01-01', 1),
        (2, 'Trần Thị B', 987654321, '1985-02-02', 2),
        (3, 'Lê Văn C', 123987456, '1995-03-03', 3),
        (4, 'Phạm Thị D', 987123654, '1992-04-04', 4),
        (5, 'Ngô Văn E', 456789123, '1991-05-05', 5),
        (6, 'Đinh Thị F', 789456123, '1988-06-06', 1),
        (7, 'Lý Văn G', 159753486, '1987-07-07', 2),
        (8, 'Vũ Thị H', 357951486, '1993-08-08', 3),
        (9, 'Phan Văn I', 951357852, '1989-09-09', 4),
        (10, 'Bùi Thị J', 753159486, '1994-10-10', 5);
insert into Tour(id, tourCode, category_id, destination_id, dateStart, dateEnd) values 
(1, 1001, 1, 1, '2024-07-15 08:00:00', '2024-07-20 18:00:00'),
        (2, 1002, 1, 2, '2024-08-01 09:00:00', '2024-08-05 17:00:00'),
        (3, 1003, 1, 3, '2024-09-10 07:00:00', '2024-09-15 19:00:00'),
        (4, 1004, 2, 4, '2024-10-05 08:30:00', '2024-10-10 18:30:00'),
        (5, 1005, 2, 5, '2024-11-20 08:00:00', '2024-11-25 17:30:00'),
        (6, 1006, 1, 1, '2024-07-25 09:00:00', '2024-07-30 19:00:00'),
        (7, 1007, 2, 2, '2024-08-10 08:00:00', '2024-08-15 18:00:00'),
        (8, 1008, 1, 3, '2024-09-20 07:30:00', '2024-09-25 17:30:00'),
        (9, 1009, 2, 4, '2024-10-15 08:00:00', '2024-10-20 18:00:00'),
        (10, 1010, 1, 5, '2024-11-05 08:30:00', '2024-11-10 17:30:00'),
        (11, 1011, 1, 1, '2024-12-01 08:00:00', '2024-12-06 18:00:00'),
        (12, 1012, 2, 2, '2024-12-10 09:00:00', '2024-12-15 17:00:00'),
        (13, 1013, 1, 3, '2024-12-20 07:00:00', '2024-12-25 19:00:00'),
        (14, 1014, 2, 4, '2024-11-25 08:30:00', '2024-11-30 18:30:00'),
        (15, 1015, 1, 5, '2024-10-20 08:00:00', '2024-10-25 17:30:00');
insert into CategoryTour(id, categoryCode, categoryName) values 
(1, 'CAT01', 'Tour biển'),
        (2, 'CAT02', 'Tour núi');
insert into OrderTour(id, tour_id, client_id, statuss) values 
(1, 1, 1, 'Đã đặt'),
        (2, 2, 2, 'Đã đặt'),
        (3, 3, 3, 'Đã đặt'),
        (4, 4, 4, 'Đã đặt'),
        (5, 5, 5, 'Chưa đặt'),
        (6, 6, 6, 'Đã đặt'),
        (7, 7, 7, 'Đã đặt'),
        (8, 8, 8, 'Chưa đặt'),
        (9, 9, 9, 'Đã đặt'),
        (10, 10, 10, 'Đã đặt');
select city.CityName, count(clients.city_id) from clients join City on city.id = clients.city_id group by City.Cityname;
select count(datestart) from tour where year(datestart) = 2024 and month(datestart) = 07;
select count(dateend) from tour where year(dateend) = 2024 and month(dateend) = 10;
