package buildify.Image;

import java.net.URI;

@FunctionalInterface
public interface URIHandler {
	public void handle(URI uri);
}