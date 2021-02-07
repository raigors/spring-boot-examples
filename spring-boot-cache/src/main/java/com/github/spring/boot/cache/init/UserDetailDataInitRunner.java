package com.github.spring.boot.cache.init;

import com.github.javafaker.Faker;
import com.github.spring.boot.cache.pojo.entity.UserDetailDO;
import com.github.spring.boot.cache.repository.IUserDetailRepository;
import com.google.common.collect.Sets;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Optional;
import java.util.Set;

/**
 * 初始化造数据
 * <p>
 * create in 2021/2/7 4:23 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class UserDetailDataInitRunner implements CommandLineRunner {

    private final IUserDetailRepository repository;

    private final RedisTemplate<String, String> redisTemplate;

    private static final Integer NUM = 33;

    @Override
    public void run(String... args) throws Exception {
        clearRedis();
        for (int i = 0; i < NUM; i++) {
            Faker faker = new Faker(Locale.ENGLISH);
            String name = faker.name().firstName();
            String phone = faker.phoneNumber().phoneNumber();
            if (repository.existsByNameOrPhone(name, phone)) {
                continue;
            }
            UserDetailDO user = getUserDetail(faker, name, phone);
            repository.save(user);
        }
    }

    private void clearRedis() {
        Optional<Set<String>> optional = Optional.ofNullable(redisTemplate.keys("*"));
        redisTemplate.delete(optional.orElse(Sets.newHashSet()));
    }

    @NotNull
    private UserDetailDO getUserDetail(Faker faker, String name, String phone) {
        UserDetailDO user = UserDetailDO.builder()
                .name(name)
                .phone(phone)
                .age(faker.number().numberBetween(10, 30))
                .build();
        log.info(user.toString());
        return user;
    }
}
