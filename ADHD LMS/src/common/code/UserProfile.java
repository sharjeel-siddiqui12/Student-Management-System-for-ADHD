package common.code;

import java.sql.Date;

public class UserProfile {
    private int id;
    private String name;
    private String email;
    private String password;  
    private String role;
    
    //TEACHER FIELDS
    private int course_id;
    private int lecture_id;
    private String gender;
    private String status;
    //TEACHER & DOCTOR FIELDS
    private String qualification;
    
    //STUDENT FIELDS
    private Date dob;
    private int parent_id;
    private int s_level;
    private String adhdtype;

    public String getAdhdtype() {
        return adhdtype;
    }

    public void setAdhdtype(String adhdtype) {
        this.adhdtype = adhdtype;
    }
    
    //PARENT FIELDS
    private String relation;
   
    
    //STUDENT ATTACHED TABLES FIELDS
     public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
  
  public int getSLevel() {
        return s_level;
    }

    public void setSLevel(int s_level) {
        this.s_level = s_level;
    }
    public int getCourseId() {
        return course_id;
    }

    public void setCourseId(int course_id) {
        this.course_id = course_id;
    }
     public int getParentId() {
        return parent_id;
    }

    public void setParentId(int parent_id) {
        this.parent_id = parent_id;
    }
    public int getLectureId() {
        return lecture_id;
    }
   
    public void setLectureId(int lecture_id) {
        this.lecture_id = lecture_id;
    }
    
      public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
    
     public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    public String getQualification() {
        return qualification;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return name;
    }

    public void setUsername(String username) {
        this.name = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "UserProfile{" + "id=" + id + ", name=" + name + ", email=" + email + ", role=" + role + ", course_id=" + course_id + ", lecture_id=" + lecture_id + ", gender=" + gender + ", status=" + status + ", qualification=" + qualification + ", dob=" + dob + ", parent_id=" + parent_id + ", s_level=" + s_level + ", relation=" + relation + '}';
    }

    
    
 
}

