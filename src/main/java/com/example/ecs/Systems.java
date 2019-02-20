package com.example.ecs;

public class Systems {
	
    public static class Velocity {
        public void update(EntityManager manager) {
            int required_components = Component.POS | Component.VEL;
            for (int i = 0; i < manager.size; i++) {
                if ((manager.flag[i] & required_components) == required_components){
                    manager.pos[i].x += manager.vel[i].velx;
                    manager.pos[i].y += manager.vel[i].vely;
                }
            }
        }
    }

    public static class Render {
        public void update(EntityManager manager) {
            int required_components = Component.POS | Component.RENDER;
            for (int i = 0; i < manager.size; i++) {
                if ((manager.flag[i] & required_components) == required_components) {
                    System.out.println(String.format("%s: (%f x, %f y)", manager.rendering[i].name, manager.pos[i].y, manager.pos[i].y));
                }
            }
        }
    }

}
