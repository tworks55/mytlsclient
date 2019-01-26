package tlsclient.tworks55;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public class InsecureTrustManager implements X509TrustManager {
    /**
     * {@inheritDoc}
     */
    public void checkClientTrusted(final X509Certificate[] chain, final String authType) throws CertificateException {
        // Everyone is trusted!
    }

    /**
     * {@inheritDoc}
     */
    public void checkServerTrusted(final X509Certificate[] chain, final String authType) throws CertificateException {
        // Everyone is trusted!
    }

    /**
     * {@inheritDoc}
     */
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}