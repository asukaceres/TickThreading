package me.nallar.tickthreading.minecraft.entitylist;

import java.lang.reflect.Field;

import me.nallar.tickthreading.minecraft.TickManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class LoadedTileEntityList extends EntityList<TileEntity> {
	public LoadedTileEntityList(World world, Field overriddenField, TickManager manager) {
		super(world, overriddenField, manager, manager.tileEntityList);
		manager.tileEntityLock = this;
	}

	@Override
	public boolean add(TileEntity t) {
		manager.add(t, true);
		return true;
	}

	@Override
	public boolean remove(Object o) {
		manager.remove((TileEntity) o);
		return true;
	}

	@Override
	public TileEntity remove(int index) {
		TileEntity removed = get(index);
		manager.remove(removed);
		return removed;
	}
}
