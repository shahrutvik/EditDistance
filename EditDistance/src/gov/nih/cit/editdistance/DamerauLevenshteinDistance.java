package gov.nih.cit.editdistance;

public class DamerauLevenshteinDistance {
    private static int minimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    private static int minimum(int a, int b) {
        return Math.min(a, b);
    }

    public static int computeLevenshteinDistance(String s, String t){
        int d[][];
        int n; // length of s
        int m; // length of t
        int i; // iterates through s
        int j; // iterates through t
        char s_i; // ith character of s
        char t_j; // jth character of t
        int cost; // cost

        n = s.length ();
        m = t.length ();
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        d = new int[n+1][m+1];

        for (i = 0; i <= n; i++) {
            d[i][0] = i;
        }

        for (j = 0; j <= m; j++) {
            d[0][j] = j;
        }

        for(i = 1; i <= n; i++) {
            s_i = s.charAt (i - 1);
            for(j = 1; j <= m; j++) {
                t_j = t.charAt (j - 1);

                if(s_i == t_j){
                    cost = 0;
                }else{
                    cost = 1;
                }
                d[i][j] = minimum(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1] + cost);

                if(i > 1 && j > 1 && s_i == t_j-1 && s_i-1 == t_j){ 
                    d[i][j] = minimum(d[i][j], d[i - 2][j - 2] + cost);
                }
            }
        }
        return d[n][m];
    }
}