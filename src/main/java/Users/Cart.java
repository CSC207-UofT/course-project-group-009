package Users;

import java.util.HashMap;
import Inventory.Product;

public class Cart{

    HashMap<Product, Integer> shoppingCart;

    public Cart(){
        this.shoppingCart = new HashMap<>();
    }

}
