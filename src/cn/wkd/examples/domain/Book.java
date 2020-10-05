package cn.wkd.examples.domain;

/**
 * @author 许佳华
 * @Description: 实体类，图书类
 * @date 2020/3/11 23:34
 */
public class Book {
    private String bk_ISBN;  //书的isbn号，唯一标识
    private String bk_name;  //书名
    private String bk_author; //作者
    private String bk_picuri; //书的封面的图片uri
    private String bk_press;  //出版社
    private String bk_detail; //书的详情
    private double bk_price; //书的价格

    public Book() {
    }

    public Book(String bk_ISBN, String bk_name, String bk_author, String bk_picuri, String bk_press, String bk_detail, double bk_price) {
        this.bk_ISBN = bk_ISBN;
        this.bk_name = bk_name;
        this.bk_author = bk_author;
        this.bk_picuri = bk_picuri;
        this.bk_press = bk_press;
        this.bk_detail = bk_detail;
        this.bk_price = bk_price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bk_ISBN='" + bk_ISBN + '\'' +
                ", bk_name='" + bk_name + '\'' +
                ", bk_author='" + bk_author + '\'' +
                ", bk_picuri='" + bk_picuri + '\'' +
                ", bk_press='" + bk_press + '\'' +
                ", bk_detail='" + bk_detail + '\'' +
                ", bk_price=" + bk_price +
                '}';
    }

    public String getBk_ISBN() {
        return bk_ISBN;
    }

    public void setBk_ISBN(String bk_ISBN) {
        this.bk_ISBN = bk_ISBN;
    }

    public String getBk_name() {
        return bk_name;
    }

    public void setBk_name(String bk_name) {
        this.bk_name = bk_name;
    }

    public String getBk_author() {
        return bk_author;
    }

    public void setBk_author(String bk_author) {
        this.bk_author = bk_author;
    }

    public String getBk_picuri() {
        return bk_picuri;
    }

    public void setBk_picuri(String bk_picuri) {
        this.bk_picuri = bk_picuri;
    }

    public String getBk_press() {
        return bk_press;
    }

    public void setBk_press(String bk_press) {
        this.bk_press = bk_press;
    }

    public String getBk_detail() {
        return bk_detail;
    }

    public void setBk_detail(String bk_detail) {
        this.bk_detail = bk_detail;
    }

    public double getBk_price() {
        return bk_price;
    }

    public void setBk_price(double bk_price) {
        this.bk_price = bk_price;
    }
}
