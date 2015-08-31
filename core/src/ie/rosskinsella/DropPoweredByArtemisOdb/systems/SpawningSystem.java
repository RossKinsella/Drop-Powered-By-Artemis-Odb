package ie.rosskinsella.DropPoweredByArtemisOdb.systems;

import com.artemis.BaseSystem;
import com.artemis.Entity;
import com.artemis.annotations.Wire;
import com.artemis.managers.GroupManager;
import com.badlogic.gdx.math.MathUtils;
import ie.rosskinsella.DropPoweredByArtemisOdb.factories.Bucket;
import ie.rosskinsella.DropPoweredByArtemisOdb.factories.Droplet;
import ie.rosskinsella.DropPoweredByArtemisOdb.managers.AssetManager;

@Wire
public class SpawningSystem extends BaseSystem {
  private final long dropletSpawnCooldown = 100;
  private long currentDropletSpawnCooldown = 0;

  private Droplet dropletFactory;
  private Bucket bucketFactory;
  private GroupManager groupManager;

  @Override
  protected void initialize() {
    Entity bucket = bucketFactory
        .position(20, 60)
        .bounds(64,64)
        .sprite(AssetManager.SpriteFile.BUCKET)
        .playerControlled()
        .create();
    groupManager.add(bucket, CollisionDetectionSystem.CollisionGroup.BUCKET.toString());
  }

  @Override
  protected void processSystem() {
    currentDropletSpawnCooldown -= world.getDelta();
    if(currentDropletSpawnCooldown <= 0) {
      Entity droplet = dropletFactory
          .position(MathUtils.random(0, 800 - 64), 480)
          .gravity(200)
          .bounds(64, 64)
          .sprite(AssetManager.SpriteFile.DROPLET)
          .collectible()
          .create();
      groupManager.add(droplet, CollisionDetectionSystem.CollisionGroup.DROPLET.toString());

      currentDropletSpawnCooldown = dropletSpawnCooldown;
    }
  }
}
