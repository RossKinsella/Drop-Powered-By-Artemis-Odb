package ie.rosskinsella.DropPoweredByArtemisOdb.components;

import com.artemis.Component;

public class Position extends Component {
  public float x;
  public float y;

  public Position() {}

  public Position(float x, float y) {
    this.x = x;
    this.y = y;
  }
}
