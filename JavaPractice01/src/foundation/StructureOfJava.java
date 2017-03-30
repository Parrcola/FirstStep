// ファイルヘッダ部	ーーーーーーーーーーーーーーーーーーーーーーーー
/**
 * 
 * このファイルはゴさんにより作られました。
 * 
 * This file is made by Mr.KO
 * 
 * 이 파일은 고씨에 의해 만들어졌습니다.
 * 
 */



//パッケージ部　ーーーーーーーーーーーーーーーーーーーーーーーー
package foundation;	



//インポート部　ーーーーーーーーーーーーーーーーーーーーーーーー
import java.math.*;	// 三つ以上をインポートする場合だけ`*`を使うこと。
import java.util.Scanner;



// クラスヘッダ部（省略）　ーーーーーーーーーーーーーーーーーーーーーーーー



// クラス定義部　ーーーーーーーーーーーーーーーーーーーーーーーー
public class StructureOfJava { // （クラス名）先頭は大文字、後は区切りを大文字。

	// 定数　ーーーーーーーーーーーーーーーーーーーーーーーー
	static final int RETURN_BOUNS_RATE = 2;	// 大文字を＿で繋ぐ。
	static final double DELAYED_RETURN_BOUNS_RATE = 0.5;
	
	
	
	// フィールド	ーーーーーーーーーーーーーーーーーーーーーーーー
	static int idNumber; // なるべく使わないこと。
	
	String name;	
	int phoneNumber;
	int point;
	
	
	
	//	コンストラクタ	ーーーーーーーーーーーーーーーーーーーーーーーー
		
		// Overloading
		public StructureOfJava(String name, int phoneNumber){
			this.name = name;
			this.phoneNumber = phoneNumber;
		}
		
		// Overloading
		public StructureOfJava(String name, int phoneNumber, int point){
			this.name = name;
			this.phoneNumber = phoneNumber;
			this.point = point;
		}
		

		
		//何もない場合は、自動的にデフォルトコンストラクタが作成される。
		public StructureOfJava(){
			
		}
		
		
		
	//	メソッド	ーーーーーーーーーーーーーーーーーーーーーーーー
		
		void currentUserInfo(){
			System.out.println("会員登録：" + idNumber);
			System.out.println("名前：" + name);
			System.out.println("電話：" + phoneNumber);
			System.out.println("ポイント：" + point);		
		}
		
		
		
	//	内部クラス	ーーーーーーーーーーーーーーーーーーーーーーーー
		
		
		
}
