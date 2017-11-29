package buildify.Image;

import java.net.URL;

@FunctionalInterface
public interface URLHandler {
	public void handle(URL url);
}