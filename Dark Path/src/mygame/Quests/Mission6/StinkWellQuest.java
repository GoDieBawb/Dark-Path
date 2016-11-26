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
public class StinkWellQuest extends Quest {
    
    public StinkWellQuest(AppStateManager stateManager, Node holder) {
        super(stateManager, holder);
        name = "StinkQuest";
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
                speech = "This well looks like it hasn't been used in years...";
                break;
            case "FindStink":
                speech = "As you approach the well the stench is overwhelming... Like dead bodies and Indian food left in a diaper.";
                stinkQuest.step = "ReportStink";
                break;
            case "ReportStink":
                speech = "You should report that the well is the source to Paul.";
                break;
            case "CleanWell":
                speech = "As you pour the ingredients down the well, you see... bones. Just as you realize this, you are seized from behind and thrown down the well...";
                super.finish();
                break;
            default:
                speech = "This well smells like death... You cannot even approach very closely";
                break;
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
