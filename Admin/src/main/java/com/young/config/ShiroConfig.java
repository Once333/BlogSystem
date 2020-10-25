package com.young.config;

import com.young.realm.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);

        HashMap<String, String> map = new HashMap<>();
        map.put("/article","user");
        map.put("/article/add","user");
        map.put("/article/edit/**","user");
        map.put("/article/publish","user");
        map.put("/article/edit","user");
        map.put("/article/delete/**","user");
        map.put("/category","user");
        map.put("/category/add","user");
        map.put("/category/delete/**","user");
        map.put("/home","user");
        map.put("/comment","user");
        map.put("/tag","user");
        map.put("/tag/add","user");
        map.put("/tag/delete/**","user");
        factoryBean.setFilterChainDefinitionMap(map);
        factoryBean.setLoginUrl("/login");
        return factoryBean;
    }

    @Bean
    public DefaultWebSecurityManager securityManager(@Qualifier("userRealm")UserRealm userRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(userRealm);
        return manager;
    }

    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }
}
