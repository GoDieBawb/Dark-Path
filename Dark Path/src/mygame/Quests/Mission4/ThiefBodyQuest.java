/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame.Quests.Mission4;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Interactable;
import mygame.Quest;

/**
*
* @author Bob
*/
public class ThiefBodyQuest extends Quest {
    
    public ThiefBodyQuest(AppStateManager stateManager, Node holder) {
        super(stateManager, holder);
    }
    
    @Override
    public void act(){
        
        Quest thiefQuest = player.questList.getQuest("ThiefQuest");
        String speech;
        
        if (thiefQuest == null) {
            thiefQuest      = new ThiefQuest(stateManager, player);
            thiefQuest.step = "Start";
            player.questList.add(thiefQuest);
        }
        
        switch (thiefQuest.step) {
            case "Start":
                speech = "A dead body lying on the floor";
                break;
            case "FindRing":
                speech = "This person was killed recently.";
                break;
            case "HasRing":
                speech = "Killed for a ring... How senseless";
                break;
            case "FindKnife":
                speech = "You take the knife from the dead body";
                ((Interactable) holder).model.getChild(1).removeFromParent();
                thiefQuest.step = "HasKnife";
                break;
            case "HasKnife":
                speech = "You know what you have to do now!";
                break;
            case "KillInn":
                speech = "You must avenge the death of this victim!";
                break;
            case "Done":
                speech = "The victim has been avenged";
                break;
            default:
                speech = "";
                break;
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
