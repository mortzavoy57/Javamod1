package mindtech.content;

import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.production.GenericCrafter;
import mindtech.content.MTItems;
import mindustry.world.blocks.environment.*;

import static mindustry.type.ItemStack.with;

public class MTBlocks {
    public static Block
            /**oreBlocks*/
            oreIron,
            /**crafting*/
            ironSmelter, steelSmelter;

    public static void load() {
        /**oreBlocks*/
        oreIron = new OreBlock("ore-iron", MTItems.ironraw) {{
            oreDefault = true;
            oreThreshold = 0.81f;
            oreScale = 23.47619f;
        }};

        /**crafting*/
        ironSmelter = new GenericCrafter("iron-smelter") {{
            requirements(Category.crafting, with(
                    Items.lead, 55,
                    Items.graphite, 30,
                    Items.titanium, 20
            ));

            size = 2;
            health = 190;
            craftTime = 60f;
            hasPower = true;
            hasLiquids = false;

            consumePower(1.5f);
            consumeItem(MTItems.ironraw, 3);
            outputItems = with(MTItems.iron, 2);

            craftEffect = Fx.pulverizeMedium;
            updateEffect = Fx.smeltsmoke;
        }};

        steelSmelter = new GenericCrafter("steel-smelter") {{
            requirements(Category.crafting, with(
                    Items.lead, 70,
                    Items.graphite, 50,
                    Items.titanium, 40
            ));

            size = 2;
            health = 300;
            craftTime = 90;
            hasPower = true;
            hasLiquids = false;

            consumePower(2f);
            consumeItems(with(MTItems.iron, 2, Items.coal, 1));
            outputItems = with(MTItems.steel, 2);

            craftEffect = Fx.pulverizeMedium;
            updateEffect = Fx.smeltsmoke;
        }};
    }
}

