package hu.junaszka.jpowerline.segment.impl;

import hu.junaszka.jpowerline.segment.Segment;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.Status;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GitSegment implements Segment {
  private static Logger LOG = LoggerFactory.getLogger(GitSegment.class);

  private Map<String, Git> gitMap = new HashMap<>();

  @Override
  public String getSegment(String path) {
    Git git = null;
    if (gitMap.containsKey(path)) {
      git = gitMap.get(path);
      LOG.info("Found git path in map ({})", path);
    } else {
      try {
        LOG.info("Open git path ({})", path);
        git = Git.open(new File(path+"/.git"));
        gitMap.put(path, git);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(path);
    try {
      Status status = git.status().call();
      stringBuilder.append("Added: " + status.getAdded());
      stringBuilder.append("Changed: " + status.getChanged());
      stringBuilder.append("Conflicting: " + status.getConflicting());
      stringBuilder.append("ConflictingStageState: " + status.getConflictingStageState());
      stringBuilder.append("IgnoredNotInIndex: " + status.getIgnoredNotInIndex());
      stringBuilder.append("Missing: " + status.getMissing());
      stringBuilder.append("Modified: " + status.getModified());
      stringBuilder.append("Removed: " + status.getRemoved());
      stringBuilder.append("Untracked: " + status.getUntracked());
      stringBuilder.append("UntrackedFolders: " + status.getUntrackedFolders());
    } catch (GitAPIException e) {
      e.printStackTrace();
    }

    return stringBuilder.toString();
  }
}
