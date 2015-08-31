package ie.rosskinsella.DropPoweredByArtemisOdb.factories;

import com.artemis.EntityFactory;
import com.artemis.annotations.Bind;
import ie.rosskinsella.DropPoweredByArtemisOdb.components.*;
import ie.rosskinsella.DropPoweredByArtemisOdb.managers.AssetManager;

@Bind({Position.class, Sprite.class, Bounds.class, Gravity.class, Collectible.class})
public interface Droplet extends EntityFactory<Droplet> {
  Droplet position(float x, float y);
  Droplet sprite(AssetManager.SpriteFile spriteFile);
  Droplet bounds(float width, float height);
  Droplet gravity(float fallSpeed);
  Droplet collectible();
}
