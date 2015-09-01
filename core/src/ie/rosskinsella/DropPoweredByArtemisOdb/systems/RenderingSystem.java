package ie.rosskinsella.DropPoweredByArtemisOdb.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Wire;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ie.rosskinsella.DropPoweredByArtemisOdb.components.Position;
import ie.rosskinsella.DropPoweredByArtemisOdb.components.Sprite;
import ie.rosskinsella.DropPoweredByArtemisOdb.components.SpriteReference;
import ie.rosskinsella.DropPoweredByArtemisOdb.managers.AssetManager;

@Wire
public class RenderingSystem extends EntityProcessingSystem {
  
  protected ComponentMapper<SpriteReference> spriteReferenceMapper;
  protected ComponentMapper<Sprite>  spriteMapper;
  protected ComponentMapper<Position>  positionMapper;

  private SpriteBatch batch;
  private AssetManager assetManager;

  public RenderingSystem() {
    super(Aspect.all(SpriteReference.class, Position.class, Sprite.class));

    batch = new SpriteBatch();
  }

  @Override
  protected void inserted(int entityId) {
    Sprite sprite = spriteMapper.get(entityId);
    SpriteReference spriteReference = spriteReferenceMapper.get(entityId);
    sprite.init(assetManager.get(spriteReference.spriteFile));
  }

  @Override
  protected void begin() {
    Gdx.gl.glClearColor(0, 0, 0.2f, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    batch.begin();
  }

  @Override
  protected void process(Entity e) {
    Sprite sprite = spriteMapper.get(e);
    Position position = positionMapper.get(e);

    batch.draw(sprite.texture, position.x, position.y);
  }

  @Override
  protected void end() {
    batch.end();
  }

}
