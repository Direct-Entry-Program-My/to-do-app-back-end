CREATE TABLE `User` (
                      `user_name` VARCHAR(50) PRIMARY KEY ,
                      `password` VARCHAR(50) NOT NULL ,
                      `full_name` VARCHAR(100) NOT NULL
);

CREATE TABLE `ToDoItem`(
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `user_name` VARCHAR(50) NOT NULL,
  `description` VARCHAR(500) NOT NULL,
  `status` ENUM('DONE', 'NOT-DONE') NOT NULL,
  CONSTRAINT FOREIGN KEY (`user_name`) REFERENCES `User`(`user_name`)
);

