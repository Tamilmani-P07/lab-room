package demo;

public class Book {
    private int id;
    private String title;
    private float price;
    private int author_id;
    private String author_name;
 

    

    public Book(int id, String title, float price,int aid) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.author_id=aid;
    
    }

    public Book(int id2, String title2, float price2, String author_name2) {
        this.id = id2;
        this.title = title2;
        this.price = price2;
        this.author_name=author_name2;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    
    
}
