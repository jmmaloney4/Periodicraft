package mods.periodicraft;

/*
Copyright (C) 2013  Jack Maloney

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

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
