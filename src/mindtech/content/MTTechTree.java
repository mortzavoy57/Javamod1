package mindtech.content;

import arc.Core;
import arc.Events;
import arc.struct.ObjectMap;
import arc.struct.ObjectSet;
import arc.struct.Seq;
import mindustry.Vars;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.content.TechTree;
import mindustry.content.TechTree.TechNode;
import mindustry.content.UnitTypes;
import mindustry.ctype.UnlockableContent;
import mindustry.game.EventType;
import mindustry.game.Objectives.Objective;
import mindustry.game.Objectives.SectorComplete;
import mindustry.type.ItemStack;
import mindustry.type.SectorPreset;
import mindustry.type.StatusEffect;
import mindustry.type.UnitType;
import mindustry.world.Block;
import mindtech.content.MTBlocks;

import static mindustry.content.TechTree.*;

public class MTTechTree {
    public static void load() {
        addSerpuloTechTree();
    }

    private static void addSerpuloTechTree() {
        addTechNode(Blocks.kiln, MTBlocks.ironSmelter);
        addTechNode(MTBlocks.ironSmelter, MTBlocks.steelSmelter);
        addTechNode(Blocks.phaseWeaver, MTBlocks.vibraniumSmelter);
        addTechNode(Blocks.impactReactor, MTBlocks.thermoNuclearReactor);
    }

    private static void addTechNode(UnlockableContent parentContent, UnlockableContent childContent) {
        TechTree.TechNode parent = all.find(node -> node.content == parentContent);
        if (parent == null || parent.children.contains(node -> node.content == childContent)) return;

        new TechNode(parent, childContent, childContent.researchRequirements());
    }
}

