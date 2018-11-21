package gap.ecom.item;

import java.io.Serializable;

public class ItemModelid implements Serializable{
	private Long uid;
	private Long prid;
	
	public ItemModelid()
	{
		
	}
	
	public ItemModelid(Long uid, Long prid) {
		super();
		this.uid = uid;
		this.prid = prid;
	}
	public Long getUid() {
		return uid;
	}
	
	public Long getPrid() {
		return prid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((prid == null) ? 0 : prid.hashCode());
		result = prime * result + uid.intValue();
		return result;
	}
 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemModelid other = (ItemModelid) obj;
		if (prid == null) {
			if (other.prid != null)
				return false;
		} else if (!prid.equals(other.prid))
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}
 
	

}
