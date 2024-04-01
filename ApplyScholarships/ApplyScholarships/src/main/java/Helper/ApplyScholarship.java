/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "scholarship")
 @XmlAccessorType(XmlAccessType.FIELD)
public class ApplyScholarship {
    
    private String applicantFName,applicantLName,applicantEmail,applicantPhone,school,gender;
    private int schoolYear;
    private double GPA;
    
    public ApplyScholarship(String applicantFName,String applicantLName, String applicantEmail, String applicantPhone, String school, String gender, int year, double GPA){
        this.applicantFName = applicantFName;
        this.applicantLName = applicantLName;
        this.applicantEmail = applicantEmail;
        this.applicantPhone = applicantPhone;
        this.school = school;
        this.gender = gender;
        this.GPA = GPA;
        this.schoolYear = year;
    }
    
    public ApplyScholarship(){
        this.applicantFName = "";
        this.applicantLName = "";
        this.applicantEmail = "";
        this.applicantPhone = "";
        this.school = "";
        this.gender = "";
        this.GPA = 0.0;
        this.schoolYear = 0;
    }
    
    public String getApplicantFName(){
        return applicantFName;
    }
    
    public String getApplicantLName(){
        return applicantLName;
    }
    
    public String getApplicantEmail(){
        return applicantEmail;
    }
    
    public String getApplicantPhone(){
        return applicantPhone;
    }
    
    public String getApplicantSchool(){
        return school;
    }
    
    public String getApplicantGender(){
        return gender;
    }
    
    public double getApplicantGPA(){
        return GPA;
    }
    
    public int getApplicantYear(){
        return schoolYear;
    }
}
