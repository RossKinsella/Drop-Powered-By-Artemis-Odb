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
import ie.rosskinsella.DropPoweredByArtemisOdb.components.Position;
import ie.rosskinsella.DropPoweredByArtemisOdb.managers.AssetManager;

@Wire
public class CollisionDetectionSystem extends EntityProcessingSystem {
  protected ComponentMapper<Position> positionMapper;
  protected ComponentMapper<Bounds>  boundsMapper;
  ImmutableBag<Entity> buckets;

  private GroupManager groupManager;
  private AssetManager assetManager;

  public enum CollisionGroup {
    DROPLET, // We never actually use DROPLET. However, it might find use should more collidables be added.
    BUCKET
  }

  public CollisionDetectionSystem() {
    super(Aspect.all(Position.class, Bounds.class, Collectible.class));
  }

  @Override
  protected void begin() {
    buckets = groupManager.getEntities(CollisionGroup.BUCKET.name());
  }

  @Override
  protected void process(Entity e) {
    buckets.forEach(bucket -> maybeCollectDroplet(bucket, e));
  }

  private void maybeCollectDroplet(Entity bucket, Entity droplet) {
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
