package com.visualgit.MyGit;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface GitOperation {

    /**
     * Set remote connection to {uri}.
     * {@code git %origin% add %uri%}
    */
    String set_remoteURI(String uri);

    /**
     * Set remote connection to {uri}.
     * {@code git %remoteName% add %uri%}
     */
    String set_remoteURI(String remoteName, String uri);

    // git bash %localPath%
    String set_localPath(String localPath);

    // NO COMMAND
    String set_privateToken(String privateToken);

    // NO COMMAND
    String set_userName(String userName);

    // NO COMMAND
    String set_password(String password);

    // git --config user.name %name%
    // git --config user.email %email%
    String set_authorInfo(String name, String email);
    
    /**
     * Set current active branch to {Branch}.
     */
    String set_curBranch(String curBranch);

    String get_curBranch();

    String status(Map<String, Set<String>> res);

    String get_privateToken();

    String get_localPath();

    String get_remoteURI();

    String branchList(Set<String> res);

    String historyList(List<String> res);
}