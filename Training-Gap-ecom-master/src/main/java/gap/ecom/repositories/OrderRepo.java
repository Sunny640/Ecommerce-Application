package gap.ecom.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gap.ecom.item.ItemModel;
import gap.ecom.item.ItemModelid;

@Repository
public interface OrderRepo extends JpaRepository<ItemModel,ItemModelid> {
//	@Query(value = "select im1.uid from t_cart im1 where im1.prid=:prid", nativeQuery=true) 
//	public Long finduserid(@Param("prid") long prid);
	
	@Query(value="select im1.uid from t_cart im1 where im1.prid=:prid and im1.uid=:userid",nativeQuery=true)
	public Long finduser(@Param("prid") long prid,@Param("userid") long userid);

	@Query(value="select im1.uid from t_cart im1 where im1.uid=:uid",nativeQuery=true)
	public Long finduserid(@Param("uid") long uid);

	@Query(value="select * from t_cart im1 where im1.uid=:uid",nativeQuery=true)
	public List<ItemModel> findcartbyuser(@Param("uid") long uid);

	


  
}
