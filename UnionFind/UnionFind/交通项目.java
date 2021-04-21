import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
某省调查城镇交通状况，得到现有城镇道路统计表，表中列出了每条道路直接连通的城镇。省政府“畅通工程”的目
标是使全省任何两个城镇间都可以实现交通（但不一定有直接的道路相连，只要互相间接通过道路可达即可）。问
最少还需要建设多少条道路？
在我们的测试数据文件夹中有一个trffic_project.txt文件，它就是诚征道路统计表，下面是对数据的解释：
20 ->城市的个数
7 -> 已经修建好的道路数目
0 1 -> 已经修建好的道路，每一行数据的两个整数分别代表两个城市，代表两个城市已经联通，下同
6 9
3 8
5 11
2 12
6 10
4 8

*/

public class TrafficProject {

    public static void main(String[] args) throws IOException {
        // 构建一个缓冲流读取数据
        BufferedReader br = new BufferedReader(new InputStreamReader(TrafficProject.class.getClassLoader().getResourceAsStream("traffic_project.txt")));

        // 读取第一行数据
        int totolNum = Integer.parseInt(br.readLine());
        // 构建一个并查集对象
        UnionFind uf = new UnionFind(totolNum);
        // 读取第二行数据
        int cityNum = Integer.parseInt(br.readLine());
        // 循环读取7条数据
        for (int i = 0; i < cityNum; i++) {
            String line = br.readLine();
            String[] str = line.split(" ");
            int p = Integer.parseInt(str[0]);
            int q = Integer.parseInt(str[1]);
            // 调用union方法合并
            uf.Union(p,q);
        }

        // 获得当前并查集分组中的数量
        int leftRoads = uf.count - 1;
        System.out.println(leftRoads);
    }
}
