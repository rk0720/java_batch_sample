package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		try {
			System.out.print("バッチ処理を実行します");
			//DAOクラスインスタンス生成
			EmployeeDao employeeDao = new EmployeeDao();
			
			//CSVファイル読み込み
			File f = new File("C:\\workspace3\\java_batch_sample\\resource\\sample.csv");
			BufferedReader br = new BufferedReader(new FileReader(f));
			
			//ファイル内の1行のテキストを一時保存する変数
			String line;
			
			//データ挿入件数
			int count = 0;
			
			//ファイルを一行ずつ読み込む
			while((line = br.readLine()) != null) {
				//読み込んだ行をカンマ区切りで分割、配列に変換
				String [] row = line.split(",");
				//DAOクラスのINSERT用メソッド呼び出し、読み込んだテキストを引数に
				employeeDao.insert(row[0], row[1]);
				//挿入件数のインクリメント
				count++;
			}
			
			//ファイル読み込み終了
			br.close();
			
			//データ挿入件数の出力
			System.out.println("\n" + count + "剣のデータ保存に成功しました");
		}catch(FileNotFoundException e) {
			System.out.println("ファイルがありません");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
