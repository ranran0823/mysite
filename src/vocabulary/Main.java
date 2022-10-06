package vocabulary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		//ファイルを1行ずつ読み込むためのクラス
		BufferedReader br = null;
		//用意したcsvファイル
		String file_name = "src/tango.csv";
		
		ArrayList<String[]> data = new ArrayList<String[]>();

		//配列にデータを格納する
		try {
			//FileReaderクラスの引数に必要なFileクラスの作成
			File file = new File(file_name);
			//FileReaderクラスでcsvファイルを読み取る
			br = new BufferedReader(new FileReader(file));

			//ファイルの行番号を表す
			int index = 0;
			//読み込んでいる行の内容を都度格納する
			String line;

			while((line = br.readLine())!= null) {
				data.add(line.split(",", -1));
				index++;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage()); //エラーメッセージを表示する
		} 

		System.out.println("どのモードにするか選んでね！\na:ランダム日→英\\nb:ランダム英→日");

		//入力を受け取る
		Scanner modeScanner = new Scanner(System.in);

		String modeInput = modeScanner.nextLine();

		if (modeInput.equals("a")) { //「a」の入力を受け取った場合
			while (true) {
				//疑似乱数生成
				Random random = new Random();
				int randomValue = random.nextInt(17);

				Scanner enterInput = new Scanner(System.in); //enterの入力を受け取る
				System.out.println("Q:" + data.get(randomValue)[1]); //問題となる値を表示する
				enterInput.nextLine(); //enterの入力待ち
				System.out.println("A:" + data.get(randomValue)[0] + "\n\n"); //答えとなる値を表示する

			}
		} else if (modeInput.equals("b")) {
			while (true) {

				Random random = new Random();
				int randomValue = random.nextInt(17);
				Scanner enterInput = new Scanner(System.in);
				System.out.println("Q:" + data.get(randomValue)[0]); //aの分岐と逆の表示順にする
				enterInput.nextLine();
				System.out.println("A:" + data.get(randomValue)[1] + "\n\n");

			}
		} else { //「a」「b」以外の入力を受け取った時

			System.out.println("やる気ないんですね。");

		}
	}

}
