package bwg4.biomes;

import bwg4.config.BWG4Config;
import net.minecraft.world.biome.BiomeGenBase;

public class BWG4Biomes 
{
	public static BiomeGenBase BETArainforest;
	public static BiomeGenBase BETAswampland;
	public static BiomeGenBase BETAseasonalForest;
	public static BiomeGenBase BETAforest;
	public static BiomeGenBase BETAsavanna;
	public static BiomeGenBase BETAshrubland;
	public static BiomeGenBase BETAtaiga;
	public static BiomeGenBase BETAdesert;
	public static BiomeGenBase BETAplains;
	public static BiomeGenBase BETAtundra;
	
	public static BiomeGenBase ALPHArainforest;
	public static BiomeGenBase ALPHAswampland;
	public static BiomeGenBase ALPHAseasonalForest;
	public static BiomeGenBase ALPHAforest;
	public static BiomeGenBase ALPHAsavanna;
	public static BiomeGenBase ALPHAshrubland;
	public static BiomeGenBase ALPHAtaiga;
	public static BiomeGenBase ALPHAdesert;
	public static BiomeGenBase ALPHAplains;
	public static BiomeGenBase ALPHAtundra;
	
	public static BiomeGenBase INFDEVdefault;
	public static BiomeGenBase INFDEVsnow;
	public static BiomeGenBase INDEVnormal;
	public static BiomeGenBase INDEVhell;
	public static BiomeGenBase INDEVparadise;
	public static BiomeGenBase INDEVwoods;
	public static BiomeGenBase INDEVsnow;
	
	public static BiomeGenBase ISLANDnormal;
	//public static BiomeGenBase ISLANDhell;
	//public static BiomeGenBase ISLANDice;
	public static BiomeGenBase ISLANDparadise;
	//public static BiomeGenBase ISLANDnormal;
	//public static BiomeGenBase ISLANDnormal;
	public static BiomeGenBase SKYLANDnormal;
	//public static BiomeGenBase SKYLANDhell;
	public static BiomeGenBase SKYLANDice;
	public static BiomeGenBase SKYLANDjungle;
	//public static BiomeGenBase SKYLANDnormal;
	//public static BiomeGenBase SKYLANDnormal;
	public static BiomeGenBase SURVIVALnether;
	public static BiomeGenBase SKYBLOCKworld;
	
	public static BiomeGenBase BDocean;
	public static BiomeGenBase BDtropicalisland;
	public static BiomeGenBase BDjungleisland;
	public static BiomeGenBase BDmushroomisland;
	public static BiomeGenBase BDbeach; 
	public static BiomeGenBase BDbeachDunes; 
	public static BiomeGenBase BDsnowpines;
	public static BiomeGenBase BDsnowforest;
	public static BiomeGenBase BDsnowtaiga;
	public static BiomeGenBase BDsnowplains;
	public static BiomeGenBase BDsnowhills;
	public static BiomeGenBase BDplains;
	public static BiomeGenBase BDforest;
	public static BiomeGenBase BDforesthills;
	public static BiomeGenBase BDforestlakes;
	public static BiomeGenBase BDpines;
	public static BiomeGenBase BDtaiga;
	public static BiomeGenBase BDgrassland;
	public static BiomeGenBase BDrainforest;
	public static BiomeGenBase BDjungle;
	public static BiomeGenBase BDswampland;
	public static BiomeGenBase BDdesert;
	public static BiomeGenBase BDsavanna;
	public static BiomeGenBase BDsavannaforest;
	public static BiomeGenBase BDshrubland;
	public static BiomeGenBase BDshrublandHill;
	public static BiomeGenBase BDiceriver;
	public static BiomeGenBase BDriver;
	public static BiomeGenBase BDgreenriver;
	public static BiomeGenBase BDsandriver;
	public static BiomeGenBase BDjungle_nocolor;
	public static BiomeGenBase BDswampland_nocolor;
	
	public static void init()
	{
		BETArainforest = (new BWG4BiomesBeta(BWG4Config.biomeIDs[0], 80)).setColor(353825).setBiomeName("rainforest").setTemperatureRainfall(0.95F, 0.95F);
		BETAswampland = (new BWG4BiomesBeta(BWG4Config.biomeIDs[1], 81)).setColor(353825).setBiomeName("swampland").setTemperatureRainfall(0.55F, 0.65F);
		BETAseasonalForest = (new BWG4BiomesBeta(BWG4Config.biomeIDs[2], 82)).setColor(353825).setBiomeName("seasonalForest").setTemperatureRainfall(0.95F, 0.7F);
		BETAforest = (new BWG4BiomesBeta(BWG4Config.biomeIDs[3], 83)).setColor(353825).setBiomeName("forest").setTemperatureRainfall(0.8F, 0.6F);
		BETAsavanna = (new BWG4BiomesBeta(BWG4Config.biomeIDs[4], 84)).setColor(16421912).setBiomeName("savanna").setTemperatureRainfall(0.7F, 0.1F);
		BETAshrubland = (new BWG4BiomesBeta(BWG4Config.biomeIDs[5], 85)).setColor(353825).setBiomeName("shrubland").setTemperatureRainfall(0.7F, 0.3F);
		BETAtaiga = (new BWG4BiomesBeta(BWG4Config.biomeIDs[6], 86)).setColor(16777215).setBiomeName("taiga").setTemperatureRainfall(0.1F, 0.35F).setEnableSnow();
		BETAdesert = (new BWG4BiomesBeta(BWG4Config.biomeIDs[7], 87)).setColor(16421912).setBiomeName("desert").setTemperatureRainfall(0.95F, 0.1F).setDisableRain();
		BETAplains = (new BWG4BiomesBeta(BWG4Config.biomeIDs[8], 88)).setColor(353825).setBiomeName("plains").setTemperatureRainfall(0.95F, 0.35F);
		BETAtundra = (new BWG4BiomesBeta(BWG4Config.biomeIDs[9], 89)).setColor(16777215).setBiomeName("tundra").setTemperatureRainfall(0.1F, 0.1F).setEnableSnow();
		
		ALPHArainforest = (new BWG4BiomesAlpha(BWG4Config.biomeIDs[10], 90)).setColor(353825).setBiomeName("rainforest").setTemperatureRainfall(0.95F, 0.95F);
		ALPHAswampland = (new BWG4BiomesAlpha(BWG4Config.biomeIDs[11], 91)).setColor(353825).setBiomeName("swampland").setTemperatureRainfall(0.55F, 0.65F);
		ALPHAseasonalForest = (new BWG4BiomesAlpha(BWG4Config.biomeIDs[12], 92)).setColor(353825).setBiomeName("seasonalForest").setTemperatureRainfall(0.95F, 0.7F);
		ALPHAforest = (new BWG4BiomesAlpha(BWG4Config.biomeIDs[13], 93)).setColor(353825).setBiomeName("forest").setTemperatureRainfall(0.8F, 0.6F);
		ALPHAsavanna = (new BWG4BiomesAlpha(BWG4Config.biomeIDs[14], 94)).setColor(353825).setBiomeName("savanna").setTemperatureRainfall(0.7F, 0.1F);
		ALPHAshrubland = (new BWG4BiomesAlpha(BWG4Config.biomeIDs[15], 95)).setColor(353825).setBiomeName("shrubland").setTemperatureRainfall(0.7F, 0.3F);
		ALPHAtaiga = (new BWG4BiomesAlpha(BWG4Config.biomeIDs[16], 96)).setColor(353825).setBiomeName("taiga").setTemperatureRainfall(0.1F, 0.35F).setEnableSnow();
		ALPHAdesert = (new BWG4BiomesAlpha(BWG4Config.biomeIDs[17], 97)).setColor(353825).setBiomeName("desert").setTemperatureRainfall(0.95F, 0.1F).setDisableRain();
		ALPHAplains = (new BWG4BiomesAlpha(BWG4Config.biomeIDs[18], 98)).setColor(353825).setBiomeName("plains").setTemperatureRainfall(0.95F, 0.35F);
		ALPHAtundra = (new BWG4BiomesAlpha(BWG4Config.biomeIDs[19], 99)).setColor(353825).setBiomeName("tundra").setTemperatureRainfall(0.1F, 0.1F).setEnableSnow();
		
		INFDEVdefault = (new BWG4BiomesInfdev(BWG4Config.biomeIDs[20])).setColor(353825).setBiomeName("Infdev");
		INFDEVsnow = (new BWG4BiomesInfdev(BWG4Config.biomeIDs[21])).setColor(353825).setBiomeName("Infdev Snow").setEnableSnow().setTemperatureRainfall(0.0F, 0.5F);
		INDEVnormal = (new BWG4BiomesIndev(BWG4Config.biomeIDs[22], 1)).setColor(353825).setBiomeName("Indev");
		INDEVhell = (new BWG4BiomesIndev(BWG4Config.biomeIDs[23], 2)).setColor(353825).setBiomeName("Indev");
		INDEVparadise = (new BWG4BiomesIndev(BWG4Config.biomeIDs[24], 3)).setColor(353825).setBiomeName("Indev");
		INDEVwoods = (new BWG4BiomesIndev(BWG4Config.biomeIDs[25], 4)).setColor(353825).setBiomeName("Indev");
		INDEVsnow = (new BWG4BiomesIndev(BWG4Config.biomeIDs[26], 5)).setColor(353825).setBiomeName("Indev").setEnableSnow().setTemperatureRainfall(0.0F, 0.5F);
		
		ISLANDnormal = (new BWG4BiomesSurvival(BWG4Config.biomeIDs[27], 107)).setColor(353825).setBiomeName("Survival Island").setTemperatureRainfall(0.9F, 0.8F);
		//ISLANDhell = (new BWG4BiomesSurvival(BWG4Config.biomeIDs[28], 108)).setColor(353825).setBiomeName("Survival Island").setTemperatureRainfall(0.9F, 0.8F);
		//ISLANDice = (new BWG4BiomesSurvival(BWG4Config.biomeIDs[29], 109)).setColor(353825).setBiomeName("Survival Island").setTemperatureRainfall(0.0F, 0.5F);
		ISLANDparadise = (new BWG4BiomesSurvival(BWG4Config.biomeIDs[30], 110)).setColor(353825).setBiomeName("Survival Island").setTemperatureRainfall(0.9F, 0.8F);
		//ISLANDnormal = (new BWG4BiomesSurvival(BWG4Config.biomeIDs[31], 111)).setColor(353825).setBiomeName("Survival Island").setTemperatureRainfall(0.9F, 0.8F);
		//ISLANDnormal = (new BWG4BiomesSurvival(BWG4Config.biomeIDs[32], 112)).setColor(353825).setBiomeName("Survival Island").setTemperatureRainfall(0.9F, 0.8F);
		SKYLANDnormal = (new BWG4BiomesSurvival(BWG4Config.biomeIDs[33], 113)).setColor(353825).setBiomeName("Survival Skyland").setTemperatureRainfall(0.9F, 0.8F);
		//SKYLANDhell = (new BWG4BiomesSurvival(BWG4Config.biomeIDs[34], 114)).setColor(353825).setBiomeName("Survival Skyland").setTemperatureRainfall(0.9F, 0.8F);
		SKYLANDice = (new BWG4BiomesSurvival(BWG4Config.biomeIDs[35], 115)).setColor(353825).setBiomeName("Survival Skyland").setTemperatureRainfall(0.0F, 0.5F);
		SKYLANDjungle = (new BWG4BiomesSurvival(BWG4Config.biomeIDs[36], 116)).setColor(353825).setBiomeName("Survival Skyland").setTemperatureRainfall(0.9F, 0.8F);
		//SKYLANDnormal = (new BWG4BiomesSurvival(BWG4Config.biomeIDs[37], 117)).setColor(353825).setBiomeName("Survival Skyland").setTemperatureRainfall(0.9F, 0.8F);
		//SKYLANDnormal = (new BWG4BiomesSurvival(BWG4Config.biomeIDs[38], 118)).setColor(353825).setBiomeName("Survival Skyland").setTemperatureRainfall(0.9F, 0.8F);
		SURVIVALnether = (new BWG4BiomesSurvival(BWG4Config.biomeIDs[39], 119)).setColor(353825).setBiomeName("Hell").setTemperatureRainfall(0.8F, 0.6F);
		SKYBLOCKworld = (new BWG4BiomesSurvival(BWG4Config.biomeIDs[40], 120)).setColor(353825).setBiomeName("Survival Skyblock").setTemperatureRainfall(0.9F, 0.8F);
		
		BDocean = (new BWG4BiomesDefault(BWG4Config.biomeIDs[41], 1, 1)).setColor(353825).setBiomeName("Ocean").setTemperatureRainfall(0.8F, 0.6F).setMinMaxHeight(-1.1F, 0.3F);
		BDtropicalisland = (new BWG4BiomesDefault(BWG4Config.biomeIDs[42], 1, 2)).setColor(353825).setBiomeName("Tropical Island").setTemperatureRainfall(1.0F, 1.0F).setMinMaxHeight(0.2F, 0.3F);
		BDjungleisland = (new BWG4BiomesDefault(BWG4Config.biomeIDs[43], 1, 3)).setColor(353825).setBiomeName("Jungle Island").setTemperatureRainfall(1.0F, 1.0F).setMinMaxHeight(0.2F, 0.3F);
		BDmushroomisland = (new BWG4BiomesDefault(BWG4Config.biomeIDs[44], 1, 4)).setColor(353825).setBiomeName("Mushroom Island").setTemperatureRainfall(0.8F, 0.6F).setMinMaxHeight(0.2F, 0.3F);
		BDbeach = (new BWG4BiomesDefault(BWG4Config.biomeIDs[45], 1, 5)).setColor(353825).setBiomeName("Beach").setTemperatureRainfall(0.8F, 0.6F).setMinMaxHeight(0.0F, 0.1F); 
		BDbeachDunes = (new BWG4BiomesDefault(BWG4Config.biomeIDs[46], 1, 6)).setColor(353825).setBiomeName("Beach Dunes").setTemperatureRainfall(0.8F, 0.6F).setMinMaxHeight(0.3F, 0.2F); 
		BDsnowpines = (new BWG4BiomesDefault(BWG4Config.biomeIDs[47], 2, 1)).setColor(353825).setBiomeName("Snow Pines").setTemperatureRainfall(0.0F, 0.0F).setMinMaxHeight(0.2F, 0.9F).setEnableSnow();
		BDsnowforest = (new BWG4BiomesDefault(BWG4Config.biomeIDs[48], 2, 2)).setColor(353825).setBiomeName("Snow Forest").setTemperatureRainfall(0.0F, 0.0F).setMinMaxHeight(0.2F, 0.7F).setEnableSnow();
		BDsnowtaiga = (new BWG4BiomesDefault(BWG4Config.biomeIDs[49], 2, 3)).setColor(353825).setBiomeName("Snow Taiga").setTemperatureRainfall(0.0F, 0.0F).setMinMaxHeight(0.2F, 0.9F).setEnableSnow();
		BDsnowplains = (new BWG4BiomesDefault(BWG4Config.biomeIDs[50], 2, 4)).setColor(353825).setBiomeName("Snow Plains").setTemperatureRainfall(0.0F, 0.0F).setMinMaxHeight(0.3F, 0.3F).setEnableSnow();
		BDsnowhills = (new BWG4BiomesDefault(BWG4Config.biomeIDs[51], 2, 5)).setColor(353825).setBiomeName("Snow Hills").setTemperatureRainfall(0.0F, 0.0F).setMinMaxHeight(0.3F, 1.3F).setEnableSnow();
		BDplains = (new BWG4BiomesDefault(BWG4Config.biomeIDs[52], 3, 1)).setColor(353825).setBiomeName("Plains").setTemperatureRainfall(0.8F, 0.6F).setMinMaxHeight(0.2F, 0.3F);
		BDforest = (new BWG4BiomesDefault(BWG4Config.biomeIDs[53], 3, 2)).setColor(353825).setBiomeName("Forest").setTemperatureRainfall(0.8F, 0.6F).setMinMaxHeight(0.2F, 1.0F);
		BDforesthills = (new BWG4BiomesDefault(BWG4Config.biomeIDs[54], 3, 3)).setColor(353825).setBiomeName("Forest Hills").setTemperatureRainfall(0.8F, 0.6F).setMinMaxHeight(0.3F, 1.5F);
		BDforestlakes = (new BWG4BiomesDefault(BWG4Config.biomeIDs[55], 3, 4)).setColor(353825).setBiomeName("Forest Lakes").setTemperatureRainfall(0.8F, 0.6F).setMinMaxHeight(-0.2F, 0.9F);
		BDpines = (new BWG4BiomesDefault(BWG4Config.biomeIDs[56], 3, 5)).setColor(353825).setBiomeName("Pines").setTemperatureRainfall(0.8F, 0.6F).setMinMaxHeight(0.2F, 0.9F);
		BDtaiga = (new BWG4BiomesDefault(BWG4Config.biomeIDs[57], 3, 6)).setColor(353825).setBiomeName("Taiga").setTemperatureRainfall(0.8F, 0.6F).setMinMaxHeight(0.2F, 0.9F);
		BDgrassland = (new BWG4BiomesDefault(BWG4Config.biomeIDs[58], 3, 7)).setColor(353825).setBiomeName("Grassland").setTemperatureRainfall(0.8F, 0.6F).setMinMaxHeight(0.2F, 1.3F);
		BDrainforest = (new BWG4BiomesDefault(BWG4Config.biomeIDs[59], 4, 1)).setColor(353825).setBiomeName("Rainforest").setMinMaxHeight(0.3F, 1.2F).setTemperatureRainfall(0.8F, 1.0F);
		BDjungle = (new BWG4BiomesDefault(BWG4Config.biomeIDs[60], 4, 2)).setColor(353825).setBiomeName("Jungle").setMinMaxHeight(0.2F, 1.2F).setTemperatureRainfall(1.0F, 1.0F);
		BDswampland = (new BWG4BiomesDefault(BWG4Config.biomeIDs[61], 4, 3)).setColor(353825).setBiomeName("Swampland").setMinMaxHeight(-0.2F, 0.3F).setTemperatureRainfall(0.9F, 1.0F);
		BDdesert = (new BWG4BiomesDefault(BWG4Config.biomeIDs[62], 5, 1)).setColor(353825).setBiomeName("Desert").setMinMaxHeight(0.3F, 0.8F).setTemperatureRainfall(1.0F, 0.0F);
		BDsavanna = (new BWG4BiomesDefault(BWG4Config.biomeIDs[63], 5, 2)).setColor(353825).setBiomeName("Savanna").setMinMaxHeight(0.3F, 0.2F).setTemperatureRainfall(1.0F, 0.2F);
		BDsavannaforest = (new BWG4BiomesDefault(BWG4Config.biomeIDs[64], 5, 3)).setColor(353825).setBiomeName("Savanna Forest").setMinMaxHeight(0.3F, 0.6F).setTemperatureRainfall(1.0F, 0.2F);
		BDshrubland = (new BWG4BiomesDefault(BWG4Config.biomeIDs[65], 5, 4)).setColor(353825).setBiomeName("Shrubland").setMinMaxHeight(0.3F, 0.2F).setTemperatureRainfall(0.9F, 0.0F);
		BDshrublandHill = (new BWG4BiomesDefault(BWG4Config.biomeIDs[66], 5, 5)).setColor(353825).setBiomeName("SandStone Hill").setMinMaxHeight(2.5F, 0.2F).setTemperatureRainfall(0.9F, 0.0F);
		BDiceriver = (new BWG4BiomesDefault(BWG4Config.biomeIDs[67], 6, 1)).setColor(353825).setBiomeName("River_ice").setTemperatureRainfall(0.0F, 0.5F).setMinMaxHeight(-0.8F, 0.0F).setEnableSnow();
		BDriver = (new BWG4BiomesDefault(BWG4Config.biomeIDs[68], 6, 2)).setColor(353825).setBiomeName("River_normal").setTemperatureRainfall(0.8F, 0.6F).setMinMaxHeight(-0.8F, 0.0F);
		BDgreenriver = (new BWG4BiomesDefault(BWG4Config.biomeIDs[69], 6, 3)).setColor(353825).setBiomeName("River_green").setTemperatureRainfall(0.8F, 1.0F).setMinMaxHeight(-0.8F, 0.0F);
		BDsandriver = (new BWG4BiomesDefault(BWG4Config.biomeIDs[70], 6, 4)).setColor(353825).setBiomeName("River_sand").setTemperatureRainfall(0.9F, 0.1F).setMinMaxHeight(-0.8F, 0.0F);
		BDjungle_nocolor = (new BWG4BiomesDefault(BWG4Config.biomeIDs[71], 4, 4)).setColor(353825).setBiomeName("Jungle").setMinMaxHeight(0.2F, 0.8F).setTemperatureRainfall(1.0F, 1.0F);
		BDswampland_nocolor = (new BWG4BiomesDefault(BWG4Config.biomeIDs[72], 4, 5)).setColor(353825).setBiomeName("Swampland").setMinMaxHeight(-0.2F, 0.3F).setTemperatureRainfall(0.9F, 1.0F);
	}
}
