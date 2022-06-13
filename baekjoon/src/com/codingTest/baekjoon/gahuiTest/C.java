package com.codingTest.baekjoon.gahuiTest;

import java.io.*;
import java.util.*;

public class C {
  public static void test() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    GroupList groupList = new GroupList(new HashMap<>());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int userCount = Integer.parseInt(st.nextToken());
    int fileCount = Integer.parseInt(st.nextToken());

    for (int i = 0; i < userCount; i++) {
      st = new StringTokenizer(br.readLine());

      String userName = st.nextToken();

      if (st.hasMoreTokens()) { // 그룹에 속해있다면
        st = new StringTokenizer(st.nextToken(), ",");
        while (st.hasMoreTokens()) {
          String groupName = st.nextToken();
          Boolean isSet = groupList.isSetGroup(groupName);
          if (isSet) {
            Group group = groupList.findByGroupName(groupName);
            group.addUser(userName);
          } else {
            groupList.addGroup(new Group(groupName, userName));
          }
        }
      }
    } // end add user & group

    FileList fileList = new FileList(new HashMap<>());

    for (int i = 0; i < fileCount; i++) {
      st = new StringTokenizer(br.readLine());
      String fileName = st.nextToken();
      String roles = st.nextToken();
      String owner = st.nextToken();
      String groupName = st.nextToken();

      fileList.addFile(new File(fileName, roles, owner, groupList.findByGroupName(groupName)));
    } // end add file

    StringBuilder sb = new StringBuilder();

    int q = Integer.parseInt(br.readLine());

    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      String userName = st.nextToken();
      String fileName = st.nextToken();
      String action = st.nextToken();

      File getFile = fileList.findFileByFileName(fileName);

//      유저와 파일간의 관계 찾기
      String relation = "other";
      if (getFile.getOwner().equals(userName)) {
        relation = "owner";
      } else if (getFile.getGroup().isSetUserFindByUserName(userName)) {
        relation = "group";
      }
      sb.append(getFile.canAction(relation, action) ? 1 : 0).append("\n");
    }

    System.out.print(sb);
  }

  public static class GroupList {
    private HashMap<String, Group> groupHashMap;

    public GroupList(HashMap<String, Group> groupHashMap) {
      this.groupHashMap = groupHashMap;
    }

    boolean isSetGroup(String groupName) {
      return groupHashMap.get(groupName) != null;
    }

    void addGroup(Group group) {
      this.groupHashMap.put(group.getGroupName(), group);
    }

    Group findByGroupName(String groupName) {
      return groupHashMap.get(groupName);
    }
  }

  public static class Group {
    private String groupName;
    private HashSet<String> groupUsers;

    public Group(String groupName, String userName) {
      this.groupName = groupName;
      this.groupUsers = new HashSet<>();
      groupUsers.add(userName);
    }

    void addUser(String userName) {
      this.groupUsers.add(userName);
    }

    boolean isSetUserFindByUserName(String userName) {
      return groupUsers.contains(userName);
    }

    public String getGroupName() {
      return groupName;
    }
  }

  public static class FileList {
    private HashMap<String, File> fileHashMap;

    public FileList(HashMap<String, File> fileHashMap) {
      this.fileHashMap = fileHashMap;
    }

    void addFile(File newFile) {
      this.fileHashMap.put(newFile.getFileName(), newFile);
    }

    File findFileByFileName(String fileName) {
      return this.fileHashMap.get(fileName);
    }
  }

  public static class File {
    private String fileName;
    private String owner;
    private Group group;
    private String[] ownerRole;
    private String[] groupRole;
    private String[] otherRole;

    public File(String fileName, String roles, String owner, Group group) {
      this.fileName = fileName;
      this.owner = owner;
      this.group = group;

      setRole(roles);
    }

    boolean canAction(String relation, String action) {
      if (relation.equals("owner")) {
        for (String role : ownerRole) {
          if (role.equals(action)) return true;
        }
        return false;
      } else if (relation.equals("group")) {
        for (String role : getGroupRole()) {
          if (role.equals(action)) return true;
        }
        return false;
      } else if (relation.equals("other")) {
        for (String role : otherRole) {
          if (role.equals(action)) return true;
        }
        return false;
      } else {
        return false;
      }
    }


    void setRole(String roles) {
      String[] role = roles.split("");
      this.ownerRole = convertRoleEng(Integer.parseInt(role[0]));
      this.groupRole = convertRoleEng(Integer.parseInt(role[1]));
      this.otherRole = convertRoleEng(Integer.parseInt(role[2]));
    }

    String[] convertRoleEng(int role) {
      switch (role) {
        case 0:
          return new String[]{"N"};
        case 1:
          return new String[]{"X"};
        case 4:
          return new String[]{"R"};
        case 5:
          return new String[]{"R", "X"};
        case 2:
        case 6:
          return new String[]{"R", "W"};
        case 3:
        case 7:
          return new String[]{"R", "W", "X"};
        default:
          return new String[]{""};
      }
    }

    public String getFileName() {
      return fileName;
    }

    public String getOwner() {
      return owner;
    }

    public Group getGroup() {
      return group;
    }


    public String[] getGroupRole() {
      return groupRole;
    }
  }
}