package ie.rosskinsella.DropPoweredByArtemisOdb.systems;

import com.artemis.BaseSystem;
import com.artemis.Entity;
import com.artemis.annotations.Wire;
import com.artemis.managers.GroupManager;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;
import ie.rosskinsella.DropPoweredByArtemisOdb.factories.Bucket;
import ie.rosskinsella.DropPoweredByArtemisOdb.factories.Droplet;
import ie.rosskinsella.DropPoweredByArtemisOdb.managers.AssetManager;

@Wire
public class SpawningSystem extends BaseSystem {
  private final long dropletSpawnCooldown = 1000000000;
  private long lastDropletSpawnTime = TimeUtils.nanoTime();
  private boolean hasBucket = false;
  private Droplet dropletFactory;
  private Bucket bucketFactory;

  @Override
  protected void processSystem() {
    if(TimeUtils.nanoTime() - lastDropletSpawnTime > dropletSpawnCooldown) {
      Entity droplet = dropletFactory
          .position(MathUtils.random(0, 800 - 64), 480)
          .gravity(200)
          .bounds(64, 64)
          .sprite(AssetManager.SpriteFile.DROPLET)
          .collectible()
          .create();
      world.getManager(GroupManager.class).add(droplet, CollisionDetectionSystem.CollisionGroup.DROPLET.toString());

      lastDropletSpawnTime = TimeUtils.nanoTime();
    }

    if (!hasBucket) {
      Entity bucket = bucketFactory
          .position(20, 60)
          .bounds(64,64)
          .sprite(AssetManager.SpriteFile.BUCKET)
          .playerControlled()
          .create();
      world.getManager(GroupManager.class).add(bucket, CollisionDetectionSystem.CollisionGroup.BUCKET.toString());
      hasBucket = true;
    }
  }
}
