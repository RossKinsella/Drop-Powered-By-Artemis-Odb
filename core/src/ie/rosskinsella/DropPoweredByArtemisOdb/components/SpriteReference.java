package ie.rosskinsella.DropPoweredByArtemisOdb.components;

import com.artemis.Component;
import ie.rosskinsella.DropPoweredByArtemisOdb.managers.AssetManager;

public class SpriteReference extends Component {
  public AssetManager.SpriteFile spriteFile;

  public SpriteReference() {}

  public SpriteReference(AssetManager.SpriteFile spriteFile) {
    this.spriteFile = spriteFile;
  }
}
