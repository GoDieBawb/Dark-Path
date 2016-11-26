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
public class PoisonCookQuest extends Quest {
    
    public PoisonCookQuest(AppStateManager stateManager, Node holder){
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
                speech = "You'll be wanting to see the Master. It's wise not to keep him waiting.";
                break;
            case "GetWeapon":
                speech = "Do as the Master says.... Always.";
                break;
            case "KillPrisoner":
                speech = "Whatever the Master asks.... Do it";
                break;
            case "KilledPrisoner":
                speech = "The Master wishes to speak with you.";
                break;
            case "SeeChef":
                speech = "The Master wishes to poison the Butler... But I will not. We are conspiring to kill the Master.";
                poisonQuest.step = "SeeButler";
                break;
            case "SeeButler":
                speech = "Go see the Butler... We have a plan to betray the Master. He's mad!";
                break;
            case "Poison":
                speech = "Go plant the Poison as instructed by the Butler, and the Master's wealth will be ours!";
                break;
            case "Done":
                speech = "I told you he was no good! I did good Master!";
                holder.removeFromParent();
                break;
            default:
                speech = "";
                break;
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
