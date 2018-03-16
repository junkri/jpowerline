package hu.junaszka.jpowerline.controller;

import hu.junaszka.jpowerline.Ps1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ps1Controller {

  private static Logger LOG = LoggerFactory.getLogger(Ps1Controller.class);

  private Ps1 ps1 = new Ps1();

  @RequestMapping("/ps1")
  public String ps1(@RequestParam("path") String path) {
    return ps1.getPs1(path);

  }
}
