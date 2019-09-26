package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.template.dto.BuyItemDTO;
import com.internousdev.template.util.DBConnector;

public class BuyItemDAO {

	/*ユーザーが入力した情報を抽出する*/
	public BuyItemDTO getBuyItemInfo(){

		/*import文で書いた「DBConnector」をインスタンス化する*/
		DBConnector dbConnector =new DBConnector();

		/*DBと接続できるようにする*/
		Connection connection = dbConnector.getConnection();

		/*インスタンス*/
		BuyItemDTO buyItemDTO = new BuyItemDTO();

		/*SQL文を書く*/
		String sql = "SELECT id, item_name, item_price FROM item_info_transaction";

			try{
				/*SQL文を運ぶための箱を作る*/
				PreparedStatement preparedStatement = connection.prepareStatement(sql);

				/*SQL文を実行する*/
				ResultSet resultSet = preparedStatement.executeQuery();

					if(resultSet.next()){
						/*DBから返された値をDTOにセットする*/
						buyItemDTO.setId(resultSet.getInt("id"));
						buyItemDTO.setItemName(resultSet.getString("item_name"));
						buyItemDTO.setItemPrice(resultSet.getString("item_price"));
					}

			/*例外処理*/
			}catch(Exception e){
				e.printStackTrace();
			}
			/*buyItemDTOに値をかえす*/
			return buyItemDTO;
	}

}
