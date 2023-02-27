/**
 * Author:
 *  -JamesNULLiu
 *  -
 */
package com.visualgit.MyGit;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.MergeCommand;
import org.eclipse.jgit.api.Status;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.JschConfigSessionFactory;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.transport.SshSessionFactory;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.eclipse.jgit.transport.OpenSshConfig.Host;

import com.jcraft.jsch.Session;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class MyGit implements RepoOperation, GitOperation {

    // Members ===================================================
    public Ostream ostream = new Ostream();
    Boolean flag = true;
    private Git m_git;
    private String m_localPath;
    private String m_curBranch = "main";
    private String m_remoteName = "origin";
    private String m_remoteURI = "";
    private String m_privateToken = "";
    private String m_userName = "";
    private String m_password = "";
    private String m_userEmail = "";
    // For ssh connection:
    final SshSessionFactory sshSessionFactory = new JschConfigSessionFactory() {
        @Override
        protected void configure(Host host, Session session) {
            session.setConfig("StrictHostKeyChecking", "no");
        }
        // @Override
        // protected JSch createDefaultJSch(FS fs) throws JSchException {
        // JSch jSch = super.createDefaultJSch(fs);
        // jSch.addIdentity("C:/Users/James/.ssh/java_final");
        // jSch.setKnownHosts("C:/Users/James/.ssh/known_hosts");
        // return jSch;
        // }
    };
    // ===========================================================

    private Boolean check_localPath() {
        if (m_localPath.equals("")) {
            ostream.log("Cannot open repository in empty path, consider set local path first.");
            return false;
        } else {
            ostream.log("check_localPath" + "\n" + "Succeeded");
            return true;
        }

    }

    private CredentialsProvider createProvider() {
        if (!m_privateToken.isEmpty()) {
            return new UsernamePasswordCredentialsProvider("PRIVATE-TOKEN", m_privateToken);
        } else if (!m_password.isEmpty() && !m_userName.isEmpty()) {
            return new UsernamePasswordCredentialsProvider(m_userName, m_password);
        }
        return null;
    }

    // Implementation of {GitOperation} ==========================

    @Override
    public String set_remoteURI(String uri) {
        flag = true;
        try {
            m_git
                    .remoteSetUrl()
                    .setRemoteName(m_remoteName)
                    .setRemoteUri(new URIish(uri)).call();
            m_remoteURI = uri;
        } catch (GitAPIException e) {
            ostream.log("set_remoteURI" + "\n" + "failed" + "\n" + e.toString());
            flag = false;
        } catch (URISyntaxException e) {
            ostream.log("set_remoteURI" + "\n" + "failed" + "\n" + e.toString());
            flag = false;
        } finally {
            if (flag)
                ostream.log("set_remoteURI" + "\n" + "Succeeded");
        }
        return ostream.loginfo;

    }

    @Deprecated
    @Override
    public String set_remoteURI(String remoteName, String uri) {
        flag = true;
        try {
            // ===========================================================
            // ***** Do Not Delete! *****
            // ===========================================================
            // Remove existing remotes.
            // Currently we only have one remote name "origin".
            // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            // List<RemoteConfig> remoteList = m_git.remoteList().call();
            // boolean whe_exist = false;
            // for (RemoteConfig x : remoteList) {
            // if (x.getName().equals(remoteName)) {
            // whe_exist = true;
            // break;
            // }
            // }
            // if (whe_exist) {
            // m_git.remoteRemove().setRemoteName(remoteName).call();
            // m_git.remoteAdd().setName(remoteName).call();
            // }
            // Set URI of remote connection to {m_git}:
            // ===========================================================
            m_git
                    .remoteSetUrl()
                    .setRemoteName(remoteName)
                    .setRemoteUri(new URIish(uri)).call();
            m_remoteURI = uri;
        } catch (GitAPIException e) {
            ostream.log("set_remoteURI" + "\n" + "failed" + "\n" + e.toString());
            flag = false;
        } catch (URISyntaxException e) {
            ostream.log("set_remoteURI" + "\n" + "failed" + "\n" + e.toString());
            flag = false;
        } finally {
            if (flag)
                ostream.log("set_remoteURI" + "\n" + "Succeeded");
        }
        return ostream.loginfo;

    }

    @Override
    public String set_localPath(String localPath) {
        this.m_localPath = localPath;
        openRepo();
        ostream.log("set_localPath" + "\n" + "Succeeded");
        return ostream.loginfo;
    }

    @Override
    public String set_authorInfo(String name, String email) {
        flag = true;
        // IF not a valid email address:
        if (!Pattern.matches("[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+", email)) {
            ostream.log("set_authorInfo" + "\n" + "failed" + "\n" + email + "is not a vaild email address");
            flag = false;
        }
        m_userName = name;
        m_userEmail = email;
        if (flag)
            ostream.log("set_authorInfo" + "\n" + "Succeeded");
        return ostream.loginfo;
    }

    @Override
    public String set_privateToken(String privateToken) {
        this.m_privateToken = privateToken;
        ostream.log("set_privateToken" + "\n" + "Succeeded");
        return ostream.loginfo;
    }

    @Override
    public String set_curBranch(String curBranch) {
        this.m_curBranch = curBranch;
        switchBranch(curBranch);
        ostream.log("set_curBranch" + "\n" + "Succeeded");
        return ostream.loginfo;
    }

    @Override
    public String set_userName(String name) {
        m_userName = name;
        ostream.log("set_userName" + "\n" + "Succeeded");
        return ostream.loginfo;
    }

    @Override
    public String set_password(String password) {
        m_password = password;
        ostream.log("set_password" + "\n" + "Succeeded");
        return ostream.loginfo;
    }

    @Override
    public final String get_curBranch() {
        return m_curBranch;
    }

    @Override
    public final String get_privateToken() {
        return m_privateToken;
    }

    @Override
    public final String get_localPath() {
        return m_localPath;
    }

    @Override
    public final String get_remoteURI() {
        return m_remoteURI;
    }

    @Override
    public String historyList(List<String> res) {
        flag = true;
        Iterable<RevCommit> container;
        try {
            container = m_git.log().call();
            for (Object object : container) {
                res.add(res.size(), object.toString());
            }
        } catch (GitAPIException e) {
            ostream.log("historyList" + "\n" + "failed" + "\n" + e.toString());
            flag = false;
        } finally {
            if (flag)
                ostream.log("historyList" + "\n" + "Succeeded");
        }
        return ostream.loginfo;
    }

    @Override
    public String status(Map<String, Set<String>> map) {
        flag = true;
        Status status;
        try {
            status = m_git.status().call();
            map.put("Added", status.getAdded());
            map.put("Changed", status.getChanged());
            map.put("Conflicting", status.getConflicting());
            map.put("IgnoredNotInIndex", status.getIgnoredNotInIndex());
            map.put("Missing", status.getMissing());
            map.put("Modified", status.getModified());
            map.put("Removed", status.getRemoved());
            map.put("UntrackedFiles", status.getUntracked());
            map.put("UntrackedFolders", status.getUntrackedFolders());
        } catch (GitAPIException e) {
            ostream.log("status" + "\n" + "failed" + "\n" + e.toString());
            flag = false;
        } finally {
            if (flag)
                ostream.log("status" + "\n" + "Succeeded");
        }
        return ostream.loginfo;
    }

    @Override
    public String branchList(Set<String> resSet) {
        flag = true;
        try {
            List<Ref> call = m_git.branchList().call();
            for (Ref ref : call) {
                String refName = ref.getName();
                if (refName.startsWith("refs/heads/")) {
                     refName = refName.replace("refs/heads/", "");
                     refName = refName.replace("[","");
                     refName = refName.replace("]","");
                }
                resSet.add(refName);
            }
        } catch (GitAPIException e) {
            ostream.log("branchList" + "\n" + "failed" + "\n" + e.toString());
            flag = false;
        } finally {
            if (flag)
                ostream.log("branchList" + "\n" + "failed" + "Succeeded");
        }
        return ostream.loginfo;

    }
    // ===========================================================

    // Implementation of {GitOperation} ==========================

    private String openRepo() {
        flag = true;
        Git git = null;
        if (!check_localPath())
            return "";
        try {
            Repository repository = new FileRepositoryBuilder()
                    // .findGitDir(new File(m_localPath))
                    .setGitDir(Paths.get(m_localPath, ".git").toFile())
                    .build();
            git = new Git(repository);
            Set<String> set = new HashSet<>();
            branchList(set);
            m_curBranch = set.toArray()[0].toString();
            switchBranch(m_curBranch);
            m_remoteURI = git.getRepository().getConfig().getString("remote","origin","url");
        } catch (IOException e) {
            ostream.log("openRepo" + "\n" + "failed" + "\n" + e.toString());
            flag = false;
        } finally {
            this.m_git = git;
            if (flag)
                ostream.log("openRepo" + "\n" + "Succeeded");
        }
        return ostream.loginfo;

    }

    public String init() {
        flag = true;
        try {
            Git.init().setDirectory(new File(m_localPath)).call();
        } catch (GitAPIException e) {
            ostream.log("init" + "\n" + "failed" + "\n" + e.toString());
            flag = false;
        } finally {
            if (flag)
                ostream.log("init" + "\n" + "Succeeded");
        }
        return ostream.loginfo;

    }

    @Override
    public String createGitRepository() {
        openRepo();
        init();
        createBranch("main");
        switchBranch("main");
        ostream.log("init" + "\n" + "Succeeded");
        return ostream.loginfo;
    }

    @Override
    public String add(String fileName) {
        ostream.loginfo = Thread.currentThread().getStackTrace()[1].getMethodName();
        flag = true;
        try {
            m_git.add().addFilepattern(fileName).call();
        } catch (GitAPIException e) {
            ostream.log("add" + "\n" + "failed" + "\n" + e.toString());
            flag = false;
        } finally {
            if (flag)
                ostream.log("add" + "\n" + "Succeeded");
        }
        return ostream.loginfo;

    }

    @Override
    public String remove(String command) {
        flag = true;
        try {
            m_git.rm().addFilepattern(command).call();
        } catch (GitAPIException e) {
            ostream.log("remove" + "\n" + "failed" + "\n" + e.toString());
            flag = false;
        } finally {
            if (flag)
                ostream.log("remove" + "\n" + "Succeeded");
        }
        return ostream.loginfo;

    }

    @Override
    public String commit(String message) {
        flag = true;
        try {
            m_git
                    .commit()
                    .setAuthor(m_userName, m_userEmail)
                    .setMessage(message)
                    .call();
        } catch (GitAPIException e) {
            ostream.log("commit" + "\n" + "failed" + "\n" + e.toString());
            flag = false;
        } finally {
            if (flag)
                ostream.log("commit" + "\n" + "Succeeded");
        }
        return ostream.loginfo;

    }

    @Override
    public String createBranch(String branchName) {
        flag = true;
        try {
            m_git.branchCreate().setName(branchName).call();
        } catch (GitAPIException e) {
            ostream.log("createBranch" + "\n" + "failed" + "\n" + e.toString());
            flag = false;
        } finally {
            if (flag)
                ostream.log("createBranch" + "\n" + "Succeeded");
        }
        return ostream.loginfo;

    }

    @Override
    public String deleteBranch(String branchName) {
        flag = true;
        try {
            Set<String> bSet = new HashSet<>();
            branchList(bSet);
            for (String b : bSet) {
                if (b.matches(branchName)) {
                    m_git.branchDelete().setBranchNames(branchName).call();
                }
            }
        } catch (GitAPIException e) {
            ostream.log("deleteBranch" + "\n" + "failed" + "\n" + e.toString());
            flag = false;
        } finally {
            if (flag)
                ostream.log("deleteBranch" + "\n" + "Succeeded");
        }
        return ostream.loginfo;

    }

    @Override
    public String switchBranch(String branchName) {
        flag = true;
        try {
            m_git.checkout().setName(branchName).call();
            m_curBranch = branchName;
        } catch (GitAPIException e) {
            ostream.log("switchBranch" + "\n" + "failed" + "\n" + e.toString());
            flag = false;
        } finally {
            if (flag)
                ostream.log("switchBranch" + "\n" + "Succeeded");
        }
        return ostream.loginfo;

    }

    @Override
    public String mergeBranch(String from, String to) {
        flag = true;
        try {
            Ref refFrom = m_git.checkout().setName(from).call();
            m_git.checkout().setName(to).call();
            m_git
                    .merge()
                    .include(refFrom)
                    .setCommit(true)
                    .setFastForward(MergeCommand.FastForwardMode.NO_FF) // Fast merge.
                    .setMessage("Merge " + from + " to " + to)
                    .call();
        } catch (GitAPIException e) {
            ostream.log("mergeBranch" + "\n" + "failed" + "\n" + e.toString());
            flag = false;
        } finally {
            if (flag)
                ostream.log("mergeBranch" + "\n" + "Succeeded");
        }
        return ostream.loginfo;

    }

    @Override
    public String remote_clone(String remote, String destination) {
        flag = true;
        // ========================================================================
        // ***** Do Not Delete *****
        // SSH connection =========================================================
        // CloneCommand cloneCommand = Git.cloneRepository();
        // cloneCommand.setTransportConfigCallback(new TransportConfigCallback(){
        // @Override
        // public String configure(Transport transport){
        // SshTransport sshTransport = (SshTransport) transport;
        // sshTransport . setSshSessionFactory(sshSessionFactory);
        // }
        // });
        // cloneCommand.setURI(remote);
        // cloneCommand.setDirectory(new File(m_localPath));
        // try{
        // cloneCommand.call().checkout();
        // } catch (GitAPIException e) {
        // e.printStackTrace();
        // }
        // HTTP connection ======================================================
        try {
            CredentialsProvider credentialsProvider = createProvider();
            m_git = Git
                    .cloneRepository()
                    .setBare(false)
                    .setCredentialsProvider(credentialsProvider)
                    .setCloneAllBranches(true)
                    .setURI(remote)
                    .setDirectory(new File(destination))
                    .call();
            m_remoteURI = remote;
            Set<String> set = new HashSet<>();
            branchList(set);
            m_curBranch = set.toArray()[0].toString();
        } catch (GitAPIException e) {
            ostream.log("remote_clone" + "\n" + "failed" + "\n" + e.toString());
            flag = false;
        } finally {
            if (flag)
                ostream.log("remote_clone" + "\n" + "Succeeded");
        }
        return ostream.loginfo;

    }

    @Override
    public String remote_push() {
        flag = true;
        try {

            CredentialsProvider credentialsProvider = createProvider();
            // CredentialsProvider credentialsProvider = new
            // UsernamePasswordCredentialsProvider("PRIVATE-TOKEN",
            // m_privateToken);
            m_git
                    .push()
                    .setRemote(m_remoteName)
                    .setRefSpecs(new RefSpec(m_curBranch))
                    .setCredentialsProvider(credentialsProvider)
                    .call();
        } catch (GitAPIException e) {
            ostream.log("remote_push" + "\n" + "failed" + "\n" + e.toString());
            flag = false;
        } finally {
            if (flag)
                ostream.log("remote_push" + "\n" + "Succeeded");
        }
        return ostream.loginfo;

    }

    @Override
    public String remote_pull() {
        flag = true;
        try {
            CredentialsProvider credentialsProvider = createProvider();
            m_git.pull()
                    .setCredentialsProvider(credentialsProvider)
                    .call();
        } catch (GitAPIException e) {
            ostream.log("remote_pull" + "\n" + "failed" + "\n" + e.toString());
            flag = false;
        } finally {
            if (flag)
                ostream.log("remote_pull" + "\n" + "Succeeded");
        }
        return ostream.loginfo;

    }
}
