package bwg4.gui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import bwg4.api.DefaultBiomeList;


import net.minecraft.world.biome.BiomeGenBase;


public class BWG4GuiBiomeSettingsInfo
{
    private final List Biomelist = new ArrayList();
	
    public List theBiomesList()
    {
        return this.Biomelist;
    }	
	
    public static BWG4GuiBiomeSettingsInfo defaultBiomesList()
    {
        return FromString(DefaultBiomeList.getDefaultString());
	}
	
    public String toString()
    {
		//CREATE STRING
        StringBuilder var1 = new StringBuilder();
		
		//VERSION
		var1.append("1&");
		
		//GET BIOME INFO
        for (int var2 = 0; var2 < this.Biomelist.size(); ++var2)
        {
            if (var2 > 0)
            {
                var1.append(";");
            }

            var1.append(((BWG4BiomeInfo)this.Biomelist.get(var2)).toString());
        }

		return var1.toString();
	}
	
	public static BWG4GuiBiomeSettingsInfo FromString(String par0Str)
    {
		BWG4GuiBiomeSettingsInfo var0 = new BWG4GuiBiomeSettingsInfo();
        if (par0Str != "")
        {
			String[] mainarray = par0Str.split("&");
			String[] biomesarray = mainarray[1].split(";");
			String settingName;
			boolean enabled;
			
			for(int biome = 0; biome < biomesarray.length; ++biome)
			{
				String[] biomeINFO = biomesarray[biome].split("=");
				settingName = biomeINFO[0];

				if(biomeINFO[1].equals("true"))
				{
					enabled = true;
				}
				else
				{
					enabled = false;
				}
				
				var0.theBiomesList().add(new BWG4BiomeInfo(settingName, enabled)); 
			}
			return var0;
		}
		return defaultBiomesList();
	}
}