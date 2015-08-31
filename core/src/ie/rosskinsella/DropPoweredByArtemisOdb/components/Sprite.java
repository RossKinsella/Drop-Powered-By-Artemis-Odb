package ie.rosskinsella.DropPoweredByArtemisOdb.components;

import com.artemis.Component;
import com.artemis.World;
import com.badlogic.gdx.graphics.Texture;
import ie.rosskinsella.DropPoweredByArtemisOdb.managers.AssetManager;

public class Sprite extends Component {
  public AssetManager.SpriteFile spriteFile;

  public Sprite() {}

  public Sprite(AssetManager.SpriteFile spriteFile) {
    this.spriteFile = spriteFile;
  }
}
