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
public class PoisonDoorQuest extends Quest {
    
    public PoisonDoorQuest(AppStateManager stateManager, Node holder){
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
                speech = "You've come a long way to get this job... You don't want to turn back now.";
                break;
            case "GetWeapon":
                speech = "You're being considered for the job... How can you leave now?";
                break;
            default:
                speech = "The door has been locked... There's no turning back now";
                break;
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
