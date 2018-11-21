package gap.ecom.repositories;


import java.util.List;

import gap.ecom.payment.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gap.ecom.item.ItemModel;
import gap.ecom.item.ItemModelid;

@Repository
public interface PaymentRepo extends JpaRepository<PaymentModel,Long> {

}