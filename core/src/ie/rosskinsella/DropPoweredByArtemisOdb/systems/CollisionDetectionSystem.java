package ie.rosskinsella.DropPoweredByArtemisOdb.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Wire;
import com.artemis.managers.GroupManager;
import com.artemis.systems.EntityProcessingSystem;
import com.artemis.utils.ImmutableBag;
import ie.rosskinsella.DropPoweredByArtemisOdb.components.Bounds;
import ie.rosskinsella.DropPoweredByArtemisOdb.components.Collectible;
import ie.rosskinsella.DropPoweredByArtemisOdb.components.Collector;
import ie.rosskinsella.DropPoweredByArtemisOdb.components.Position;
import ie.rosskinsella.DropPoweredByArtemisOdb.managers.AssetManager;
import net.mostlyoriginal.api.system.core.DualEntityProcessingSystem;

@Wire
public class CollisionDetectionSystem extends DualEntityProcessingSystem {
  protected ComponentMapper<Position> positionMapper;
  protected ComponentMapper<Bounds>  boundsMapper;

  private AssetManager assetManager;

  private static Aspect.Builder droplets = Aspect.all(Position.class, Bounds.class, Collectible.class);
  private static Aspect.Builder buckets = Aspect.all(Position.class, Bounds.class, Collector.class);

  public CollisionDetectionSystem() {
    super(buckets, droplets);
  }

  @Override
  protected void process(Entity bucket, Entity droplet) {
    Position dropletPosition = positionMapper.get(droplet);
    Bounds dropletBounds = boundsMapper.get(droplet);
    Position bucketPosition = positionMapper.get(bucket);
    Bounds bucketBounds = boundsMapper.get(bucket);
    if (overlaps(dropletPosition, dropletBounds, bucketPosition, bucketBounds)) {
      droplet.deleteFromWorld();
      assetManager.get(AssetManager.SoundFile.SPLASH).play();
    }
  }

  private boolean overlaps(Position position1, Bounds bounds1, Position position2, Bounds bounds2) {
    return position1.x < position2.x + bounds2.width
        && position1.x + bounds1.width > position2.x
        && position1.y < position2.y + bounds2.height
        && position1.y + bounds1.height > position2.y;
  }
}
