package com.example.ecs;

public class EntityManager {
	
	public int flag[];
	public Component.Position pos[];
	public Component.Velocity vel[];
	public Component.Rendering rendering[];
	public final int size;
	
	public EntityManager(int size) {
		this.size = size;
		this.pos = new Component.Position[size];
		this.vel = new Component.Velocity[size];
		this.rendering = new Component.Rendering[size];
		flag = new int[size];
	}
	
	public int createEntity(int flag) {
		for (int i = 0; i < size; i++) {
			// looking for an empty spot
			if (this.flag[i] == 0) {
				this.flag[i] = flag;
				if ((flag & Component.POS) > 0) pos[i] = new Component.Position();
				if ((flag & Component.VEL) > 0) vel[i] = new Component.Velocity();
				if ((flag & Component.RENDER) > 0) rendering[i] = new Component.Rendering();
				return i;
			}
		}
		return -1;
	}

}
