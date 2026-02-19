class UserSolution {

    static class Node {
        int id;
        int team;
        Node next;

        void set(int id, int team) {
            this.id = id;
            this.team = team;
            this.next = null;
        }
    }

    Node[] active = new Node[100001];  // 현재 활성 상태인 노드
    Node[][] listHead = new Node[6][6];  // 각 팀-점수별 리스트 시작
    Node[][] listTail = new Node[6][6];  // 각 팀-점수별 리스트 끝

    public void init() {
        for (int i = 0; i <= 100000; i++) {
            active[i] = null;
        }

        for (int t = 1; t <= 5; t++) {
            for (int s = 1; s <= 5; s++) {
                listHead[t][s] = null;
                listTail[t][s] = null;
            }
        }
    }

    private void append(int team, int score, Node node) {
        if (listHead[team][score] == null) {
            listHead[team][score] = node;
            listTail[team][score] = node;
        } else {
            listTail[team][score].next = node;
            listTail[team][score] = node;
        }
    }

    public void hire(int mID, int mTeam, int mScore) {
        Node node = new Node();
        node.set(mID, mTeam);

        active[mID] = node;
        append(mTeam, mScore, node);
    }

    public void fire(int mID) {
        active[mID] = null;
    }

    public void updateSoldier(int mID, int mScore) {
        if (active[mID] == null) return;

        int currentTeam = active[mID].team;
        hire(mID, currentTeam, mScore);
    }

    private void mergeList(int team, int src, int dst) {
        if (src == dst || listHead[team][src] == null) return;

        if (listHead[team][dst] == null) {
            listHead[team][dst] = listHead[team][src];
            listTail[team][dst] = listTail[team][src];
        } else {
            listTail[team][dst].next = listHead[team][src];
            listTail[team][dst] = listTail[team][src];
        }

        listHead[team][src] = null;
        listTail[team][src] = null;
    }

    public void updateTeam(int mTeam, int mChangeScore) {
        if (mChangeScore == 0) return;

        if (mChangeScore > 0) {
            // 점수 증가: 위에서 아래로
            for (int cur = 4; cur >= 1; cur--) {
                int next = Math.min(5, cur + mChangeScore);
                mergeList(mTeam, cur, next);
            }
        } else {
            // 점수 감소: 아래서 위로
            for (int cur = 2; cur <= 5; cur++) {
                int next = Math.max(1, cur + mChangeScore);
                mergeList(mTeam, cur, next);
            }
        }
    }

    public int bestSoldier(int mTeam) {
        for (int score = 5; score >= 1; score--) {
            Node node = listHead[mTeam][score];
            int result = 0;

            while (node != null) {
                if (active[node.id] == node && node.id > result) {
                    result = node.id;
                }
                node = node.next;
            }

            if (result > 0) return result;
        }
        return 0;
    }
}