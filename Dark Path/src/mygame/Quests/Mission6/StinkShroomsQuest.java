/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame.Quests.Mission6;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Quest;

/**
*
* @author Bob
*/
public class StinkShroomsQuest extends Quest {
    
    public StinkShroomsQuest(AppStateManager stateManager, Node holder) {
        super(stateManager, holder);
    }
    
    @Override
    public void act() {
        
        Quest stinkQuest =  player.questList.getQuest("StinkQuest");
        String speech;
        
        if (stinkQuest ==  null) {
            stinkQuest = new StinkWellQuest(stateManager, player);
            stinkQuest.step  = "Start";
            player.questList.add(stinkQuest);
        }
        
        switch (stinkQuest.step) {
            case "Start":
                speech = "Some poisonous looking Mushrooms";
                break;
            case "FindShovel":
                speech = "You probably need to find a shovel to dig these up.";
                break;
            case "FindShrooms":
                speech = "Using the shovel you carefully dig up the Shrooms. Back in the you'd get some friends and... Well never mind";
                stinkQuest.step = "HasShrooms";
                holder.removeFromParent();
                break;
            default:
                speech = "Some poisonous looking mushrooms...";
                break;
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}

