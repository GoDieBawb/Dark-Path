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
public class StinkTreeQuest extends Quest {
    
    public StinkTreeQuest(AppStateManager stateManager, Node holder) {
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
                speech = "An oak tree full of acorns";
                break;
            case "FindStink":
                speech = "This isn't the source of the stink";
                break;
            case "FindShovel":
                speech = "This isn't going to help you find mushrooms.... Is it?";
                break;
            case "FindShrooms":
                speech = "These aren't mushrooms...";
                break;
            case "FindAxe":
                speech = "You see acorns high up the tree... You'll likely need an axe.";
                break;
            case "FindAcorns":
                speech = "You chop down the tree, and find many acorns.";
                stinkQuest.step = "HasAcorns";
                holder.removeFromParent();
                break;
            default:
                speech = "Looks like an oak tree full of acorns.";
                break;
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}

