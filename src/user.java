import java.util.LinkedList;
import java.util.List;

public class user {
    private final List<person> users = new LinkedList<>();
    private final List<item> items = new LinkedList<>();

    // add item
    public void addItem(item itm) {
        items.add(itm);
    }

    // add user
    public void addUser(person user) {
        users.add(user);
    }

    // checking if username has been existed
    public boolean checkUser(String username) {
        boolean a = false;
        for (person us : users)
            if (us.username.equals(username))
                a = true;

        return a;
    }


    // checking existing users
    public boolean getPass(String un, String pw) {
        boolean e = false;
        for (person f : users) {
            if (f.username.equals(un)) {
                if (f.password.equals(pw)) {
                    e = true;
                }
            }
        }
        return e;
    }

    // find the type of users
    public String findType(String un) {
        String t = null;
        for (person u : users) {
            if (u.username.equals(un)) {
                t = u.type;
            }
        }
        return t;
    }

    // find the username of users
    public String findUser(String un) {
        String t = null;
        for (person u : users) {
            if (u.username.equals(un)) {
                t = u.username;
            }
        }
        return t;
    }

    // find the password of users
    public String findPass(String un) {
        String t = null;
        for (person u : users) {
            if (u.username.equals(un)) {
                t = u.password;
            }
        }
        return t;
    }

    // find the balance of users
    public Long findCash(String un) {
        Long t = null;
        for (person u : users) {
            if (u.username.equals(un)) {
                t = u.money;
            }
        }
        return t;
    }

    // add balance
    public void addCash(String un, Long m) {

        for (person u : users) {
            if (u.username.equals(un)) {
                u.money = u.money + m;
            }
        }
    }

    // find unverified sellers
    public String findUnverifiedUsers() {

        for (person u : users) {
            if (u.type.equals("s")) {
                if (u.verify == 0) {
                    System.out.println(u.username);
                }
            }
        }
        return null;
    }

    // approve sellers
    public void approve(String un) {

        for (person u : users) {
            if (u.username.equals(un)) {
                u.verify = 1;
            }
        }
    }

    // print all users
    public String allUsers() {

        for (person u : users) {
            if (u.type.equals("s") || u.type.equals("c")) {
                System.out.println(u.username);
            }
        }
        return null;
    }

    // remove users
    public void removeUser(String un) {

        for (person u : users) {
            if (u.username.equals(un)) {
                users.remove(u);
            }
        }
    }

    // find verified user
    public boolean checkVerified(String username) {
        boolean a = false;
        for (person us : users)
            if (us.username.equals(username))
                if (us.verify == 1) {
                    a = true;
                }
        return a;
    }

    // printing the list of items
    public String listItems() {

        for (item u : items) {
            System.out.println(u.id + " " + u.name);
        }
        return null;
    }

    // checking the owner of the item
    public boolean checkOwner(String un, Integer n) {
        boolean a = false;
        for (item us : items)
            if (us.id.equals(n))
                if (us.owner.equals(un)) {
                    a = true;
                }
        return a;
    }

    // removing item
    public void removeItem(Integer n) {

        for (item u : items) {
            if (u.id.equals(n)) {
                items.remove(u);
            }
        }
    }

    // printing the list of items with prices and ids
    public String fullListItems() {

        for (item u : items) {
            System.out.println("id: " + u.id + ", name: " + u.name + ", price: " + u.price);
        }
        return null;
    }

    // checking if user has enough money to buy the item
    public boolean checkCash(String un, Integer n) {
        boolean a = false;
        for (person us : users)
            if(us.username.equals(un)) {
                for (item i : items) {
                    if (i.id.equals(n)) {
                        if (us.money >= i.price) {
                            a = true;
                            us.money = us.money - i.price;
                        }
                    }
                }
            }
        return a;
    }

    // printing the items with the searched tag
    public String searchByTag(String tag) {

        for (item u : items) {
            if (u.tag.equals(tag)) {
                System.out.println("id: " + u.id + ", name: " + u.name + ", price: " + u.price);
            }
        }
        return null;
    }

}
