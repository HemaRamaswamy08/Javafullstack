CREATE DATABASE java;

USE java;

CREATE TABLE Employee (
    employee_id INT PRIMARY KEY,
    employee_name VARCHAR(25) NOT NULL, 
    phone_number BIGINT,
    employee_email VARCHAR(25) UNIQUE,
    age INT CHECK (age > 17),
    passport_number INT,
    gender CHAR(1), -- 
    aadhar_number BIGINT,
    blood_group CHAR(4), -- 
    emergency_no BIGINT,
    mobile_no BIGINT, -- 
    father_name VARCHAR(100), -- 
    address VARCHAR(100), -- 
    city VARCHAR(25),
    pincode INT, 
    date_of_join DATE,
    marriage_status BOOLEAN
);

INSERT INTO Employee VALUES (
    1, 'Hema', 9876543210, 'hema@gmail.com', 28,
    1234567, 'F', 123456789012, 'A+', 9988776655,
    9876543210, 'Rajesh', '123 Main St', 'Bengaluru', 560001, '2022-01-15', FALSE
);

INSERT INTO Employee VALUES (
    2, 'Nisha', 9876543211, 'nisha@gmail.com', 25,
    2345678, 'F', 234567890123, 'B-', 9988776656,
    9876543211, 'Kumar', '456 Oak Ave', 'Bengaluru', 560002, '2023-03-01', TRUE
);

INSERT INTO Employee VALUES (
    3, 'Reshma', 9876543212, 'reshma@gmail.com', 30,
    3456789, 'F', 345678901234, 'O+', 9988776657,
    9876543212, 'Anil', '789 Pine Ln', 'Bengaluru', 560003, '2021-06-20', TRUE
);

INSERT INTO Employee VALUES (
    4, 'Nisarga', 9876543213, 'nisarga@gmail.com', 22,
    4567890, 'F', 456789012345, 'AB+', 9988776658,
    9876543213, 'Ravi', '101 Cedar Rd', 'Bengaluru', 560004, '2024-01-10', FALSE
);

INSERT INTO Employee  VALUES (
    5, 'Pooja', 9876543214, 'pooja@gmail.com', 27,
    5678901, 'F', 567890123456, 'O-', 9988776659,
    9876543214, 'Suresh', '202 Elm St', 'Bengaluru', 560005, '2023-08-01', FALSE
);

INSERT INTO Employee VALUES (
    6, 'Chandra', 9876543215, 'chandra@gmail.com', 35,
    6789012, 'M', 678901234567, 'A-', 9988776660,
    9876543215, 'Gopal', '303 Birch Dr', 'Bengaluru', 560001, '2020-02-14', TRUE
);

INSERT INTO Employee VALUES (
    7, 'Manvith', 9876543216, 'manvith@gmail.com', 29,
    7890123, 'M', 789012345678, 'B+', 9988776661,
    9876543216, 'Deepak', '404 Maple Ave', 'Bengaluru', 560002, '2022-07-01', FALSE
);

INSERT INTO Employee VALUES (
    8, 'Sanju', 9876543217, 'sanju@gmail.com', 26,
    8901234, 'M', 890123456789, 'O+', 9988776662,
    9876543217, 'Vijay', '505 Poplar St', 'Bengaluru', 560003, '2023-05-10', FALSE
);

INSERT INTO Employee VALUES (
    9, 'Keerthi', 9876543218, 'keerthi@gmail.com', 31,
    9012345, 'F', 901234567890, 'AB-', 9988776663,
    9876543218, 'Prakash', '606 Ash Ln', 'Bengaluru', 560004, '2021-09-15', TRUE
);

INSERT INTO Employee VALUES (
    10, 'Sandeep', 9876543219, 'sandeep@gmail.com', 33,
    1023456, 'M', 102345678901, 'B+', 9988776664,
    9876543219, 'Mahesh', '707 Willow Dr', 'Bengaluru', 560005, '2020-11-01', TRUE
);

INSERT INTO Employee VALUES (
    11, 'Dhanu', 9876543220, 'dhanu@gmail.com', 24,
    1134567, 'F', 113456789012, 'A+', 9988776665,
    9876543220, 'Ganesh', '808 Cherry Rd', 'Bengaluru', 560001, '2024-03-20', FALSE
);