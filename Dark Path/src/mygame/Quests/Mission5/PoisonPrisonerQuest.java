/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame.Quests.Mission5;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Quest;

/**
*
* @author Bob
*/
public class PoisonPrisonerQuest extends Quest {
    
    public PoisonPrisonerQuest(AppStateManager stateManager, Node holder){
        super(stateManager, holder);
    }
    
    @Override
    public void act(){
        
        Quest poisonQuest = player.questList.getQuest("PoisonQuest");
        String speech;
        
        if (poisonQuest == null) {
            poisonQuest =  new PoisonQuest(stateManager, player);
            poisonQuest.step = "Start";
            player.questList.add(poisonQuest);
        }
        
        switch (poisonQuest.step) {
            case "Start":
                speech = "If you're wise... You'd leave now";
                break;
            case "GetWeapon":
                speech = "It's too late... Too late for either of us friend.";
                break;
            case "KillPrisoner":
                speech = "Please... I have a family";
                gui.delayAlert("Execution", "You raise the piston through the bars and fire a single shot. The prisoner lies dead on the floor", 2);
                holder.removeFromParent();
                poisonQuest.step = "KilledPrisoner";
                break;
            default:
                speech = "";
                break;
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
