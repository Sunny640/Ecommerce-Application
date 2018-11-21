package gap.ecom.inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/inventory")
public class InvController {
	
	@Autowired
	InvService ob;
	@RequestMapping("/")
	public Iterable<InvModel> getAll() {
		return ob.getAll();
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addProduct(@RequestBody InvModel in,UriComponentsBuilder ucb)
	{
		return ob.addProduct(in);
		
	}
	@RequestMapping("/get/{id}")
	public InvModel getProduct(@PathVariable long id) {
		return ob.getProduct(id);
		
	}
	@RequestMapping("/remove/{id}")
	public String removeProduct(@PathVariable long id) {
		
		
		
		return ob.removeProduct(id) ;
		
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@RequestBody InvModel in,UriComponentsBuilder ucb)
	{
		
		return ob.update(in);
		
	}
	

}
