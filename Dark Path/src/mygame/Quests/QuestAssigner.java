package mygame.Quests;

import mygame.Quests.Mission1.*;
import mygame.Quests.Mission2.*;
import mygame.Quests.Mission3.*;
import mygame.Quests.Mission4.*;
import mygame.Quests.Mission5.*;
import mygame.Quests.Mission6.*;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.TextureKey;
import com.jme3.material.Material;
import com.jme3.material.RenderState;
import com.jme3.scene.Node;
import com.jme3.texture.Texture;
import mygame.Interactable;
import mygame.Npc;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class QuestAssigner {
  
  private AppStateManager stateManager;
    
  public QuestAssigner(AppStateManager stateManager) {
    this.stateManager = stateManager;
    }  
    
  public Quest assignQuest(Node holder) {
    
    Quest quest;
    String name;
    
    try {
      name = ((Interactable) holder).model.getUserData("Name");
      }
    
    catch (ClassCastException e) {
      name = ((Npc) holder).model.getUserData("Name");  
      }
    
    //Init the BillyQuest Stuff
    if (name.equals("Billy")) {
      quest = new BillyQuest(stateManager, holder);
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/Billy.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);
      mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
      mat.setFloat("AlphaDiscardThreshold", .5f);
      ((Npc) holder).model.setMaterial(mat);
    }

    else if (name.equals("Clark")) {
      quest = new ClarkQuest(stateManager, holder);
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/Clark.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);
      mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
      mat.setFloat("AlphaDiscardThreshold", .5f);
      ((Npc) holder).model.setMaterial(mat);      
    }

    else if (name.equals("Betsy")) {
      quest = new BetsyQuest(stateManager, holder);
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/Betsy.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);
      mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
      mat.setFloat("AlphaDiscardThreshold", .5f);
      ((Npc) holder).model.setMaterial(mat);
    }
    
    else if (name.equals("BillyTree")) {
      quest = new BillyTreeQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "Looks like a normal tree.";
    }
    
    else if (name.equals("BillyAxe")) {
      quest = new BillyAxeQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "Looks like a block for chopping wood.";
    }
    
    //Quest Two Will Start Here
    else if (name.equals("Flora")) {
      quest = new FloraQuest(stateManager, holder); 
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/Flora.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex); 
      mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
      mat.setFloat("AlphaDiscardThreshold", .5f);
      ((Npc) holder).model.setMaterial(mat);
    }
    
    else if (name.equals("Dampe")) {
      quest = new DampeQuest(stateManager, holder);
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/Dampe.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);
      mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
      mat.setFloat("AlphaDiscardThreshold", .5f);
      ((Npc) holder).model.setMaterial(mat);
    }
    
    else if (name.equals("RandomGrave")) {
      quest = new GraveQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "Looks like someone was buried here";
      }

    else if (name.equals("GraveTable")) {
      quest = new GraveTableQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "An old table...";
      }

    else if (name.equals("Gallows")) {
      quest = new GallowsQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "Looks like an old set of gallows";
      }
    
    else if (name.equals("GraveShovel")) {
      quest = new GraveShovelQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "A shovel leans against the wall.";
      }
    
    //Mission Three Items
    
    else if (name.equals("Father")) {
      quest = new FatherQuest(stateManager, holder);
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/Priest.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);
      mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
      mat.setFloat("AlphaDiscardThreshold", .5f);
      ((Npc) holder).model.setMaterial(mat);
      }
    
    else if (name.equals("Brother")) {
      quest = new BrotherQuest(stateManager, holder);
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/Priest.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);  
      mat.setTexture("ColorMap", tex);
      mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
      mat.setFloat("AlphaDiscardThreshold", .5f);
      ((Npc) holder).model.setMaterial(mat);
      }

    else if (name.equals("Devil")) {
      quest = new DevilQuest(stateManager, holder);
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/Devil.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);
      mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
      mat.setFloat("AlphaDiscardThreshold", .5f);
      ((Npc) holder).model.setMaterial(mat);
      }
    
    else if (name.equals("DevilWall")) {
      quest = new DevilWallQuest(stateManager, holder);  
      ((Interactable) holder).contactMessage = "There is something strange about this wall...";  
      }

    else if (name.equals("DevilDoor")) {
      quest = new DevilDoorQuest(stateManager, holder);  
      ((Interactable) holder).contactMessage = "A tightly locked door...";    
      }

    else if (name.equals("DevilTable")) {
      quest = new DevilTableQuest(stateManager, holder);  
      ((Interactable) holder).contactMessage = "An old table...";    
      }

    else if (name.equals("StormDoor")) {
      quest = new StormDoorQuest(stateManager, holder);  
      ((Interactable) holder).contactMessage = "The Door to the outside";    
      }
    
    //Mission Four Stuff
    else if (name.equals("Thief")) {
      quest = new ThiefQuest(stateManager, holder);
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/Prisoner.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);
      mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
      mat.setFloat("AlphaDiscardThreshold", .5f);
      ((Npc) holder).model.setMaterial(mat);
      }

    else if (name.equals("Sheriff")) {
      quest = new SheriffQuest(stateManager, holder);
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/Sheriff.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);
      mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
      mat.setFloat("AlphaDiscardThreshold", .5f);
      ((Npc) holder).model.setMaterial(mat);
      }

    else if (name.equals("ThiefInn")) {
      quest = new ThiefInnQuest(stateManager, holder);
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/BlackSmith.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);
      mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
      mat.setFloat("AlphaDiscardThreshold", .5f);
      ((Npc) holder).model.setMaterial(mat);
      }

    else if (name.equals("ThiefCrate")) {
      quest = new ThiefCrateQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "An old crate";
      }

    else if (name.equals("ThiefBody")) {
      quest = new ThiefBodyQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "A dead body lies here on the floor.";
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/Body.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);
      mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
      mat.setFloat("AlphaDiscardThreshold", .5f);
      ((Interactable) holder).model.setMaterial(mat);
      }
    
    //Mission 5 Stuff
    else if (name.equals("PoisonMaster")) {
      quest = new PoisonQuest(stateManager, holder);
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/Devil.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);
      mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
      mat.setFloat("AlphaDiscardThreshold", .5f);
      ((Npc) holder).model.setMaterial(mat);
      }

    else if (name.equals("PoisonPrisoner")) {
      quest = new PoisonPrisonerQuest(stateManager, holder);
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/Prisoner.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);
      mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
      mat.setFloat("AlphaDiscardThreshold", .5f);
      ((Npc) holder).model.setMaterial(mat);
      }
    
    else if (name.equals("PoisonCook")) {
      quest = new PoisonCookQuest(stateManager, holder);
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/ShopKeeper.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);
      mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
      mat.setFloat("AlphaDiscardThreshold", .5f);
      ((Npc) holder).model.setMaterial(mat);
    }
    
    else if (name.equals("PoisonButler")) {
      quest = new PoisonButlerQuest(stateManager, holder);
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/Butler.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);
      mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
      mat.setFloat("AlphaDiscardThreshold", .5f);
      ((Npc) holder).model.setMaterial(mat);
      }

    else if (name.equals("PoisonTable")) {
      quest = new PoisonTableQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "A very fancy dining table.";
      }

    else if (name.equals("PoisonDoor")) {
      quest = new PoisonDoorQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "The door to the outside";
      }
    
    //Mission Six Stuff
    else if (name.equals("StinkPeter")) {
      quest = new StinkPeterQuest(stateManager, holder);
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/Peter.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);
      mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
      mat.setFloat("AlphaDiscardThreshold", .5f);
      ((Npc) holder).model.setMaterial(mat);
      }
    
    else if (name.equals("StinkPaul")) {
      quest = new StinkPaulQuest(stateManager, holder);  
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/Paul.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);
      mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
      mat.setFloat("AlphaDiscardThreshold", .5f);
      ((Npc) holder).model.setMaterial(mat);
      }

    else if (name.equals("StinkWell")) {
      quest = new StinkWellQuest(stateManager, holder);  
      ((Interactable) holder).contactMessage = "An old well";
      }

    else if (name.equals("StinkShovel")) {
      quest = new StinkShovelQuest(stateManager, holder);  
      ((Interactable) holder).contactMessage = "A shovel leans against the wall here.";
      }

    else if (name.equals("StinkShrooms")) {
      quest = new StinkShroomsQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "Some good looking mushrooms";
      }

    else if (name.equals("StinkAxe")) {
      quest = new StinkAxeQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "An old block for chopping wood";
      }

    else if (name.equals("StinkTree")) {
      quest = new StinkTreeQuest(stateManager, holder); 
      ((Interactable) holder).contactMessage = "An Oak Tree";
      }

    else if (name.equals("StinkSpider")) {
      quest = new StinkSpiderQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "This spider looks extremely dangerous";
      }
    
    else {
      return null;
      }
    
    return quest;
    }  
    
  }
