package mindtech.content;

import arc.graphics.Color;
import mindustry.type.Item;

public class MTItems {

    public static Item
            ironraw, iron, steel, vibranium;

    public static void load() {
        ironraw = new Item("iron-raw", Color.valueOf("808080")) {{
            hardness = 1;
            cost = 0.5f;
        }};

        iron = new Item("iron", Color.valueOf("A5A5A5")) {{
            hardness = 1;
        }};

        steel = new Item("steel", Color.valueOf("C1C3CC")) {{
            hardness = 3;
        }};

        vibranium = new Item("vibranium", Color.valueOf("8993BF")) {{
            hardness = 5;
        }};
    }
}