package hu.junaszka.jpowerline;

import hu.junaszka.jpowerline.segment.Segment;
import hu.junaszka.jpowerline.segment.SegmentPart;
import hu.junaszka.jpowerline.segment.impl.CwdSegment;
import hu.junaszka.jpowerline.segment.impl.DollarSegment;
import hu.junaszka.jpowerline.segment.impl.GitSegment;
import hu.junaszka.jpowerline.segment.impl.ResetSegment;

public class Ps1 {
  public Segment[] segments = new Segment[]{new CwdSegment(), new GitSegment(), new DollarSegment(), new ResetSegment()};

  public String getPs1(String path) {
    String ps1 = "";
    for (Segment segment : segments) {
      String renderedSegmentParts = segment.getSegmentParts(path)[0].toString();
      String divider = (segment instanceof ResetSegment || renderedSegmentParts.length()==0)?"":SegmentPart.DIVIDER;
      ps1 = ps1 + renderedSegmentParts + divider;
    }
    return ps1;
  }
}
