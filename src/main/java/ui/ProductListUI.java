package ui;

import entities.Product;
import gateway.DatabaseGateway;
import login.LoginController;
import login.LoginUI;
import login.LoginUseCase;
import login.UserReadWriter;
import uses.UserManager;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProductListUI {

    /**
     * A constructor for ProductListUI.
     */
    public ProductListUI() {
    }


    public void createCategories(){
        ArrayList<String> categories = new ArrayList<>();
        File path = new File("src/main/java/database");
        File [] files = path.listFiles();
        assert files != null;
        int count = files.length;
        int i = 0;
        while (i < count){
            int num = i + 1;
            String category = files[i].getName().replaceAll(".json", "");
            category = category.replaceAll("_", " ");
            System.out.println("[" + num + "] " + category);
            i += 1;
        }
    }


    public void productCategory(int num){

        File path = new File("src/main/java/database");
        File [] files = path.listFiles();
        assert files != null;

        DatabaseGateway gateway = new DatabaseGateway();
        ProductListPresenter presenter = new ProductListPresenter(gateway);

        ArrayList<ArrayList<Object>> list = presenter.createProductList(files[num-1]);

        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.printf("%15s %20s %20s", "Product Name", "Price", "Stock Quantity");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");


        for(ArrayList<Object> l: list)
        {
            System.out.format("%15s %20s %20s", l.get(0), l.get(1), l.get(2));
            System.out.println();
        }
        System.out.println("----------------------------------------------------------------------------------------------");
    }




}