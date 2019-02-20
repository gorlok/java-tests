package com.example.ecs;

public class Engine {
	
    EntityManager manager;
    Systems.Render renderingSystem;
    Systems.Velocity velocitySystem;	

    Engine() {
        manager = new EntityManager(5);
        renderingSystem = new Systems.Render();
        velocitySystem = new Systems.Velocity();

        int id = manager.createEntity(Component.POS | Component.VEL | Component.RENDER);
        if (id > -1) {
            manager.pos[id].x = 10;
            manager.pos[id].y = 10;
            manager.vel[id].velx = 1;
            manager.vel[id].vely = 1;
            manager.rendering[id].name = "player";
        }

        id = manager.createEntity(Component.POS | Component.RENDER);
        if (id > -1) {
            manager.pos[id].x = 0;
            manager.pos[id].y = 0;
            manager.rendering[id].name = "tree";
        }
        startGameLoop();
    }

    void startGameLoop() {
        while(true) {
            velocitySystem.update(manager);
            renderingSystem.update(manager);
        }
    }	

}
