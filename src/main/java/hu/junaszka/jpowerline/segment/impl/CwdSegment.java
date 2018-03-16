package hu.junaszka.jpowerline.segment.impl;

import hu.junaszka.jpowerline.segment.Segment;
import hu.junaszka.jpowerline.segment.SegmentPart;
import java.util.ArrayList;

public class CwdSegment implements Segment {

  private static final char PATH_DIVIDER = '\uE0B1';
  @Override
  public SegmentPart[] getSegmentParts(String path) {
    return new SegmentPart[]{new SegmentPart(path.replace('/', PATH_DIVIDER), 237, 250)};
  }
}
