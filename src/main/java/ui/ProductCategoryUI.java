package ui;

import controllers.UseCaseInjector;
import database.DatabaseAccess;

import java.io.File;
import java.util.ArrayList;

public class ProductCategoryUI {

    /**
     * A constructor for ProductListUI.
     */
    public ProductCategoryUI() {
    }


    /**
     * A method to create every product category where each category contains
     * a list of products.
     */
    public void createCategories(){
        File path = new File("src/main/java/database/data");
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


    /** A method to create a product category containing a list of products.
     * @param num The index of the product category in the data directory
     */
    public void productCategory(int num){

        File path = new File("src/main/java/database/data");
        File [] files = path.listFiles();
        assert files != null;

        DatabaseAccess gateway = new DatabaseAccess();

        UseCaseInjector injector = new UseCaseInjector();
        ProductList presenter = new ProductList(gateway, injector.injectInventory());

        ArrayList<ArrayList<Object>> list = presenter.createProductList(files[num-1]);

        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.printf("%-30s %-30s %-30s", "Product Name", "Price", "Stock Quantity");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");


        for(ArrayList<Object> l: list)
        {
            System.out.format("%-30s %-30s %-30s", l.get(0), l.get(1), l.get(2));
            System.out.println();
        }
        System.out.println("----------------------------------------------------------------------------------------------");
    }




}