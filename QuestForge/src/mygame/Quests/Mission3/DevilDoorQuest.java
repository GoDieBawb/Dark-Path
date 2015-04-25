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
public class DevilDoorQuest extends Quest {
  
  public DevilDoorQuest(AppStateManager stateManager, Node holder) {
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
      speech = "A dark force resides inside";
      }
    
    else if (devilQuest.step.equals("FindWall")) {
      speech = "A dark force eminates from within...";  
      }
    
    else if (devilQuest.step.equals("FindDoor")) {
      speech = "You hear a voice coming from the inside...";  
      }

    else if (devilQuest.step.equals("FatherTalk")) {
      speech = "The door is securely locked";  
      }

    else if (devilQuest.step.equals("FindAxe")) {
      speech = "The door is blocked by planks... If only you had something to remove this.";  
      }

    else if (devilQuest.step.equals("ChopDoor")) {
      speech = "You chop the planks away from the door and it immediately flies open...";
      holder.removeFromParent();
      stateManager.getState(SceneManager.class).addPhys();
      devilQuest.step = "Done";
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
