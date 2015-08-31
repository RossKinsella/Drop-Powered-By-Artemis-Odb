package ie.rosskinsella.DropPoweredByArtemisOdb.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Wire;
import com.artemis.systems.EntityProcessingSystem;
import ie.rosskinsella.DropPoweredByArtemisOdb.components.Gravity;
import ie.rosskinsella.DropPoweredByArtemisOdb.components.Position;
import ie.rosskinsella.DropPoweredByArtemisOdb.managers.AssetManager;

@Wire
public class GravitySystem extends EntityProcessingSystem {

  protected ComponentMapper<Gravity> gravityMapper;
  protected ComponentMapper<Position>  positionMapper;

  public GravitySystem() {
    super(Aspect.all(Position.class, Gravity.class));
  }

  @Override
  protected void process(Entity e) {
    Position position = positionMapper.get(e);
    Gravity gravity = gravityMapper.get(e);

    position.y -= gravity.fallSpeed * world.delta;
    if(position.y + 64 < 0) {
      e.deleteFromWorld();
      world.getManager(AssetManager.class).get(AssetManager.SoundFile.SPLASH).play();
    }
  }
}
