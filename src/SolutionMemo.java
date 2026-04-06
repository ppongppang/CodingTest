import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class SolutionMeMo
{
    private final static int CMD_INIT       = 100;
    private final static int CMD_INSERT     = 200;
    private final static int CMD_MOVECURSOR = 300;
    private final static int CMD_COUNT      = 400;

    private final static UserSolutionMemo UserSolutionMemo = new UserSolutionMemo();

    private static void String2Char(char[] buf, String str, int maxLen)
    {
        for (int k = 0; k < str.length(); k++)
            buf[k] = str.charAt(k);

        for (int k = str.length(); k <= maxLen; k++)
            buf[k] = '\0';
    }

    private static char[] mStr = new char[90001];

    private static boolean run(BufferedReader br) throws Exception
    {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int queryCnt = Integer.parseInt(st.nextToken());
        boolean correct = false;

        for (int q = 0; q < queryCnt; q++)
        {
            st = new StringTokenizer(br.readLine(), " ");

            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == CMD_INIT)
            {
                int H = Integer.parseInt(st.nextToken());
                int W = Integer.parseInt(st.nextToken());

                String2Char(mStr, st.nextToken(), 90000);

                UserSolutionMemo.init(H, W, mStr);
                correct = true;
            }
            else if (cmd == CMD_INSERT)
            {
                char mChar = st.nextToken().charAt(0);

                UserSolutionMemo.insert(mChar);
            }
            else if (cmd == CMD_MOVECURSOR)
            {
                int mRow = Integer.parseInt(st.nextToken());
                int mCol = Integer.parseInt(st.nextToken());

                char ret = UserSolutionMemo.moveCursor(mRow, mCol);

                char ans = st.nextToken().charAt(0);
                if (ret != ans)
                {
                    correct = false;
                }
            }
            else if (cmd == CMD_COUNT)
            {
                char mChar = st.nextToken().charAt(0);

                int ret = UserSolutionMemo.countCharacter(mChar);

                int ans = Integer.parseInt(st.nextToken());
                if (ret != ans)
                {
                    correct = false;
                }
            }
        }
        return correct;
    }

    public static void main(String[] args) throws Exception
    {
        int TC, MARK;

        System.setIn(new java.io.FileInputStream("src/sample_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        TC = Integer.parseInt(st.nextToken());
        MARK = Integer.parseInt(st.nextToken());

        for (int testcase = 1; testcase <= TC; ++testcase)
        {
            int score = run(br) ? MARK : 0;

            System.out.println("#" + testcase + " " + score);
        }

        br.close();
    }
}

class UserSolutionMemo
{
    private Deque<Character> left;
    private Deque<Character> right;

    private int H, W;

    private int[] rightCount;

    void init(int H, int W, char[] mStr) {
        this.H = H;
        this.W = W;

        left  = new ArrayDeque<>();
        right = new ArrayDeque<>();
        rightCount = new int[26];

        int len = 0;
        while (mStr[len] != '\0') len++;

        for (int i = len - 1; i >= 0; i--) {
            right.push(mStr[i]);
            rightCount[mStr[i] - 'a']++;
        }
    }

    void insert(char mChar)
    {
        left.push(mChar);
    }

    char moveCursor(int mRow, int mCol) {
        int targetIdx = (mRow - 1) * W + (mCol - 1);
        int totalLen  = left.size() + right.size();

        if (targetIdx >= totalLen) {
            moveToEnd();
            return '$';
        }

        while (left.size() < targetIdx) {
            char ch = right.pop();
            rightCount[ch - 'a']--;
            left.push(ch);
        }
        while (left.size() > targetIdx) {
            char ch = left.pop();
            right.push(ch);
            rightCount[ch - 'a']++;
        }

        return right.peek();
    }

    int countCharacter(char mChar) {
        return rightCount[mChar - 'a'];
    }

    private void moveToEnd() {
        while (right.size() > 0) {
            char ch = right.pop();
            rightCount[ch - 'a']--;
            left.push(ch);
        }
    }
}