CREATE TABLE User (
                      user_name VARCHAR(50) PRIMARY KEY ,
                      password VARCHAR(50) NOT NULL ,
                      full_name VARCHAR(100) NOT NULL
);

CREATE TABLE ToDoItem(
  id INT PRIMARY KEY AUTO_INCREMENT,
  user_name VARCHAR(50) NOT NULL,
  description VARCHAR(500) NOT NULL ,
  status ENUM('DONE', 'NOT-DONE') NOT NULL,
  CONSTRAINT FOREIGN KEY (user_name) REFERENCES User(user_name)
);

INSERT INTO User (user_name, password, full_name) VALUES ('u001', 'danula123', 'Danula Balasooriya'),
                                                         ('u002', '12345', 'Kamal Gunarathna'),
                                                         ('u003', '567', 'Nimal'),
                                                         ('u005', 'era123', 'Eranga Bandara');

INSERT INTO ToDoItem (user_name, description, status) VALUES
('u001', 'learn Angular', 'NOT-DONE'),
('u003', 'learn React', 'NOT-DONE'),
('u005', 'learn JavaEE', 'DONE');