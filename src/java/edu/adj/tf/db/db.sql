DROP DATABASE forum;
CREATE DATABASE forum;

USE forum;

CREATE TABLE User(
    user_id int(10) AUTO_INCREMENT primary key ,
    first_name varchar(100),
    last_name varchar(100),
    password varchar(100),
    email varchar(100),
    mobile varchar(100)
);

CREATE TABLE Question(
    q_id varchar(10) primary key,
    user_id int(10),
    question varchar(100),
    date varchar(100),
    time varchar(100),
    constraint foreign key(user_id) references User(user_id) 
    on delete cascade on update cascade
);

CREATE TABLE Reply(
    r_id varchar(10) primary key,
    q_id varchar(10),
    user_id int(10),
    reply varchar(100),
    date varchar(100),
    time varchar(100),
    constraint foreign key(q_id) references Question(q_id) 
    on delete cascade on update cascade,
    constraint foreign key(user_id) references User(user_id) 
    on delete cascade on update cascade
);

CREATE TABLE QuestionVote(
    user_id int(10),
    q_id varchar(10),
    vote varchar(100),
    constraint primary key(user_id,q_id),
    constraint foreign key(q_id) references Question(q_id) 
    on delete cascade on update cascade,
    constraint foreign key(user_id) references User(user_id) 
    on delete cascade on update cascade
);

CREATE TABLE ReplyVote(
    user_id int(10),
    r_id varchar(10),
    vote varchar(100),
    constraint primary key(user_id,r_id),
    constraint foreign key(r_id) references Reply(r_id) 
    on delete cascade on update cascade,
    constraint foreign key(user_id) references User(user_id) 
    on delete cascade on update cascade
);

CREATE TABLE Category(
    c_id int(10) AUTO_INCREMENT primary key,
    name varchar(100)
);

CREATE TABLE CategoryDetail(
    cd_id int AUTO_INCREMENT primary key, 
    c_id int(10),
    q_id varchar(10),
    constraint foreign key(c_id) references Category(c_id) 
    on delete cascade on update cascade,
    constraint foreign key(q_id) references Question(q_id) 
    on delete cascade on update cascade    
);


INSERT INTO Category(name) VALUES("JAVA");
INSERT INTO Category(name) VALUES("MYSQL");
INSERT INTO Category(name) VALUES("ANDROID");
INSERT INTO Category(name) VALUES("IOS");
INSERT INTO Category(name) VALUES("HTML");
INSERT INTO Category(name) VALUES("DOTNET");
INSERT INTO Category(name) VALUES("MONGODB");
INSERT INTO Category(name) VALUES("JAVASCRIPT");