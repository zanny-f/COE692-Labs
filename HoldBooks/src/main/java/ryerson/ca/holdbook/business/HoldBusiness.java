/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.holdbook.business;



import ryerson.ca.holdbook.helper.BookHold;
import ryerson.ca.holdbook.persistence.BOOK_Hold_CRUD;

/**
 *
 * @author student
 */
public class HoldBusiness {

   



    public BookHold getBooks(String isbn) {
        BookHold bs = BOOK_Hold_CRUD.getHoldBook(isbn);

        return (bs);
    }

public boolean hold(String isbn, String userid) {
       
        return (BOOK_Hold_CRUD.addHold(isbn, userid));
    }

    
}
