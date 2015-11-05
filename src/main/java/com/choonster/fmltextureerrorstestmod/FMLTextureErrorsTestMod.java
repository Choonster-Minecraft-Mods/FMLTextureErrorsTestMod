package com.choonster.fmltextureerrorstestmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = FMLTextureErrorsTestMod.MODID, version = FMLTextureErrorsTestMod.VERSION)
public class FMLTextureErrorsTestMod {
	public static final String MODID = "fmltextureerrorstestmod";
	public static final String VERSION = "1.0";

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Block brokenAnimation = new Block(Material.iron);
		brokenAnimation.setCreativeTab(CreativeTabs.tabBlock);
		brokenAnimation.setUnlocalizedName("brokenAnimation");
		GameRegistry.registerBlock(brokenAnimation, "broken_animation");

		Block workingAnimation = new Block(Material.iron);
		workingAnimation.setCreativeTab(CreativeTabs.tabBlock);
		workingAnimation.setUnlocalizedName("workingAnimation");
		GameRegistry.registerBlock(workingAnimation, "working_animation");
	}
}
