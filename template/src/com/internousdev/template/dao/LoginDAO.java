package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.template.dto.LoginDTO;
import com.internousdev.template.util.DBConnector;

public class LoginDAO {

	/*ユーザーが入力した情報を抽出する*/
	public LoginDTO getLoginUserInfo(String loginUserId, String loginPassword){

		/*import文で書いた「DBConnector」をインスタンス化する*/
		DBConnector dbConnector = new DBConnector();

		/*DBと接続できるようにする*/
		Connection connection =dbConnector.getConnection();

		/*インスタンス*/
		LoginDTO loginDTO = new LoginDTO();

		/*SQL文を書く*/
		String sql = "SELECT * FROM login_user_transaction where login_id = ? AND login_pass = ?";

			try{
				/*SQL文を運ぶための箱を作る*/
				PreparedStatement preparedStatement = connection.prepareStatement(sql);

				/*25行目のSQL文の「login_id」「login_pass」に代入する*/
				preparedStatement.setString(1, loginUserId);
				preparedStatement.setString(2, loginPassword);

				/*SQL文を実行する*/
				ResultSet resultSet = preparedStatement.executeQuery();

					if(resultSet.next()){
						/*DBから返された値をDTOにセットする*/
						loginDTO.setLoginId(resultSet.getString("login_id"));
						loginDTO.setLoginPassword(resultSet.getString("login_pass"));
						loginDTO.setUserName(resultSet.getString("user_name"));

							/*DBから「login_id」が正常に取り出せたら「true」*/
							if(resultSet.getString("login_id")!= null){
								loginDTO.setLoginFlg(true);
							}
					}
			/*例外処理*/
			}catch(Exception e){
				e.printStackTrace();
			}
			/*loginDTOに値をかえす*/
			return loginDTO;
	}

}
