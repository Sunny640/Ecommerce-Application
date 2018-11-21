package gap.ecom.order;

import gap.ecom.inventory.InvModel;
import gap.ecom.inventory.InvService;
import gap.ecom.item.ItemModel;
import gap.ecom.payment.PaymentModel;
import gap.ecom.repositories.InvRepo;
import gap.ecom.repositories.ItemOrderRepo;
import gap.ecom.repositories.OrderRepo;
import gap.ecom.repositories.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrderService {

    @Autowired
    OrderRepo order;

    @Autowired
    InvService ob;

    @Autowired
    ItemOrderRepo imv;

    @Autowired
    InvRepo io;

    @Autowired
    PaymentRepo p;

    static long s=0;
    static long id=0;
    public List<OrderModel> getAll() {
        return imv.findAll();

    }

    public String addOrder(long uid)
    {
        InvModel iv = new InvModel();
        OrderModel o = new OrderModel();
        float price=0;
        int quantity=0;
        int invq;
        id=id+1;
        List<ItemModel> i = new ArrayList<ItemModel>();


            System.out.println("exists");
            PaymentModel pm = new PaymentModel();
            i = order.findcartbyuser(uid);
            for(ItemModel im:i){
                s++;
                pm.setS(s);
                pm.setUid(uid);
                pm.setOrderId(id);
                pm.setProductId(im.getPrid());
                pm.setPrice(im.getPrice());
                p.save(pm);
                iv=io.findOne(im.getPrid());
                invq = iv.getQuantity();
                invq=invq-im.getQuantity();
                iv.setQuantity(invq);
                ob.update(iv);
                quantity+=im.getQuantity();
                price+=im.getPrice();
            }

            o.setOrderId(id);
            o.setUid(uid);
            o.setTotalQuantity(quantity);
            o.setTotalPrice(price);
            imv.save(o);


            //order.deletecartbyuser(uid);

            List<ItemModel> itemModels = order.findAll();
            for(ItemModel is:itemModels) {
            	if(is.getUid()==uid) {
            		order.delete(is);
            	}
            }
            return "Order added";





    }


}

