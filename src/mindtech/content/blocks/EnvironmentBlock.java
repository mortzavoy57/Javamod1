package mindtech.content.blocks;

import arc.func.Prov;
import arc.util.Log;
import mindustry.content.Blocks;
import mindustry.content.StatusEffects;
import mindustry.gen.Building;
import mindustry.graphics.CacheLayer;
import mindustry.graphics.MultiPacker;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.blocks.environment.*;
import mindtech.content.MTItems;

public class EnvironmentBlock {
    public static Block
            oreIron;

    public static void load() {
        oreIron = new OreBlock("ore-iron", MTItems.ironraw) {{
            oreDefault = true;
            oreThreshold = 0.81f;
            oreScale = 23.47619f;
        }};
    }
}

