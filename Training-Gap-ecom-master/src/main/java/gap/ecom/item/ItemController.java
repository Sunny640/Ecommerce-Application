package gap.ecom.item;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import gap.ecom.inventory.InvModel;
import gap.ecom.item.ItemModel;
import gap.ecom.repositories.InvRepo;
import gap.ecom.repositories.OrderRepo;

@RestController
public class ItemController {
@Autowired
OrderRepo cr;
@Autowired
InvRepo ir;
InvModel iv;
@PersistenceContext private EntityManager em;
@RequestMapping(value="/addtocart/{uid}/{prid}/{quantity}")
public String addtocart(@PathVariable long uid,@PathVariable long prid,@PathVariable int quantity)
{
	ItemModel oldqt = new ItemModel();
	int qt;
	Long userid = cr.finduser(prid,uid);
	iv=ir.findOne(prid);
	if(userid != null)
	{
	ItemModelid imd=new ItemModelid(userid,prid);
	oldqt=em.find(ItemModel.class,imd);
	qt=oldqt.getQuantity()+quantity;
	if(qt<iv.getQuantity())
	{
	oldqt.setQuantity(qt);
	oldqt.setPrice(iv.getprice()*qt);
	cr.save(oldqt);
	return "product updated";
	
	}
	else
	{	
		return "quantity exceeded";
	}
	}
	
	else {
	ItemModel im = new ItemModel();
	im.setUid(uid);
	im.setPrid(prid);
	im.setPrice((iv.getprice())*quantity);
	im.setQuantity(quantity);
	cr.save(im);
	return "product added to cart";
	}
	}

	@RequestMapping("/getcartbyuid/{uid}")
	public List<ItemModel> findcartbyuid(@PathVariable Long uid)
	{
		if(uid==cr.finduserid(uid))
		{
			return cr.findcartbyuser(uid);
		}
		else
			return null;
	}
	
	@RequestMapping("/cart")
	public Iterable<ItemModel> getAll() {
	return cr.findAll();
}

@RequestMapping("/deletefromcart/{uid}/{prid}/{quantity}")
public String deletefromcart(@PathVariable long uid,@PathVariable long prid,@PathVariable int quantity) 
{
	ItemModel i1=new ItemModel();
	InvModel iv;
	Long userid=cr.finduser(prid,uid);
	iv=ir.findOne(prid);
	 if(userid != null)
	 {
	ItemModelid imd1=new ItemModelid(userid,prid);
     i1= em.find(ItemModel.class,imd1);
	 int qty=i1.getQuantity();
	 int newqt=qty-quantity;
	 float newprice=(i1.getPrice())-((iv.getprice())*quantity);
	 if(newqt>=0)
	 {
		
		i1.setQuantity(newqt);
		i1.setPrice(newprice);
		cr.save(i1);
		return "deleted";
	 }
	 else
		return "cannot delete";
	 }
	 else
		 return "enter a valid userid";
		
}
}
