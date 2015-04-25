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
public class StinkTreeQuest extends Quest {
    
  public StinkTreeQuest(AppStateManager stateManager, Node holder) { 
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
      speech = "An oak tree full of acorns";  
      }
    
    else if (stinkQuest.step.equals("FindStink")) {
      speech = "This isn't the source of the stink";  
      }

    else if (stinkQuest.step.equals("FindShovel")) {
      speech = "This isn't going to help you find mushrooms.... Is it?";  
      }

    else if (stinkQuest.step.equals("FindShrooms")) {
      speech = "These aren't mushrooms...";  
      }

    else if (stinkQuest.step.equals("FindAxe")) {
      speech = "You see acorns high up the tree... You'll likely need an axe.";  
      }

    else if (stinkQuest.step.equals("FindAcorns")) {
      speech = "You chop down the tree, and find many acorns.";
      stinkQuest.step = "HasAcorns";
      holder.removeFromParent();
      }
    
    else {
      speech = "Looks like an oak tree full of acorns.";
      }
    
    gui.showAlert(holder.getName(), speech);
      
    }
    
  }

