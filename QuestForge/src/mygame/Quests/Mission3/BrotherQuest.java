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
public class BrotherQuest extends Quest {
  
  public BrotherQuest(AppStateManager stateManager, Node holder) {
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
      speech = "Speak to Father John... We do not normally welcome guests at the Hermitage";
      }
    
    else if (devilQuest.step.equals("FindWall")) {
      speech = "You are to leave as soon as the storm passes...";  
      }
    
    else if (devilQuest.step.equals("FindDoor")) {
      speech = "There are no secret places here... Don't go looking for any";  
      }

    else if (devilQuest.step.equals("FatherTalk")) {
      speech = "The Father would like to speak with you about what you've seen.";  
      }

    else if (devilQuest.step.equals("FindAxe")) {
      speech = "Do not go near that door again!";  
      }

    else if (devilQuest.step.equals("ChopDoor")) {
      speech = "Put the axe down for God's sake!";  
      }

    else if (devilQuest.step.equals("Done")) {
      speech = "May God have mercy on your soul for the act you've committed here.";  
      }
    
    else {
      speech = "";
      }
    
    gui.showAlert(holder.getName(), speech);      
      
    }
  
  }
