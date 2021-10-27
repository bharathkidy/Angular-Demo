DROP TABLE IF EXISTS user_details;
CREATE TABLE user_details(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(250) NOT NULL, email VARCHAR(250) NOT NULL, password VARCHAR(250) NOT NULL, role VARCHAR(250) NOT NULL);
INSERT INTO user_details(name,email,password,role) VALUES
('James','James@123.com', '1!23#4', 'EMPLOYEE'),
('Peter','Peter@123.com', '8^23!3', 'EMPLOYEE'),
('John','John@123.com', '98!891', 'ADMIN'),
('Fred','Fred@123.com', '68651', 'ADMIN');