package gap.ecom.repositories;


import gap.ecom.order.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemOrderRepo extends JpaRepository<OrderModel,Long> {
//	@Query(value = "select im1.uid from t_cart im1 where im1.prid=:prid", nativeQuery=true)
//	public Long finduserid(@Param("prid") long prid);



}
