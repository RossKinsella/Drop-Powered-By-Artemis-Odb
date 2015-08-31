package ie.rosskinsella.DropPoweredByArtemisOdb;

import com.artemis.*;
import com.artemis.annotations.Wire;
import com.artemis.managers.GroupManager;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import ie.rosskinsella.DropPoweredByArtemisOdb.managers.AssetManager;
import ie.rosskinsella.DropPoweredByArtemisOdb.systems.*;
import net.mostlyoriginal.api.utils.builder.WorldConfigurationBuilder;

@Wire
public class DropPoweredByArtemisOdb extends ApplicationAdapter {

  private World world;

  @Override
  public void create () {
    world = new World(new WorldConfigurationBuilder()
        .with(new AssetManager())
        .with(new GroupManager())
        .with(new RenderingSystem())
        .with(new GravitySystem())
        .with(new SpawningSystem())
        .with(new PlayerControlSystem())
        .with(new CollisionDetectionSystem())
        .build());
    world.getManager(AssetManager.class).playMusic(AssetManager.MusicFile.RAIN);
  }

  @Override
  public void render () {
    world.setDelta(Gdx.graphics.getDeltaTime());
    world.process();

  }
}
