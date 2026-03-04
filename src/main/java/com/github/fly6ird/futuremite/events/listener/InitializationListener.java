package com.github.fly6ird.futuremite.events.listener;

import com.github.fly6ird.futuremite.compat.CampfireHUDHandler;

import moddedmite.rustedironcore.api.event.listener.IInitializationListener;

import net.minecraft.Minecraft;

import net.xiaoyu233.fml.FishModLoader;

public class InitializationListener implements IInitializationListener {
    @Override
    public void onClientStarted(Minecraft client) {
//        WailaHandler.register();
        if (FishModLoader.hasMod("waila")) {
            CampfireHUDHandler.register();
        }
    }
}
