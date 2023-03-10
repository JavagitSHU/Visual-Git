package com.visualgit;


import com.visualgit.MyGit.*;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import javax.lang.model.type.NullType;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class mian {
    public static <JGitUtils> void main(String[] args) throws GitAPIException, URISyntaxException {
        String localPath = "E:\\JAVA程序设计\\test2";


        com.visualgit.MyGit.JGitUtils jGitUtils=null;
        Git git = jGitUtils.openRpo(localPath); //获取git对象
        System.out.println(git);
//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
        CredentialsProvider provider = new UsernamePasswordCredentialsProvider("PRIVATE-TOKEN", "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");  //生成身份信息
//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
        String branch = "master";   //克隆目标分支
  /*      git.push()
                .setRemote("origin")    //设置推送的URL名称
                .setRefSpecs(new RefSpec(branch))   //设置需要推送的分支,如果远端没有则创建
                .setCredentialsProvider(provider)   //身份验证
                .call();
*/
        git .remoteAdd().setName("origin")
                        .setUri(new URIish("https://github.com/ZraryZU/testrepo.git"))
                                .call();
        git.pull()
                .setRemoteBranchName("master")  //设置需要pull的远端分支
                .setCredentialsProvider(provider)  //身份验证
                .call();
        System.out.print("6666");
        git.push()
                .setRemote("origin")    //设置推送的URL名称
                .setRefSpecs(new RefSpec(branch))   //设置需要推送的分支,如果远端没有则创建
                .setCredentialsProvider(provider)   //身份验证
                .call();

    }
}
