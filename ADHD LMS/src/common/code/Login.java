package common.code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Login {
    private MyDbConnector dbConnector;

    public Login() {
        dbConnector = new MyDbConnector();
    }

  
    
    public UserProfile authenticateUser(String email, String password) {
         try {
        Connection connection = null; 
        
        connection = dbConnector.getMyConnection();
        String sql = "select role from user where email = ?";
          PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
          ResultSet resultSet = preparedStatement.executeQuery();
          String rolee = "";
           if (resultSet.next()) {
           rolee = resultSet.getString("role");
           }
        
        if(rolee.equals("Admin")){
            sql = "SELECT *  FROM user WHERE email = ? AND password = ?";
        }else if(rolee.equals("Teacher")) {
            sql = "select t_status from teacher where email = ?";
            preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1, email);
           resultSet = preparedStatement.executeQuery();
          String status = "";
           if (resultSet.next()) {
           status = resultSet.getString("t_status");
           }
           if(status.equals("approved")){
               
            sql = "SELECT t.*   FROM user u,teacher t WHERE u.id = t.t_id and u.email = ? AND u.password = ?";
           }else{
               JOptionPane.showMessageDialog(null, "You are not approved yet", "Error", JOptionPane.ERROR_MESSAGE);
            
           }
        } 
        else{
            if(rolee.equals("Doctor")){
                sql = "SELECT r.*   FROM user u," + rolee.toLowerCase() + " r WHERE u.id = r.d_id and u.email = ? AND u.password = ?";
            }else if(rolee.equals("Parent")){
                sql = "SELECT r.*   FROM user u," + rolee.toLowerCase() + " r WHERE u.id = r.p_id and u.email = ? AND u.password = ?";
            }else if(rolee.equals("Student")){
                sql = "SELECT r.*   FROM user u," + rolee.toLowerCase() + " r WHERE u.id = r.s_id and u.email = ? AND u.password = ?";
            }
            
        }
        
       
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
             
                if (resultSet.next()) {

                    UserProfile user = new UserProfile();
                  
                    user.setUsername(resultSet.getString("name"));
                    user.setEmail(resultSet.getString("email"));
                    user.setRole(rolee);
                    
                    if(rolee.equals("Parent")){
                         user.setId(resultSet.getInt("p_id"));
                        user.setRelation(resultSet.getString("relation"));
                        
                    }
                    else  if(rolee.equals("Teacher")){
                         user.setId(resultSet.getInt("t_id"));
                        user.setGender(resultSet.getString("gender"));
                         user.setCourseId(resultSet.getInt("c_id"));
                          user.setStatus(resultSet.getString("t_status"));
                          user.setQualification(resultSet.getString("qualification"));
                    }
                     else  if(rolee.equals("Doctor")){
                          user.setId(resultSet.getInt("d_id"));
                          user.setQualification(resultSet.getString("qualification"));
                    } 
                     else if(rolee.equals("Student")){
                          user.setId(resultSet.getInt("s_id"));
                          user.setDob(resultSet.getDate("DOB"));
                          user.setParentId(resultSet.getInt("p_id"));
                          user.setSLevel(resultSet.getInt("s_level"));
                        user.setGender(resultSet.getString("gender"));
                        user.setAdhdtype(resultSet.getString("adhd_type"));
                    }else if(rolee.equals("Admin")){
                         user.setId(resultSet.getInt("id"));
                    }
                    return user;
                }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return null;
    }
}
