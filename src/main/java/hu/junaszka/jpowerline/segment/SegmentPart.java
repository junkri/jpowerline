package hu.junaszka.jpowerline.segment;

import hu.junaszka.jpowerline.BashColor;

public class SegmentPart {
  public static final String DIVIDER = "\uE0B0";

  private String text;
  private int backgroundColor = 0;
  private int foregroundColor = 0;

  public SegmentPart(String text, int backgroundColor, int foregroundColor) {
    this.text = text;
    this.backgroundColor = backgroundColor;
    this.foregroundColor = foregroundColor;
  }

  public String toString() {
    String render;
    if (backgroundColor < 0) {
      render = "\\[\\e[0m\\]"; //reset
    } else {
      if (text.length()>0) {
        render = BashColor.background(backgroundColor) + BashColor.foreground(foregroundColor) + " " + text + " ";
      } else {
        render = "";
      }
    }
    return render;
  }

}
