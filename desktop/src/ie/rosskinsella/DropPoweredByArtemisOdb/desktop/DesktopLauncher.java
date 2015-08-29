package ie.rosskinsella.DropPoweredByArtemisOdb.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ie.rosskinsella.DropPoweredByArtemisOdb.DropPoweredByArtemisOdb;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new DropPoweredByArtemisOdb(), config);
	}
}
