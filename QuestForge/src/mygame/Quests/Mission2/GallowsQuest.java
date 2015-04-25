/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission2;

import mygame.Quests.Mission2.FloraQuest;
import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class GallowsQuest extends Quest {
  
  public GallowsQuest(AppStateManager stateManager, Node holder) {
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
    
    if (floraQuest.step.equals("Hang")) {
      speech = "Realizing what you must do... You slowly climb the gallows, place the rope around your neck and...";
      ((FloraQuest) floraQuest).finish();
      super.finish();
      }
    
    else {
      speech = "This isn't a place you want to end up.";
      }
    
    gui.showAlert(holder.getName(), speech);  
    }
  
  }
