package tlsclient.tworks55;

import java.security.Security;

public class BCtest {

	public static void main(String[] args) {
		// BC is the ID for the Bouncy Castle provider;
		if (Security.getProvider("BC") == null) {
			System.out.println("Bouncy Castle provider is NOT available");
		} else {
			System.out.println("Bouncy Castle provider is available");
		}
	}

}
