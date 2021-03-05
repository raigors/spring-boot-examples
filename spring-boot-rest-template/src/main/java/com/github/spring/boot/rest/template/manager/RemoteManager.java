package com.github.spring.boot.rest.template.manager;

import com.github.spring.boot.rest.template.pojo.dto.UserInfoDTO;
import com.github.spring.boot.rest.template.pojo.vo.ReturnVO;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * TODO
 * <p>
 * create in 2021/3/5 5:10 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Component
public class RemoteManager {

    private static final ParameterizedTypeReference<ReturnVO<UserInfoDTO>> REFERENCE = new ParameterizedTypeReference<ReturnVO<UserInfoDTO>>() {
    };

    @Resource
    private RestTemplate template;

    @SneakyThrows({URISyntaxException.class})
    public UserInfoDTO remote(String url, List<String> data) {
        log.debug("push data request:{}", data);
        RequestEntity<List<String>> requestEntity = RequestEntity.post(new URI(url))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(data);
        ResponseEntity<ReturnVO<UserInfoDTO>> response = template.exchange(requestEntity, REFERENCE);
        ReturnVO<UserInfoDTO> responseData = requireNonNull(response.getBody());
        log.debug("remote response:{} - {}", url, responseData);
        return responseData.getData();
    }


}
