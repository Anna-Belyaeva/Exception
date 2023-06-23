import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.NotFoundException;
import ru.netology.Product;
import ru.netology.ShopRepository;

public class ProductTest {
    @Test
    public void shouldRemoveProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(135, "яблоко", 100);
        Product product2 = new Product(222, "молоко", 80);
        Product product3 = new Product(305, "хлеб", 50);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(222);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(actual, expected);

    }

    @Test
    public void shouldThrowNotFoundException() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "яблоко", 100);
        Product product2 = new Product(2, "молоко", 80);
        Product product3 = new Product(3, "хлеб", 50);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(404);
        });
    }
}
