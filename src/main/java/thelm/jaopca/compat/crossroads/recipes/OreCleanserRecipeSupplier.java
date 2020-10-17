package thelm.jaopca.compat.crossroads.recipes;

import java.util.Objects;
import java.util.function.Supplier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.Da_Technomancer.crossroads.crafting.recipes.OreCleanserRec;
import com.google.common.base.Strings;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import thelm.jaopca.utils.MiscHelper;

public class OreCleanserRecipeSupplier implements Supplier<OreCleanserRec> {

	private static final Logger LOGGER = LogManager.getLogger();

	public final ResourceLocation key;
	public final String group;
	public final Object input;
	public final Object output;
	public final int count;

	public OreCleanserRecipeSupplier(ResourceLocation key, Object input, Object output, int count) {
		this(key, "", input, output, count);
	}

	public OreCleanserRecipeSupplier(ResourceLocation key, String group, Object input, Object output, int count) {
		this.key = Objects.requireNonNull(key);
		this.group = Strings.nullToEmpty(group);
		this.input = input;
		this.output = output;
		this.count = count;
	}

	@Override
	public OreCleanserRec get() {
		Ingredient ing = MiscHelper.INSTANCE.getIngredient(input);
		if(ing.hasNoMatchingItems()) {
			throw new IllegalArgumentException("Empty ingredient in recipe "+key+": "+input);
		}
		ItemStack stack = MiscHelper.INSTANCE.getItemStack(output, count);
		if(stack.isEmpty()) {
			LOGGER.warn("Empty output in recipe {}: {}", key, output);
		}
		return new OreCleanserRec(key, group, ing, stack, true);
	}
}
