package com.learning.spring.basics.componentscan;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/*
    Summary: If you're using a BEAN (component), and one of its dependencies (autowired)
    is a PROTOTYPE, you need to use a proxy so each time you try to get BEAN and the dependencies
    you'll get a new instance of the dependency

*   If the component calling this class has its scope as SINGLETON,
*   even if this is declared as PROTOTYPE, it will have not effect, as the same personDAO bean and
*   its corresponding JdbcConnection combo will always be called
*
*   To insist on a different JdbcConnection each time (regardless of scope of the calling component,
*   you need to configure a proxy (proxyMode= ScopedProxyMode.TARGET_CLASS)
*
    * @Component
    @Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE,
            proxyMode= ScopedProxyMode.TARGET_CLASS)
    public class JdbcConnection
    {
*
*/
@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE,
        proxyMode= ScopedProxyMode.TARGET_CLASS)
public class ComponentJdbcConnection
{
    public ComponentJdbcConnection()
    {
        System.out.println("ComponentJdbcConnection Connected!");
    }
}
