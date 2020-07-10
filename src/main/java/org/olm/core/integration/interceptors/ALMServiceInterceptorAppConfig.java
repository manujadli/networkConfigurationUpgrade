package org.olm.core.integration.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Component
public class ALMServiceInterceptorAppConfig extends WebMvcConfigurerAdapter {
   @Autowired
   ALMServiceInterceptor almServiceInterceptor;

   @Override
   public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(almServiceInterceptor);
   }
}