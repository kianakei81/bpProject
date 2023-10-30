import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        user user = new user();

        long money = 0;
        // 0 = unverified, 1 = verified
        int verify = 0;
        int id = 1;
        int k;
        int o;
        int f;
        int g;
        int u;

        // add admin
        String ad = "admin";
        int v = 1;
        user.addUser(new person(ad, ad, ad, money, v));

        System.out.println("Hello, welcome to our online shop");

        boolean b = true;
        while (b) {
            // menu
            System.out.println("here’s a list of available commands:");
            System.out.println("1. Sign up");
            System.out.println("2. Log in");
            System.out.println("3. Close");

            o = scanner.nextInt();

            switch (o) {
                // sign up
                case 1:
                    // get the type
                    System.out.println("Seller or costumer?(s or c)\n1. Back\t");
                    String type = scanner.next();
                    if(type.equals("1")) {
                        break;
                    }
                    // get username
                    System.out.println("Please Enter your username:\n1. Back\t");
                    String username = scanner.next();
                    if(username.equals("1")) {
                        break;
                    }
                    // check if the username has already been chosen
                    if (user.checkUser(username)) {
                        System.out.println("Sorry, this username has already been chosen.");
                        System.out.println("a. Back");
                        String ll = scanner.next();
                        if(ll.equals("a")) {
                            break;
                        }
                    }
                    // get the password
                    System.out.println("Please Enter your password:\n1. Back\t");
                    String password = scanner.next();
                    if(password.equals("1")) {
                        break;
                    }

                    // add users info
                    user.addUser(new person(type, username, password, money, verify));
                    System.out.println("Done");
                    System.out.println("a. Back");
                    String c = scanner.next();
                    if(c.equals("a")) {
                        break;
                    }
                // log in
                case 2:
                    // ask for username
                    System.out.println("username:");
                    String un = scanner.next();
                    // ask for password
                    System.out.println("password:");
                    String pw = scanner.next();
                    // check if username or password is wrong
                    if (!user.checkUser(un) || !user.getPass(un, pw)) {
                        System.out.println("Sorry, the username or password is wrong.");
                        System.out.println("a. Back");
                        String nn = scanner.next();
                        if(nn.equals("a")) {
                            break;
                        }
                    }
                    // costumer
                    if (user.findType(un).equals("c")) {
                        boolean a = true;
                        while (a) {
                            // menu
                            System.out.println("list of available commands:");
                            System.out.println("1. account info");
                            System.out.println("2. add balance");
                            System.out.println("3. list of items");
                            System.out.println("4. search by tag");
                            System.out.println("5. log out");

                            f = scanner.nextInt();

                            switch(f) {
                                case 1 :
                                    System.out.println("User type: costumer");
                                    System.out.println("Username: " + un);
                                    System.out.println("Password: " + pw);
                                    System.out.println("Cash: " + user.findCash(un));
                                    System.out.println("1. Back");
                                    g = scanner.nextInt();
                                    if(g == 1) {
                                        break;
                                    }

                                case 2 :
                                    // show how much money user has
                                    System.out.println("Cash: " + user.findCash(un));
                                    System.out.println("1. add money\n2. Back");
                                    int h = scanner.nextInt();
                                    if(h == 2) {
                                        break;
                                    } else if(h == 1) {
                                        System.out.println("How much money do you want to add?");
                                        long add = scanner.nextLong();
                                        user.addCash(un, add);
                                        System.out.println("done");
                                    }
                                    System.out.println("a. Back");
                                    String j = scanner.next();
                                    if(j.equals("a")) {
                                        break;
                                    }

                                case 3 :
                                    System.out.println("list of items:");
                                    user.fullListItems();
                                    System.out.println("Enter the id of the item you want to buy:");
                                    int vv = scanner.nextInt();
                                    if(user.checkCash(un, vv)) {
                                        user.removeItem(vv);
                                        System.out.println("Done");
                                        System.out.println("a. Back");
                                        String r = scanner.next();
                                        if(r.equals("a")) {
                                            break;
                                        }
                                    } else {
                                        System.out.println("sorry, you don’t have enough balance to buy this item.");
                                        System.out.println("a. Back");
                                        String q = scanner.next();
                                        if(q.equals("a")) {
                                            break;
                                        }
                                    }
                                case 4 :
                                    System.out.println("Enter the tag you want to search by:");
                                    String tg = scanner.next();
                                    System.out.println("list of items:");
                                    user.searchByTag(tg);
                                    System.out.println("Enter the id of the item you want to buy:");
                                    int yy = scanner.nextInt();
                                    if(user.checkCash(un, yy)) {
                                        user.removeItem(yy);
                                        System.out.println("Done");
                                        System.out.println("a. Back");
                                        String r = scanner.next();
                                        if(r.equals("a")) {
                                            break;
                                        }
                                    } else {
                                        System.out.println("sorry, you don’t have enough balance to buy this item.");
                                        System.out.println("a. Back");
                                        String q = scanner.next();
                                        if(q.equals("a")) {
                                            break;
                                        }
                                    }

                                case 5 :
                                    a = false;
                                    break;
                            }
                        }
                    // seller
                    } else if(user.findType(un).equals("s")) {
                        boolean y = true;
                        while(y) {
                            // menu
                            System.out.println("list of available commands:");
                            System.out.println("1. account info");
                            System.out.println("2. add item");
                            System.out.println("3. remove item");
                            System.out.println("4. log out");

                            k = scanner.nextInt();

                            switch(k) {
                                // account info
                                case 1 :
                                    System.out.println("User type: seller");
                                    System.out.println("Username: " + un);
                                    System.out.println("Password: " + pw);
                                    if(user.checkVerified(un)) {
                                        System.out.println("Verified");
                                    } else {
                                        System.out.println("Unverified");
                                    }
                                    System.out.println("1. Back");
                                    g = scanner.nextInt();
                                    if(g == 1) {
                                        break;
                                    }
                                // add item
                                case 2 :
                                    if (user.checkVerified(un)) {
                                        boolean t = true;
                                        while(t) {
                                            System.out.println("a. add\nb. Back");
                                            String ans = scanner.next();
                                            if(ans.equals("a")) {
                                                // ask for item name
                                                System.out.println("item name:");
                                                String item_name = scanner.next();
                                                // ask for item price
                                                System.out.println("item price:");
                                                long item_price = scanner.nextLong();
                                                // ask for item tag
                                                System.out.println("item tag:");
                                                String item_tag = scanner.next();

                                                user.addItem(new item(id, item_name, item_price, item_tag, un));
                                                System.out.println("item with id " + id + " was added successfully.");
                                                id++;

                                            } else if(ans.equals("b")) {
                                                t = false;
                                                break;
                                            }

                                        }
                                    } else {
                                        // for unverified users
                                        System.out.println("you don’t have the permission to add an item.");
                                    }
                                    break;
                                // remove item
                                case 3 :
                                    System.out.println("list of items:");
                                    user.listItems();
                                    System.out.println("Enter the number of the item you want to remove:");
                                    int dd = scanner.nextInt();
                                    if(user.checkOwner(un, dd)) {
                                        user.removeItem(dd);
                                        System.out.println("item was removed successfully.");
                                        System.out.println("a. Back");
                                        String w = scanner.next();
                                        if(w.equals("a")) {
                                            break;
                                        }

                                    } else {
                                        System.out.println("you can’t remove this item.");
                                        System.out.println("a. Back");
                                        String i = scanner.next();
                                        if(i.equals("a")) {
                                            break;
                                        }
                                    }

                                case 4 :
                                    y = false;
                                    break;
                            }

                        }
                    // admin
                    } else if (un.equals("admin") && pw.equals("admin")) {
                        boolean x = true;
                        while(x) {
                            // menu
                            System.out.println("list of available commands:");
                            System.out.println("1. list of unverified users");
                            System.out.println("2. list of all users");
                            System.out.println("3. remove user");
                            System.out.println("4. remove item");
                            System.out.println("5. log out");
                            u = scanner.nextInt();
                            switch(u) {
                                // list of unverified users
                                case 1 :
                                    System.out.println("list of unverified users:");
                                    user.findUnverifiedUsers();
                                    System.out.println("a. approve\nb. back");
                                    String z = scanner.next();
                                    if(z.equals("a")) {
                                        System.out.println("Enter the username you want to approve:");
                                        String input = scanner.next();
                                        user.approve(input);
                                        System.out.println("Done");
                                        System.out.println("a. Back");
                                        String i = scanner.next();
                                        if(i.equals("a")) {
                                            break;
                                        }
                                    } else if (z.equals("b")) {
                                        break;
                                    }

                                // list of all users
                                case 2 :
                                    System.out.println("list of all users:");
                                    user.allUsers();
                                    System.out.println("a. Back");
                                    String l = scanner.next();
                                    if(l.equals("a")) {
                                        break;
                                    }
                                // remove users
                                case 3 :
                                    System.out.println("list of users:");
                                    user.allUsers();
                                    boolean aa = true;
                                    while(aa) {
                                        System.out.println("a. remove\nb. Back");
                                        String zz = scanner.next();
                                        if(zz.equals("a")) {
                                            System.out.println("Enter the username you want to remove:\n1. Back");
                                            String uu = scanner.next();
                                            if(uu.equals("1")) {
                                                aa = false;
                                                break;
                                            } else {
                                                user.removeUser(uu);
                                                System.out.println("user with username " + uu + " was removed successfully.");
                                            }
                                        } else if (zz.equals("b")) {
                                            aa = false;
                                            break;
                                        }
                                    }
                                    break;
                                // remove item
                                case 4 :
                                    System.out.println("list of items:");
                                    user.listItems();
                                    System.out.println("Enter the id of the item you want to remove:\n0. Back");
                                    int kk = scanner.nextInt();
                                    if(kk==0) {
                                        break;
                                    } else {
                                        user.removeItem(kk);
                                        System.out.println("item with id " + kk + " was removed successfully.");
                                    }
                                    System.out.println("a. Back");
                                    String bb = scanner.next();
                                    if(bb.equals("a")) {
                                        break;
                                    }

                                case 5 :
                                    x = false;
                                    break;
                            }
                        }
                    }

                    break;
                // close
                case 3:
                    b = false;
                    System.out.println("Goodbye!");
                    break;

            }
        }

    }

}
