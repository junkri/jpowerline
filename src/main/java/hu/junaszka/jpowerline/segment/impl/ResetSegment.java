package hu.junaszka.jpowerline.segment.impl;

import hu.junaszka.jpowerline.segment.Segment;
import hu.junaszka.jpowerline.segment.SegmentPart;

public class ResetSegment implements Segment {

  @Override
  public SegmentPart[] getSegmentParts(String path) {
    return new SegmentPart[]{new SegmentPart("", -1, -1)};
  }
}
