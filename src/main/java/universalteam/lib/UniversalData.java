/**
 * Copyright (c) 2014, big_Xplosion and the UniversalTeam
 *
 * UniversalTeam's mods are distributed under the terms of GNU LGPL v3.0
 * Please check the contents of the license located in
 * https://www.gnu.org/licenses/lgpl.html
 *
 * @author big_Xplosion
 */
package universalteam.lib;

import java.io.File;
import java.util.HashMap;

import net.minecraftforge.fml.relauncher.FMLInjectionData;

public class UniversalData
{
	public static HashMap<String, Object> blackboard = new HashMap<String, Object>();

	private static String build = "@BUILD_NUMBER@";
	private static String version = "@VERSION@";
	private static String dev = "dev=true";

	static {
		if (build.equals("@BUILD_NUMBER@") || build.equals("0"))
			blackboard.put("libVersion", version);
		else
			blackboard.put("libVersion", version + "." + build);
		blackboard.put("forgeRoot", FMLInjectionData.data()[6]);
		blackboard.put("dev", Boolean.parseBoolean(dev.substring('=')));
	}

	public static String getString(String id) {
		return (String) blackboard.get(id);
	}

	public static File getForgeRoot() {
		return (File) blackboard.get("forgeRoot");
	}


}
