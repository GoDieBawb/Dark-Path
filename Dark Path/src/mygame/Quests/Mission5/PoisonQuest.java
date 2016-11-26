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
public class PoisonQuest extends Quest {
    
    public PoisonQuest(AppStateManager stateManager, Node holder){
        super(stateManager, holder);
        name = "PoisonQuest";
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
                speech = "So... You're here for the job. Good! The Butler will explain your first assignment.";
                poisonQuest.step = "GetWeapon";
                break;
            case "GetWeapon":
                speech = "Please... Like I said, the Butler has your first assignment. Now go quickly.";
                break;
            case "KillPrisoner":
                speech = "Are you... confused about your assignment?";
                break;
            case "KilledPrisoner":
                speech = "Aha! So you've done it, very good! Now I have another person needing... Taking care of. See the chef.";
                poisonQuest.step = "SeeChef";
                break;
            case "SeeChef":
                speech = "The Butler... has to go. I plan to poison him tonight... Well to have you poison him. The Chef has the details.";
                break;
            case "SeeButler":
                speech = "I hope you don't tell anyone who doesn't need to know about our little plan... For your own safety.";
                break;
            case "Poison":
                speech = "The moment of truth has almost arrived.... Has it not?";
                break;
            case "Done":
                speech = "Well... I guess he'll make a tasty prisoner.";
                super.finish();
                gui.delayAlert("Death", "You are immediately seized and thrown into the dungeon... Knowing full well you await the same fate as the prisoner before you.", 2);
                holder.removeFromParent();
                break;
            default:
                speech = "";
                break;
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
