package com.visualgit;


import com.visualgit.MyGit.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class jFrame extends javax.swing.JFrame {

    public jFrame() {
        initComponents();
    }

    MyGit mygit = new MyGit();
    Ostream ostream = new Ostream();
    GitOperation git = mygit;

    RepoOperation repo = mygit;

    ProxyOperation proxy=new ProxyOperation();

    String pathhh;
    private void initComponents() {
        git.set_localPath("C:\\Users\\28040\\Desktop");
        /*
         *
         *创建分支，jButton1ActionPerformed()方法在263行，不要在这里写！！！！！！
         * 万一出bug这个函数再找起来太麻烦，别的监听尽量也在这个函数外写
         *
         */

        //声明
        jMenuBar = new JMenuBar();
        jMenu1 = new JMenu("设置");
        jMenuItem1 = new JMenuItem("设置代理");
        jMenuItem2 = new JMenuItem("设置Token");
        jMenuItem6 = new JMenuItem("设置署名");
        jMenuItem7 = new JMenuItem("账号登录");
        jMenu2 = new JMenu("分支");
        jMenuItem3 = new JMenuItem("添加分支");
        jMenuItem4 = new JMenuItem("删除分支");
        jMenuItem5 = new JMenuItem("切换分支");

        jButton15 = new JButton("确认");
        jButton16 = new JButton("确认");
        jButton17 = new JButton("确认");
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jFileChooser1 = new javax.swing.JFileChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jTextArea3 = new javax.swing.JTextArea();
        jButton12 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextArea4 = new javax.swing.JTextArea();
        jScrollPane5 = new JScrollPane();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();


        jTextField8.setText("用户名");
        jTextField9.setText("邮箱");
        jTextField10.setText("用户名");
        jTextField11.setText("密码");
        jTextField11.setForeground(Color.BLACK);
        //jTextField11.setVisible(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Visual Git - version 0.2.0");
        setPreferredSize(new java.awt.Dimension(768, 720));
        setSize(new java.awt.Dimension(768, 720));
        //左边部分
        jPanel1.setPreferredSize(new java.awt.Dimension(325, 710));
        //创建分支
        jButton1.setText("创建分支");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        //分支名
        jTextField1.setText("分支名");
        //列出分支
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "目前尚无分支" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        Set<String> res =  new HashSet<>();
        mygit.branchList(res);
        String[] now=new String[res.size()];
        System.out.println(res.size());
        int i =0;
        for(String b:res)
        {
            now[i]=b;
            System.out.println(b);
            i++;
        }
        jList1.setListData(now);
        jList1.setVisible(true);
        jScrollPane1.setViewportView(jList1);
        //当前分支
        jTextField2.setText("当前分支");
        jTextField2.setEditable(false);
        //删除分支
        jButton2.setText("删除分支");
        //切换分支
        jButton3.setText("切换分支");
        //git command
        //jTextField5.setText("git command");
        //status信息
        jTextArea4.setEditable(false);
        jTextArea4.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jTextArea4.setText("command");
        jTextArea4.setAutoscrolls(false);
        jTextArea4.setName("");
        jScrollPane5.setViewportView(jTextArea4);




        jButton13.setText("代理连接");
        jButton14.setText("断开连接");
        jTextField6.setText("host");
        jTextField7.setText("porter");
        //将组件加到左边jpanel里
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(117, 117, 117)
                                                .addComponent(jTextField1))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jTextField2))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE,220 , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, Short.MAX_VALUE)
                                                .addComponent(jTextField7))

                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                        ))


                                .addContainerGap())
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(211, Short.MAX_VALUE)))
                        /*//test
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(211, Short.MAX_VALUE)
                                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(211, Short.MAX_VALUE)))*/

        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(gapsize, gapsize, gapsize)

                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(60, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(60, Short.MAX_VALUE)

                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(60, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(664, Short.MAX_VALUE)))
                       /* .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(664, Short.MAX_VALUE)
                                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(664, Short.MAX_VALUE)))*/
        );

        //中间部分
        //文件选择器，可以复选。如果不是那个仓库+文件列表+全选，可能要改
        jFileChooser1.setCurrentDirectory(new java.io.File("C:\\Users\\28040\\Desktop"));
        jFileChooser1.setFileHidingEnabled(true);
        jFileChooser1.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);
        jFileChooser1.setMultiSelectionEnabled(true);
        jFileChooser1.setRequestFocusEnabled(false);
        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });
        //status信息
        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("status信息");
        jTextArea1.setAutoscrolls(false);
        jTextArea1.setName("");
        jScrollPane2.setViewportView(jTextArea1);

        //组件加到中间部分的容器
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                        .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTextField2,javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()
                                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2)
                                .addContainerGap())
        );


        //右边部分
        //
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("commitmessage");
        jScrollPane3.setViewportView(jTextArea2);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.setText("Logs:\n");
        jTextArea3.setEditable(false);
        jTextArea3.setAutoscrolls(true);
        jScrollPane4.setViewportView(jTextArea3);


        jButton12.setText("pull");

        jButton11.setText("pudh");

        jButton10.setText("romote");

        jButton9.setText("status");

        jButton8.setText("commit");

        jButton6.setText("init");

        jButton7.setText("add");

        jButton5.setText("clone");

        jTextField3.setText("远程仓库");

        jTextField4.setText("token");


        jMenu1.add(jMenuItem1);
        jMenu1.add(jMenuItem2);
        jMenu1.add(jMenuItem6);
        jMenu1.add(jMenuItem7);
        jMenu2.add(jMenuItem3);
        jMenu2.add(jMenuItem4);
        jMenu2.add(jMenuItem5);
        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);
        this.setJMenuBar(jMenuBar);
        //组件加到右边容器
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField3)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                                        .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                                        .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(gapsize, gapsize, gapsize)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                .addGap(gapsize, gapsize, gapsize)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                                .addGap(gapsize, gapsize, gapsize)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                                .addGap(gapsize, gapsize, gapsize)
                                //.addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                //.addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                                .addGap(gapsize, gapsize, gapsize)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                                .addGap(gapsize, gapsize, gapsize)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                                .addGap(gapsize,gapsize,gapsize)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                                .addContainerGap())
        );

        //总的
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                //.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                // .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        //.addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
                                )
                                .addContainerGap())
        );

        jButton5.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jButton12.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jButton13.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jButton14.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jButton15.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jButton16.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jButton17.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });


        jMenuItem1.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuItem2.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuItem3.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenuItem4.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenuItem5.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenuItem6.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenuItem7.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });


        jTextField1.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField6.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jTextField7.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jTextField8.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jTextField9.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jTextField10.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jTextField11.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jTextArea2.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextArea2ActionPerformed(evt);
            }
        });

        pack();
    }// </editor-fold>




    private void jTextField1ActionPerformed(java.awt.event.MouseEvent evt) {
        //方法
        jTextField1.setText("");
    }
    private void jTextField3ActionPerformed(java.awt.event.MouseEvent evt) {
        //方法
        jTextField3.setText("");
    }
    private void jTextField4ActionPerformed(java.awt.event.MouseEvent evt) {
        //方法
        jTextField4.setText("");
    }
    private void jTextField6ActionPerformed(java.awt.event.MouseEvent evt) {
        //方法
        jTextField6.setText("");
    }
    private void jTextField7ActionPerformed(java.awt.event.MouseEvent evt) {
        //方法
        jTextField7.setText("");
    }
    private void jTextField8ActionPerformed(java.awt.event.MouseEvent evt) {
        //方法
        jTextField8.setText("");
    }
    private void jTextField9ActionPerformed(java.awt.event.MouseEvent evt) {
        //方法
        jTextField9.setText("");
    }
    private void jTextField10ActionPerformed(java.awt.event.MouseEvent evt) {
        //方法
        jTextField10.setText("");
    }
    private void jTextField11ActionPerformed(java.awt.event.MouseEvent evt) {
        //方法
        jTextField11.setText("");
    }
    private void jTextArea2ActionPerformed(java.awt.event.MouseEvent evt) {
        //方法
        jTextArea2.setText("");
    }










    /***
     以下为监听函数，写在相应的监听函数中
     ***/
    //创建分支
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        //方法
        System.out.printf("创建分支\n");
        String name=jTextField1.getText();
        String log = repo.createBranch(name);
        String oldlog = jTextArea3.getText();
        log=oldlog+"\n"+log;
        jTextArea3.setText(log);
        Set<String> res =  new HashSet<>();
        mygit.branchList(res);
        String[] now=new String[res.size()];
        System.out.println(res.size());
        int i =0;
        for(String b:res)
        {
            now[i]=b;
            System.out.println(b);
            i++;
        }
        jList1.setListData(now);
        jList1.setVisible(true);

    }
    //删除分支
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        //方法
        System.out.printf("删除分支\n");
        String name=jList1.getSelectedValue();
        String log = repo.deleteBranch(name);
        String oldlog = jTextArea3.getText();
        log=oldlog+"\n"+log;
        jTextArea3.setText(log);
        Set<String> res =  new HashSet<>();
        mygit.branchList(res);
        String[] now=new String[res.size()];
        System.out.println(res.size());
        int i =0;
        for(String b:res)
        {
            now[i]=b;
            System.out.println(b);
            i++;
        }
        jList1.setListData(now);
        jList1.setVisible(true);

    }
    //切换分支
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        //方法
        System.out.printf("切换分支\n");
        System.out.printf(jList1.getSelectedValue()+'\n');//选择项
        String name = jList1.getSelectedValue();
        String log = repo.switchBranch(name);
        String oldlog = jTextArea3.getText();
        log=oldlog+"\n"+log;
        jTextArea3.setText(log);
        jTextField2.setText("当前分支为："+name);
    }
    //clone
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        //方法
        System.out.printf("clone\n");
        String now= jTextField3.getText();
        ostream.output(jFileChooser1.getSelectedFile().getParent());
        String log = repo.remote_clone(now, jFileChooser1.getSelectedFile().toString());
        System.out.println(jFileChooser1.getSelectedFile().toString());
        String oldlog = jTextArea3.getText();
        log=oldlog+"\n"+log;
        jTextArea3.setText(log);
    }
    //init
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {             //已完成
        //方法
        git.set_localPath(pathhh);
        String log = repo.createGitRepository();
        String oldlog = jTextArea3.getText();
        log=oldlog+"\n"+log;
        jTextArea3.setText(log);
    }
    //add
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {           //已完成
        //方法
        System.out.printf("add\n");
        String all="";
        File[] now = jFileChooser1.getSelectedFiles();
        String[] now1= toStrin1(now);
        for (int j = 0; j < now1.length; j++) {
            String[] split=now1[j].split("\\\\");
            now1[j]=split[split.length-1];
            System.out.println(now1[j]);
        }
        for (int i = 0; i < now1.length; i++) {
            String log = repo.add(now1[i]);
            all = log+all;
        }
        String oldlog = jTextArea3.getText();
        all=oldlog+"\n"+all;
        jTextArea3.setText(all);

    }
    //commit
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {             //已完成
        //方法
        String context = jTextArea2.getText();
        System.out.printf("commit\n");
        System.out.println(jTextArea2.getText());
        String log = repo.commit(context);
        String oldlog = jTextArea3.getText();
        log=oldlog+"\n"+log;
        jTextArea3.setText(log);

    }
    //status
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {                    //已完成
        //方法
        System.out.printf("status\n");
        String now = "";
        Map<String, Set<String>> map1 = new HashMap<String, Set<String>>();
        String log = mygit.status(map1);
        now +="[Added]: \n";
        if(map1.get("Added")!=null) {
            for (String fileName: map1.get("Added")) {
                    now += "|- ";
                    now += fileName + "\n";
                }
            }
        now +="[Changed]: \n";
        if(map1.get("Changed")!=null) {
            for (String fileName : map1.get("Changed")) {
                now += "|- ";
                now += fileName + "\n";
            }
        }
        now +="[Conflicting]: \n";
        if(map1.get("Conflicting")!=null) {
            for (String fileName : map1.get("Conflicting")) {
                now += "|- ";
                now += fileName + "\n";
            }
        }
        now +="[IgnoredNotInIndex]: \n";
        if(map1.get("IgnoredNotInIndex")!=null) {
            for (String fileName : map1.get("IgnoredNotInIndex")) {
                now += "|- ";
                now += fileName + "\n";
            }
        }
        now +="[Missing]: \n";
        if(map1.get("Missing")!=null) {
            for (String fileName : map1.get("Missing")) {
                now += "|- ";
                now += fileName + "\n";
            }
        }
        now +="[Modified]: \n";
        if(map1.get("Modified")!=null) {
            for (String fileName : map1.get("Modified")) {
                now += "|- ";
                now += fileName + "\n";
            }
        }
        now +="[Removed]: \n";
        if(map1.get("Removed")!=null) {
            for (String fileName : map1.get("Removed")) {
                now += "|- ";
                now += fileName + "\n";
            }
        }
        now +="[UntrackedFiles]: \n";
        if(map1.get("UntrackedFiles")!=null) {
            for (String fileName : map1.get("UntrackedFiles")) {
                now += "|- ";
                now += fileName + "\n";
            }
        }
        now +="[UntrackedFolders]: \n";
        if(map1.get("UntrackedFolders")!=null) {
            for (String fileName : map1.get("UntrackedFolders")) {
                now += "|- ";
                now += fileName + "\n";
            }
        }
        jTextArea1.setText(now);
        String oldlog = jTextArea3.getText();
        log=oldlog+"\n"+log;
        jTextArea3.setText(log);

    }
    //remote
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {
        //方法
        System.out.printf("remote\n");
        String url=jTextField3.getText();
        System.out.printf(url);
        String log = git.set_remoteURI(url);
        String oldlog = jTextArea3.getText();
        log=oldlog+"\n"+log;
        jTextArea3.setText(log);

    }
    //push
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {
        //方法
        System.out.printf("push\n");
        String log = mygit.remote_push();
        String oldlog = jTextArea3.getText();
        log=oldlog+"\n"+log;
        jTextArea3.setText(log);

    }
    //pull
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {
        //方法
        System.out.printf("pull\n");
        String log =mygit.remote_pull();
        String oldlog = jTextArea3.getText();
        log=oldlog+"\n"+log;
        jTextArea3.setText(log);

    }
    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {
        //方法
        //
        String porter = jTextField7.getText();
        String aaa = jTextField6.getText();
        proxy.set_host(aaa);
        proxy.set_porter(porter);
        String oldlog = jTextArea3.getText();
        porter=oldlog+"\n"+porter;
        jTextArea3.setText(porter + "设置成功");

    }
    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {
        //方法
        proxy.set_host("");
        proxy.set_porter("");
        String log = "断开连接成功";
        String oldlog = jTextArea3.getText();
        log=oldlog+"\n"+log;
        jTextArea3.setText(log);

        System.out.printf("断开连接\n");
    }
    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {
        //方法
        // git.set_remoteURL("","");
        System.out.printf("设置token\n");
        String token=jTextField7.getText();
        System.out.println(token);
        String log = git.set_privateToken(token);
        String oldlog = jTextArea3.getText();
        log=oldlog+"\n"+log;
        jTextArea3.setText(log);

    }
    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {
        //方法
        System.out.printf("设置署名信息\n");
        String user=jTextField8.getText();
        String email=jTextField9.getText();
        System.out.println(user);
        System.out.println(email);
        String log = git.set_authorInfo(user,email);
        String oldlog = jTextArea3.getText();
        log=oldlog+"\n"+log;
        jTextArea3.setText(log);


    }
    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {
        //方法
        System.out.printf("设置身份信息\n");
        String user=jTextField10.getText();
        String password=jTextField11.getText();
        System.out.println(user);
        System.out.println(password);
        String log1 = git.set_userName(user);
        String log2 = git.set_password(password);
        log1=log1+log2;
        String oldlog = jTextArea3.getText();
        log1=oldlog+"\n"+log1;
        jTextArea3.setText(log1);

    }
    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {                    //已完成
        //方法
        if(evt.getActionCommand() == "ApproveSelection") {
            System.out.println(evt.getActionCommand() + '\n' + jFileChooser1.getSelectedFile());
            String[] now = toStrin(jFileChooser1.getSelectedFile());
            String pathnow = "";
            int leng = now.length;
            for (int i = 0; i < (now.length - 1); i++) {
                pathnow = pathnow + now[i] + "\\\\";
            }
            pathnow = pathnow + now[leng - 1];
            System.out.println(pathnow);
            pathhh=pathnow;
            jFileChooser1.setCurrentDirectory(new java.io.File(pathnow));
        } else if (evt.getActionCommand() == "CancelSelection") {
            System.out.println(evt.getActionCommand() + '\n' + jFileChooser1.getSelectedFile());
            jFileChooser1.setCurrentDirectory(new java.io.File("C:\\Users\\28040\\Desktop"));
        }
    }

    public String[] toStrin(File file)
    {
        String path = file.getPath();
        String[] now = path.split("\\\\");
        return  now;
    }

    public String[] toStrin1(File file[])
    {
        String[] now=new String[file.length];
        for(int i =0;i<file.length;i++)
        {
            String[] now1=toStrin(file[i]);
            String pathnow = "";
            int leng = now1.length;
            for (int j = 0; j < (now1.length - 1); j++) {
                pathnow = pathnow + now1[j] + "\\\\";
            }
            pathnow = pathnow + now1[leng - 1];
            now[i]=pathnow;

        }
        return  now;
    }


    /***
     以上为监听函数
     ***/

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
        //方法
        JFrame jfram2= new JFrame();
        jfram2.setTitle("设置代理");
        jfram2.setVisible(true);
        jfram2.setPreferredSize(new java.awt.Dimension(360, 150));
        jfram2.setSize(new java.awt.Dimension(360, 150));
        javax.swing.GroupLayout jfram2layout = new javax.swing.GroupLayout(jfram2.getContentPane());
        jfram2.getContentPane().setLayout(jfram2layout);
        jfram2layout.setHorizontalGroup(
                jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jfram2layout.createParallelGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jfram2layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE,280 , javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, Short.MAX_VALUE)
                                        .addComponent(jTextField7)
                                        .addContainerGap())

                                .addGap(14, 14, 14)
                                .addGroup(jfram2layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                                .addGap(14, 14, 14))
        );
        jfram2layout.setVerticalGroup(
                jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jfram2layout.createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addGroup(jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(5, Short.MAX_VALUE)

                                .addGroup(jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(5, Short.MAX_VALUE))
        );

    }
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
        //方法
        JFrame jfram2= new JFrame();
        jfram2.setTitle("设置Token");
        jfram2.setVisible(true);
        jfram2.setPreferredSize(new java.awt.Dimension(42, 90));
        jfram2.setSize(new java.awt.Dimension(420, 90));
        javax.swing.GroupLayout jfram2layout = new javax.swing.GroupLayout(jfram2.getContentPane());
        jfram2.getContentPane().setLayout(jfram2layout);
        jfram2layout.setHorizontalGroup(
                jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jfram2layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jButton15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))
        );
        jfram2layout.setVerticalGroup(
                jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jfram2layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE))
                                .addContainerGap())
        );

    }
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {
        //方法
        JFrame jfram2= new JFrame();
        jfram2.setTitle("添加分支");
        jfram2.setVisible(true);
        jfram2.setPreferredSize(new java.awt.Dimension(360, 90));
        jfram2.setSize(new java.awt.Dimension(360, 90));
        javax.swing.GroupLayout jfram2layout = new javax.swing.GroupLayout(jfram2.getContentPane());
        jfram2.getContentPane().setLayout(jfram2layout);
        jfram2layout.setHorizontalGroup(
                jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jfram2layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))
        );
        jfram2layout.setVerticalGroup(
                jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jfram2layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE))
                                .addContainerGap())
        );

    }
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {
        //方法
        JFrame jfram2= new JFrame();
        jfram2.setTitle("删除分支");
        jfram2.setVisible(true);
        jfram2.setPreferredSize(new java.awt.Dimension(360, 500));
        jfram2.setSize(new java.awt.Dimension(360, 500));
        javax.swing.GroupLayout jfram2layout = new javax.swing.GroupLayout(jfram2.getContentPane());
        jfram2.getContentPane().setLayout(jfram2layout);
        jfram2layout.setHorizontalGroup(
                jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jfram2layout.createSequentialGroup()
                                .addGroup(jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jfram2layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jButton2)
                                                .addContainerGap())
                                        .addGroup(jfram2layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap()))));
        jfram2layout.setVerticalGroup(
                jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jfram2layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                )
                                .addContainerGap()
                                .addGroup(jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)

                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE))
                                .addContainerGap())
        );

    }
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {
        //方法
        JFrame jfram2= new JFrame();
        jfram2.setTitle("切换分支");
        jfram2.setVisible(true);
        jfram2.setPreferredSize(new java.awt.Dimension(360, 500));
        jfram2.setSize(new java.awt.Dimension(360, 500));
        javax.swing.GroupLayout jfram2layout = new javax.swing.GroupLayout(jfram2.getContentPane());
        jfram2.getContentPane().setLayout(jfram2layout);
        jfram2layout.setHorizontalGroup(
                jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jfram2layout.createSequentialGroup()
                                .addGroup(jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jfram2layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jButton3)
                                                .addContainerGap())
                                        .addGroup(jfram2layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap()))));
        jfram2layout.setVerticalGroup(
                jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jfram2layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                )
                                .addContainerGap()
                                .addGroup(jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)

                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE))
                                .addContainerGap())
        );

    }
    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {
        //方法
        JFrame jfram2= new JFrame();
        jfram2.setTitle("设置署名");
        jfram2.setVisible(true);
        jfram2.setPreferredSize(new java.awt.Dimension(360, 180));
        jfram2.setSize(new java.awt.Dimension(360, 180));
        javax.swing.GroupLayout jfram2layout = new javax.swing.GroupLayout(jfram2.getContentPane());
        jfram2.getContentPane().setLayout(jfram2layout);
        jfram2layout.setHorizontalGroup(
                jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jfram2layout.createSequentialGroup()
                                .addGroup(jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jfram2layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jTextField8)
                                                .addContainerGap())
                                        .addGroup(jfram2layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jTextField9)
                                                .addContainerGap())
                                        .addGroup(jfram2layout.createSequentialGroup()
                                                .addGap(100, 100, 100)
                                                .addComponent(jButton16,javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(100, 100, 100)))));
        jfram2layout.setVerticalGroup(
                jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jfram2layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                )
                                .addContainerGap()
                                .addGroup(jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextField9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                )
                                .addContainerGap()
                                .addGroup(jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)

                                        .addComponent(jButton16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                                .addContainerGap())
        );

    }
    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {
        //方法
        JFrame jfram2= new JFrame();
        jfram2.setTitle("设置身份信息");
        jfram2.setVisible(true);
        jfram2.setPreferredSize(new java.awt.Dimension(360, 180));
        jfram2.setSize(new java.awt.Dimension(360, 180));
        javax.swing.GroupLayout jfram2layout = new javax.swing.GroupLayout(jfram2.getContentPane());
        jfram2.getContentPane().setLayout(jfram2layout);
        jfram2layout.setHorizontalGroup(
                jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jfram2layout.createSequentialGroup()
                                .addGroup(jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jfram2layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jTextField10)
                                                .addContainerGap())
                                        .addGroup(jfram2layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jTextField11)
                                                .addContainerGap())
                                        .addGroup(jfram2layout.createSequentialGroup()
                                                .addGap(100, 100, 100)
                                                .addComponent(jButton17,javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(100, 100, 100)))));
        jfram2layout.setVerticalGroup(
                jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jfram2layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextField10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                )
                                .addContainerGap()
                                .addGroup(jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextField11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                )
                                .addContainerGap()
                                .addGroup(jfram2layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)

                                        .addComponent(jButton17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                                .addContainerGap())
        );

    }


    public static void main(String args[]) {
        //窗口样式
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFrame().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton jButton10;//remote
    private javax.swing.JButton jButton11;//push
    private javax.swing.JButton jButton12;//pull
    private javax.swing.JButton jButton13;//代理连接
    private javax.swing.JButton jButton14;//断开代理
    private javax.swing.JButton jButton15;//确认token
    private javax.swing.JButton jButton16;//确认署名
    private javax.swing.JButton jButton17;//确认身份验证账号密码
    private javax.swing.JButton jButton1;//创建分支
    private javax.swing.JButton jButton2;//删除分支
    private javax.swing.JButton jButton3;//切换分支
    private javax.swing.JButton jButton5;//clone
    private javax.swing.JButton jButton6;//init
    private javax.swing.JButton jButton7;//add
    private javax.swing.JButton jButton8;//commit
    private javax.swing.JButton jButton9;//status
    private javax.swing.JFileChooser jFileChooser1;//文件选择
    private javax.swing.JList<String> jList1;//分支列表
    private javax.swing.JPanel jPanel1;//左列
    private javax.swing.JPanel jPanel2;//中间
    private javax.swing.JPanel jPanel3;//右列
    private javax.swing.JScrollPane jScrollPane1;//分支列表
    private javax.swing.JScrollPane jScrollPane2;//status容器
    private javax.swing.JScrollPane jScrollPane3;//commit message容器
    private javax.swing.JScrollPane jScrollPane4;//Log容器
    private javax.swing.JTextArea jTextArea1;//status信息
    private javax.swing.JTextArea jTextArea2;//commit message
    private javax.swing.JTextArea jTextArea3;//Log
    private javax.swing.JTextField jTextField1;//分支名
    private javax.swing.JTextField jTextField2;//当前分支
    private javax.swing.JTextField jTextField3;//远程仓库
    private javax.swing.JTextField jTextField4;//token
    private javax.swing.JTextField jTextField6;//host
    private javax.swing.JTextField jTextField7;//port
    private javax.swing.JTextField jTextField8;//署名用户名
    private javax.swing.JTextField jTextField9;//署名邮箱
    private javax.swing.JTextField jTextField10;//身份验证用户名
    private javax.swing.JPasswordField jTextField11;//身份验证密码

    private javax.swing.JScrollPane jScrollPane5;//command容器
    private javax.swing.JTextArea jTextArea4;//git command

    private javax.swing.JMenuBar jMenuBar;//菜单栏
    private javax.swing.JMenu jMenu1;//设置代理
    private javax.swing.JMenuItem jMenuItem1;//代理
    private javax.swing.JMenuItem jMenuItem2;//token

    private javax.swing.JMenu jMenu2;//分支
    private javax.swing.JMenuItem jMenuItem3;//创建分支
    private javax.swing.JMenuItem jMenuItem4;//切换分支
    private javax.swing.JMenuItem jMenuItem5;//删除分支
    private javax.swing.JMenuItem jMenuItem6;//设置署名
    private javax.swing.JMenuItem jMenuItem7;//设置账号密码
    private int gapsize=10;

    // End of variables declaration
}
