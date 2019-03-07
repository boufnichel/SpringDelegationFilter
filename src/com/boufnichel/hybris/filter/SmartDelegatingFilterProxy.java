package com.boufnichel.hybris.filter;

import de.hybris.platform.core.Registry;
import de.hybris.platform.util.Config;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

/**
 * Smart Delegation filter proxy that check if all conditions are true before delegating
 *
 * @author boufnichel
 */
public class SmartDelegatingFilterProxy extends DelegatingFilterProxy implements Delegable {

  public SmartDelegatingFilterProxy() {
    super();
  }

  public SmartDelegatingFilterProxy(Filter delegate) {
    super(delegate);
  }

  public SmartDelegatingFilterProxy(String targetBeanName) {
    this(targetBeanName, (WebApplicationContext)null);
  }

  public SmartDelegatingFilterProxy(String targetBeanName, WebApplicationContext wac) {
   super(targetBeanName, wac);
  }

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    // check if all delegation conditions are true
    if(getDelegationStrategy().isDelegable()){
      super.doFilter(request,response,filterChain);
    } else { // otherwise bypass delegation
      filterChain.doFilter(request,response);
    }
  }

  private Delegable getDelegationStrategy(){
    return (Delegable) Registry.getApplicationContext().getBean("delegationStrategy");
  }

}
