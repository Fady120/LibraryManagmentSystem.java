package sample;

import java.util.ArrayList;

public class Teacher extends Person {

    protected ArrayList<Book> Bought = new ArrayList<Book>();
    protected int C_bought = 0;
    protected ArrayList<Book> Borrow = new ArrayList<Book>();
    protected int C_borrow;
    private String email;
    private String pass;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public ArrayList<Book> getBought() {
        return Bought;
    }

    public void setBought(ArrayList<Book> bought) {
        Bought = bought;
    }



    public int getC_bought() {
        return C_bought;
    }

    public void setC_bought(int c_bought) {
        C_bought = c_bought;
    }


    public ArrayList<Book> getBorrow() {
        return Borrow;
    }

    public void setBorrow(ArrayList<Book> borrow) {
        Borrow = borrow;
    }


    public int getC_borrow() {
        return C_borrow;
    }

    public void setC_borrow(int c_borrow) {
        C_borrow = c_borrow;
    }

    @Override
    public String search(String target, ArrayList<Student> Student, ArrayList<Teacher> Teacher, int size) {
        for (int i = 0; i < size; i++)
        {
            if (target.equals(Teacher.get(i).Name))
            {
                return (Teacher.get(i).toString()+"\nNumber of Borrowed Books: " + Teacher.get(i).C_borrow + "\nNumber of Bought Books: " + Teacher.get(i).C_bought);
            }
        }
        return "Teacher not found";
    }

}
