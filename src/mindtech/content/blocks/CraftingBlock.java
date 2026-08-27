package mindtech.content.blocks;

import arc.Core;
import arc.graphics.Blending;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.graphics.g2d.TextureRegion;
import arc.math.Angles;
import arc.math.Interp;
import arc.math.Mathf;
import arc.math.Rand;
import arc.util.Time;
import arc.util.Tmp;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.Effect;
import mindustry.entities.effect.MultiEffect;
import mindustry.gen.Building;
import mindustry.gen.Sounds;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.draw.*;
import mindustry.world.meta.BuildVisibility;
import mindtech.content.MTItems;

import static arc.graphics.g2d.Draw.alpha;
import static arc.graphics.g2d.Draw.color;
import static arc.math.Angles.randLenVectors;
import static mindustry.Vars.tilesize;
import static mindustry.type.ItemStack.with;

public class CraftingBlock {
    public static Block
        ironSmelter, steelSmelter;

    public static void load() {
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

