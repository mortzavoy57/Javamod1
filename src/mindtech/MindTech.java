package mindtech;

import arc.*;
import arc.util.*;
import mindtech.content.MTItems;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

public class MindTech extends Mod{

    public MindTech(){
        Log.info("Loaded MindTech constructor.");
    }

    public void loadContent(){
        MTItems.load();

        Log.info("MindTech Loaded Complete.");
    }

}
