package com.visualgit.MyGit;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface GitOperation {

    // git origin add %uri%
    String set_remoteURI(String uri);

    // git %remoteName% add %uri%
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
    
    // NO COMMAND
    String set_curBranch(String curBranch);

    // git rev-parse --abbrev-ref HEAD
    String get_curBranch();

    // git status
    String status(Map<String, Set<String>> res);

    // NO COMMAND
    String get_privateToken();

    // NO COMMAND
    String get_localPath();

    // NO COMMAND
    String get_remoteURI();

    // git branch
    String branchList(Set<String> res);

    // git log
    String historyList(List<String> res);
}