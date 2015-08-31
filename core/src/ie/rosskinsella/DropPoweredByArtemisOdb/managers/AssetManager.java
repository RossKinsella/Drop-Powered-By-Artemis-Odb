package ie.rosskinsella.DropPoweredByArtemisOdb.managers;

import com.artemis.Manager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class AssetManager extends Manager {
  public Texture droplet;
  public Texture bucket;
  public Sound dropSound;
  public Music rainMusic;

  public enum SpriteFile {
    DROPLET,
    BUCKET
  }

  public enum SoundFile {
    SPLASH
  }

  public enum MusicFile {
    RAIN
  }

  public AssetManager() {
    droplet = new Texture(Gdx.files.internal("droplet.png"));
    bucket = new Texture(Gdx.files.internal("bucket.png"));
    dropSound = Gdx.audio.newSound(Gdx.files.internal("water-drop.mp3"));
    rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
  }

  public Texture get(SpriteFile sprite) {
    if (sprite.equals(SpriteFile.DROPLET)) {
      return droplet;
    }
    else if (sprite.equals(SpriteFile.BUCKET)){
      return bucket;
    }

    return null;
  }

  public Sound get(SoundFile sound) {
    if (sound.equals(SoundFile.SPLASH)) {
      return dropSound;
    }

    return null;
  }

  public void playMusic(MusicFile music) {
    if (music.equals(MusicFile.RAIN)) {
      rainMusic.setLooping(true);
      rainMusic.play();
    }
  }

}
