package sample;

import java.util.ArrayList;

public class Book {

    protected String Name;
    protected String AuthorName;
    protected String PublicationDate;
    protected double Price;
    public double RentPrice;
    public double PurchasePrice;
    protected int Quantity;
    protected String Publisher;
    protected int Borrow;
    protected int Bought;
    protected int State;
    protected int Access;

    public Book()
    {

    }
    public Book(String Name, String AuthorName, String PublicationDate, double Price, int Quantity, String Publisher, double RentPrice, double PurchasePrice, int Borrow, int Bought, int State, int Access)
    {
        this.Name = Name;
        this.AuthorName = AuthorName;
        this.PublicationDate = PublicationDate;
        this.Price = Price;
        this.Quantity = Quantity;
        this.Publisher = Publisher;
        this.RentPrice = RentPrice;
        this.PurchasePrice = PurchasePrice;
        this.Borrow = Borrow;
        this.Bought = Bought;
        this.State = State;
        this.Access = Access;

    }



    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }



    public String getPublicationDate() {
        return PublicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        PublicationDate = publicationDate;
    }



    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }



    public double getRentPrice() {
        return RentPrice;
    }

    public void setRentPrice(double rentPrice) {
        RentPrice = rentPrice;
    }



    public double getPurchasePrice() {
        return PurchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        PurchasePrice = purchasePrice;
    }



    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }



    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }



    public int getBorrow() {
        return Borrow;
    }

    public void setBorrow(int borrow) {
        Borrow = borrow;
    }



    public int getBought() {
        return Bought;
    }

    public void setBought(int bought) {
        Bought = bought;
    }



    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }



    public int getAccess() {
        return Access;
    }

    public void setAccess(int access) {
        Access = access;
    }



    public static String Search(String target, ArrayList<Book> book, int size)
    {

        for (int i = 0; i < size; i++)
        {
            if (target.equals(book.get(i).getName()))
            {
                return book.get(i).toString();
            }

        }
        return "Book not found";
    }

    @Override
    public String toString() {
        return   "Name= " + Name + '\n' +
                "AuthorName= " + AuthorName + '\n' +
                "PublicationDate= " + PublicationDate + '\n' +
                "Price= " + Price + '\n' +
                "RentPrice= " + RentPrice + '\n' +
                "PurchasePrice= " + PurchasePrice + '\n' +
                "Quantity= " + Quantity + '\n' +
                "Publisher= " + Publisher + '\n' +
                "Borrow= " + Borrow + '\n' +
                "Bought= " + Bought + '\n' +
                "State= " + State + '\n' +
                "Access= "+ Access ;
    }
}
