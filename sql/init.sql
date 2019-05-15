
-- CREATE DATABASE engineproject;
-- USE engineproject;
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`(
	user_id INT NOT NULL AUTO_INCREMENT,
	user_name CHAR(50),
	user_birthday DATETIME,
	user_sex CHAR(50),
	user_address CHAR(100),
	PRIMARY KEY(user_id)
);
INSERT INTO `users`(user_name,user_birthday,user_sex,user_address)VALUES('宋乔安','1983-06-21','女','台湾台北'),('刘昭国','1982-07-11','男','台湾高雄'),('王赦','1988-03-1','男','内蒙呼和浩特'),('丁美媚','1990-07-11','女','湖南长沙'),('林一骏','1990-07-21','男','广东揭阳');
INSERT INTO `users`(user_name,user_birthday,user_sex,user_address)VALUES('李大芝','1993-06-21','女','安徽合肥'),('廖纽世','1972-09-11','男','吉林吉林'),('应思悦','1988-03-11','女','新疆维吾尔'),('应思聪','1990-05-11','男','湖北武汉'),('宋乔平','1991-08-11','女','广东东莞');

-- SELECT * FROM `users`;

###############

DROP TABLE IF EXISTS items;
CREATE TABLE items(
	item_id INT NOT NULL AUTO_INCREMENT,
	item_name CHAR(50),
	item_price FLOAT,
	item_pic CHAR(100),
	createtime DATETIME,
	item_detail CHAR(100),
	PRIMARY KEY(item_id)
);

INSERT INTO items(item_name,item_price,createtime,item_detail)
VALUES
	('大鸡腿','89','2019-04-29','炒鸡贵'),
	('变身器','50','1999-04-29','来自M87星云'),
	('咖喱棒','100','2010-10-29','又叫石中剑'),
	('头盔','5','2019-04-01','要威又要戴头盔'),
	('iPhoneSE2','2999','2019-07-29','活在梦里的手机'),
	('老魔杖','42','1601-01-01','要足够老'),
	('和道一文字','350','2003-04-29','未开封'),
	('大馒头','2999','2013-07-29','森海塞尔'),
	('快客杯','199','2014-01-22','情无价'),
	('武则天','2000','2014-05-29','那个女人')
	;
-- SELECT * FROM items;

###############

DROP TABLE IF EXISTS orders;
CREATE TABLE orders(
	order_id INT NOT NULL AUTO_INCREMENT,
	order_userid INT,
	order_goodscount CHAR(50),
	createtime DATETIME,
	order_note CHAR(100),
	PRIMARY KEY(order_id)
);
INSERT INTO orders (order_userid)
VALUES (2),(5),(3),(8),(1),(9),(4),(7),(6),(10),(10),(10),(3),(2),(5),(5),(5),(4),(7),(9);
-- SELECT * FROM orders;

###############

DROP TABLE IF EXISTS orderdetail;
CREATE TABLE orderdetail(
	detail_id INT NOT NULL AUTO_INCREMENT,
	detail_orderid INT,
	detail_itemid INT,
	detail_itemNum CHAR(100),
	PRIMARY KEY(detail_id)
);
INSERT INTO orderdetail(detail_orderid,detail_itemid,detail_itemNum)
VALUES
	('2','1','2'),
	('20','2','1'),
	('13','3','3'),
	('3','4','1'),
	('4','5','1'),
	('7','6','2'),
	('6','7','4'),
	('5','8','1'),
	('1','9','1'),
	('11','10','2'),
	('9','2','1'),
	('8','2','1'),
	('10','4','2'),
	('12','7','2'),
	('19','10','2'),
	('18','3','1'),
	('14','5','1'),
	('15','8','4'),
	('17','10','1'),
	('16','1','8'),
	('11','2','1'),
	('11','4','5'),
	('1','1','6'),
	('2','5','7'),
	('2','10','6'),
	('2','3','4'),
	('3','3','5'),
	('16','4','4'),
	('17','1','1'),
	('17','1','2'),
	('17','5','2'),
	('2','1','1'),
	('19','6','1'),
	('8','7','1'),
	('6','10','1'),
	('5','3','2'),
	('1','8','3'),
	('3','9','3'),
	('9','3','1'),
	('4','1','2')
	;
-- SELECT * FROM orderdetail;
