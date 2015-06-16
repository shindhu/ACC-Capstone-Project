-- LearningDiary Users
DROP TABLE USERS;
SET SCHEMA APP;
CREATE TABLE USERS (ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
					USERNAME VARCHAR(50) NOT NULL UNIQUE,
					PASSWORD VARCHAR(20) NOT NULL,
					EMAIL VARCHAR (50) NOT NULL,
					PRIMARY KEY(ID));

--INSERT INTO USERS (USERNAME, PASSWORD, EMAIL) VALUES ('admin','admin','admin@learningdiary.com'); --1
INSERT INTO USERS (USERNAME, PASSWORD, EMAIL) VALUES ('shindhu','abc','shindhu@learningdiary.com'); --1
INSERT INTO USERS (USERNAME, PASSWORD, EMAIL) VALUES ('john','abc','john@learningdiary.com'); --2
INSERT INTO USERS (USERNAME, PASSWORD, EMAIL) VALUES ('sam','abc','sam@learningdiary.com'); --3
INSERT INTO USERS (USERNAME, PASSWORD, EMAIL) VALUES ('norman','abc','norman@learningdiary.com'); --4
INSERT INTO USERS (USERNAME, PASSWORD, EMAIL) VALUES ('marc','abc','marc@learningdiary.com'); --5

SELECT * FROM USERS;

-- UsersBook
DROP TABLE USERBOOKS;
SET SCHEMA APP;
CREATE TABLE USERBOOKS (ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
			USER_ID INT NOT NULL,
			CONSTRAINT USER_ID_REF FOREIGN KEY (USER_ID) REFERENCES USERS(ID),
			IMAGE VARCHAR(1000),
			NAME VARCHAR(500) NOT NULL,
			BOOK_FORMAT VARCHAR(1000),
			NOTES VARCHAR(32672) );

INSERT INTO USERBOOKS (USER_ID, IMAGE, NAME, BOOK_FORMAT, NOTES) VALUES (1, 'http://ecx.images-amazon.com/images/I/517vKtvmPDL._SX258_BO1,204,203,200_.jpg','Junie B.Jones Books in a Bus! (Books 1-27!)','Hardcover','The box features all-new artwork by Denise Brunkus, so that readers can store their Junie collection in their very own Stupid Smelly Bus.'); 
INSERT INTO USERBOOKS (USER_ID, IMAGE, NAME, BOOK_FORMAT, NOTES) VALUES (1, 'http://ecx.images-amazon.com/images/I/51Bi8EhM5GL._SX258_BO1,204,203,200_.jpg','Magic Tree House, Books 1-28 ','Hardcover','Magic Tree House fan or any child who loves a good adventure.'); 

INSERT INTO USERBOOKS (USER_ID, IMAGE, NAME, BOOK_FORMAT, NOTES) VALUES (2, 'https://kingdomcivics.files.wordpress.com/2013/12/j-k-rowling-harry-potter-the-complete-series-4990-68033-1-zoom.jpg','The Complete Harry Potter Collection','Kindle','The series chronicles the adventures of a young wizard, Harry Potter, the titular character, and his friends Ronald Weasley and Hermione Granger, all of whom are students at Hogwarts School of Witchcraft and Wizardry. The main story arc concerns Harrys quest to overcome the Dark wizard Lord Voldemort, who aims to become immortal, conquer the wizarding world, subjugate non-magical people, and destroy all those who stand in his way, especially Harry Potter.'); 
INSERT INTO USERBOOKS (USER_ID, IMAGE, NAME, BOOK_FORMAT, NOTES) VALUES (2, 'http://ecx.images-amazon.com/images/I/51-uo4HUPCL._SX258_BO1,204,203,200_.jpg','Object-Oriented Analysis and Design with Applications','Hardcover','The authors draw upon their rich and varied experience to offer improved methods for object development and numerous examples that tackle the complex problems faced by software engineers, including systems architecture, data acquisition, cryptoanalysis, control systems, and Web development.'); 

INSERT INTO USERBOOKS (USER_ID, IMAGE, NAME, BOOK_FORMAT, NOTES) VALUES (3, 'http://ecx.images-amazon.com/images/I/81gtKoapHFL.jpg','Design Patterns: Elements of Reusable Object-Oriented Software ','Hardcover','Capturing a wealth of experience about the design of object-oriented software, four top-notch designers present a catalog of simple and succinct solutions to commonly occurring design problems.'); 
INSERT INTO USERBOOKS (USER_ID, IMAGE, NAME, BOOK_FORMAT, NOTES) VALUES (3, 'http://www.headfirstlabs.com/Images/hfdp_cover.gif','Head First Design Patterns','Paperback','Now updated for Java 8—shows you the tried-and-true, road-tested patterns used by developers to create functional, elegant, reusable, and flexible software.'); 

INSERT INTO USERBOOKS (USER_ID, IMAGE, NAME, BOOK_FORMAT, NOTES) VALUES (4, 'http://ecx.images-amazon.com/images/I/51ZGbn7hvuL._SX258_BO1,204,203,200_.jpg','Spring in Action','Hardcover',' It covers Spring core, along with the latest updates to Spring MVC, Security, Web Flow, and more. You will move between short snippets and an ongoing example as you learn to build simple and efficient JEE applications.');

INSERT INTO USERBOOKS (USER_ID, IMAGE, NAME, BOOK_FORMAT, NOTES) VALUES (5, 'http://ecx.images-amazon.com/images/I/81aua6jLqHL.jpg','Java 8 in Action','Hardcover','The book covers lambdas, streams, and functional-style programming. With Java 8s functional features you can now write more concise code in less time, and also automatically benefit from multicore architectures. '); 
INSERT INTO USERBOOKS (USER_ID, IMAGE, NAME, BOOK_FORMAT, NOTES) VALUES (5, 'http://ecx.images-amazon.com/images/I/51Dzvr9b2JL._SX258_BO1,204,203,200_.jpg','Professional Java EE Design Patterns ','Paperback',' This book drives home the implementation of the pattern to real problems to ensure that the reader learns how the patterns should be used and to be aware of their pitfalls.');

SELECT * FROM USERBOOKS;

select * from userbooks where user_id = 3;

delete from userbooks where id=4;


