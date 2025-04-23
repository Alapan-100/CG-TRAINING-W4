import java.util.*;
abstract class WareHouseItems{
    final private String name ;
    public WareHouseItems(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public abstract void showDetails();
}
class Electronics extends WareHouseItems{
    public Electronics(String name){
        super(name);
    }

    public String getName() {
        return super.getName();
    }
    @Override
    public void showDetails(){
        System.out.println("Electronics : " + getName());
    }
}
class Groceries extends WareHouseItems{
    public Groceries(String name){
        super(name);
    }
    @Override
    public void showDetails(){
        System.out.println("Groceries: " +getName());
    }

}
class Furniture extends WareHouseItems{
    public Furniture(String name){
        super(name);
    }

    @Override
    public void showDetails() {
        System.out.println("Furniture: " +getName());
    }
}
class Storage <T extends WareHouseItems>{
    final private List<T> items = new ArrayList<>();
    public void addItems(T item){
        items.add(item);
    }
    public List<T> getitems(){
        return items;
    }
}
class WarehouseUtils {
    public static void displayItems(List<? extends WareHouseItems> items) {
        for (WareHouseItems item : items) {
            item.showDetails();
        }
    }
}
public class WarehouseMangement {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItems(new Electronics("Laptop"));
        electronicsStorage.addItems(new Electronics("Smartphone"));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItems(new Groceries("Apples"));
        groceriesStorage.addItems(new Groceries("Milk"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItems(new Furniture("Chair"));
        furnitureStorage.addItems(new Furniture("Table"));

        System.out.println("=== Electronics ===");
        WarehouseUtils.displayItems(electronicsStorage.getitems());

        System.out.println("=== Groceries ===");
        WarehouseUtils.displayItems(groceriesStorage.getitems());

        System.out.println("=== Furniture ===");
        WarehouseUtils.displayItems(furnitureStorage.getitems());
    }
}
