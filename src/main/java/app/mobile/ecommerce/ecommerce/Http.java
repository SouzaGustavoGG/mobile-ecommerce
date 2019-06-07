package app.mobile.ecommerce.ecommerce;

import java.util.List;

public interface Http <Entity,Key>{
	
	public List<Entity> doGet();
	public Entity doGet(Key k);
	public void doPost(Entity e);
	public void doPut(Key k, Entity e);
	public void doDelete(Key k);
	
	

}
