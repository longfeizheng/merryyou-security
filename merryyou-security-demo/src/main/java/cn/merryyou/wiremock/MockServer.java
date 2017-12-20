package cn.merryyou.wiremock;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * Created on 2017/12/20 0020.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class MockServer {
    public static void main(String[] args) throws Exception {
        configureFor(8080);
        removeAllMappings();

        mock("/order/1", "01");
    }

    private static void mock(String url, String fileName) throws Exception {
        ClassPathResource resource = new ClassPathResource("mock/response/" + fileName + ".txt");
        String content = FileUtils.readFileToString(resource.getFile(), "UTF-8");
        stubFor(get(urlPathEqualTo(url))
                .willReturn(aResponse()
                        .withBody(content)
                        .withStatus(200)));
    }
}
