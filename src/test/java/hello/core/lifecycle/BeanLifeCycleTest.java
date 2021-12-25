package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {
  @Test
  public void lifeCycleTest() {
    ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
    NetworkClient client = ac.getBean(NetworkClient.class);
    ac.close();
  }

  @Configuration
  static class LifeCycleConfig {
    @Bean
    // or, destroyMethod can be skipped (by 'inferred')
//    @Bean(initMethod = "init")
    public NetworkClient networkClient() {
      NetworkClient myNet = new NetworkClient();
      myNet.setUrl("http://fjdkajfkds.com");
      return myNet;
    }
  }

}
