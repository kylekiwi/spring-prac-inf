package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request") // == @Scope("request")
public class MyLogger {
  private String uuid;
  private String reqURL;

  public void setReqURL(String reqURL) {
    this.reqURL = reqURL;
  }
  public void log(String msg) {
    System.out.println("[" + uuid + "]" + "[" + reqURL + "] : " + msg);
  }

  @PostConstruct
  public void init() {
    uuid = UUID.randomUUID().toString();
    System.out.println("[" + uuid + "] request scope been created: " + this);
  }

  @PreDestroy
  public void close() {
    System.out.println("[" + uuid + "] request scope been closed: " + this);
  }


}
