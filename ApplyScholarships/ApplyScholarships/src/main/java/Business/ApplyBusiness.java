package Business;

import Helper.ApplyScholarship;
import Persistence.Apply_CRUD;

public class ApplyBusiness {
   
    public ApplyScholarship getApplication(String firstName) {
        ApplyScholarship s = Apply_CRUD.getApplication(firstName);
        return (s);
    }

public boolean apply(String firstName, String lastName){//, String email, String phoneNumber, String school, String gender, int schoolYear, double GPA) {
       return (Apply_CRUD.addApplication(firstName, lastName)); //, email, phoneNumber, school, gender, schoolYear, GPA));
    }
}