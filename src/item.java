
public class item {

    public String name;
    public String tag;
    public Long price;
    public Integer id;
    public String owner;

    public item(Integer id, String name, Long price, String tag, String owner) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.tag = tag;
        this.owner = owner;
    }

}
