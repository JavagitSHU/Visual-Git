package shu.javase.MyGit;


public interface RepoOperation {
    // Local Repository Operations:
    String createGitRepository();

    String add(String fileName);

    String remove(String fileName);

    String commit(String comment);


    String createBranch(String branchName);

    String deleteBranch(String branchName);

    String switchBranch(String branchName);

    String mergeBranch(String from, String to);


    // Remote Repository Operations:
    String remote_clone(String remote, String destination);

    String remote_push();

    String remote_pull();
}
