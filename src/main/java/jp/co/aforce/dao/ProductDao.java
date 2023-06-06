package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.bean.Product;


public class ProductDao extends DAO {

    public void insertMember(Product product) throws SQLException {
        try (Connection connection = getConnection()) {
            String insertQuery = "INSERT INTO member_info (member_id, last_name, first_name, sex, birth_year, birth_month, birth_day, job, phone_number, mail_address) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            
 
            insertStatement.setString(1, product.getMember_id());
            insertStatement.setString(2, product.getLast_name());
            insertStatement.setString(3, product.getFirst_name());
            insertStatement.setString(4, product.getSex());
            insertStatement.setInt(5, product.getBirth_year());
            insertStatement.setInt(6, product.getBirth_month());
            insertStatement.setInt(7, product.getBirth_day());
            insertStatement.setString(8, product.getJob());
            insertStatement.setString(9, product.getPhone_number());
            insertStatement.setString(10, product.getMail_address());

            insertStatement.executeUpdate();
        } catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
    }
    
    public int countMember(Product product) throws SQLException {
        int count = 0;

        try (Connection connection = getConnection()) {
            String countQuery = "SELECT COUNT(*) AS count FROM member_info WHERE last_name = ? AND first_name = ? AND sex = ? AND birth_year = ? AND birth_month = ? AND birth_day = ? AND job = ? AND phone_number = ? AND mail_address = ?";
            PreparedStatement countStatement = connection.prepareStatement(countQuery);
            countStatement.setString(1, product.getLast_name());
            countStatement.setString(2, product.getFirst_name());
            countStatement.setString(3, product.getSex());
            countStatement.setInt(4, product.getBirth_year());
            countStatement.setInt(5, product.getBirth_month());
            countStatement.setInt(6, product.getBirth_day());
            countStatement.setString(7, product.getJob());
            countStatement.setString(8, product.getPhone_number());
            countStatement.setString(9, product.getMail_address());

            ResultSet countResult = countStatement.executeQuery();

            if (countResult.next()) {
                count = countResult.getInt("count");
            }
        } catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}return count;
    }
    
    public List<Product> searchMember(String member_Id) {
        List<Product> memberList = new ArrayList<>();

        try (Connection connection = getConnection()) {
            String selectQuery = "SELECT * FROM member_info WHERE member_id = ?";
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setString(1, member_Id);
           
            ResultSet resultSet = selectStatement.executeQuery();


            while (resultSet.next()) {
                Product p = new Product();
                p.setMember_id(resultSet.getString("member_id"));
                p.setLast_name(resultSet.getString("last_name"));
                p.setFirst_name(resultSet.getString("first_name"));
                p.setSex(resultSet.getString("sex"));
                p.setBirth_year(resultSet.getInt("birth_year"));
                p.setBirth_month(resultSet.getInt("birth_month"));
                p.setBirth_day(resultSet.getInt("birth_day"));
                p.setJob(resultSet.getString("job"));
                p.setPhone_number(resultSet.getString("phone_number"));
                p.setMail_address(resultSet.getString("mail_address"));

                memberList.add(p);
            }System.out.println("Member List: " + memberList);
        } catch (Exception e) {
           
            e.printStackTrace(); // エラーメッセージを出力
            
        }

        return memberList;
    }

    public void updateMember(Product product) throws SQLException{
        try (Connection connection = getConnection()) {
            String updateQuery = "UPDATE member_info SET last_name = ?, first_name = ?, sex = ?, "
                    + "birth_year = ?, birth_month = ?, birth_day = ?, job = ?, phone_number = ?, mail_address = ? "
                    + "WHERE member_id = ?";
            PreparedStatement upStatement = connection.prepareStatement(updateQuery);
            
 
            upStatement.setString(1, product.getMember_id());
            upStatement.setString(2, product.getLast_name());
            upStatement.setString(3, product.getFirst_name());
            upStatement.setString(4, product.getSex());
            upStatement.setInt(5, product.getBirth_year());
            upStatement.setInt(6, product.getBirth_month());
            upStatement.setInt(7, product.getBirth_day());
            upStatement.setString(8, product.getJob());
            upStatement.setString(9, product.getPhone_number());
            upStatement.setString(10, product.getMail_address());

            upStatement.executeUpdate();
        } catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
        }
    
    }

    
