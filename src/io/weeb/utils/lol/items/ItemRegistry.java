package io.weeb.utils.lol.items;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class ItemRegistry
{
	private static HashMap<Integer, Item> itemsByID = new HashMap<Integer, Item>();
	
	private static boolean loaded = false;
	
	public static void loadItems()
	{
		if(!loaded)
		{
			BufferedReader reader = null;
			
			// TODO: Get a more reliable way of loading items.
			try
			{
				URL fileURL = ItemRegistry.class.getResource("tempItems.txt_new");
				reader = new BufferedReader(new FileReader(new File(fileURL.getFile())));
				
				ArrayList<String> itemsRaw = new ArrayList<String>();
				
				String line = null;
				while((line = reader.readLine()) != null)
				{
					String removedNullChar = line.replace("\0", "").trim();
					if(removedNullChar.startsWith("gameItems["))
					{
						itemsRaw.add(removedNullChar);
					}
				}
				
				System.out.println(itemsRaw.size());
				
				for(String s : itemsRaw)
				{
					String s2[] = s.split("\\(");
					s = "";
					for(int i = 0; i < s2.length; i++)
					{
						if(i != 0)
							s += s2[i];
					}
					s = s.replace(";", "");
					System.out.println(s);
					// ------
						int timesQuotes = 0;
					// ------
					
					int ID = 0;
					String name = "";
					String description = "";
					String textureLocation = "";
					ArrayList<String> 
					
					int currentArgNr = 0;
					String currentArg = "";
					boolean argReadStarted = false;
					
					boolean readingList = false;
					String sub
					
					for(char c : s.toCharArray())
					{
						switch(currentArgNr)
						{
						case 0: //reading ID
							System.out.println(c);
							switch(c)
							{
							case ' ':
								break;
							
							case ',':
								ID = Integer.parseInt(currentArg);
								
								currentArg = "";
								currentArgNr++;
								break;
								
							default:
								currentArg += c;
							}
							
							break;
							
						case 1: // reading name
						case 2:
						case 3:
							
							switch(c)
							{
							case ' ':
								if(argReadStarted)
									currentArg += c;
								break;
								
							case '"':
								argReadStarted = !argReadStarted;
								
								timesQuotes++;
								break;
								
							case ',':
								
								if(!argReadStarted)
								{
									switch(currentArgNr)
									{
									case 1:
										name = currentArg;
										break;
									case 2:
										description = currentArg;
										break;
									case 3:
										textureLocation = currentArg;
										break;
									}
									
									currentArg = "";
									currentArgNr++;
								}
								break;
							
							default:
								currentArg += c;
								
							}
							
							break;
						}
					}
					
					System.out.println("ID: " + ID);
					System.out.println("	Name: " + name);
					System.out.println("	Description: " + description);
					System.out.println("	Texture Location: " + textureLocation);
					System.out.println(" 	Times quotes: " + timesQuotes);
					System.out.println("	Raw: " + s);
					
				}
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			finally
			{
				try
				{
					reader.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public static Item getItemByID(int ID)
	{
		if(itemsByID.containsKey(ID))
		{
			return itemsByID.get(ID);
		}
		
		return null;
	}
}
