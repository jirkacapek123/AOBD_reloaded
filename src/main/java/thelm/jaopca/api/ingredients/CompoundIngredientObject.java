package thelm.jaopca.api.ingredients;

import thelm.jaopca.api.ingredients.CompoundIngredientObject.Type;

public record CompoundIngredientObject(Type type, Object... ingredients) {

	public static CompoundIngredientObject of(Type type, Object... ingredients) {
		return new CompoundIngredientObject(type, ingredients);
	}

	public static CompoundIngredientObject union(Object... ingredients) {
		return new CompoundIngredientObject(Type.UNION, ingredients);
	}

	public static CompoundIngredientObject intersection(Object... ingredients) {
		return new CompoundIngredientObject(Type.INTERSECTION, ingredients);
	}

	public static CompoundIngredientObject difference(Object... ingredients) {
		return new CompoundIngredientObject(Type.DIFFERENCE, ingredients);
	}

	public enum Type {
		UNION, INTERSECTION, DIFFERENCE;
	}
}
