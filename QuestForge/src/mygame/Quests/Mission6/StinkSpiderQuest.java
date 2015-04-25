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
public class StinkSpiderQuest extends Quest {
    
  public StinkSpiderQuest(AppStateManager stateManager, Node holder) { 
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
      speech = "You approach the Spider too closely and it immediately eats your face off. Idiot";  
      super.fail();
      }

    else if (stinkQuest.step.equals("KillSpider")) {
      speech = "You approach the spider with the axe and swing it chopping the spider in two... You gather some spider guts.";
      holder.removeFromParent();
      stinkQuest.step = "KilledSpider";
      }
    
    else {
      speech = "As you approach the spider it immediately eats your face off.... Idiot";
      super.fail();
      }
    
    gui.showAlert(holder.getName(), speech);
      
    }
    
  }

