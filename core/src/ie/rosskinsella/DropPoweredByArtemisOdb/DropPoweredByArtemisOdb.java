package ie.rosskinsella.DropPoweredByArtemisOdb;

import com.artemis.*;
import com.artemis.annotations.Wire;
import com.artemis.managers.GroupManager;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import ie.rosskinsella.DropPoweredByArtemisOdb.managers.AssetManager;
import ie.rosskinsella.DropPoweredByArtemisOdb.systems.*;
import net.mostlyoriginal.api.utils.builder.WorldConfigurationBuilder;

@Wire
public class DropPoweredByArtemisOdb extends ApplicationAdapter {

  private World world;

  @Override
  public void create () {
    WorldConfiguration configuration = new WorldConfigurationBuilder()
        .with(new AssetManager())
        .with(new GroupManager())
        .with(new RenderingSystem())
        .with(new GravitySystem())
        .with(new SpawningSystem())
        .with(new PlayerControlSystem())
        .with(new CollisionDetectionSystem())
        .build();

    OrthographicCamera camera = new OrthographicCamera();
    camera.setToOrtho(false, 800, 480);
    configuration.register(camera); // This allows @Wire access to the camera

    world = new World(configuration);
    world.getManager(AssetManager.class).playMusic(AssetManager.MusicFile.RAIN); // Could be in the initialize of a 'MusicSystem'
  }

  @Override
  public void render () {
    world.setDelta(Gdx.graphics.getDeltaTime());
    world.process();
  }
}
