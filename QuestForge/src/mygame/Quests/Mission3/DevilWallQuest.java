/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission3;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Quest;
import mygame.SceneManager;

/**
 *
 * @author Bob
 */
public class DevilWallQuest extends Quest {
  
  public DevilWallQuest(AppStateManager stateManager, Node holder) {
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
    
    if (devilQuest.step.equals("Start")) {
      speech = "This seems to be a very strange wall";
      }
    
    else if (devilQuest.step.equals("FindWall")) {
      speech = "The wall falls away as you press one of the bricks";
      holder.removeFromParent();
      stateManager.getState(SceneManager.class).addPhys();
      devilQuest.step = "FindDoor";
      }
    
    else if (devilQuest.step.equals("FindDoor")) {
      speech = "";  
      }

    else if (devilQuest.step.equals("FatherTalk")) {
      speech = "";  
      }

    else if (devilQuest.step.equals("FindAxe")) {
      speech = "";  
      }

    else if (devilQuest.step.equals("ChopDoor")) {
      speech = "";  
      }

    else if (devilQuest.step.equals("Done")) {
      speech = "";  
      }
    
    else {
      speech = "";
      }
    
    gui.showAlert(holder.getName(), speech);      
      
    }
  
  }
