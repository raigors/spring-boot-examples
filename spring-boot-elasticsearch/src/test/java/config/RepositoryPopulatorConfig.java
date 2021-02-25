package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

/**
 * TODO
 * <p>
 * create in 2021/2/23 9:28 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Configuration
public class RepositoryPopulatorConfig {

    @Bean
    public Jackson2RepositoryPopulatorFactoryBean repositoryPopulator() {
        Jackson2RepositoryPopulatorFactoryBean factoryBean = new Jackson2RepositoryPopulatorFactoryBean();
        factoryBean.setResources(new Resource[]{new ClassPathResource("data.json")});
        return factoryBean;
    }

}
