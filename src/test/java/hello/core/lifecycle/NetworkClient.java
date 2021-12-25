package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {
  private String url;

  public NetworkClient() {
    System.out.println("생성자 호출, url = " + url);
  }

  public void setUrl(String url) {
    this.url = url;
  }

  //서비스 시작시 호출
  public void connect() {
    System.out.println("connect = " + url);
  }

  public void call(String msg) {
    System.out.println("call: " + url + " msg = " + msg);
  }

  public void disconnect() {
    System.out.println("close: " + url);
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("NetworkClient.afterPropertiesSet");
    connect();
    call("msg for init connection");
  }

  @Override
  public void destroy() throws Exception {
    System.out.println("NetworkClient.destroy");
    disconnect();
  }
}
