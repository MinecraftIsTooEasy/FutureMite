package com.github.fly6ird.futuremite.events;

import com.github.fly6ird.futuremite.events.listener.*;
import moddedmite.rustedironcore.api.event.Handlers;

public class FutureMITEEventRIC extends Handlers {
    public static void register() {
        EntityTracker.register(new EntityTrackerRegistry());
        LootTable.register(new LootTableRegistry());
        Barbecue.register(new BarbecueListener());
        TileEntityData.register(new TileEntityDataTypeRegistry());
        BiomeGenerate.register(new BiomeGenerateListener());
        PropertiesRegistry.register(new PropertyRegistry());
        Initialization.register(new InitializationListener());
    }
}
