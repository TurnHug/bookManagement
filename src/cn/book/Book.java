package cn.book;

/**
 * @author TurnHug
 * @date 2022/9/21 8:56
 */
public class Book {
    private String id;
    private String name;
    private String type;
    private Boolean free;
    private double price;
    private Boolean state;
    private String people;
    private String lendDate;
    private String returnDate;

    public Book(){

    }
    public Book(String id, String name, String type, Boolean free, double price,Boolean state,String people) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.free = free;
        this.price = price;
        this.state = state;
        this.people = people;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean getFree() {
        return free;
    }


    public void setFree(Boolean free) {
        this.free = free;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getLendDate() {
        return lendDate;
    }

    public void setLendDate(String lendDate) {
        this.lendDate = lendDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", free=" + free +
                ", price=" + price +
                '}';
    }
}
