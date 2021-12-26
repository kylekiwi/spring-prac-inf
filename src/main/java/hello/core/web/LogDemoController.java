package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
  private final LogDemoService logDemoService;
  private final MyLogger myLogger;

  @RequestMapping("log-demo")
  @ResponseBody
  public String logDemo(HttpServletRequest request) {
    String reqURL = request.getRequestURL().toString();

    System.out.println("myLogger = " + myLogger.getClass());


    myLogger.setReqURL(reqURL); // 이 때 진짜 myLogger클래스를 찾아서 동작해(provider 사용했을 때 처럼)
    myLogger.log("controller test");
    logDemoService.logic("testId");
    return "OK";
  }
}
