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
UNIQUE (question_id,user_id),
PRIMARY KEY (id),
FOREIGN KEY (question_id) REFERENCES question(id)
);