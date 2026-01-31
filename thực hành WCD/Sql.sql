CREATE DATABASE hr_manage
USE hr_manage;

CREATE TABLE employee (
    employee_id   VARCHAR(20)    NOT NULL,
    employee_name NVARCHAR(64)    NOT NULL,
    birthday      DATE            NOT NULL,
    phone_number  VARCHAR(11)     NOT NULL,
    email         VARCHAR(255)    NOT NULL,
    PRIMARY KEY (employee_id)
);

INSERT INTO employee (employee_id, employee_name, birthday, phone_number, email) VALUES
('E001', N'Nguyễn Văn An', '1995-03-15', '0912345678', 'an.nguyen@company.com'),
('E002', N'Trần Thị Bình', '1998-07-22', '0987654321', 'binh.tran@company.com'),
('E003', N'Lê Hoàng Minh', '1992-11-05', '0901122334', 'minh.le@company.com'),
('E004', N'Phạm Ngọc Lan', '1999-01-30', '0933445566', 'lan.pham@company.com'),
('E005', N'Võ Đức Thành', '1990-09-18', '0977889900', 'thanh.vo@company.com');


select * from employee