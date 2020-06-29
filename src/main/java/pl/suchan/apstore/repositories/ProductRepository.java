package pl.suchan.apstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.suchan.apstore.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
