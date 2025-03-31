CREATE TABLE question(
id INT AUTO_INCREMENT,
question_title VARCHAR(250) UNIQUE NOT NULL,
answer_1 VARCHAR(250) NOT NULL,
answer_2 VARCHAR(250) NOT NULL,
answer_3 VARCHAR(250) NOT NULL,
answer_4 VARCHAR(250) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE answer(
id INT AUTO_INCREMENT,
question_id INT NOT NULL,
answer_id INT NOT NULL,
user_id INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (question_id) REFERENCES question(id)
--FOREIGN KEY (user_id) REFERENCES id(user)
)



--CREATE TABLE users(
--id INT AUTO_INCREMENT,
--first_name VARCHAR(30) NOT NULL,
--last_name VARCHAR(30) NOT NULL,
--email VARCHAR(50) UNIQUE NOT NULL,
--age INT NOT NULL,
--address VARCHAR(100) NOT NULL,
--joining_date DATE,
----date is allowed to be null since we do not enter it. it finds the current date which is the date the user is made
--PRIMARY KEY (id)
--);
