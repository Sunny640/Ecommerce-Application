package gap.ecom.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService ob;
    @RequestMapping("/all")
    public Iterable<OrderModel> getAll() {
        return ob.getAll();
    }

    @RequestMapping(value="/add/{uid}",method=RequestMethod.POST)
    public String addProduct(@PathVariable long uid)
    {
        return ob.addOrder(uid);

    }

}
