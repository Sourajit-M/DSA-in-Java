import java.util.Scanner;

public class Classroom {

    static class QuickFindUF
    {
        private int[] id;
        public QuickFindUF(int N)
        {
            id = new int[N];
            for (int i = 0; i < N; i++)
                id[i] = i;
            }
        public boolean connected(int p, int q)
        { return id[p] == id[q]; }
        public void union(int p, int q)
        {
            int pid = id[p];
            int qid = id[q];
            for (int i = 0; i < id.length; i++)
            if (id[i] == pid) id[i] = qid;
        }
    }

    public static void main(String[] args) {
        QuickFindUF uf = new QuickFindUF(5);
        Scanner scan = new Scanner(System.in);

        for(int i=1; i<= 5; i++)
        {
        int p = scan.nextInt();
        int q = scan.nextInt();
        if (!uf.connected(p, q))
        {
        uf.union(p, q);
        System.out.println(p + " " + q);
        }
    }

    }
}