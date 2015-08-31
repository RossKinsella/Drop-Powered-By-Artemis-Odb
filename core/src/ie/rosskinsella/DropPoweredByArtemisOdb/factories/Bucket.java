package ie.rosskinsella.DropPoweredByArtemisOdb.factories;

import com.artemis.EntityFactory;
import com.artemis.World;
import com.artemis.annotations.Bind;
import ie.rosskinsella.DropPoweredByArtemisOdb.components.Bounds;
import ie.rosskinsella.DropPoweredByArtemisOdb.components.PlayerControlled;
import ie.rosskinsella.DropPoweredByArtemisOdb.components.Position;
import ie.rosskinsella.DropPoweredByArtemisOdb.components.Sprite;
import ie.rosskinsella.DropPoweredByArtemisOdb.managers.AssetManager;

@Bind({Position.class, Sprite.class, Bounds.class, PlayerControlled.class})
public interface Bucket extends EntityFactory<Bucket> {
  Bucket position(float x, float y);
  Bucket sprite(AssetManager.SpriteFile spriteFile);
  Bucket bounds(float width, float height);
  Bucket playerControlled();
}
