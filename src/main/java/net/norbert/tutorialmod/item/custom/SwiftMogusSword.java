package net.norbert.tutorialmod.item.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;
import net.norbert.tutorialmod.CustomToolMaterial;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;


public class SwiftMogusSword extends SwordItem {
    private int hitCount = 0;

    public SwiftMogusSword(CustomToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        hitCount++;
        World world = attacker.getWorld();

        // Generowanie cząsteczek
        world.addParticle(ParticleTypes.CLOUD, target.getX(), target.getY() + 2, target.getZ(), 0.0, 0.0, 0.0);

        // Co trzeci atak generuje piorun
        if (hitCount >= 3) {
            hitCount = 0;
            if (!world.isClient) {
                PlayerEntity player = (PlayerEntity) attacker;
                // Nadaj efekt odporności na krótki czas
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1, 10));

                LightningEntity lightning = EntityType.LIGHTNING_BOLT.create(world);
                lightning.refreshPositionAfterTeleport(target.getX(), target.getY(), target.getZ());
                world.spawnEntity(lightning);
            }
        }

        return super.postHit(stack, target, attacker);
    }
}