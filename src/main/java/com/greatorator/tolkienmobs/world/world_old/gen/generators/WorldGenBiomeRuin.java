//package com.greatorator.tolkienmobs.world.world_old.gen.generators;
//
//import com.greatorator.tolkienmobs.handler.handler_old.interfaces.ITTMStructure;
//import com.greatorator.tolkienmobs.handler.handler_old.interfaces.ITTMStructureSummon;
//import com.greatorator.tolkienmobs.init.LootInit;
//import net.minecraft.block.BlockStairs;
//import net.minecraft.block.BlockStoneBrick;
//import net.minecraft.block.state.IBlockState;
//import net.minecraft.init.Blocks;
//import net.minecraft.tileentity.TileEntityChest;
//import net.minecraft.util.EnumFacing;
//import net.minecraft.util.ResourceLocation;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.World;
//import net.minecraft.world.gen.feature.WorldGenAbstractTree;
//
//import java.util.Random;
//
//public class WorldGenBiomeRuin extends WorldGenAbstractTree implements ITTMStructure, ITTMStructureSummon {
//    public static final WorldGenBiomeRuin INSTANCE = new WorldGenBiomeRuin(true);
//
//    public WorldGenBiomeRuin(boolean notify) {
//        super(notify);
//    }
//
//    @Override
//    public boolean generate(World world, Random random, BlockPos position) {
//
//        if(random.nextInt(70) == 0) {
//            IBlockState surfaceState = Blocks.GRASS.getDefaultState();
//            int chest;
//            for (int newPos = -7; newPos < 5; ++newPos) {
//                if (newPos == -6 || newPos == -5) {
//                    world.setBlockState(position.add(newPos, 0, -6), this.getRandomState(random));
//                }
//
//                if (newPos == -7 || newPos >= -4 && newPos <= 2) {
//                    world.setBlockState(position.add(newPos, 0, -4), this.getRandomState(random));
//                }
//
//                if (newPos >= -4 && newPos <= 3) {
//                    world.setBlockState(position.add(newPos, 0, -3), this.getRandomState(random));
//                    world.setBlockState(position.add(newPos, 0, 4), surfaceState);
//                    if (newPos != 3) {
//                        world.setBlockState(position.add(newPos, 0, 5), surfaceState);
//                    }
//                }
//
//                if (newPos == -2) {
//                    world.setBlockState(position.add(newPos, 0, -7), this.getRandomState(random));
//                }
//
//                if (newPos == 4) {
//                    world.setBlockState(position.add(newPos, 0, 6), this.getRandomState(random));
//                }
//
//                if (newPos == 2) {
//                    world.setBlockState(position.add(newPos, 0, 7), this.getRandomState(random));
//                }
//
//                if (newPos >= -5) {
//                    for (chest = -2; chest < 4; ++chest) {
//                        world.setBlockState(position.add(newPos, 0, chest), random.nextInt(10) == 0 ? surfaceState : this.getRandomState(random));
//                    }
//                }
//            }
//
//            BlockPos var9 = position.up();
//
//            for (chest = -5; chest < 8; ++chest) {
//                BlockPos usedLootTable;
//                if (chest == 4 || chest == 5 || chest <= -3) {
//                    usedLootTable = var9.add(chest, 0, -2);
//                    world.setBlockState(usedLootTable, this.getRandomState(random));
//                    if (chest == 5) {
//                        world.setBlockState(var9.add(chest, 0, 7), this.getRandomState(random));
//                    }
//
//                    if (chest == 4) {
//                        world.setBlockState(var9.add(chest, 0, -1), this.getRandomState(random));
//                        world.setBlockState(var9.add(chest, 0, 0), this.getRandomState(random));
//                        world.setBlockState(var9.add(chest, 0, 1), this.getRandomState(random));
//                        world.setBlockState(var9.add(chest, 0, 2), this.getRandomState(random));
//                    }
//
//                    if (chest == -3) {
//                        world.setBlockState(usedLootTable, Blocks.STONE_BRICK_STAIRS.getDefaultState());
//                    }
//                }
//
//                if (chest >= -4 && chest <= 2) {
//                    if (chest == 0) {
//                        world.setBlockState(var9.add(chest, 0, -1), Blocks.COBBLESTONE.getDefaultState());
//                        world.setBlockState(var9.add(chest, 0, 1), Blocks.LOG.getDefaultState());
//                        world.setBlockState(var9.add(chest, 0, -6), this.getRandomState(random));
//                    }
//
//                    if (chest == 1) {
//                        world.setBlockState(var9.add(chest, 0, -1), this.getRandomState(random));
//                        world.setBlockState(var9.add(chest, 0, 1), this.getRandomState(random));
//                        world.setBlockState(var9.add(chest, 0, 3), this.getRandomState(random));
//                    }
//
//                    if (chest == 2) {
//                        world.setBlockState(var9.add(chest, 0, -1), Blocks.STONE_BRICK_STAIRS.getDefaultState());
//                        world.setBlockState(var9.add(chest, 0, 1), this.getRandomState(random));
//                    }
//
//                    world.setBlockState(var9.add(chest, 0, -4), this.getRandomState(random));
//                }
//
//                if (chest == -5 || chest == -4 || chest == 4) {
//                    world.setBlockState(var9.add(chest, 0, 3), this.getRandomState(random));
//                }
//
//                if (chest == -4 || chest == -3 || chest == -2 || chest == 4) {
//                    usedLootTable = var9.add(chest, 0, -2);
//                    world.setBlockState(usedLootTable, this.getRandomState(random));
//                    if (chest == -2) {
//                        world.setBlockState(usedLootTable, Blocks.FIRE.getDefaultState());
//                    }
//                }
//
//                if (chest >= -3 && chest <= 2 || chest == 5) {
//                    world.setBlockState(var9.add(chest, 0, 5), this.getRandomState(random));
//                }
//
//                if (chest == -4 || chest == -1 || chest == 2 || chest == 3) {
//                    if (chest == -1) {
//                        world.setBlockState(var9.add(chest, 0, -2), Blocks.COBBLESTONE.getDefaultState());
//                    }
//
//                    world.setBlockState(var9.add(chest, 0, -3), this.getRandomState(random));
//                }
//            }
//
//            var9 = position.up(2);
//
//            int var10;
//            for (chest = -5; chest < 5; ++chest) {
//                if (chest >= -3 && chest <= 1) {
//                    if (chest == 0) {
//                        world.setBlockState(var9.add(chest, 0, 1), Blocks.LOG.getDefaultState());
//                    }
//
//                    world.setBlockState(var9.add(chest, 0, -4), this.getRandomState(random));
//                    world.setBlockState(var9.add(chest, 0, 5), this.getRandomState(random));
//                }
//
//                if (chest == -4 || chest == -2 || chest == -1 || chest == 3) {
//                    if (chest == -4) {
//                        world.setBlockState(var9.add(chest, 0, 4), this.getRandomState(random));
//                    }
//
//                    world.setBlockState(var9.add(chest, 0, -3), random.nextInt(4) == 0 ? this.getRandomState(random) : Blocks.COBBLESTONE.getDefaultState());
//                }
//
//                if (chest == -5) {
//                    world.setBlockState(var9.add(chest, 0, -2), this.getRandomState(random));
//                    world.setBlockState(var9.add(chest, 0, 3), this.getRandomState(random));
//                }
//
//                if (chest == 2) {
//                    world.setBlockState(var9.add(chest, 0, -4), this.getRandomState(random));
//                }
//
//                if (chest == 4) {
//                    for (var10 = -2; var10 < 3; ++var10) {
//                        world.setBlockState(var9.add(chest, 0, var10), this.getRandomState(random));
//                    }
//                }
//            }
//
//            var9 = position.up(3);
//
//            for (chest = -5; chest < 5; ++chest) {
//                if (chest >= -3 && chest <= 2) {
//                    if (chest == 0) {
//                        world.setBlockState(var9.add(chest, 0, 1), Blocks.LOG.getDefaultState());
//                        world.setBlockState(var9.add(chest, 0, 5), this.getRandomState(random));
//                    }
//
//                    world.setBlockState(var9.add(chest, 0, -4), this.getRandomState(random));
//                }
//
//                if (chest == -4 || chest == -1 || chest == 1 || chest == 3) {
//                    if (chest == -1) {
//                        world.setBlockState(var9.add(chest, 0, 5), this.getRandomState(random));
//                    }
//
//                    if (chest == -4) {
//                        world.setBlockState(var9.add(chest, 0, 4), this.getRandomState(random));
//                    }
//
//                    world.setBlockState(var9.add(chest, 0, -3), random.nextInt(4) == 0 ? this.getRandomState(random) : Blocks.COBBLESTONE.getDefaultState());
//                }
//
//                if (chest == -5) {
//                    world.setBlockState(var9.add(chest, 0, -2), this.getRandomState(random));
//                    world.setBlockState(var9.add(chest, 0, 3), this.getRandomState(random));
//                }
//
//                if (chest == 4) {
//                    for (var10 = -2; var10 < 3; ++var10) {
//                        world.setBlockState(var9.add(chest, 0, var10), this.getRandomState(random));
//                    }
//                }
//            }
//
//            var9 = position.up(4);
//
//            for (chest = -5; chest < 5; ++chest) {
//                if (chest >= -2 && chest <= 2) {
//                    if (chest == 0) {
//                        world.setBlockState(var9.add(chest, 0, 1), Blocks.LOG.getDefaultState());
//                        world.setBlockState(var9.add(chest, 0, 2), Blocks.LOG.getDefaultState());
//                        world.setBlockState(var9.add(chest, 0, 5), this.getRandomState(random));
//                    }
//
//                    world.setBlockState(var9.add(chest, 0, -4), this.getRandomState(random));
//                }
//
//                if (chest == -4 || chest == 2 || chest == 3) {
//                    if (chest == 3) {
//                        world.setBlockState(var9.add(chest, 0, -2), this.getRandomState(random));
//                    }
//
//                    if (chest == -4) {
//                        world.setBlockState(var9.add(chest, 0, 4), this.getRandomState(random));
//                    }
//
//                    world.setBlockState(var9.add(chest, 0, -3), random.nextInt(4) == 0 ? this.getRandomState(random) : Blocks.COBBLESTONE.getDefaultState());
//                }
//
//                if (chest == -3) {
//                    world.setBlockState(var9.add(chest, 0, 5), this.getRandomState(random));
//                }
//
//                if (chest == -5) {
//                    world.setBlockState(var9.add(chest, 0, -2), this.getRandomState(random));
//                    world.setBlockState(var9.add(chest, 0, 3), this.getRandomState(random));
//                }
//
//                if (chest == 4) {
//                    for (var10 = -2; var10 < 2; ++var10) {
//                        world.setBlockState(var9.add(chest, 0, var10), this.getRandomState(random));
//                    }
//                }
//            }
//
//            var9 = position.up(5);
//
//            for (chest = -5; chest < 5; ++chest) {
//                if (chest >= -2 && chest <= 2) {
//                    if (chest == 0) {
//                        world.setBlockState(var9.add(chest, 0, -1), Blocks.LOG.getDefaultState());
//                        world.setBlockState(var9.add(chest, 0, 1), Blocks.LOG.getDefaultState());
//                        world.setBlockState(var9.add(chest, 0, 3), Blocks.LOG.getDefaultState());
//                    }
//
//                    world.setBlockState(var9.add(chest, 0, -4), this.getRandomState(random));
//                }
//
//                if (chest >= -1 && chest <= 2) {
//                    world.setBlockState(var9.add(chest, 0, 1), Blocks.LOG.getDefaultState());
//                }
//
//                if (chest == -4) {
//                    world.setBlockState(var9.add(chest, 0, 4), this.getRandomState(random));
//                }
//
//                if (chest == 3) {
//                    world.setBlockState(var9.add(chest, 0, -3), this.getRandomState(random));
//                    world.setBlockState(var9.add(chest, 0, 0), this.getRandomState(random));
//                }
//
//                if (chest == 4) {
//                    for (var10 = -2; var10 < 2; ++var10) {
//                        world.setBlockState(var9.add(chest, 0, var10), this.getRandomState(random));
//                    }
//                }
//
//                if (chest == -1 || chest == -2 || chest == -3) {
//                    world.setBlockState(var9.add(chest, 0, 5), this.getRandomState(random));
//                }
//
//                if (chest == -5) {
//                    for (var10 = -2; var10 < 3; ++var10) {
//                        world.setBlockState(var9.add(chest, 0, var10), this.getRandomState(random));
//                    }
//                }
//            }
//
//            var9 = position.up(6);
//
//            for (chest = -5; chest < 5; ++chest) {
//                if (chest >= -3 && chest <= 2) {
//                    if (chest == 0) {
//                        world.setBlockState(var9.add(chest, 0, 1), Blocks.LOG.getDefaultState());
//                    }
//
//                    world.setBlockState(var9.add(chest, 0, -4), this.getRandomState(random));
//                }
//
//                if (chest == -1 || chest == -2 || chest == -3) {
//                    world.setBlockState(var9.add(chest, 0, 5), this.getRandomState(random));
//                }
//
//                if (chest == -4) {
//                    world.setBlockState(var9.add(chest, 0, -3), this.getRandomState(random));
//                }
//
//                if (chest == -4) {
//                    world.setBlockState(var9.add(chest, 0, -3), this.getRandomState(random));
//                    world.setBlockState(var9.add(chest, 0, 4), this.getRandomState(random));
//                }
//
//                if (chest == 4) {
//                    world.setBlockState(var9.add(chest, 0, -2), this.getRandomState(random));
//                    world.setBlockState(var9.add(chest, 0, -1), this.getRandomState(random));
//                    world.setBlockState(var9.add(chest, 0, 1), this.getRandomState(random));
//                }
//
//                if (chest == -5) {
//                    for (var10 = -2; var10 < 4; ++var10) {
//                        if (var10 != 0) {
//                            world.setBlockState(var9.add(chest, 0, var10), this.getRandomState(random));
//                        }
//                    }
//                }
//            }
//
//            var9 = position.up(7);
//
//            for (chest = -5; chest < 5; ++chest) {
//                if (chest >= -3 && chest <= 0) {
//                    world.setBlockState(var9.add(chest, 0, -4), this.getRandomState(random));
//                    world.setBlockState(var9.add(chest, 0, -3), this.getRandomState(random));
//                    world.setBlockState(var9.add(chest, 0, 4), this.getRandomState(random));
//                }
//
//                if (chest == 4 || chest == -2 || chest == -3 || chest == -5) {
//                    world.setBlockState(var9.add(chest, 0, -2), this.getRandomState(random));
//                    world.setBlockState(var9.add(chest, 0, -1), this.getRandomState(random));
//                    world.setBlockState(var9.add(chest, 0, 0), this.getRandomState(random));
//                }
//
//                if (chest == -1 || chest == -2 || chest == -3) {
//                    world.setBlockState(var9.add(chest, 0, 5), this.getRandomState(random));
//                }
//
//                if (chest == 0 || chest == -1 || chest == -3 || chest == -5) {
//                    if (chest == -1) {
//                        world.setBlockState(var9.add(chest, 0, -2), this.getRandomState(random));
//                    }
//
//                    if (chest == -5) {
//                        world.setBlockState(var9.add(chest, 0, 1), this.getRandomState(random));
//                    }
//
//                    world.setBlockState(var9.add(chest, 0, 3), this.getRandomState(random));
//                }
//
//                if (chest == 2 || chest == 1) {
//                    world.setBlockState(var9.add(chest, 0, -4), this.getRandomState(random));
//                }
//
//                if (chest == -4) {
//                    for (var10 = -3; var10 < 5; ++var10) {
//                        world.setBlockState(var9.add(chest, 0, var10), this.getRandomState(random));
//                    }
//                }
//            }
//
//            var9 = position.up(8);
//            world.setBlockState(var9.add(4, 0, -1), this.getRandomState(random));
//            world.setBlockState(var9.add(-2, 0, 5), this.getRandomState(random));
//            world.setBlockState(var9.add(-3, 0, -4), this.getRandomState(random));
//            world.setBlockState(var9.add(-4, 0, -3), this.getRandomState(random));
//            world.setBlockState(var9.add(-4, 0, -2), Blocks.CHEST.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.EAST));
//            TileEntityChest var11 = (TileEntityChest) world.getTileEntity(var9.add(-4, 0, -2));
//            ResourceLocation var12 = random.nextInt(3) == 0 ? LootInit.REMOTE_RUINS : LootInit.HOBBIT_HOUSE;
//
//            for (int treasureSize = 0; treasureSize < 2 + random.nextInt(2); ++treasureSize) {
//                var11.setLootTable(var12, random.nextLong());
//            }
//
//            world.setBlockState(var9.add(-4, 0, 4), this.getRandomState(random));
//            world.setBlockState(var9.add(-5, 0, -2), this.getRandomState(random));
//            world.setBlockState(var9.add(-5, 0, -1), this.getRandomState(random));
//            world.setBlockState(var9.add(-5, 0, 0), this.getRandomState(random));
//            var9 = position.up(9);
//            world.setBlockState(var9.add(-3, 0, -4), this.getRandomState(random));
//            world.setBlockState(var9.add(-4, 0, -3), this.getRandomState(random));
//            world.setBlockState(var9.add(-5, 0, -2), this.getRandomState(random));
//            world.setBlockState(var9.add(-5, 0, -1), this.getRandomState(random));
//            var9 = position.up(10);
//            world.setBlockState(var9.add(-4, 0, -3), this.getRandomState(random));
//            world.setBlockState(var9.add(-5, 0, -2), this.getRandomState(random));
//            var9 = position.up(11);
//            world.setBlockState(var9.add(-4, 0, -3), this.getRandomState(random));
//            world.setBlockState(var9.add(-5, 0, -2), this.getRandomState(random));
//        }
//        return false;
//    }
//
//    private IBlockState getRandomState(Random random) {
//        IBlockState block = Blocks.STONEBRICK.getDefaultState();
//        return random.nextInt(5) == 0 ? block.withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.CRACKED) : block;
//    }
//}