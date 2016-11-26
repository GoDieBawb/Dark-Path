/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame.Quests.Mission2;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Interactable;
import mygame.Quest;

/**
*
* @author Bob
*/
public class GraveQuest extends Quest {
    
    public GraveQuest(AppStateManager stateManager, Node holder) {
        super(stateManager, holder);
    }
    
    @Override
    public void act() {
        
        Quest floraQuest = player.questList.getQuest("FloraQuest");
        String speech;
        
        if (floraQuest == null) {
            floraQuest      = new FloraQuest(stateManager, player);
            floraQuest.step = "Start";
            player.questList.add(floraQuest);
        }
        
        switch (floraQuest.step) {
            case "FindShovel":
                if (player.inventory.contains("Shovel")) {
                    
                    if (((Interactable) holder).model.getUserData("special") != null) {
                        speech = "You dig up the body... Right there on the fingers you retrieve the ring.";
                        ((Interactable) this.holder).contactMessage = "It seems the ring was in this grave... Strange";
                        floraQuest.step = "HasRing";
                    }
                    
                    else {
                        speech = "There doesn't seem to be anything special in this grave...";
                    }
                    
                }
                
                else {
                    speech = "You'll need a shovel to search the graves";
                }   
                
                break;
            case "Done":
                speech = "Here lies a worthless grave robber... The date is 10 years ago... Today";
                ((Interactable) this.holder).contactMessage = ("The Grave Message Changes Before your eyes...");
                floraQuest.step = "Hang";
                break;
            case "Hang":
                speech = "The grave now reads.... Your name, and the date is today.";
                ((Interactable) this.holder).contactMessage = "Your own grave sits before you.";
                break;
            default:
                speech = "Looks like a grave of a long dead individual.";
                break;
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
