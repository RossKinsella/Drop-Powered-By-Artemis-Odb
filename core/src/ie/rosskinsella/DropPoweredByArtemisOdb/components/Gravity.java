package ie.rosskinsella.DropPoweredByArtemisOdb.components;

import com.artemis.Component;

public class Gravity extends Component {
  public float fallSpeed;

  public Gravity() {}

  public Gravity(float fallSpeed) {
    this.fallSpeed = fallSpeed;
  }
}
