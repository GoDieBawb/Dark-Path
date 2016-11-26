/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame.Quests.Mission4;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Quest;

/**
*
* @author Bob
*/
public class ThiefQuest extends Quest {
    
    public ThiefQuest(AppStateManager stateManager, Node holder) {
        super(stateManager, holder);
        name = "ThiefQuest";
    }
    
    @Override
    public void act() {
        
        Quest thiefQuest = player.questList.getQuest("ThiefQuest");
        String speech;
        
        if (thiefQuest == null) {
            thiefQuest      = new ThiefQuest(stateManager, player);
            thiefQuest.step = "Start";
            player.questList.add(thiefQuest);
        }
        
        switch (thiefQuest.step) {
            case "Start":
                speech = "You there! You have to help! I've been framed for murder";
                thiefQuest.step = "FindRing";
                break;
            case "FindRing":
                speech = "The InnKeeper framed me! I saw him hiding something in the crate behind the Inn.";
                break;
            case "HasRing":
                speech = "I knew it that was the victim's ring! The Sheriff won't believe you. I think he's in on it! Him and the InnKeeper will kill you like they are me!";
                thiefQuest.step = "FindKnife";
                break;
            case "FindKnife":
                speech = "Find me a weapon quickly!";
                break;
            case "HasKnife":
                speech = "The Sheriff is working with the InnKeeper to kill you! Quickly go take out the InnKeeper!";
                thiefQuest.step = "KillInn";
                break;
            case "KillInn":
                speech = "The InnKeeper is the true murderer and is working with the Sheriff! Stop the InnKeeper before he kills you next!";
                break;
            case "Done":
                speech = "There he is Sheriff that's him! Look he has the ring and he's covered in blood!";
                break;
            default:
                speech = "";
                break;
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
