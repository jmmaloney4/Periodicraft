package mods.periodicraft;

//Periodicraft Class
//Created By Jack Maloney on 3/10/2013
//Copyright (C)2013 Jack Maloney

import java.util.Hashtable;
import java.util.Map;

import cpw.mods.fml.common.registry.GameRegistry;

public class ID {

	public static int eID = 1;
	public static int newID = 499;
	public static int ID;
	
	public static int id() {
		newID++;
		return newID;	
	}
 
	public static int eID() {
		eID++;
		return eID;
	}

}
