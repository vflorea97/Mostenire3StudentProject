package ro.mycode.Controller;

import ro.mycode.Model.Book;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerBook {
    private ArrayList<Book> books;

    public ControllerBook (){
        books = new ArrayList<>();
        this.load();

    }
    public ControllerBook (String text){
        books = new ArrayList<>();
    }
    public void load (){
        try {
            File file = new File("D:\\mycode\\mostenirea\\Mostenire3StudentProject\\src\\ro\\mycode\\Data\\Book.txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                String text = scanner.nextLine();
                Book book = new Book(text);
                this.books.add(book);
            }
            scanner.close();
        }catch (Exception e){

        }
    }
    public void save (){
        try{
            File file = new File("D:\\mycode\\mostenirea\\Mostenire3StudentProject\\src\\ro\\mycode\\Data\\Book.txt");
            FileWriter writer = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.print(this.toSave());
            printWriter.close();

        }catch (Exception e){

        }
    }
    public String toSave (){
        String text = "";
        int i = 0;
        for (i = 0; i < books.size() - 1; i++){
            text += this.books.get(i).toSave() + "\n";
        }
        text += this.books.get(i).toSave();
        return text;
    }

    public void afisare (){
        for (int i = 0; i < books.size(); i++){
            System.out.println(books.get(i).descriere());
        }
    }

    public Book getBookByName(String nume) {
        for (int i = 0; i < books.size(); i++){
            if (books.get(i).getBookName().equals(nume)){
                return books.get(i);
            }
        }
        return null;
    }
    public Book getBookByStudentId (int id){
        for (int i = 0; i < books.size(); i++){
            if (books.get(i).getStudentId() == id){
                return books.get(i);
            }
        }
        return null;
    }
    public void addBook (Book book){
        if (getBookByName(book.getBookName()) == null) {
            this.books.add(book);
        }
    }

    public int pozitie (String text){
        for(int i = 0; i < books.size(); i++){
            if(books.get(i).getBookName().equals(text)){
                return i;
            }
        }
        return -1;
    }
    public void removeBook (String text){
        int poz = pozitie(text);
        if (poz != -1){
            this.books.remove(poz);
        }
    }

    public void upDate (String nume, Book b){
        int poz = pozitie(nume);
        Book book = this.books.get(poz);
        if (b.getId() != 0){
            book.setId(b.getId());
        }
        if (b.getStudentId() != 0){
            book.setStudentId(b.getStudentId());
        }
        if (!b.getBookName().equals("")){
            book.setBookName(b.getBookName());
        }

    }

    public boolean verificareNume (String nume){
        for (int i = 0; i < books.size(); i++){
            if (books.get(i).getBookName().equals(nume)){
                return true;
            }
        }
        return false;
    }
    public void verificare (String nume){
        if (!verificareNume(nume)){
            System.out.println("Nu exista aceasta carte, introdu alt nume!");
        }
    }

    public ArrayList<Book>  fiindBooksByUserId (int id){
        ArrayList<Book> carti = new ArrayList<>();
        for (int i = 0; i < books.size(); i++){
            if (books.get(i).getStudentId() == id){
                carti.add(books.get(i));
            }
        }
        return carti;
    }

    public Book cartiImprumutate (int id, String nume){
        Book book = new Book();
        for (int i = 0; i < books.size(); i++){
            if (books.get(i).getBookName().equals(nume)){
                books.get(i).setStudentId(id);
            }
        }
        return book;
    }
}
