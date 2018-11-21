package gap.ecom.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import gap.ecom.repositories.InvRepo;

@Service
public class InvService {
	@Autowired
	InvRepo inventory;
	
	
	public Iterable<InvModel> getAll() {
		return inventory.findAll();
		
	}
	public String addProduct( InvModel in)
	{
		long pid=in.getproductId();
		int qt;
		if(inventory.exists(pid))
		{
			InvModel oldpro=inventory.findOne(pid);
			qt=oldpro.getQuantity()+in.getQuantity();
			in.setQuantity(qt);
		}
		inventory.save(in);

		return "prodcut added";
		
	}

	public InvModel getProduct(long id) {
		return inventory.findOne(id);
		
	}

	public String removeProduct(long id) {
		
		if (inventory.exists(id)) {
			inventory.delete(id);
			return "Product removed from Inventory";
		}
		
		return "Product removal failed, ID not found" ;
		
	}
	
	public String update(InvModel in)
	{
		if (inventory.exists(in.getproductId())) {
			inventory.delete(in.getproductId());
			inventory.save(in);
			return "Updation Successful";
		}
		return "Updation failed, ID not found";
		
	}

}
