package sample;

import java.util.ArrayList;

abstract class Person {

    protected String Name;
    protected int ID;
    protected String E_mail;
    protected String Department;


    public abstract String search(String target, ArrayList<Student> Student, ArrayList<Teacher> Teacher, int size);

    @Override
    public String toString() {
        return "Name= " + Name + '\n' +
                "ID= " + ID + '\n' +
                "E_mail= " + E_mail + '\n' +
                "Department= " + Department;
    }
}
