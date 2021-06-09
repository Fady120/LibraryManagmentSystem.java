package sample;

import java.util.ArrayList;

public class Student extends Person {

    protected ArrayList<Book> Bought = new ArrayList<Book>();
    protected int C_bought = 0;
    protected ArrayList<Book> Borrow = new ArrayList<Book>();
    protected int C_borrow;


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
            if (target.equals(Student.get(i).Name))
            {
                return (Student.get(i).toString() + "\nNumber of Borrowed Books= " + Student.get(i).C_borrow + "\nNumber of Boughted Books= " + Student.get(i).C_bought);
            }
        }
        return "Student not found";
    }
}
