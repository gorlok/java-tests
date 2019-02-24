package com.example.ecs;

public class Engine {
	
	int MAX_ENTITIES = 5;
	
    EntityManager manager;
    
    ISystem[] systems = {
    		new Systems.Render(),
    		new Systems.Velocity()
    };

    Engine() {
        manager = new EntityManager(MAX_ENTITIES);
        
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
    	for (ISystem system: this.systems)
    		system.update(manager);
    }	

}
