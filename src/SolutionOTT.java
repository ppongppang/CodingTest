import java.util.*;

class SolutionOTT
{
    private static UserSolutionOTT usersolution = new UserSolutionOTT();

    private final static int CMD_INIT       = 100;
    private final static int CMD_ADD        = 200;
    private final static int CMD_ERASE      = 300;
    private final static int CMD_WATCH      = 400;
    private final static int CMD_SUGGEST    = 500;

    public final static class RESULT
    {
        int cnt;
        int[] IDs = new int[5];

        RESULT()
        {
            cnt = -1;
        }
    }

    private static boolean run(Scanner sc) throws Exception
    {
        int Q, N;
        int mID, mGenre, mTotal, mRating, uID;

        int ret = -1, cnt, ans;

        RESULT res;

        Q = sc.nextInt();

        boolean okay = false;

        for (int q = 0; q < Q; ++q)
        {
            int cmd;
            cmd = sc.nextInt();

            switch(cmd)
            {
                case CMD_INIT:
                    N = sc.nextInt();
                    usersolution.init(N);
                    okay = true;
                    break;
                case CMD_ADD:
                    mID = sc.nextInt();
                    mGenre = sc.nextInt();
                    mTotal = sc.nextInt();
                    ret = usersolution.add(mID, mGenre, mTotal);
                    ans = sc.nextInt();
                    if (ret != ans)
                        okay = false;
                    break;
                case CMD_ERASE:
                    mID = sc.nextInt();
                    ret = usersolution.erase(mID);
                    ans = sc.nextInt();
                    if (ret != ans)
                        okay = false;
                    break;
                case CMD_WATCH:
                    uID = sc.nextInt();
                    mID = sc.nextInt();
                    mRating = sc.nextInt();
                    ret = usersolution.watch(uID, mID, mRating);
                    ans = sc.nextInt();
                    if (ret != ans)
                        okay = false;
                    break;
                case CMD_SUGGEST:
                    uID = sc.nextInt();
                    res = usersolution.suggest(uID);
                    cnt = sc.nextInt();
                    if (res.cnt != cnt)
                        okay = false;
                    for (int i = 0; i < cnt; ++i)
                    {
                        ans = sc.nextInt();
                        if (res.IDs[i] != ans)
                            okay = false;
                    }
                    break;
                default:
                    okay = false;
                    break;
            }
        }

        return okay;
    }

    public static void main(String[] args) throws Exception
    {
        System.setIn(new java.io.FileInputStream("src/sample_input.txt"));

        Scanner sc = new Scanner(System.in);

        int TC = sc.nextInt();
        int MARK = sc.nextInt();

        for (int testcase = 1; testcase <= TC; ++testcase)
        {
            int score = run(sc) ? MARK : 0;
            System.out.println("#" + testcase + " " + score);
        }

        sc.close();
    }
}

class UserSolutionOTT
{
    class User {
        Deque<int[]> recentWatch = new ArrayDeque<>();
        Set<Integer> watchedSet = new HashSet<>();
    }

    static User[] users;
    static Map<Integer, int[]> movieMap = new HashMap<>();
    static Map<Integer, TreeSet<Integer>> genreMap = new HashMap<>();
    static TreeSet<Integer> allMovies;
    static int registerNum;

    static Comparator<Integer> movieComp = (a, b) -> {
        int[] ma = movieMap.get(a);
        int[] mb = movieMap.get(b);
        if (ma[1] != mb[1]) return mb[1] - ma[1];
        if (ma[3] != mb[3]) return mb[3] - ma[3];
        return a - b; // ID로 동점 처리 (TreeSet에서 중복 제거 방지)
    };

    void init(int N)
    {
        users = new User[N+1];
        for(int i=1;i<=N;i++) {
            users[i] = new User();
        }
        movieMap.clear();
        genreMap.clear();
        allMovies = new TreeSet<>(movieComp);
        registerNum = 0;
    }

    int add(int mID, int mGenre, int mTotal)
    {
        if(movieMap.containsKey(mID)) return 0;
        movieMap.put(mID, new int[] {mGenre, mTotal, 0, registerNum++});

        genreMap.computeIfAbsent(mGenre, k -> new TreeSet<>(movieComp)).add(mID);
        allMovies.add(mID);

        return 1;
    }

    int erase(int mID)
    {
        int[] movie = movieMap.get(mID);
        if(movie == null || movie[2] == 1) return 0;
        movie[2] = 1;

        genreMap.get(movie[0]).remove(mID);
        allMovies.remove(mID);

        return 1;
    }

    int watch(int uID, int mID, int mRating)
    {
        User user = users[uID];
        int[] movie = movieMap.get(mID);

        if(movie == null || movie[2] == 1) return 0;
        if(user.watchedSet.contains(mID)) return 0;

        user.watchedSet.add(mID);
        user.recentWatch.addFirst(new int[] {mID, mRating});

        // 점수 업데이트 전에 TreeSet에서 제거
        genreMap.get(movie[0]).remove(mID);
        allMovies.remove(mID);

        movie[1] += mRating;

        // 점수 업데이트 후 다시 삽입
        genreMap.get(movie[0]).add(mID);
        allMovies.add(mID);

        return 1;
    }

    SolutionOTT.RESULT suggest(int uID) {
        SolutionOTT.RESULT res = new SolutionOTT.RESULT();
        User user = users[uID];

        TreeSet<Integer> source;

        if (user.recentWatch.isEmpty()) {
            source = allMovies;
        } else {
            int bestRating = -1;
            int bestGenre = -1;
            int cnt = 0;
            for(int[] arr : user.recentWatch) {
                if(cnt == 5) break;
                if(movieMap.get(arr[0])[2] == 1) continue;
                if (arr[1] > bestRating) {
                    bestRating = arr[1];
                    bestGenre = movieMap.get(arr[0])[0];
                }
                cnt++;
            }

            if(bestGenre == -1) {
                source = allMovies;
            }else source = genreMap.get(bestGenre);
        }

        int count = 0;
        for (int mid : source) {
            if (user.watchedSet.contains(mid)) continue;
            res.IDs[count++] = mid;
            if (count == 5) break;
        }

        res.cnt = count;
        return res;
    }
}