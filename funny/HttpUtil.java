package funny;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpUtil {

	public static String getResult(String url) throws IOException {
		String result = "";

		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpGet httpget = new HttpGet(url);

			System.out.println("Executing request " + httpget.getRequestLine());
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {

				// Get hold of the response entity
				HttpEntity entity = response.getEntity();

				result = EntityUtils.toString(entity);

			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}

		return result;
	}
}
