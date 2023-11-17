package net.norbert.tutorialmod;


import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.item.Items;

public enum CustomToolMaterial implements ToolMaterial {
    // Przykładowe wartości
    MOGUS(3, 1500, 8.0F, 2.5F, 10, Ingredient.ofItems(Items.DIAMOND));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Ingredient repairIngredient;

    CustomToolMaterial(int miningLevel, int durability, float miningSpeed, float attackDamage, int enchantability, Ingredient repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = durability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient;
    }
}
