/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission6;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Interactable;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class StinkAxeQuest extends Quest {
    
  public StinkAxeQuest(AppStateManager stateManager, Node holder) { 
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
      speech = "You shouldn't take other people's things....";  
      }
    
    else if (stinkQuest.step.equals("FindStink")) {
      speech = "This isn't the source of the smell..";  
      }

    else if (stinkQuest.step.equals("FindAxe")) {
      speech = "You take the axe.";
      stinkQuest.step = "FindAcorns";
      ((Interactable) holder).model.getChild(0).removeFromParent();
      }
    
    else {
      speech = "A chopping block...";
      }
    
    gui.showAlert(holder.getName(), speech);
      
    }
    
  }

