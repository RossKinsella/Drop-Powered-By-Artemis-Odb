package ie.rosskinsella.DropPoweredByArtemisOdb.factories;

import com.artemis.EntityFactory;
import com.artemis.annotations.Bind;
import ie.rosskinsella.DropPoweredByArtemisOdb.components.*;
import ie.rosskinsella.DropPoweredByArtemisOdb.managers.AssetManager;

@Bind({Position.class, SpriteReference.class, Sprite.class, Bounds.class, PlayerControlled.class, Collector.class})
public interface Bucket extends EntityFactory<Bucket> {
  Bucket position(float x, float y);
  Bucket spriteReference(AssetManager.SpriteFile spriteFile);
  Bucket sprite();
  Bucket bounds(float width, float height);
  Bucket playerControlled();
  Bucket collector();
}
