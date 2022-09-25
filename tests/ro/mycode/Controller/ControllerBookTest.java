package ro.mycode.Controller;

import org.junit.jupiter.api.Test;
import ro.mycode.Model.Book;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControllerBookTest {

    @Test
    public void toSave() {
        ControllerBook controllerBook = new ControllerBook("new");
        Book book = new Book(301,101,"Geografie");
        Book book1 = new Book(302,102,"Limba Romana");
        controllerBook.addBook(book);
        controllerBook.addBook(book1);
        controllerBook.afisare();
    }
    @Test
    public void addBook() {
        ControllerBook controllerBook = new ControllerBook();
        Book book = new Book(301,101,"Geografie");

        controllerBook.addBook(book);

        assertEquals(true,controllerBook.getBookByName("Geografie") != null);

    }

    @Test
    public void pozitie() {
        ControllerBook controllerBook = new ControllerBook("new");
        Book book = new Book(301,101,"Geografie");
        controllerBook.addBook(book);

        controllerBook.pozitie(book.getBookName());

        assertEquals(0,controllerBook.pozitie(book.getBookName()));
    }

    @Test
    public void removeBook() {
        ControllerBook controllerBook = new ControllerBook();
        Book book = new Book(301,101,"Geografie");

        controllerBook.removeBook(book.getBookName());


        assertEquals(true,controllerBook.getBookByName(book.getBookName()) == null);
    }

    @Test
    public void upDate() {
        ControllerBook controllerBook = new ControllerBook();
        Book book = new Book(301,101,"Geografie");

        controllerBook.upDate(book.getBookName(),book);

        assertEquals(true,controllerBook.getBookByName(book.getBookName()) != null);
    }

    @Test
    public void verificareNume() {
        ControllerBook controllerBook = new ControllerBook();
        Book book = new Book(301,101,"Geografie");

        controllerBook.verificareNume(book.getBookName());

        assertEquals(true,controllerBook.getBookByName(book.getBookName()) != null);
    }

    @Test
    public void verificare() {
        ControllerBook controllerBook = new ControllerBook();
        Book book = new Book(301,101,"Geografie");

        controllerBook.verificare(book.getBookName());

        assertEquals(true,controllerBook.getBookByName(book.getBookName()) != null);
    }

    @Test
    public void fiindBooksByUserId() {
        ControllerBook controllerBook = new ControllerBook("new");
        Book book = new Book(301,101,"Geografie");
        Book book1 = new Book(302,102,"Limba Romana");

        controllerBook.addBook(book);
        controllerBook.addBook(book1);

        ArrayList<Integer> studentId = new ArrayList<>();
        studentId.add(101);
        studentId.add(102);

        controllerBook.fiindBooksByUserId(book.getStudentId());

        assertEquals(book,controllerBook.getBookByStudentId(studentId.get(0)));
    }

    @Test
    public void cartiImprumutate (){
        ControllerBook controllerBook = new ControllerBook("new");
        Book book = new Book(301,101,"Geografie");
        controllerBook.addBook(book);

        controllerBook.cartiImprumutate(102, book.getBookName());

        assertEquals(102,book.getStudentId());
    }

    @Test
    public void getBookByName (){
        ControllerBook controllerBook = new ControllerBook("new");
        Book book = new Book(301,101,"Geografie");
        controllerBook.addBook(book);

        Book book1 = controllerBook.getBookByName(book.getBookName());

        assertEquals("Geografie",book1.getBookName());
    }

    @Test
    public void getBookByStudentId (){
        ControllerBook controllerBook = new ControllerBook("new");
        Book book = new Book(301,101,"Geografie");
        controllerBook.addBook(book);

        Book book1 = controllerBook.getBookByStudentId(book.getStudentId());

        assertEquals(101,book1.getStudentId());
    }
}