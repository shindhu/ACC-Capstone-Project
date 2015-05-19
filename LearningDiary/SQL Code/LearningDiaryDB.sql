-- Table Category
DROP TABLE CATEGORY;
SET SCHEMA APP;
CREATE TABLE CATEGORY ( ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	NAME VARCHAR(50) NOT NULL);

INSERT INTO CATEGORY (NAME) values ('Autobiography');
INSERT INTO CATEGORY (NAME) values ('Investments');
INSERT INTO CATEGORY (NAME) values ('Self Improvements');
INSERT INTO CATEGORY (NAME) values ('Stories');
INSERT INTO CATEGORY (NAME) values ('Technology');

SELECT * FROM CATEGORY;

-- Table Books
DROP TABLE BOOKS;
SET SCHEMA APP;
CREATE TABLE BOOKS ( ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	CATEGORY_ID INT NOT NULL,
	CATEGORY_NAME VARCHAR(50),
	IMAGE VARCHAR(1000),
	NAME VARCHAR(50) NOT NULL,
	BOOK_FORMAT VARCHAR(1000),
	NOTES VARCHAR(10000));
-- 1 Autobiography Books
INSERT INTO BOOKS(CATEGORY_ID,CATEGORY_NAME, IMAGE, NAME, BOOK_FORMAT, NOTES) VALUES(1,'Autobiography', 'http://d.gr-assets.com/books/1348842650l/3142407.jpg','The Name Is Rajinikanth','HARD BOOK','SUPER HIT STAR IN KOLLYWOOD, DEVOTEE OF BABAJI & RAGAVENDRA');
INSERT INTO BOOKS(CATEGORY_ID,CATEGORY_NAME, IMAGE, NAME, BOOK_FORMAT, NOTES) VALUES(1,'Autobiography', 'http://upload.wikimedia.org/wikipedia/en/e/e4/Steve_Jobs_by_Walter_Isaacson.jpg','Steve Jobs','HARD BOOK',' American entrepreneur, marketer, and inventor, who was the cofounder, chairman, and CEO of Apple Inc. ');
INSERT INTO BOOKS(CATEGORY_ID,CATEGORY_NAME, IMAGE, NAME, BOOK_FORMAT, NOTES) VALUES(1,'Autobiography', 'http://upload.wikimedia.org/wikipedia/en/3/3a/Wings_of_Fire_by_A_P_J_Abdul_Kalam_Book_Cover.jpg','Wings of Fire','HARD BOOK','When the student is ready, the teacher will appear - How true!');
-- 2 Investments Books
INSERT INTO BOOKS(CATEGORY_ID,CATEGORY_NAME, IMAGE, NAME, BOOK_FORMAT, NOTES) VALUES(2,'Investments', 'http://ecx.images-amazon.com/images/I/5113wZDGuCL._SX258_BO1,204,203,200_.jpg','Buying Real Estate Without Cash OR Credit','HARD BOOK','3 Biggest marketing mistakes most beginning investors make. The 3 most important terms deal acquisition stratergies');
INSERT INTO BOOKS(CATEGORY_ID,CATEGORY_NAME, IMAGE, NAME, BOOK_FORMAT, NOTES) VALUES(2,'Investments','http://img1.imagesbn.com/p/9780446691840_p0_v1_s260x420.JPG','The ABCs of Real Estate Investing','HARD BOOK','The secrets of finding hidden profits most investors miss');
-- 3 Self Improvements Books
INSERT INTO BOOKS(CATEGORY_ID,CATEGORY_NAME, IMAGE, NAME, BOOK_FORMAT, NOTES) VALUES(3,'Self improvements', 'http://ecx.images-amazon.com/images/I/51TXJ-YCNpL._SY344_BO1,204,203,200_.jpg','Dale Carnagie Lifetime Plan For Success','HARD BOOK','How to Win Friends & Influence People and How to Stop Worrying & Start Living');
INSERT INTO BOOKS(CATEGORY_ID,CATEGORY_NAME, IMAGE, NAME, BOOK_FORMAT, NOTES) VALUES(3,'Self improvements', 'http://img6a.flixcart.com/img/608/9780981475608.jpg','Speakers Edge','HARD BOOK','Secrets and Stratergies for Connecting with Any Audience');
-- 4 Stories
INSERT INTO BOOKS(CATEGORY_ID,CATEGORY_NAME, IMAGE, NAME, BOOK_FORMAT, NOTES) VALUES(4,'Stories', 'http://upload.wikimedia.org/wikipedia/en/8/88/WhoMovedMyCheeseCover.jpg','Who Moved My Cheese','HARD BOOK','An amazing way to DEAL with Change in your Work and in your Life');
-- 5 Technology
INSERT INTO BOOKS(CATEGORY_ID,CATEGORY_NAME, IMAGE, NAME, BOOK_FORMAT, NOTES) VALUES(5,'Technology', 'http://ecx.images-amazon.com/images/I/51PNFtMQBaL._SX258_BO1,204,203,200_.jpg','Murachs Java Servlets and JSP','HARD BOOK','Easy book to learn java servlets and jsp for Beginners');
INSERT INTO BOOKS (CATEGORY_ID,CATEGORY_NAME, IMAGE, NAME, BOOK_FORMAT, NOTES) VALUES(5, 'Technology','http://www.headfirstlabs.com/Images/hfjava_cover.gif','Head First Java 2nd Edition','http://it-ebooks.info/book/3214/','Book has explained in simple terms');

SELECT * FROM BOOKS;

-- to display the category name and count of books in each category
select category.id,category.name, count(books.name) as bookcounts
from category, books
where category.id = books.category_id
group by category.id,category.name;

select * from books where category_id = 2;


select count(name) from books group by CATEGORY_id;


