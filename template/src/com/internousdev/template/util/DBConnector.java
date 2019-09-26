package com.internousdev.template.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	/*ドライバー名*/
	private static String driverName = "com.mysql.jdbc.Driver";

	/*データベース接続URL*/
	private static String url = "jdbc:mysql://localhost/ecsite";

	/*アカウント名*/
	private static String user = "root";

	/*パスワード*/
	private static String password = "mysql";

		/*JavaからDB接続の通路(Connectionクラス、型としても使える)*/
		public Connection getConnection() {

			/*初期化*/
			Connection con = null;

				try{
					/*「driverName」→ドライバーのクラス名
					 →ロードされる→実際に使えるようになる*/
					Class.forName(driverName);

					/*設定した情報を使ってMySQLサーバに接続するための記述*/
					/*(Connection)は無理やりConnection型に変換している(キャスト演算子)*/
					con = (Connection) DriverManager.getConnection(url, user, password);

				/*ロードしようとしたが、指定された名前のクラスの定義が見つからなかった場合の処理を記述*/
				}catch(ClassNotFoundException e) {
					e.printStackTrace();

				/*データベースアクセスエラーまたはその他のエラーの場合の処理を記述*/
				 }catch(SQLException e){
					e.printStackTrace();
				  }
				/*MySQLサーバに接続した結果をメソッドの呼び出し元に渡す*/
				return con;
		}

}
