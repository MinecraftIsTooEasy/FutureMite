package com.github.fly6ird.futuremite.events.listener;


import com.github.fly6ird.futuremite.world.structure.OceanMonument;

public class PropertyRegistry implements Runnable {
    @Override
    public void run() {
        OceanMonument.makeMap();
    }
}
