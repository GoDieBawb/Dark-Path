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
public class StinkPeterQuest extends Quest {
    
    public StinkPeterQuest(AppStateManager stateManager, Node holder) {
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
                speech = "Hmm... Do you smell that? It smells like death, perhaps you can help...";
                stinkQuest.step = "FindStink";
                break;
            case "FindStink":
                speech = "Find source of the smell of death... It's been haunting us for years, but you may be able to... help.";
                break;
            case "ReportStink":
                speech = "So... The well demands cleansing. Go see Paul, only he knows the items necessary.";
                stinkQuest.step = "FindPaul";
                break;
            case "FindPaul":
                speech = "Go find Paul... He can help us.... cleanse the well.";
                break;
            case "CleanWell":
                speech = "Perfect... The cleansing can begin...";
                break;
            default:
                speech = "Whatever Paul needs... He needs.";
                break;
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}

