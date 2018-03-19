package database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import game.Account;
import game.Actor;
import game.Item;
import game.Map;
import game.Tile;
import game.Game;

public class InitialData {
	//unpacks everything from the database into lists
	public static List<Map> getMap() throws IOException {
		List<Map> mapList = new ArrayList<Map>();
		ReadCSV readMap = new ReadCSV("Map.csv");
		try {
			while (true) {
				List<String> tuple = readMap.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Map map = new Map();
				map.setAccountId(Integer.parseInt(i.next()));		//account id
				map.setHeight(Integer.parseInt(i.next()));			//map height
				map.setWidth(Integer.parseInt(i.next()));			//map width
				map.decompileTiles(i.next()); 						//creates all tiles and retrieves their data
				mapList.add(map);
			}
			return mapList;
		} finally {
			readMap.close();
		}
	}


	public static List<Account> getAccount() throws IOException {
		List<Account> accountList = new ArrayList<Account>();
		ReadCSV readAccount = new ReadCSV("Account.csv");
		try {
			while (true) {
				List<String> tuple = readAccount.next();
				if (tuple == null) {
					break;
				}
				
				Iterator<String> i = tuple.iterator();
				Account account = new Account("","");
				account.setId(Integer.parseInt(i.next()));
				account.setUsername(i.next());
				account.setPassword(i.next());
				accountList.add(account);
			}
			return accountList;
		} finally {
			readAccount.close();
		}
	}
	
	public static List<Actor> getActor() throws IOException {
		List<Actor> actorList = new ArrayList<Actor>();
		ReadCSV readAccount = new ReadCSV("Actor.csv");
		try {
			while (true) {
				List<String> tuple = readAccount.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Actor actor = new Actor();
				actorList.add(actor);
				
				String inv = i.next();
				StringBuilder item = new StringBuilder();	//reads a single item
				List<Item> inventoryList = new ArrayList<Item>();
				for(int k = 0; k < inv.length(); k++){
					if(inv.charAt(k) == '|'){
						//TODO: get item name from dictionary
						//inventoryList.add();
						k++;
						item.delete(0, item.length());
					}
					else{
						item.append(inv.charAt(k));
					}
				}
				
				actor.setInventory(inventoryList);
//				actor.setEquippedItem( TODO: get item from i.next());
				actor.setHealth(Integer.parseInt(i.next()));
				actor.setLocation(new Tile());		//TODO: set to real tile later, after game has been matched with id
				actor.getLocation().setX(Integer.parseInt(i.next()));
				actor.getLocation().setY(Integer.parseInt(i.next()));
				actor.setBaseDamage(Integer.parseInt(i.next()));
			}
			return actorList;
		} finally {
			readAccount.close();
		}
	}
}
