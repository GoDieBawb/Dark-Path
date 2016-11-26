/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame.Quests.Mission6;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Interactable;
import mygame.Quest;

/**
*
* @author Bob
*/
public class StinkAxeQuest extends Quest {
    
    public StinkAxeQuest(AppStateManager stateManager, Node holder) {
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
                speech = "You shouldn't take other people's things....";
                break;
            case "FindStink":
                speech = "This isn't the source of the smell..";
                break;
            case "FindAxe":
                speech = "You take the axe.";
                stinkQuest.step = "FindAcorns";
                ((Interactable) holder).model.getChild(0).removeFromParent();
                break;
            default:
                speech = "A chopping block...";
                break;
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}

