/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission1;

import com.jme3.app.state.AppStateManager;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import mygame.Npc;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class BillyQuest extends Quest {
    
  public BillyQuest(AppStateManager stateManager, Node holder) {
    super(stateManager, holder);
    name = "BillyQuest";
    }
  
  public void billyChecker(Node npcNode) {
      
    Npc billy = (Npc) holder;
    if (player.questList.getQuest("BillyQuest") != null)
    if (player.questList.getQuest("BillyQuest").step.equals("HasBilly")) {
        float distance     = billy.model.getWorldTranslation().distance(player.model.getWorldTranslation());
        Vector3f playerDir = player.model.getWorldTranslation().subtract(billy.model.getWorldTranslation());
        
        if (distance > 10){
          billy.phys.warp(player.getWorldTranslation().add(0, 3, 0));
          }
      
        else if (distance > 1) {
          billy.phys.setWalkDirection(playerDir);  
          billy.run();  
          }
      
        else {
          billy.phys.setWalkDirection(new Vector3f(0,0,0));
          billy.idle();
          }
        
        }
    
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
      speech = "Crazy Old Clark can sure be a scary guy...";  
      }
    
    else if (billyQuest.step.equals("GetWood")) {
      speech = "Clark wants you to get wood? Usually he doesn't like it when people don't listen";    
      }

    else if (billyQuest.step.equals("HasWood")) {
      speech = "You better bring that wood to Clark... For your own safety";
      }
    
    else if (billyQuest.step.equals("GetBilly")) {
      speech = "I have to go home for dinner? Okay! Let's go.";
      billyQuest.step = "HasBilly";
      }
    
    else if (billyQuest.step.equals("HasBilly")) {
      speech = "Oh boy I wonder what's for Dinner!";    
      }
    
    else if (billyQuest.step.equals("GaveBilly")) {
      speech = "Billy seems to scared to move.";    
      }

    else if (billyQuest.step.equals("KillClark")) {
      speech = "Billy's gone...";    
      }
    
    else if (billyQuest.step.equals("Done")) {
      speech = "Billy's gone...";    
      }
    
    else {
      speech = "Billy's gone...";  
      }
    
    gui.showAlert(holder.getName(), speech);
      
    }
  
  }
