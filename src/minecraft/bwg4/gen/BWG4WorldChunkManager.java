package bwg4.gen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import bwg4.mod_bwg4;
import bwg4.biomes.BWG4Biomes;
import bwg4.generatordata.BWG4DecodeGeneratorString;
import bwg4.generatordata.BWG4GeneratorType;
import bwg4.layer.BWG4Layer;
import bwg4.noise.BWG4oldNoiseGeneratorOctaves2;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.layer.IntCache;

public class BWG4WorldChunkManager extends WorldChunkManager
{
    private BWG4Layer genBiomes;
    private BWG4Layer biomeIndexLayer;
    private BiomeCache biomeCache;
    private List biomesToSpawnIn;
	
    private static BWG4oldNoiseGeneratorOctaves2 field_4194_e;
    private static BWG4oldNoiseGeneratorOctaves2 field_4193_f;
    private static BWG4oldNoiseGeneratorOctaves2 field_4192_g;
    public static double temperature[]; 
    public static double humidity[];
    public static double field_4196_c[];
    private static int biomeLookupTable[] = new int[4096];	
	
	protected BWG4WorldChunkManager()
	{
        this.biomeCache = new BiomeCache(this);
		
		//spawn list
        this.biomesToSpawnIn = new ArrayList();
		
		//default spawn biomes
        this.biomesToSpawnIn.add(BiomeGenBase.forest);
        this.biomesToSpawnIn.add(BiomeGenBase.plains);
        this.biomesToSpawnIn.add(BiomeGenBase.beach);
		
		//bwg4 spawn biomes
        this.biomesToSpawnIn.add(BWG4Biomes.BDtropicalisland);
        this.biomesToSpawnIn.add(BWG4Biomes.BDjungleisland);
        this.biomesToSpawnIn.add(BWG4Biomes.BDmushroomisland);
        this.biomesToSpawnIn.add(BWG4Biomes.BDbeach);
        this.biomesToSpawnIn.add(BWG4Biomes.BDbeachDunes); 
        this.biomesToSpawnIn.add(BWG4Biomes.BDsnowpines);
        this.biomesToSpawnIn.add(BWG4Biomes.BDsnowforest);
        this.biomesToSpawnIn.add(BWG4Biomes.BDsnowtaiga);
        this.biomesToSpawnIn.add(BWG4Biomes.BDsnowplains);
        this.biomesToSpawnIn.add(BWG4Biomes.BDsnowhills);
        this.biomesToSpawnIn.add(BWG4Biomes.BDplains);
        this.biomesToSpawnIn.add(BWG4Biomes.BDforest);
        this.biomesToSpawnIn.add(BWG4Biomes.BDforesthills);
        this.biomesToSpawnIn.add(BWG4Biomes.BDforestlakes);
        this.biomesToSpawnIn.add(BWG4Biomes.BDpines);
        this.biomesToSpawnIn.add(BWG4Biomes.BDtaiga);
        this.biomesToSpawnIn.add(BWG4Biomes.BDgrassland);
        this.biomesToSpawnIn.add(BWG4Biomes.BDrainforest);
        this.biomesToSpawnIn.add(BWG4Biomes.BDjungle);
        this.biomesToSpawnIn.add(BWG4Biomes.BDswampland);
        this.biomesToSpawnIn.add(BWG4Biomes.BDdesert);
        this.biomesToSpawnIn.add(BWG4Biomes.BDsavanna);
        this.biomesToSpawnIn.add(BWG4Biomes.BDsavannaforest);
        this.biomesToSpawnIn.add(BWG4Biomes.BDshrubland);
        this.biomesToSpawnIn.add(BWG4Biomes.BDshrublandHill);
	}

    public BWG4WorldChunkManager(World par1World, boolean remote)
    {
        this();
        long seed = par1World.getSeed();
        
        if(remote)
        {
			generateBiomeLookup();
	        field_4194_e = new BWG4oldNoiseGeneratorOctaves2(new Random(seed * 9871L), 4);
	        field_4193_f = new BWG4oldNoiseGeneratorOctaves2(new Random(seed * 39811L), 4);
	        field_4192_g = new BWG4oldNoiseGeneratorOctaves2(new Random(seed * 0x84a59L), 2);
        }

        if (BWG4GeneratorType.Current == BWG4GeneratorType.BWG4SMALL || BWG4GeneratorType.Current == BWG4GeneratorType.BWG4LARGE)
        {	
	        BWG4Layer[] var4 = BWG4Layer.initializeAllBiomeGenerators(seed, BWG4GeneratorType.generatorinfo);
	        this.genBiomes = (BWG4Layer) var4[0];
	        this.biomeIndexLayer = (BWG4Layer) var4[1];
        }
    }    
    
	public static double[] getColdTemperatures(double ad[], int i, int j, int k, int l)
    {
        if(ad == null || ad.length < k * l)
        {
            ad = new double[k * l];
        }
        ad = field_4194_e.func_4112_a(ad, i, j, k, l, 0.02500000037252903D, 0.02500000037252903D, 0.25D);
        field_4196_c = field_4192_g.func_4112_a(field_4196_c, i, j, k, l, 0.25D, 0.25D, 0.58823529411764708D);
        int i1 = 0;
        for(int j1 = 0; j1 < k; j1++)
        {
            for(int k1 = 0; k1 < l; k1++)
            {
                double d = field_4196_c[i1] * 1.1000000000000001D + 0.5D;
                double d1 = 0.01D;
                double d2 = 1.0D - d1;
                double d3 = (ad[i1] * 0.14999999999999999D + 0.69999999999999996D) * d2 + d * d1;
                d3 = 1.0D - (1.0D - d3) * (1.0D - d3);
                if(d3 < 0.0D)
                {
                    d3 = 0.0D;
                }
                if(d3 > 1.0D)
                {
                    d3 = 1.0D;
                }
                ad[i1] = d3;
                i1++;
            }

        }

        return ad;
    }
	
    public static int[] getBiomesGens(int par1, int par2, int par3, int par4)
    {		
		int[] abiomegenbase = new int[par3 * par4];
		temperature = field_4194_e.func_4112_a(temperature, par1, par2, par3, par3, 0.02500000037252903D, 0.02500000037252903D, 0.25D);
		humidity = field_4193_f.func_4112_a(humidity, par1, par2, par3, par3, 0.05000000074505806D, 0.05000000074505806D, 0.33333333333333331D);
		field_4196_c = field_4192_g.func_4112_a(field_4196_c, par1, par2, par3, par3, 0.25D, 0.25D, 0.58823529411764708D);
		int i1 = 0;
		for(int j1 = 0; j1 < par3; j1++)
		{
			for(int k1 = 0; k1 < par4; k1++)
			{
				double d = field_4196_c[i1] * 1.1000000000000001D + 0.5D;
				double d1 = 0.01D;
				double d2 = 1.0D - d1;
				double d3 = (temperature[i1] * 0.14999999999999999D + 0.69999999999999996D) * d2 + d * d1;
				d1 = 0.002D;
				d2 = 1.0D - d1;
				double d4 = (humidity[i1] * 0.14999999999999999D + 0.5D) * d2 + d * d1;
				d3 = 1.0D - (1.0D - d3) * (1.0D - d3);
				if(d3 < 0.0D)
				{
					d3 = 0.0D;
				}
				if(d4 < 0.0D)
				{
					d4 = 0.0D;
				}
				if(d3 > 1.0D)
				{
					d3 = 1.0D;
				}
				if(d4 > 1.0D)
				{
					d4 = 1.0D;
				}
				temperature[i1] = d3;
				humidity[i1] = d4;
				abiomegenbase[i1++] = getBiomeFromLookup(d3, d4);
			}
		}
		return abiomegenbase;
    }
	
    public static int getBiomeFromLookup(double d, double d1)
    {
        int i = (int)(d * 63D);
        int j = (int)(d1 * 63D);
        return biomeLookupTable[i + j * 64];
    }
	
    public void generateBiomeLookup()  
    {
		if(BWG4GeneratorType.Current == BWG4GeneratorType.BWG4SKY1)
		{
			for(int i = 0; i < 64; i++)
			{
				for(int j = 0; j < 64; j++)
				{
					biomeLookupTable[i + j * 64] = getDefaultBiomes((float)i / 63F, (float)j / 63F);
				}
			}
		}
		else if(BWG4GeneratorType.Current == BWG4GeneratorType.BWG4SKY2)
		{
			for(int i = 0; i < 64; i++)
			{
				for(int j = 0; j < 64; j++)
				{
					biomeLookupTable[i + j * 64] = getBetaBiomes((float)i / 63F, (float)j / 63F);
				}
			}
		}
		else if(BWG4GeneratorType.Current == BWG4GeneratorType.BWG4BETA1)
		{
			for(int i = 0; i < 64; i++)
			{
				for(int j = 0; j < 64; j++)
				{
					biomeLookupTable[i + j * 64] = getBetaBiomes((float)i / 63F, (float)j / 63F);
				}
			}
		}
		else if(BWG4GeneratorType.Current == BWG4GeneratorType.BWG4BETA2)
		{
			for(int i = 0; i < 64; i++)
			{
				for(int j = 0; j < 64; j++)
				{
					biomeLookupTable[i + j * 64] = getDefaultBiomes((float)i / 63F, (float)j / 63F);
				}
			}
		}
		else
		{
			for(int i = 0; i < 64; i++)
			{
				for(int j = 0; j < 64; j++)
				{
					biomeLookupTable[i + j * 64] = getAlphaBiomes((float)i / 63F, (float)j / 63F);
				}
			}
		}
    }
	
    public int getBetaBiomes(float f, float f1) 
    {
		f1 *= f;
		if(f < 0.1F)
		{
			return BWG4Biomes.BETAtundra.biomeID; 
		}
		if(f1 < 0.2F)
		{
			if(f < 0.5F)
			{
				return BWG4Biomes.BETAtundra.biomeID;
			}
			if(f < 0.95F)
			{
				return BWG4Biomes.BETAsavanna.biomeID;
			} else
			{
				return BWG4Biomes.BETAdesert.biomeID;
			}
		}
		if(f1 > 0.5F && f < 0.7F)
		{
			return BWG4Biomes.BETAswampland.biomeID;
		}
		if(f < 0.5F)
		{
			return BWG4Biomes.BETAtaiga.biomeID;
		}
		if(f < 0.97F)
		{
			if(f1 < 0.35F)
			{
				return BWG4Biomes.BETAshrubland.biomeID;
			} else
			{
				return BWG4Biomes.BETAforest.biomeID;
			}
		}
		if(f1 < 0.45F)
		{
			return BWG4Biomes.BETAplains.biomeID;
		}
		if(f1 < 0.9F)
		{
			return BWG4Biomes.BETAseasonalForest.biomeID;
		} else
		{
			return BWG4Biomes.BETArainforest.biomeID;
		}
    }
	
    public int getDefaultBiomes(float temp, float rain) 
    {
		rain *= temp;
		if(temp < 0.2F)
		{
			if(rain < 0.1F)
			{
				return BWG4Biomes.BDsnowplains.biomeID; 
			}
			else
			{
				return BWG4Biomes.BDsnowpines.biomeID; 
			}
		}
		if(temp < 0.4F)
		{
			if(rain < 0.1F)
			{
				return BWG4Biomes.BDsnowtaiga.biomeID; 
			}
			if(rain < 0.2F)
			{
				return BWG4Biomes.BDsnowforest.biomeID; 
			}
			else
			{
				return BWG4Biomes.BDsnowpines.biomeID; 
			}
		}
		if(temp < 0.5F)
		{
			if(rain < 0.1F)
			{
				return BWG4Biomes.BDtaiga.biomeID; 
			}
			if(rain < 0.2F)
			{
				return BWG4Biomes.BDforest.biomeID; 
			}
			else
			{
				return BWG4Biomes.BDpines.biomeID; 
			} 
		}
		if(temp < 0.7F)
		{
			if(rain < 0.3F)
			{
				return BWG4Biomes.BDforest.biomeID; 
			}
			if(rain < 0.5F)
			{
				return BWG4Biomes.BDforesthills.biomeID; 
			}
			if(rain < 0.7F)
			{
				return BWG4Biomes.BDgrassland.biomeID; 
			}
			else
			{
				return BWG4Biomes.BDswampland_nocolor.biomeID; 
			} 
		}
		if(temp < 0.8F)
		{
			if(rain < 0.2F)
			{
				return BWG4Biomes.BDplains.biomeID; 
			}
			if(rain < 0.5F)
			{
				return BWG4Biomes.BDforest.biomeID; 
			}
			if(rain < 0.7F)
			{
				return BWG4Biomes.BDforestlakes.biomeID; 
			}
			else
			{
				return BWG4Biomes.BDswampland_nocolor.biomeID; 
			}
		}
		if(rain < 0.2F)
		{
			if(temp < 0.9F)
			{
				return BWG4Biomes.BDshrubland.biomeID; 
			}
			else
			{
				return BWG4Biomes.BDdesert.biomeID; 
			}
		}
		if(rain < 0.3F)
		{
			return BWG4Biomes.BDsavanna.biomeID; 
		}
		if(rain < 0.4F)
		{
			return BWG4Biomes.BDplains.biomeID; 
		}
		if(rain < 0.7F)
		{
			return BWG4Biomes.BDforestlakes.biomeID;  
		}
		if(rain < 0.8F)
		{
			return BWG4Biomes.BDrainforest.biomeID; 
		}
		else
		{
			return BWG4Biomes.BDjungle_nocolor.biomeID; 
		}
    }
	
    public int getAlphaBiomes(float f, float f1) 
    {
		f1 *= f;
		if(f < 0.1F)
		{
			return BWG4Biomes.ALPHAtundra.biomeID; 
		}
		if(f1 < 0.2F)
		{
			if(f < 0.5F)
			{
				return BWG4Biomes.ALPHAtundra.biomeID;
			}
			if(f < 0.95F)
			{
				return BWG4Biomes.ALPHAsavanna.biomeID;
			} else
			{
				return BWG4Biomes.ALPHAdesert.biomeID;
			}
		}
		if(f1 > 0.5F && f < 0.7F)
		{
			return BWG4Biomes.ALPHAswampland.biomeID;
		}
		if(f < 0.5F)
		{
			return BWG4Biomes.ALPHAtaiga.biomeID;
		}
		if(f < 0.97F)
		{
			if(f1 < 0.35F)
			{
				return BWG4Biomes.ALPHAshrubland.biomeID;
			} else
			{
				return BWG4Biomes.ALPHAforest.biomeID;
			}
		}
		if(f1 < 0.45F)
		{
			return BWG4Biomes.ALPHAplains.biomeID;
		}
		if(f1 < 0.9F)
		{
			return BWG4Biomes.ALPHAseasonalForest.biomeID;
		} else
		{
			return BWG4Biomes.ALPHArainforest.biomeID;
		}
    }
	
    public List getBiomesToSpawnIn()
    {
        return this.biomesToSpawnIn;
    }

    public BiomeGenBase getBiomeGenAt(int par1, int par2)
    {
        return this.biomeCache.getBiomeGenAt(par1, par2);
    }

    public float[] getRainfall(float[] par1ArrayOfFloat, int par2, int par3, int par4, int par5)
    {
        IntCache.resetIntCache();

        if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5)
        {
            par1ArrayOfFloat = new float[par4 * par5];
        }

		int var6[];
		if(BWG4GeneratorType.Current == BWG4GeneratorType.BWG4BETA1 || BWG4GeneratorType.Current == BWG4GeneratorType.BWG4BETA2 || BWG4GeneratorType.Current == BWG4GeneratorType.BWG4SKY1 || BWG4GeneratorType.Current == BWG4GeneratorType.BWG4SKY2 || BWG4GeneratorType.Current == BWG4GeneratorType.BWG4ALPHA)
		{	
			var6 = getBiomesGens(par2, par3, par4, par5);
		}
		else
		{
			var6 = biomeIndexLayer.getInts(par2, par3, par4, par5);
		}


        for (int var7 = 0; var7 < par4 * par5; ++var7)
        {
            float var8 = (float)BiomeGenBase.biomeList[var6[var7]].getIntRainfall() / 65536.0F;

            if (var8 > 1.0F)
            {
                var8 = 1.0F;
            }

            par1ArrayOfFloat[var7] = var8;
        }

        return par1ArrayOfFloat;
    }

    /**
     * Return an adjusted version of a given temperature based on the y height
     */
    public float getTemperatureAtHeight(float par1, int par2)
    {
        return par1;
    }

    /**
     * Returns a list of temperatures to use for the specified blocks.  Args: listToReuse, x, y, width, length
     */
    public float[] getTemperatures(float[] par1ArrayOfFloat, int par2, int par3, int par4, int par5)
    {
        IntCache.resetIntCache();

        if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5)
        {
            par1ArrayOfFloat = new float[par4 * par5];
        }

		int var6[];
		if(BWG4GeneratorType.Current == BWG4GeneratorType.BWG4BETA1 || BWG4GeneratorType.Current == BWG4GeneratorType.BWG4BETA2 || BWG4GeneratorType.Current == BWG4GeneratorType.BWG4SKY1 || BWG4GeneratorType.Current == BWG4GeneratorType.BWG4SKY2 || BWG4GeneratorType.Current == BWG4GeneratorType.BWG4ALPHA)
		{		
			var6 = getBiomesGens(par2, par3, par4, par5);
		}
		else
		{
			var6 = biomeIndexLayer.getInts(par2, par3, par4, par5);
		}

        for (int var7 = 0; var7 < par4 * par5; ++var7)
        {
            float var8 = (float)BiomeGenBase.biomeList[var6[var7]].getIntTemperature() / 65536.0F;

            if (var8 > 1.0F)
            {
                var8 = 1.0F;
            }

            par1ArrayOfFloat[var7] = var8;
        }

        return par1ArrayOfFloat;
    }

    /**
     * Returns an array of biomes for the location input.
     */
    public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5)
    {
        IntCache.resetIntCache();

        if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5)
        {
            par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
        }

		int var6[];
		if(BWG4GeneratorType.Current == BWG4GeneratorType.BWG4BETA1 || BWG4GeneratorType.Current == BWG4GeneratorType.BWG4BETA2 || BWG4GeneratorType.Current == BWG4GeneratorType.BWG4SKY1 || BWG4GeneratorType.Current == BWG4GeneratorType.BWG4SKY2 || BWG4GeneratorType.Current == BWG4GeneratorType.BWG4ALPHA)
		{	
			var6 = getBiomesGens(par2, par3, par4, par5);
		}
		else
		{
			var6 = genBiomes.getInts(par2, par3, par4, par5);
		}

        for (int var7 = 0; var7 < par4 * par5; ++var7)
        {
            par1ArrayOfBiomeGenBase[var7] = BiomeGenBase.biomeList[var6[var7]];
        }

        return par1ArrayOfBiomeGenBase;
    }

    /**
     * Returns biomes to use for the blocks and loads the other data like temperature and humidity onto the
     * WorldChunkManager Args: oldBiomeList, x, z, width, depth
     */
    public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5)
    {
        return this.getBiomeGenAt(par1ArrayOfBiomeGenBase, par2, par3, par4, par5, true);
    }

    /**
     * Return a list of biomes for the specified blocks. Args: listToReuse, x, y, width, length, cacheFlag (if false,
     * don't check biomeCache to avoid infinite loop in BiomeCacheBlock)
     */
    public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5, boolean par6)
    {
        IntCache.resetIntCache();

        if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5)
        {
            par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
        }

        if (par6 && par4 == 16 && par5 == 16 && (par2 & 15) == 0 && (par3 & 15) == 0)
        {
            BiomeGenBase[] var9 = this.biomeCache.getCachedBiomes(par2, par3);
            System.arraycopy(var9, 0, par1ArrayOfBiomeGenBase, 0, par4 * par5);
            return par1ArrayOfBiomeGenBase;
        }
        else
        {
			int var7[];
			if(BWG4GeneratorType.Current == BWG4GeneratorType.BWG4BETA1 || BWG4GeneratorType.Current == BWG4GeneratorType.BWG4BETA2 || BWG4GeneratorType.Current == BWG4GeneratorType.BWG4SKY1 || BWG4GeneratorType.Current == BWG4GeneratorType.BWG4SKY2 || BWG4GeneratorType.Current == BWG4GeneratorType.BWG4ALPHA)
			{	
				var7 = getBiomesGens(par2, par3, par4, par5);
			}
			else
			{
				var7 = biomeIndexLayer.getInts(par2, par3, par4, par5);
			}

            for (int var8 = 0; var8 < par4 * par5; ++var8)
            {
                par1ArrayOfBiomeGenBase[var8] = BiomeGenBase.biomeList[var7[var8]];
            }

            return par1ArrayOfBiomeGenBase;
        }
    }

    /**
     * checks given Chunk's Biomes against List of allowed ones
     */
    public boolean areBiomesViable(int par1, int par2, int par3, List par4List)
    {
        IntCache.resetIntCache();
        int var5 = par1 - par3 >> 2;
        int var6 = par2 - par3 >> 2;
        int var7 = par1 + par3 >> 2;
        int var8 = par2 + par3 >> 2;
        int var9 = var7 - var5 + 1;
        int var10 = var8 - var6 + 1;
		
		int var11[];
		if(BWG4GeneratorType.Current == BWG4GeneratorType.BWG4BETA1 || BWG4GeneratorType.Current == BWG4GeneratorType.BWG4BETA2 || BWG4GeneratorType.Current == BWG4GeneratorType.BWG4SKY1 || BWG4GeneratorType.Current == BWG4GeneratorType.BWG4SKY2 || BWG4GeneratorType.Current == BWG4GeneratorType.BWG4ALPHA)
		{	
			return false;
		}
		else
		{
			var11 = genBiomes.getInts(var5, var6, var9, var10);
		}


        for (int var12 = 0; var12 < var9 * var10; ++var12)
        {
            BiomeGenBase var13 = BiomeGenBase.biomeList[var11[var12]];

            if (!par4List.contains(var13))
            {
                return false;
            }
        }

        return true;
    }

    /**
     * Finds a valid position within a range, that is in one of the listed biomes. Searches {par1,par2} +-par3 blocks.
     * Strongly favors positive y positions.
     */
    public ChunkPosition findBiomePosition(int par1, int par2, int par3, List par4List, Random par5Random)
    {
        IntCache.resetIntCache();
        int var6 = par1 - par3 >> 2;
        int var7 = par2 - par3 >> 2;
        int var8 = par1 + par3 >> 2;
        int var9 = par2 + par3 >> 2;
        int var10 = var8 - var6 + 1;
        int var11 = var9 - var7 + 1;
		
		int var12[];
		if(BWG4GeneratorType.Current == BWG4GeneratorType.BWG4BETA1 || BWG4GeneratorType.Current == BWG4GeneratorType.BWG4BETA2 || BWG4GeneratorType.Current == BWG4GeneratorType.BWG4SKY1 || BWG4GeneratorType.Current == BWG4GeneratorType.BWG4SKY2 || BWG4GeneratorType.Current == BWG4GeneratorType.BWG4ALPHA)
		{	
			return null;
		}
		else
		{
			var12 = genBiomes.getInts(var6, var7, var10, var11);
		}
		
        ChunkPosition var13 = null;
        int var14 = 0;

        for (int var15 = 0; var15 < var10 * var11; ++var15)
        {
            int var16 = var6 + var15 % var10 << 2;
            int var17 = var7 + var15 / var10 << 2;
            BiomeGenBase var18 = BiomeGenBase.biomeList[var12[var15]];

            if (par4List.contains(var18) && (var13 == null || par5Random.nextInt(var14 + 1) == 0))
            {
                var13 = new ChunkPosition(var16, 0, var17);
                ++var14;
            }
        }

        return var13;
    }

    /**
     * Calls the WorldChunkManager's biomeCache.cleanupCache()
     */
    public void cleanupCache()
    {
        this.biomeCache.cleanupCache();
    }
}
