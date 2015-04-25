/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission5;

import com.jme3.app.state.AppStateManager;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import mygame.Npc;
import mygame.NpcManager;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class PoisonTableQuest extends Quest {
    
  public PoisonTableQuest(AppStateManager stateManager, Node holder){
    super(stateManager, holder);
    }
  
  @Override
  public void act(){
      
    Quest poisonQuest = player.questList.getQuest("PoisonQuest");
    String speech;
    
    if (poisonQuest == null) {
      poisonQuest =  new PoisonQuest(stateManager, player);
      poisonQuest.step = "Start";
      player.questList.add(poisonQuest);
      }
    
    if (poisonQuest.step.equals("Start")) {
      speech = "Looks like the Master of the Manor's Table.";
      }

    else if (poisonQuest.step.equals("GetWeapon")) {
      speech = "A fancy eating area for fancy people.";  
      }

    else if (poisonQuest.step.equals("KillPrisoner")) {
      speech = "A lunatic must eat here...";  
      }

    else if (poisonQuest.step.equals("KilledPrisoner")) {
      speech = "Wonder if the prisoner is on the menu...";  
      }
    
    else if (poisonQuest.step.equals("SeeChef")) {
      speech = "A table... Fit for a madman";  
      }
    
    else if (poisonQuest.step.equals("SeeButler")) {
      speech = "Another murder... Why did you come here?";  
      }

    else if (poisonQuest.step.equals("Poison")) {
      speech = "You place the poison into the kings food";  
      poisonQuest.step = "Done";
      Node npcNode = stateManager.getState(NpcManager.class).npcNode;
      ((Npc) npcNode.getChild("Master")).phys.warp(new Vector3f(-16, 0, -8));
      ((Npc) npcNode.getChild("Cook")).phys.warp(new Vector3f(-16, 0, -7));
      ((Npc) npcNode.getChild("Butler")).phys.warp(new Vector3f(-16, 0, -9));
      }

    else if (poisonQuest.step.equals("Done")) {
      speech = "You're going to die...";  
      }
    
    else {
      speech = "";
      }
    
    gui.showAlert(holder.getName(), speech);
      
    }
    
  }
