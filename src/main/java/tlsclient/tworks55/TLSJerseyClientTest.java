package tlsclient.tworks55;

import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;
import org.json.JSONObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.client.urlconnection.HTTPSProperties;

import java.security.Provider;
import java.security.Security;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.ws.rs.core.MediaType;

public class TLSJerseyClientTest {
	public static void main(String[] args) {
		try {
			TrustManager[] trustAllCerts = { new InsecureTrustManager() };
			HostnameVerifier hostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
			ClientConfig config = new DefaultClientConfig();

			Provider provider = new BouncyCastleJsseProvider();
			Security.addProvider(provider);
			SSLContext ctx = SSLContext.getInstance("TLSv1.2", provider.getName());

			ctx.init(null, trustAllCerts, null);

			config.getProperties().put(HTTPSProperties.PROPERTY_HTTPS_PROPERTIES,
					new HTTPSProperties(hostnameVerifier, ctx));
			Client c = Client.create(config);
			WebResource resource = c.resource("https://github.com/login/oauth/access_token");

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("client_id", "*** Set client_id here ***");
			jsonObject.put("client_secret", "*** Set client_secret here ***");
			jsonObject.put("code", "*** Set code here ***");
			String response = resource.type(MediaType.APPLICATION_JSON_TYPE).post(String.class, jsonObject.toString());

			System.out.println(response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}