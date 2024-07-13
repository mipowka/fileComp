package Hw;

import java.util.*;

/*
Создайте синглтон для управления списком продуктов.
класс ProductManager в котором есть лист продуктов
так же есть методы добавить
удалить
удалить все продукты
добавить продукт если его нет в листе (сравнивать по названию) так же добавить продукт если цена не отрицательная
метод получить список продуктов отсортированные по цене
метод получить список продуктов отсортированные по названию
 */
public class ProductManager {
    private static ProductManager instance;
    List<Product> productList;

    public ProductManager(List<Product> productList) {
        this.productList = productList;
    }

    public static ProductManager getInstance() {
        if(instance == null) {
            instance = new ProductManager(new ArrayList<Product>());
        }
        return instance;
    }

    public void addProduct(Product product) {
//        getInstance().productList.add(product);
        productList.add(product);
    }

    public void removeProduct(Product product) {
//        getInstance().productList.remove(product);
        ListIterator<Product> iterator = productList.listIterator();

        while (iterator.hasNext()) {
            if (iterator.next().equals(product)) {
                iterator.remove();
            }
        }
    }

    public void removeAllProduct() {
       productList.clear();
    }

    public void addIfNotExist(Product product) {
        if (!productList.contains(product)) {
            productList.add(product);
        }
    }

    public void addIfPriceGood(Product product) {
        if(product.getPrice() >= 0) {
            productList.add(product);
        }
    }

    public void sortProductListPrice() {
        Comparator<Product> productComparator = Comparator.comparing(Product::getPrice);
        productList.sort(productComparator);
    }

    public void sortProductListName() {
        Comparator<Product> productComparator = Comparator.comparing(Product::getName);
        productList.sort(productComparator);
    }

    @Override
    public String toString() {
        return "ProductManager{" +
                "productList=" + productList +
                '}';
    }

    public static void main(String[] args) {
        ProductManager productManager = new ProductManager(new ArrayList<>());
        Product p1 = new Product("Cola",200.55);
        Product p2 = new Product("Juice",100.55);
        Product p3 = new Product("Snack",50.55);
        Product p4 = new Product("Bread",20.55);
        Product p5 = new Product("Meat",2000.55);
        productManager.addProduct(p1);
        System.out.println(p1);
        System.out.println(productManager);
        System.out.println();

        productManager.removeProduct(p1);
        System.out.println(productManager);
        System.out.println();

        productManager.addProduct(p2);
        productManager.addProduct(p3);
        System.out.println(productManager);
        System.out.println();
        productManager.removeAllProduct();
        System.out.println(productManager);
        System.out.println();

        productManager.addProduct(p4);
        productManager.addProduct(p5);
        System.out.println(productManager);
        System.out.println();

        productManager.addIfNotExist(p4);
        productManager.addIfNotExist(new Product("Andarine",50.88));
        System.out.println(productManager);
        System.out.println();

        productManager.addIfPriceGood(new Product("Cola",-200.55));
        System.out.println(productManager);
        System.out.println();

        productManager.sortProductListPrice();
        System.out.println(productManager);

        System.out.println();

        productManager.sortProductListName();
        System.out.println(productManager);



    }



}
