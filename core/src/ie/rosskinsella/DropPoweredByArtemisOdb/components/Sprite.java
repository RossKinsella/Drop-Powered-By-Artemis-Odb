package ie.rosskinsella.DropPoweredByArtemisOdb.components;

import com.artemis.Component;
import com.artemis.annotations.Transient;
import com.badlogic.gdx.graphics.Texture;

@Transient
public class Sprite extends Component {
  public Texture texture;

  public Sprite() {}

  public void init(Texture texture) {
    this.texture = texture;
  }

}
