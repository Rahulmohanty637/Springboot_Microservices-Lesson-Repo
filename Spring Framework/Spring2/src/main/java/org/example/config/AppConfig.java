package org.example.config;

import org.example.Alien;
import org.example.Computer;
import org.example.Desktop;
import org.example.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

/**
 * @Configuration marks this class as a source of bean definitions
 * for the Spring container. Equivalent to XML-based <beans>...</beans>.
 */
@Configuration
public class AppConfig {

    /**
     * @Bean indicates that this method returns a bean to be managed by Spring.
     * Method name defaults to the bean ID unless specified via @Bean(name = "...")
     *
     * @Autowired on the method parameter tells Spring to automatically wire
     * a matching bean of type `Computer`.
     *
     * @Qualifier("desktop") specifies which implementation of `Computer` to inject
     * when multiple candidates exist (like Laptop and Desktop).
     *
     * This method creates and returns an `Alien` object with its dependencies set.
     */
    @Bean
    public Alien alien(@Autowired @Qualifier("desktop") Computer com) {
        Alien obj = new Alien();
        obj.setAge(25);     // setting primitive field using setter
        obj.setCom(com);    // injecting the qualified Computer implementation
        return obj;
    }

    /**
     * @Bean registers a bean of type `Desktop` in the Spring context.
     *
     * @Scope("prototype") ensures a **new object** is created **each time**
     * this bean is requested. By default, Spring beans are singleton.
     *
     * Equivalent to:
     * <bean class="org.example.Desktop" scope="prototype"/>
     */
    @Bean
    @Scope("prototype")
    public Desktop desktop() {
        return new Desktop();
    }

    /**
     * @Bean registers a bean of type `Laptop`.
     *
     * @Primary tells Spring that **this bean should be preferred**
     * when autowiring a dependency by type and multiple candidates exist.
     *
     * If `@Qualifier` is not used elsewhere, this bean will be injected by default.
     *
     * Equivalent to:
     * <bean class="org.example.Laptop" primary="true"/>
     */
    @Bean
    @Primary
    public Laptop laptop() {
        return new Laptop();
    }

    // Alternative: You could use @Bean(name = {"com1", "com2"}) to create aliases.
    // @Bean(name = {"com1", "com2"}) — allows the same bean to be accessed with multiple names.
}