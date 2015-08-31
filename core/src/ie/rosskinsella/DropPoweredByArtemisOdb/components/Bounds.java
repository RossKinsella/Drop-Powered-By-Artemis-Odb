package ie.rosskinsella.DropPoweredByArtemisOdb.components;

import com.artemis.Component;

public class Bounds extends Component {
  public float width;
  public float height;

  public Bounds() {}

  public Bounds(float width, float height) {
    this.width = width;
    this.height = height;
  }
}
