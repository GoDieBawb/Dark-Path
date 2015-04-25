/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission3;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Interactable;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class DevilTableQuest extends Quest {
  
  public DevilTableQuest(AppStateManager stateManager, Node holder) {
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
      speech = "You shouldn't go messing with people's stuff.";
      }
    
    else if (devilQuest.step.equals("FindWall")) {
      speech = "Brother Jerome eyes you suspiciously";  
      }
    
    else if (devilQuest.step.equals("FindDoor")) {
      speech = "Brother Jerome eyes you suspiciously";  
      }

    else if (devilQuest.step.equals("FatherTalk")) {
      speech = "You should talk to Father John before doing anything crazy.";  
      }

    else if (devilQuest.step.equals("FindAxe")) {
      speech = "You take the axe from the table...";
      devilQuest.step = "ChopDoor";
      ((Interactable) holder).model.getChild(1).removeFromParent();
      }

    else if (devilQuest.step.equals("ChopDoor")) {
      speech = "An empty table...";  
      }

    else if (devilQuest.step.equals("Done")) {
      speech = "You should never have grabbed the axe...";  
      }
    
    else {
      speech = "";
      }
    
    gui.showAlert(holder.getName(), speech);      
      
    }
  
  }
