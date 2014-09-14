package io.weeb.utils.lol.items;

import java.util.List;


public class Item
{
	/** The official ID of the item, used by League of Legends. **/
	int ID;
	/** The name of the item. **/
	String name;
	/** The description of the item. **/
	String description;
	/** The location of the texture for this item. **/
	String textureLocation;
	/** The cost of the item, in some cases this is the combined cost. **/
	int cost;
	/** This items components in IDs. **/
	List<Integer> components;
	/** What this item builds into in IDs. **/
	List<Integer> buildsInto;
	/** The stats categories this item belongs in. **/
	List<ItemCatagory> categories;
	
	public Item(int ID, String name, String description, String textureLocation, int cost, List<Integer> components, List<Integer> buildsInto, List<ItemCatagory> categories)
	{
		this.ID = ID;
		this.name = name;
		this.description = description;
		this.textureLocation = textureLocation;
		this.cost = cost;
		this.components = components;
		this.buildsInto = buildsInto;
		this.categories = categories;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public int getCost()
	{
		return cost;
	}
	
	public List<Integer> getComponents()
	{
		if(components != null)
			return components;
		return null;
	}
	
	public List<Integer> getBuildsInto()
	{
		if(buildsInto != null)
			return buildsInto;
		return null;
	}
	
	public List<ItemCatagory> getItemCategories()
	{
		if(categories != null)
			return categories;
		return null;
	}
}