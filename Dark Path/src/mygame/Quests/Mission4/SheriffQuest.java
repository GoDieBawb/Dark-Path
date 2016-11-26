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
public class SheriffQuest extends Quest {
    
    public SheriffQuest(AppStateManager stateManager, Node holder) {
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
        
        if (thiefQuest.step.equals("Start")) {
            speech = "We're about to have a hanging... There's been a murder in town";
        }
        
        else if (thiefQuest.step.equals("FindRing")) {
            speech = "I don't care what that thief says... We know it was him.";
        }
        
        else if (thiefQuest.step.equals("FindRing")) {
            speech = "I don't care what that thief says... We know it was him.";
        }
        
        else if (thiefQuest.step.equals("HasRing")) {
            speech = "I don't care what that thief says... We know it was him.";
        }
        
        else if (thiefQuest.step.equals("FindKnife")) {
            speech = "I don't care what that thief says... We know it was him.";
        }
        
        else if (thiefQuest.step.equals("HasKnife")) {
            speech = "I don't care what that thief says... We know it was him.";
        }
        
        else if (thiefQuest.step.equals("Done")) {
            speech = "So.... It was you all along!";
            gui.delayAlert("Death", "As you approach the thief points you out as the murderer. The Sheriff finding the knife and ring hangs you immediately.", 1);
            holder.removeFromParent();
            super.finish();
        }
        
        else {
            speech = "I don't care what that thief says... We know it was him.";
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
