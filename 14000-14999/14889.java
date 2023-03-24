static boolean arr[];
static int team[][];

public static void dfs(int depth, int idx) {
	if (depth == n/2) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i] && arr[j] && i != j) sum1 = team[i][j] + team[j][i];
				else sum2 = team[i][j] + team[j][i];
			}
			answer = answer > Math.abs(sum2-sum1) ? Math.abs(sum2-sum1) : answer;
		}
	}
	
	for (int i = idx; i < n; i++) {
		arr[i] = true;
		dfs(depth + 1, i + 1);
		arr[i] = false;
	}
}