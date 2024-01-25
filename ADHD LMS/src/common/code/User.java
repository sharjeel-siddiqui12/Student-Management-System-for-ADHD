package common.code;

import admin.gui.AdminDashboard;
import Teacher.gui.LecturerDashboard;
import common.gui.LoginNewGui;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import student.StudentDashboard;

public class User implements UserOperations {
    
    @Override
    public void logout(){
        LoginNewGui newLogin = new LoginNewGui();
        newLogin.setVisible(true);
    }

    @Override
    public void back(Object parameter) {
        
        UserProfile loggedUser = Auth.getLoggedUser();
        String userType = loggedUser.getRole();
        
        if("Admin".equals(userType)){
            AdminDashboard adminDash = new AdminDashboard();
            adminDash.setVisible(true);
        }else if("Student".equals(userType)){
            StudentDashboard stu = new StudentDashboard();
            stu.setVisible(true);            
        }else if("Teacher".equals(userType)){
              LecturerDashboard lecDash;
            try {
                lecDash = new LecturerDashboard();
                 lecDash.setVisible(true);        
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }else{
            System.out.println("Null value.... Errorr");
        }
    }
 
}