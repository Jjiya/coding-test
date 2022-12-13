package level_1;

import java.util.*;

public class July_2 {
// 신규 아이디 추천
  public String solution(String new_id) {
    String re_new_id = new_id
        .toLowerCase()
        .replaceAll("[^\\w-_.]", "")
        .replaceAll("[.]{2,}", ".")
        .replaceAll("^[.]|[.]$", "");

    if (re_new_id.isEmpty()) {
      re_new_id = "a";
    }

    if (re_new_id.length() >= 16) {
      re_new_id = re_new_id
          .substring(0, 15)
          .replaceAll("[.]$", "");
    }

    while (re_new_id.length() < 3) {
      re_new_id += re_new_id.charAt(re_new_id.length() - 1);
    }

    return re_new_id;
  }

  //  로또 최고 순위와 최저 순위
  public int[] solution(int[] lottos, int[] win_nums) {
    lottos = Arrays.stream(lottos).filter(num -> num != 0).toArray();

    Arrays.sort(lottos);
    Arrays.sort(win_nums);

    int correctCount = 0, winNumIdx = 0, unknownCount = 6 - lottos.length;

    for (int i = 0; i < lottos.length; i++) {
      for (int j = winNumIdx; j < win_nums.length; j++) {
        if (lottos[i] == win_nums[j]) {
          winNumIdx = j + 1;
          correctCount++;
          break;
        }
      }
    }

    int[] answer = {convertRank(Math.min(correctCount + unknownCount, 6)), convertRank(correctCount)};

    return answer;
  }

  public int convertRank(int correctCount) {
    return switch (correctCount) {
      case 6 -> 1;
      case 5 -> 2;
      case 4 -> 3;
      case 3 -> 4;
      case 2 -> 5;
      default -> 6;
    };
  }

  //  신고 결과 받기
  public int[] solution(String[] id_list, String[] report, int k) {
    /*
        1. 유저 별 신고한 유저를 저장한다.
            key value 형식 이용
            key: 신고 당한 유저, value: String[] 신고한 유저 리스트
        2. 신고된 횟수가 k번 이상인 유저를 찾는다.
            key로 반복문 돌려서 그에 해당하는 길이가 k번 이상인 것
        3. 2에 해당하는 유저를 신고한 유저를 찾는다.
        4. 3에 해당하는 유저가 받을 메일 수를 저장한다.
    */
    HashMap<String, HashSet<String>> reportList = new HashMap<>(id_list.length);
    HashSet<String> reportedThanK = new HashSet<>();

    for (String reportInfo : report) {
      StringTokenizer st = new StringTokenizer(reportInfo);
      String userId = st.nextToken(), reportId = st.nextToken();
      HashSet<String> userList = reportList.getOrDefault(reportId, new HashSet<>());
      userList.add(userId);
      reportList.put(reportId, userList);

      if (userList.size() == k) {
        reportedThanK.add(reportId);
      }
    }

    int[] answer = new int[id_list.length];

    if (reportedThanK.size() != 0) {
      for (int i = 0; i < id_list.length; i++) {
        for (String reportId : reportedThanK) {
          if (reportList.get(reportId).contains(id_list[i])) {
            answer[i]++;
          }
        }
      }
    }

    return answer;
  }

  void sout(Object o) {
    System.out.println(o);
  }
}
