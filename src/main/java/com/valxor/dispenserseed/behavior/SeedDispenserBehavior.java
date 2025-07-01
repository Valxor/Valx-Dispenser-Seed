package com.valxor.dispenserseed.behavior;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

import com.valxor.dispenserseed.Valxdispenserseed;

public class SeedDispenserBehavior {
    private static boolean behaviorsRegistered = false;
    

    private static final Map<Item, Block> SEED_TO_CROP = new HashMap<>();
    
    static {
        SEED_TO_CROP.put(Items.WHEAT_SEEDS, Blocks.WHEAT);
        SEED_TO_CROP.put(Items.CARROT, Blocks.CARROTS);
        SEED_TO_CROP.put(Items.POTATO, Blocks.POTATOES);
        SEED_TO_CROP.put(Items.BEETROOT_SEEDS, Blocks.BEETROOTS);
        SEED_TO_CROP.put(Items.PUMPKIN_SEEDS, Blocks.PUMPKIN_STEM);
        SEED_TO_CROP.put(Items.MELON_SEEDS, Blocks.MELON_STEM);
    }    public static void registerBehaviors() {
        if (behaviorsRegistered) return;
        
        Valxdispenserseed.LOGGER.info("Registering seed dispenser behaviors...");
        

        for (Item seed : SEED_TO_CROP.keySet()) {
            DispenserBlock.registerBehavior(seed, new SeedPlantingBehavior());
            Valxdispenserseed.LOGGER.info("Registered behavior for: " + seed);
        }
        

        DispenserBlock.registerBehavior(Items.BONE_MEAL, new BoneMealBehavior());
        Valxdispenserseed.LOGGER.info("Registered behavior for: " + Items.BONE_MEAL);
        
        behaviorsRegistered = true;
        Valxdispenserseed.LOGGER.info("Seed dispenser behaviors registered successfully!");
    }
    
    private static class SeedPlantingBehavior extends ItemDispenserBehavior {
          @Override
        public ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
            World world = pointer.world();
            Direction direction = pointer.state().get(DispenserBlock.FACING);
            BlockPos dispenserPos = pointer.pos();
            
            Valxdispenserseed.LOGGER.info("Seed dispenser activated with item: " + stack.getItem());
            

            int planted = 0;
            int maxDistance = 6;
            
            for (int distance = 1; distance <= maxDistance && stack.getCount() > 0; distance++) {
                BlockPos targetPos = dispenserPos.offset(direction, distance);
                BlockPos belowTargetPos = targetPos.down();
                

                BlockState belowState = world.getBlockState(belowTargetPos);
                if (belowState.getBlock() instanceof FarmlandBlock) {
                    BlockState aboveState = world.getBlockState(targetPos);
                    

                    if (aboveState.isAir()) {

                        Block cropBlock = SEED_TO_CROP.get(stack.getItem());
                        if (cropBlock != null) {

                            BlockState cropState = cropBlock.getDefaultState();
                            world.setBlockState(targetPos, cropState);
                            

                            world.playSound(null, targetPos, SoundEvents.ITEM_CROP_PLANT, 
                                          SoundCategory.BLOCKS, 1.0F, 1.0F);
                            

                            stack.decrement(1);
                            planted++;
                        }
                    }
                }
            }
            

            if (planted > 0) {
                this.playSound(pointer);
            } else {

                return super.dispenseSilently(pointer, stack);
            }
              return stack;
        }
    }
    

    private static class BoneMealBehavior extends ItemDispenserBehavior {
        @Override
        public ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
            World world = pointer.world();
            Direction direction = pointer.state().get(DispenserBlock.FACING);
            BlockPos dispenserPos = pointer.pos();
            
            Valxdispenserseed.LOGGER.info("Bone meal dispenser activated");
            

            int fertilized = 0;
            int maxDistance = 6;
            
            for (int distance = 1; distance <= maxDistance && stack.getCount() > 0; distance++) {
                BlockPos targetPos = dispenserPos.offset(direction, distance);
                BlockState targetState = world.getBlockState(targetPos);
                

                if (targetState.getBlock() instanceof Fertilizable fertilizable) {
                    if (fertilizable.isFertilizable(world, targetPos, targetState)) {

                        if (world instanceof ServerWorld serverWorld) {
                            if (fertilizable.canGrow(world, world.random, targetPos, targetState)) {
                                fertilizable.grow(serverWorld, world.random, targetPos, targetState);
                                

                                spawnBoneMealParticles(world, targetPos);
                                

                                world.playSound(null, targetPos, SoundEvents.ITEM_BONE_MEAL_USE, 
                                              SoundCategory.BLOCKS, 1.0F, 1.0F);
                                

                                stack.decrement(1);
                                fertilized++;
                            }
                        }
                    }
                }
            }
            

            if (fertilized > 0) {
                this.playSound(pointer);
            } else {

                return super.dispenseSilently(pointer, stack);
            }
            
            return stack;
        }
        

        private void spawnBoneMealParticles(World world, BlockPos pos) {
            if (world instanceof ServerWorld serverWorld) {
                Random random = world.random;
                for (int i = 0; i < 15; i++) {
                    double d = random.nextGaussian() * 0.02D;
                    double e = random.nextGaussian() * 0.02D;
                    double f = random.nextGaussian() * 0.02D;
                    serverWorld.spawnParticles(ParticleTypes.HAPPY_VILLAGER, 
                        pos.getX() + 0.5D + random.nextDouble() * 0.6D - 0.3D,
                        pos.getY() + 0.5D + random.nextDouble() * 0.6D - 0.3D,
                        pos.getZ() + 0.5D + random.nextDouble() * 0.6D - 0.3D,
                        1, d, e, f, 0.0D);
                }
            }
        }
    }
}
