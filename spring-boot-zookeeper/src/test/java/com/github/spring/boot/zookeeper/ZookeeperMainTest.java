package com.github.spring.boot.zookeeper;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;

import java.security.NoSuchAlgorithmException;

/**
 * TODO
 * <p>
 * create in 2021/3/25 4:17 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
public class ZookeeperMainTest {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(DigestAuthenticationProvider.generateDigest("super:ccy"));
    }

}
