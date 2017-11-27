package buildify.Image;

import javafx.scene.image.ImageView;

@FunctionalInterface
public interface ImageHandler {
	public void handle(ImageView image);
}