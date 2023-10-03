package mod.climatechange;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ClimatechangeClient implements ClientModInitializer {
	public static final BottleMilk BottleMilk = new BottleMilk(new FabricItemSettings());
	private static final ItemGroup CC_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(BottleMilk))
			.displayName(Text.translatable("Climate Change"))
			.entries((context, entries) -> {
				entries.add(BottleMilk);
			})
			.build();
	@Override
	public void onInitializeClient() {
		Registry.register(Registries.ITEM, new Identifier("climate-change", "bottle_milk"), BottleMilk);
		Registry.register(Registries.ITEM_GROUP,new Identifier("climate-change","cc_group"),CC_GROUP);
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
	}
	public void onInitialize() {
	}
}