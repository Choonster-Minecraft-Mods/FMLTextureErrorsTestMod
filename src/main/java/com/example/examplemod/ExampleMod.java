package com.example.examplemod;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
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

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod {
	public static final String MODID = "examplemod";
	public static final String VERSION = "1.0";

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Fluid testFluid = new Fluid("normal", new ResourceLocation("examplemod:blocks/fluid_normal_still"), new ResourceLocation("examplemod:blocks/fluid_normal_flow"))
				.setLuminosity(10).setDensity(800).setViscosity(1500);
		FluidRegistry.registerFluid(testFluid);

		BlockFluidClassic fluidBlock = new BlockFluidClassic(testFluid, new MaterialLiquid(MapColor.blackColor));
		fluidBlock.setUnlocalizedName(testFluid.getUnlocalizedName());
		GameRegistry.registerBlock(fluidBlock, "fluidNormal");

		if (event.getSide().isClient()) {
			Item item = Item.getItemFromBlock(fluidBlock);

			ModelBakery.addVariantName(item);

			final ModelResourceLocation modelResourceLocation = new ModelResourceLocation("examplemod:fluid", fluidBlock.getFluid().getName());

			ModelLoader.setCustomMeshDefinition(item, new ItemMeshDefinition() {
				@Override
				public ModelResourceLocation getModelLocation(ItemStack stack) {
					return modelResourceLocation;
				}
			});

			ModelLoader.setCustomStateMapper(fluidBlock, new StateMapperBase() {
				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState p_178132_1_) {
					return modelResourceLocation;
				}
			});
		}
	}
}
