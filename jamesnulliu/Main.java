package com.jamesnulliu;

import com.jamesnulliu.MyGit.*;



public class Main {
    // {ostream} is used for output and log.
    static Ostream ostream = new Ostream();
    public static void main(String[] args) {
        // System.setProperty("proxyType", "4");
        // System.setProperty("proxyPort", "7890");
        // System.setProperty("proxyHost", "127.0.0.1");
        // System.setProperty("proxySet", "true");

        MyGit mygit = new MyGit();
        GitOperation git = mygit;
        RepoOperation repo = mygit;

        // Go to one foler.
        git.set_localPath("C:/Users/Majin/Desktop/pre");


        // ostream.log(git.branchList().toString());
        git.set_authorInfo("james", "jamesnulliu@outlook.com");
        git.set_privateToken("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");
        
        // SSH connection:
        // repo.remote_clone("git@github.com:jamesnulliu/a.git");
        // HTTP connection:
        repo.remote_clone("https://github.com/Dilute9629/test.git");
        // ostream.log(git.status());
        // repo.add(".");
        // repo.commit("update");
        // ostream.log(git.status());
        // repo.remote_push();
    }
}
