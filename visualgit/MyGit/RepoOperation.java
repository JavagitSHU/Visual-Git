package com.visualgit.MyGit;

public interface RepoOperation {
    // git init
    String createGitRepository();

    // git add %fileName%
    String add(String fileName);

    // git rm %fileName%
    String remove(String fileName);

    // git commit -m %comment%
    String commit(String comment);

    // git branch -b %branchName%j
    String createBranch(String branchName);

    // git branch -d %branchName%
    String deleteBranch(String branchName);

    // git checkout %branchName%
    String switchBranch(String branchName);

    // git checkout %from%
    // git merge %to%
    String mergeBranch(String from, String to);

    // git clone %remote%
    String remote_clone(String remote, String destination);

    // git push
    String remote_push();

    // git pull
    String remote_pull();
}
