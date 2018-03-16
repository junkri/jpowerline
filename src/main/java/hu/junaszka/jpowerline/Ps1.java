package hu.junaszka.jpowerline;

import hu.junaszka.jpowerline.segment.Segment;
import hu.junaszka.jpowerline.segment.impl.GitSegment;

public class Ps1 {
  public Segment[] segments = new Segment[]{new GitSegment()};

  public String getPs1(String path) {
    String ps1 = "";
    for (Segment segment : segments) {
      ps1 = ps1 + segment.getSegment(path);
    }
    return ps1;
  }
}
