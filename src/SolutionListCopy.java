import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class SolutionListCopy {
    private final static int CMD_INIT			= 100;
    private final static int CMD_MAKE_LIST		= 200;
    private final static int CMD_COPY_LIST		= 300;
    private final static int CMD_UNDATE_ELEMENT	= 400;
    private final static int CMD_ELEMENT		= 500;

    private final static UserSolutionListCopy usersolution = new UserSolutionListCopy();

    private static int mSeed;
    private static int pseudo_rand()
    {
        mSeed = mSeed * 214013 + 2531011;
        return (mSeed >> 16) & 0x7FFF;
    }

    private static char[] mName = new char[21];
    private static char[] mDest = new char[21];
    private static char[] mSrc = new char[21];
    private static int[] mListValue = new int[200000];

    private static void generateName(char[] name, int seed)
    {
        mSeed = seed;
        int name_len = pseudo_rand() % 20 + 1;
        for (int i = 0; i < name_len; ++i)
        {
            name[i] = (char)(pseudo_rand() % 26 + 'a');
        }
        name[name_len] = '\0';
    }

    private static int generateList(int[] listValue, int seed)
    {
        mSeed = seed;
        int length = pseudo_rand() << 15;
        length = (length + pseudo_rand()) % 200000 + 1;
        for (int i = 0; i < length; ++i)
        {
            listValue[i] = pseudo_rand();
        }
        return length;
    }

    private static boolean run(BufferedReader br) throws Exception
    {
        StringTokenizer st;

        int numQuery;

        int seed;
        int mIndex, mValue, mCopy, mLength;
        int userAns, ans;
        boolean isCorrect = false;

        numQuery = Integer.parseInt(br.readLine());

        for (int q = 0; q < numQuery; ++q)
        {
            st = new StringTokenizer(br.readLine(), " ");

            int cmd;
            cmd = Integer.parseInt(st.nextToken());

            switch (cmd)
            {
                case CMD_INIT:
                    usersolution.init();
                    isCorrect = true;
                    break;
                case CMD_MAKE_LIST:
                    seed = Integer.parseInt((st.nextToken()));
                    generateName(mName, seed);
                    seed = Integer.parseInt((st.nextToken()));
                    mLength = generateList(mListValue, seed);
                    usersolution.makeList(mName, mLength, mListValue);
                    break;
                case CMD_COPY_LIST:
                    seed = Integer.parseInt((st.nextToken()));
                    generateName(mDest, seed);
                    seed = Integer.parseInt((st.nextToken()));
                    generateName(mSrc, seed);
                    mCopy = Integer.parseInt((st.nextToken()));
                    usersolution.copyList(mDest, mSrc, (mCopy != 0));
                    break;
                case CMD_UNDATE_ELEMENT:
                    seed = Integer.parseInt((st.nextToken()));
                    generateName(mName, seed);
                    mIndex = Integer.parseInt((st.nextToken()));
                    mValue = Integer.parseInt((st.nextToken()));
                    usersolution.updateElement(mName, mIndex, mValue);
                    break;
                case CMD_ELEMENT:
                    seed = Integer.parseInt((st.nextToken()));
                    generateName(mName, seed);
                    mIndex = Integer.parseInt((st.nextToken()));
                    userAns = usersolution.element(mName, mIndex);
                    ans = Integer.parseInt((st.nextToken()));
                    if (userAns != ans)
                    {
                        isCorrect = false;
                    }
                    break;
                default:
                    isCorrect = false;
                    break;
            }
        }
        return isCorrect;
    }

    public static void main(String[] args) throws Exception
    {
        int TC, MARK;

        System.setIn(new java.io.FileInputStream("./src/sample_input.txt"));

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

class UserSolutionListCopy {

    static final int MAX_ADDR = 6000;
    static final int MAX_BASE = 6000;
    static final int MAX_UPD  = 120000;

    static int[][] baseStore;
    static int baseCount;

    static HashMap<String, Integer> addrId;
    static int addrCount;

    static int[] baseOfAddr;
    static int[] lastUpdOfAddr;

    static int[] uIdx, uVal, uPrev;
    static int updCount;

    public void init() {
        baseStore = new int[MAX_BASE][];
        baseCount = 0;

        addrId = new HashMap<>(MAX_ADDR * 2);
        addrCount = 0;

        baseOfAddr = new int[MAX_ADDR];
        lastUpdOfAddr = new int[MAX_ADDR];
        for (int i = 0; i < MAX_ADDR; i++) lastUpdOfAddr[i] = -1;

        uIdx = new int[MAX_UPD];
        uVal = new int[MAX_UPD];
        uPrev = new int[MAX_UPD];
        updCount = 0;
    }

    public void makeList(char[] mName, int mLength, int[] mListValue) {
        String name = charToString(mName);

        int[] base = new int[mLength];
        System.arraycopy(mListValue, 0, base, 0, mLength);
        baseStore[baseCount] = base;
        int myBaseId = baseCount++;

        int myAddrId = addrCount++;
        addrId.put(name, myAddrId);

        baseOfAddr[myAddrId] = myBaseId;
        lastUpdOfAddr[myAddrId] = -1;
    }

    public void copyList(char[] mDest, char[] mSrc, boolean mCopy) {
        String dest = charToString(mDest);
        String src  = charToString(mSrc);

        int srcAddr = addrId.get(src);

        if (!mCopy) {
            addrId.put(dest, srcAddr);
            return;
        }

        int destAddr = addrCount++;
        addrId.put(dest, destAddr);

        baseOfAddr[destAddr] = baseOfAddr[srcAddr];
        lastUpdOfAddr[destAddr] = lastUpdOfAddr[srcAddr];
    }

    public void updateElement(char[] mName, int mIndex, int mValue) {
        String name = charToString(mName);
        int aId = addrId.get(name);

        uIdx[updCount] = mIndex;
        uVal[updCount] = mValue;
        uPrev[updCount] = lastUpdOfAddr[aId];
        lastUpdOfAddr[aId] = updCount;
        updCount++;
    }

    public int element(char[] mName, int mIndex) {
        String name = charToString(mName);
        int aId = addrId.get(name);

        for (int e = lastUpdOfAddr[aId]; e != -1; e = uPrev[e]) {
            if (uIdx[e] == mIndex) return uVal[e];
        }

        int bId = baseOfAddr[aId];
        return baseStore[bId][mIndex];
    }

    private String charToString(char[] arr) {
        int len = 0;
        while (len < arr.length && arr[len] != '\0') len++;
        return new String(arr, 0, len);
    }
}