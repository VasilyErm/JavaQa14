import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test
    public void testRemoveExistProduct() {

        ShopRepository shopRepository = new ShopRepository();

        Product product1 = new Product(1, "Книга", 2000);
        Product product2 = new Product(2, "Одежда", 9000);
        Product product3 = new Product(3, "Техника", 5000);

        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);

        shopRepository.remove(2);

        Product[] actual = shopRepository.findAll();
        Product[] expected = {product1, product3};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void testRemoveNotExistProduct() {

        ShopRepository shopRepository = new ShopRepository();

        Product product1 = new Product(1, "Книга", 2000);
        Product product2 = new Product(2, "Одежда", 9000);
        Product product3 = new Product(3, "Техника", 5000);

        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> shopRepository.remove(4)
        );
    }

//    @Test
//    public void testAlreadyExistProduct() {
//
//        ShopRepository shopRepository = new ShopRepository();
//
//        Product product1 = new Product(1, "Книга", 2000);
//        Product product2 = new Product(2, "Одежда", 5000);
//        Product product3 = new Product(3, "Часы", 9000);
//
//        shopRepository.add(product1);
//        shopRepository.add(product2);
//        shopRepository.add(product3);
//
//        Product[] actual = shopRepository.findAll();
//        Product[] expected = {product1, product2, product3};
//
//        assertArrayEquals(actual, expected);
//    }
//
//    @Test
//    public void testAlreadyExistProductww() {
//
//        ShopRepository shopRepository = new ShopRepository();
//
//        Product product1 = new Product(1, "Книга", 2000);
//        Product product2 = new Product(2, "Одежда", 9000);
//        Product product3 = new Product(3, "Техника", 5000);
//
//        shopRepository.add(product1);
//        shopRepository.add(product2);
//        shopRepository.add(product3);
//        shopRepository.add(product3);
//
//        Assertions.assertThrows(NotFoundException.class,
//                () -> shopRepository.remove(3)
//        );
}