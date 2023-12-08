import org.example.AlreadyExistsException;
import org.example.NotFoundException;
import org.example.Product;
import org.example.ShopRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    ShopRepository shop = new ShopRepository();
    Product product1 = new Product(1, "Продукт 1", 100);
    Product product2 = new Product(2, "Продукт 2", 200);
    Product product3 = new Product(3, "Продукт 3", 300);

    @Test
    public void testSuccessfullRemovall() {
        shop.add(product1);
        shop.add(product2);
        shop.add(product3);
        shop.remove(2);
        Product[] expected = {product1, product3};
        Assertions.assertArrayEquals(expected, shop.findAll());

    }

    @Test
    public void testNotFoundException() {
        shop.add(product1);
        shop.add(product2);
        shop.add(product3);
        Assertions.assertThrows(NotFoundException.class, () -> {
            shop.remove(10);

        });
    }
@Test
        public void testSuccessfullAdded() {
            Product product4 = new Product(4, "Продукт 4", 400);
            shop.add(product1);
            shop.add(product2);
            shop.add(product3);
            shop.add(product4);
            Product[] expected = {product1,product2,product3,product4};
            Assertions.assertArrayEquals(expected, shop.findAll());
        }
        @Test
        public void testAlreadyExistsException() {
        shop.add(product1);
        shop.add(product2);
        shop.add(product3);
        Assertions.assertThrows(AlreadyExistsException.class, () ->{
            shop.add(product3);
        });

        }

    }



