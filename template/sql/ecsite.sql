/*言語を設定*/
set names utf8;

/*初期化？*/
set foreign_key_checks = 0;

/*同じデータベース名のデータベースが存在する場合は消去する*/
drop database if exists ecsite;

/*データベースを新たに作成する*/
create database if not exists ecsite;

/*データベースを使用すると定義する*/
use ecsite;

/*同じテーブル名のテーブルが存在する場合は消去する(念のため?)*/
drop table if exists login_user_transaction;

/*テーブルとその器を新たに作成する*/
create table login_user_transaction(

	/*重複しないシーケンス番号を割り当てている*/
	id int not null primary key auto_increment,

	/*テーブルの中の名前と型と大きさを記載*/
	login_id varchar(16) unique,
	login_pass varchar(16),
	user_name varchar(50),

	/*DBに日時を表示する*/
	insert_date datetime,
	updated_date datetime
);

/*同じテーブル名のテーブルが存在する場合は消去する(念のため?)*/
drop table if exists item_info_transaction;

/*テーブルとその器を新たに作成する*/
create table item_info_transaction(

	/*重複しないシーケンス番号を割り当てている*/
	id int not null primary key auto_increment,

	/*テーブルの中の名前と型と大きさを記載*/
	item_name varchar(30),
	item_price int,
	item_stock int,

	/*DBに日時を表示する*/
	insert_date datetime,
	update_date datetime
);

/*同じテーブル名のテーブルが存在する場合は消去する(念のため?)*/
drop table if exists user_buy_item_transaction;

/*テーブルとその器を新たに作成する*/
create table user_buy_item_transaction(

	/*重複しないシーケンス番号を割り当てている*/
	id int not null primary key auto_increment,

	/*テーブルの中の名前と型と大きさを記載*/
	item_transaction_id int,
	total_price int,
	total_count int,
	user_master_id varchar(16),
	pay varchar(30),

	/*DBに日時を表示する*/
	insert_date datetime,
	delete_date datetime
);

/*データを追加する*/
INSERT INTO item_info_transaction(item_name, item_price, item_stock) VALUES("ノートBook", 100, 50);
INSERT INTO login_user_transaction(login_id, login_pass, user_name) VALUES("internous", "internous01","test");

