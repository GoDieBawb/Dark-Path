/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission1;

import com.jme3.app.state.AppStateManager;
import com.jme3.asset.TextureKey;
import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.texture.Texture;
import mygame.Npc;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class ClarkQuest extends Quest {
    
  public ClarkQuest(AppStateManager stateManager, Node holder) {
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
      speech = "Hello there friend, your trespassing. If you'd like to leave alive go get me some wood.";  
      billyQuest.step = "GetWood";
      }
    
    else if (billyQuest.step.equals("GetWood")) {
      speech = "I really suggest you get me some wood for my fire soon... I'm getting hungry.";    
      }
    
    else if (billyQuest.step.equals("HasWood")) {
      speech = "That is some great wood.... Now where has Billy gone...";
      billyQuest.step = "GetBilly";
      }
    
    else if (billyQuest.step.equals("GetBilly")) {
      speech = "Go out and find me Little Billy, I need him for dinner.";    
      }
    
    else if (billyQuest.step.equals("HasBilly")) {
      speech = "Well hello Billy... Thank you friend, I don't need your services anymore.";    
      Npc billy = (Npc) holder.getParent().getChild("Little Billy");
      billy.phys.warp(((Npc) holder).model.getWorldTranslation().add(1, 1, 0));
      billy.phys.setWalkDirection(new Vector3f(0,0,0));
      billy.idle();
      billyQuest.step = "GaveBilly";
      }
    
    else if (billyQuest.step.equals("GaveBilly")) {
      speech = "I suggest you leave";    
      }

    else if (billyQuest.step.equals("KillClark")) {
      speech = "As you bury the axe deep into Clark's skull, you feel his life leave his body.";
      holder.removeFromParent();
      billyQuest.step = "Done";
      }
    
    else if (billyQuest.step.equals("Done")) {
      speech = "Clarks Body Lies Dead on the floor";    
      }
    
    else {
      speech = "Clarks Body Lies Dead on the floor.";  
      }
    
    gui.showAlert(holder.getName(), speech);
      
    }
  
  }
