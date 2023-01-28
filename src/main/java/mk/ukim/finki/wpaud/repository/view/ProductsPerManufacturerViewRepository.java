package mk.ukim.finki.wpaud.repository.view;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

//public interface ProductsPerManufacturerViewRepository extends JpaRepository<ProductsPerManufacturerView, Long>
//{
//    @Transactional
//    @Modifying(clearAutomatically = true)
//    @Query(value = "REFRESH MATERIALIZED VIEW public.products_per_manufacturers", nativeQuery = true)
//    void refreshMaterializedView();
//}
