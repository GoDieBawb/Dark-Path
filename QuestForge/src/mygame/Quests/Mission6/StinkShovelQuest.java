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
public class StinkShovelQuest extends Quest {
    
  public StinkShovelQuest(AppStateManager stateManager, Node holder) { 
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
    
    if (stinkQuest.step.equals("Start")) {
      speech = "Someone else's shovel... Don't take that.";  
      }
    
    else if (stinkQuest.step.equals("FindStink")) {
      speech = "The shovel is quite dirty but not the source of the stink.";  
      }

    else if (stinkQuest.step.equals("FindPaul")) {
      speech = "This isn't Paul... Either that or Peter is crazy";  
      }

    else if (stinkQuest.step.equals("FindShovel")) {
      speech = "You pick up the shovel";
      stinkQuest.step = "FindShrooms";
      holder.removeFromParent();
      }
    else {
      speech = "Don't take other people's things.";
      }
    
    gui.showAlert(holder.getName(), speech);
      
    }
    
  }

