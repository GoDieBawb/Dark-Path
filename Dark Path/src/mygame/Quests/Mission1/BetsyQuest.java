/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission1;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class BetsyQuest extends Quest {
    
  public BetsyQuest(AppStateManager stateManager, Node holder) {
      
    super(stateManager, holder);
    name = "BillyQuest";
  }
    
  @Override
  public void act() {
    
    Quest billyQuest = player.questList.getQuest("BillyQuest");
    
    if (billyQuest == null) {
      billyQuest = new BillyQuest(stateManager, player);
      player.questList.add(billyQuest);
      billyQuest.step = "Start";
      }
    
    String speech;
    
    if (billyQuest.step.equals("Start")) {
      speech = "Hello there... My name is Betsy. Welcome to my house";  
      }
    
    else if (billyQuest.step.equals("GetWood")) {
      speech = "Be careful of Clark.... He's a strange person. But when he asks you to do something... Do it.";    
      }
    
    else if (billyQuest.step.equals("HasWood")) {
      speech = "I would take that wood to Mr Clark quickly.... It's for your safety";
      }
    
    else if (billyQuest.step.equals("GetBilly")) {
      speech = "Whatever Clark asks.... Do it, for your own safety";    
      }
    
    else if (billyQuest.step.equals("HasBilly")) {
      speech = "Why isn't Billy playing outside? He should be out in the woods";    
      }
    
    else if (billyQuest.step.equals("GaveBilly")) {
      speech = "Clark.... Wanted Billy for dinner? Go stop him! Go get my Billy back";
      holder.getParent().getChild("Little Billy").removeFromParent();
      billyQuest.step = "KillClark";
      }

    else if (billyQuest.step.equals("KillClark")) {
      speech = "Go and stop Clark from killing my Little Billy!";    
      }
    
    else if (billyQuest.step.equals("Done")) {
      speech = "Betsy overcome with her son's death has committed suicide... The guilt of the deed you've committed is so overwhelming, you do the same.";
      super.finish();
      }
    
    else {
      speech = "Betsy has committed suicide. The guilt overwhelms you... and you d the same";  
      super.finish();
      }
    
    gui.showAlert(holder.getName(), speech);
      
    }
  
  }
