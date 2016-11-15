/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission3;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class StormDoorQuest extends Quest {
  
  public StormDoorQuest(AppStateManager stateManager, Node holder) {
    super(stateManager, holder);
    }
    
  @Override
  public void act() {
    
    String speech;
    Quest devilQuest = player.questList.getQuest("DevilQuest");
    
    if (devilQuest == null) {
      
      devilQuest      = new DevilQuest(stateManager, player);
      devilQuest.step = "Start";
      player.questList.add(devilQuest);
        
      }
    
    if (devilQuest.step.equals("Done")) {
      speech = "As you walk out from the safety of the interior into the storm... You know you will die, but you just don't care.";  
      super.finish();
      }
    
    else {
      speech = "The storm still rages outside";
      }
    
    gui.showAlert(holder.getName(), speech);      
      
    }
  
  }
