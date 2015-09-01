package ie.rosskinsella.DropPoweredByArtemisOdb.systems;

import com.artemis.BaseSystem;
import com.artemis.annotations.Wire;
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
  private AssetManager assetManager;

  @Override
  protected void initialize() {
    bucketFactory
      .position(20, 60)
      .bounds(64, 64)
      .spriteReference(AssetManager.SpriteFile.BUCKET)
      .sprite()
      .playerControlled()
      .collector()
      .create();
  }

  @Override
  protected void processSystem() {
    currentDropletSpawnCooldown -= world.getDelta();
    if(currentDropletSpawnCooldown <= 0) {
      dropletFactory
        .position(MathUtils.random(0, 800 - 64), 480)
        .gravity(200)
        .bounds(64, 64)
        .spriteReference(AssetManager.SpriteFile.DROPLET)
        .sprite()
        .collectible()
        .create();

      currentDropletSpawnCooldown = dropletSpawnCooldown;
    }
  }
}
