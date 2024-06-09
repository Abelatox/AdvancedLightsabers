package com.stelmods.lightsabers.datagen.init;

import com.stelmods.lightsabers.Lightsabers;
import com.stelmods.lightsabers.common.item.ItemCrystal;
import com.stelmods.lightsabers.common.item.ModItems;
import com.stelmods.lightsabers.common.lightsaber.CrystalColor;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemModels extends ItemModelProvider {

    public ItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator.getPackOutput(), Lightsabers.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (RegistryObject<Item> itemRegistryObject : ModItems.ITEMS.getEntries()) {

            //item Name
            final Item item = itemRegistryObject.get();
            final String path = ForgeRegistries.ITEMS.getKey(item).getPath();
            if (item instanceof BlockItem blockItem && blockItem.getBlock() instanceof ItemCrystal) {
                standardBlockItem( path);
            }
        }
        }
    void standardBlockItem(String name) {
        getBuilder(name).parent(new ModelFile.UncheckedModelFile(Lightsabers.MODID + ":block/crystal"));
    }

}
